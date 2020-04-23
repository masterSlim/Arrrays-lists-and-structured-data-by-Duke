
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    public CaesarCipher(int key){
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
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
        System.out.println(encrypted);
        return encrypted.toString();
    }
    public String decrypt(String input){
    int[] fregs = new int[26];
    for(int i=0; i < input.length(); i++){
        char ch = Character.toUpperCase(input.charAt(i));
        int dex = alphabet.indexOf(ch);
        if(dex != -1){
            fregs[dex] +=1;
        }
    }    
    int maxDex = maxIndex(fregs);
    int dKey = maxDex-4;
    if(maxDex < 4){
    dKey = 26 - (4-maxDex);
    }    
    CaesarCipher cc = new CaesarCipher(26-dKey);
    return cc.encrypt(input);
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
    }
