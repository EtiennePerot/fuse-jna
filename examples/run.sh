#!/usr/bin/env bash

set -e

if [ $# -lt 2 ]; then
	echo "Usage: $0 full.class.name [fs-arguments] mountpoint" >&2
	exit 1
fi

if ! which gradle &> /dev/null; then
  echo 'gradle not found in $PATH. Please install gradle.' >&2
  exit 1
fi

cd "`dirname "$0"`/.."
mountPoint="${@: -1}"
if [ ! -d "$mountPoint" ]; then
	mkdir -p "$mountPoint" || exit 1
fi

gradle uberJar
java -cp build/libs/\* "$@"
