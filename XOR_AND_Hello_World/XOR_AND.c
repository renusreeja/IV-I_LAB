#include <stdio.h>
#include <string.h> // Include the string.h header for strcpy

int main() {
    char str[] = "Hello world";

    printf("Original string: %s\n", str);

    // AND each character with 127
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = str[i] & 127;
    }

    printf("ANDed string: %s\n", str);

    // Reset the string to the original
    strcpy(str, "Hello world");

    // XOR each character with 127
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = str[i] ^ 127;
    }

    printf("XORed string: %s\n", str);

    return 0;
}

