
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher1 {
    String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < encrypted.length(); i++){
        char currChar = encrypted.charAt(i);
        int idx = alphabet.indexOf(Character.toUpperCase(currChar));
        if (idx != -1){
        char newChar = shiftedAlphabet.charAt(idx);
        if(Character.isLowerCase(currChar)){
            encrypted.setCharAt(i, Character.toLowerCase(newChar));            
        }
        else{
            encrypted.setCharAt(i, newChar);
        }
        }
        }
        return encrypted.toString();
    }
    String encryptTwoKey(String input, int key1, int key2){
    StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for(int i = 0; i < encrypted.length(); i+=2){
        char currChar = encrypted.charAt(i);
        int idx = alphabet.indexOf(Character.toUpperCase(currChar));
        if (idx != -1){
        char newChar = shiftedAlphabet1.charAt(idx);
        if(Character.isLowerCase(currChar)){
            encrypted.setCharAt(i, Character.toLowerCase(newChar));            
        }
        else{
            encrypted.setCharAt(i, newChar);
        }
        }
        }
        for(int i = 1; i < encrypted.length(); i+=2){
        char currChar = encrypted.charAt(i);
        int idx = alphabet.indexOf(Character.toUpperCase(currChar));
        if (idx != -1){
        char newChar = shiftedAlphabet2.charAt(idx);
        if(Character.isLowerCase(currChar)){
            encrypted.setCharAt(i, Character.toLowerCase(newChar));            
        }
        else{
            encrypted.setCharAt(i, newChar);
        }
        }
        }
        return encrypted.toString();
    }
    void testEncryptTwoKey(){
    System.out.println("Encrypted \"At noon be in the conference room with your hat on for a surprise party. YELL LOUD!\" is: " + encryptTwoKey("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
    
    void testCaesar(){
    FileResource fr = new FileResource();
    String message = fr.asString();
    int key = 23;
    String encrypted = encrypt(message, key);
    System.out.println("key is " + key + "\n" + encrypted);
    }
    
    void testEncrypt(){
    System.out.println("At noon be in the conference room with your hat on for a surprise party. YELL LOUD! encrypted to " + encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
    }
}
