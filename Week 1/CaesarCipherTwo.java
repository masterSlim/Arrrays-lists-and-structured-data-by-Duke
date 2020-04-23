
/**
 * Write a description of class CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;    
    private String shiftedAlphabet2;
    public CaesarCipherTwo(int key1, int key2){
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);    
    shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }
    String encrypt(String input){
    StringBuilder encrypted = new StringBuilder(input);
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
        //System.out.println(encrypted);
        return encrypted.toString();
    }
    String decrypt(String input){
    BreakCaesarCipher bcc = new BreakCaesarCipher();
    StringBuilder part1 = new StringBuilder();
    StringBuilder part2 = new StringBuilder();
    for(int i = 0; i < input.length(); i+=2){
    part1.append(input.charAt(i));
    }
    for (int i = 1; i < input.length(); i+=2){
    part2.append(input.charAt(i));
    }
    String newPart1 = bcc.decrypt(part1.toString());
    
    //System.out.println(part1 + "\n" + newPart1);
    String newPart2 = bcc.decrypt(part2.toString());
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
    //System.out.println(output.toString());
    System.out.println(output);
    return output.toString(); //нужно слепить 2 половины сроки обратно в одну
}
String decryptWithKeys(String input, int key1, int key2){
    StringBuilder part1 = new StringBuilder();
    StringBuilder part2 = new StringBuilder();
    for(int i = 0; i < input.length(); i+=2){
    part1.append(input.charAt(i));
    }
    for (int i = 1; i < input.length(); i+=2){
    part2.append(input.charAt(i));
    }
    CaesarCipher cc1 = new CaesarCipher(26-key1);
    String newPart1 = cc1.encrypt(part1.toString());
    
    //System.out.println(part1 + "\n" + newPart1);
    CaesarCipher cc2 = new CaesarCipher(26-key2);
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
    //System.out.println(output.toString());
    System.out.println(output);
    return output.toString(); //нужно слепить 2 половины сроки обратно в одну
}
}
