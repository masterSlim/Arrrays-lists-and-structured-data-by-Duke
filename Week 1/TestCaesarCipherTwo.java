
/**
 * Write a description of class TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipherTwo {
    int[] countLetters(String message){
    String alph = "abcdefghijklmnopqrstuvwxyz";
    int[] counts = new int[26];
    for(int i=0; i < message.length(); i++){
        char ch = Character.toLowerCase(message.charAt(i));
        int dex = alph.indexOf(ch);
        if(dex != -1){
            counts[dex] +=1;
        }
    }    
    return counts;
}
    int maxIndex(int[] values){
        int max = 0;
        for(int i = 0; i< values.length; i++){
            if (values[i] > values[max]){
                max = i;
            }
        }
        return max;
    }
    String halfOfString(String message, int start){
    StringBuilder sb = new StringBuilder();
    for (int i = start; i<= message.length()-1; i+=2){
    sb.append(message.charAt(i));
    }
    return sb.toString();
}
void simpleTests(){
FileResource fr = new FileResource();
//CaesarCipherTwo cct = new CaesarCipherTwo(17,3);
//String encrypted = cct.encrypt(fr.asString());
//System.out.println("Encrypted :" + encrypted);
//String decrypted = cct.decrypt(encrypted);
//System.out.println("Decrypted: " + decrypted);
System.out.println("breakCaesarCipher: ");
breakCaesarCipher(fr.asString());
}
void breakCaesarCipher(String input){
BreakCaesarCipher bcc = new BreakCaesarCipher();
String firstHalf = halfOfString(input, 0);
//System.out.println("First half: " + firstHalf);
String secondHalf = halfOfString(input, 1);
//System.out.println("Second half: " + secondHalf);
int key1 = bcc.getKey(firstHalf);
System.out.println("Key 1 is: " + key1 +"\n");
int key2 = bcc.getKey(secondHalf);
System.out.println("Key 2 is: " + key2);
CaesarCipherTwo cct = new CaesarCipherTwo(key1, key2);
String decrypted = cct.decrypt(input);
//System.out.println(decrypted);
}
}
