import java.io.*;
import java.util.*;
public class SubstitutionCipher
{
static Scanner sc = new Scanner(System.in);
static BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
public static void main(String[] args) throws IOException {
String a = "abcdefghijklmnopqrstuvwxyz";
String b = "zyxwvutsrqponmlkjihgfedcba";
System.out.print("Enter any string: ");
String str = br.readLine();
String encrypt = "";
char c;
for(int i=0;i<str.length();i++){
c = str.charAt(i);
int j = a.indexOf(c);
encrypt = encrypt+b.charAt(j);
}
System.out.println("The encrypted data is: " +encrypt);
String decrypt = "";
char c1;
for(int i=0;i<encrypt.length();i++){
c1 = encrypt.charAt(i);
int k = b.indexOf(c1);
decrypt = decrypt+a.charAt(k);
}
System.out.println("The decrypted data is: " +decrypt);
}
}
