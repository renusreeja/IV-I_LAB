#include <stdio.h>

int main() {
    char str[] = "Hello world";

    printf("Original string: %s\n", str);

    // XOR each character with 0
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = str[i] ^ 0;
    }

    printf("XORed string: %s\n", str);

    return 0;
}

