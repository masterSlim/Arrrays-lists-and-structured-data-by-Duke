
/**
 * Write a description of class BreakCesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class BreakCaesarCipher {
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
    String decrypt(String encrypted){;
    int[] fregs = countLetters(encrypted);
    int maxDex = maxIndex(fregs);
    int dKey = maxDex-4;
    if(maxDex < 4){
    dKey = 26 - (4-maxDex);
    }    
    //System.out.println(dKey);    
    CaesarCipher cc = new CaesarCipher(26-dKey);
    return cc.encrypt(encrypted);
    }
    public int getKey(String encrypted){   
    int[] fregs = countLetters(encrypted);
    int maxDex = maxIndex(fregs);
    int dKey = maxDex-4;
    if(maxDex < 4){
    dKey = 26 - (4-maxDex);
    } 
    //System.out.println(dKey);
    return 26-dKey;
    }
    String twoKeyDecrypt(String encrypted){
    StringBuilder part1 = new StringBuilder();
    StringBuilder part2 = new StringBuilder();
    for(int i = 0; i < encrypted.length(); i+=2){
    part1.append(encrypted.charAt(i));
    }
    for (int i = 1; i < encrypted.length(); i+=2){
    part2.append(encrypted.charAt(i));
    }
    String newPart1 = decrypt(part1.toString());
    
    System.out.println(part1 + "\n" + newPart1);
    String newPart2 = decrypt(part2.toString());
    /*for (int i = 1; i <= part2.length(); i+=2){
    part1.insert(i, newPart2.toString().charAt(i-1));
    }*/
    StringBuilder output = new StringBuilder();
    for(int i= 0; i< newPart1.length(); i+=1){
        if(newPart1.charAt(i) != 0){
            output.append(newPart1.charAt(i));
        }
        if(i < newPart2.length()){
        output.append(newPart2.charAt(i));
    }
    }    
    System.out.println(output.toString());
    return output.toString(); //нужно слепить 2 половины сроки обратно в одну
}
String twoKeyDecryptWithKeys(String encrypted, int key1, int key2){
    StringBuilder part1 = new StringBuilder();
    StringBuilder part2 = new StringBuilder();
    for(int i = 0; i < encrypted.length(); i+=2){
    part1.append(encrypted.charAt(i));
    }
    for (int i = 1; i < encrypted.length(); i+=2){
    part2.append(encrypted.charAt(i));
    }
    CaesarCipher cc1 = new CaesarCipher(26-key1);
    CaesarCipher cc2 = new CaesarCipher(26-key2);
    String newPart1 = cc1.encrypt(part1.toString());    
    System.out.println(part1 + "\n" + newPart1);
    String newPart2 = cc2.encrypt(part2.toString());
    /*for (int i = 1; i <= part2.length(); i+=2){
    part1.insert(i, newPart2.toString().charAt(i-1));
    }*/
    StringBuilder output = new StringBuilder();
    for(int i= 0; i< newPart1.length(); i+=1){
        if(newPart1.charAt(i) != 0){
            output.append(newPart1.charAt(i));
        }
        if(i < newPart2.length()){
        output.append(newPart2.charAt(i));
    }
    }    
    System.out.println(output.toString());
    return output.toString(); //нужно слепить 2 половины сроки обратно в одну
}
void testTwoKeyDecrypt(){
    FileResource fr = new FileResource();
    twoKeyDecrypt(fr.asString());
}
void testTwoKeyDecryptWithKeys(){
FileResource fr = new FileResource();
twoKeyDecryptWithKeys(fr.asString(), 2, 20);
}
}

