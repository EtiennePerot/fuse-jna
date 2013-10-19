#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	struct stat sb;
	size_t i;
	char *c;

	if (argc != 2) {
		fprintf(stderr, "Usage: %s <pathname>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	if (stat(argv[1], &sb) == -1) {
		perror("stat");
		exit(EXIT_FAILURE);
	}

	c = (char *) &sb;
	for (i = 0; i < sizeof(struct stat); i++) {
		printf("%02x ", *c++ & 0xff);
		if(i % 4 == 3)
		{
			printf("  ");
		}
		if(i % 16 == 15)
		{
			printf(" [%d]\n", i + 1);
		}
	}
	printf("\n");
}
