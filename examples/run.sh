#!/usr/bin/env bash

if [ $# -lt 2 ]; then
	echo "Usage: $0 full.class.name [fs-arguments] mountpoint" >&2
	exit 1
fi
cd "`dirname "$0"`"
javaFile="../src/`echo "$1" | sed 's/\./\//g'`.java"
if [ ! -e "$javaFile" ]; then
	echo "Cannot find class $1." >&2
	exit 1
fi
javac -cp ../lib/jna/jna.jar:../src/ -d ../bin "$javaFile" || exit 1
mountPoint="${@: -1}"
if [ ! -d "$mountPoint" ]; then
	mkdir -p "$mountPoint" || exit 1
fi
java -cp ../lib/jna/jna.jar:../bin "$@"
