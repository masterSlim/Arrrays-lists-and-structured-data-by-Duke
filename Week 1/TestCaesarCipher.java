
/**
 * Write a description of class TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
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
    void simpleTests(){
    FileResource fr = new FileResource();
    CaesarCipher cc = new CaesarCipher(18);
    String encrypted = cc.encrypt(fr.asString());
    System.out.println("Encrypted: " + "\n" + encrypted);
    String decrypted = cc.decrypt(encrypted);    
    System.out.println("Decrypted: " + "\n" + decrypted);
    System.out.println("\n breakeCaesarCipher method: \n");
    breakCaesarCipher(encrypted);
    }            
    void breakCaesarCipher(String input){
        BreakCaesarCipher bcc = new BreakCaesarCipher();
        String decrypted = bcc.decrypt(input);
        System.out.println("Input: " + input + "\n" + "Decrypted: " + decrypted);
    }
}
