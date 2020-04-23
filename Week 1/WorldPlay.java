
/**
 * Write a description of class WorldPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldPlay {
    boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
        return true;
    } else {
        return false;
    }    
    }
    
    String replaceVowels (String phrase, char ch){
    StringBuilder newPhrase = new StringBuilder(phrase);
    for (int i = 0; i < newPhrase.length(); i++){
        if(isVowel(Character.toLowerCase((newPhrase.charAt(i))))){
            newPhrase.replace(i, i+1, Character.toString(ch));        
        }
    }
    return newPhrase.toString();    
    }
    String emphasize (String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i+=2){
        if(Character.toLowerCase((newPhrase.charAt(i))) == Character.toLowerCase(ch)){
        newPhrase.replace(i, i+1, Character.toString('*'));
        }
    }
        for (int i = 1; i < phrase.length(); i+=2){
        if(Character.toLowerCase((newPhrase.charAt(i))) == Character.toLowerCase(ch)){
        newPhrase.replace(i, i+1, Character.toString('+'));
        }
    } 
    return newPhrase.toString();
    }
    
    void testEmphasize(){
    System.out.println("dna ctgaaactga with a emphasized to: " + emphasize("dna ctgaaactga", 'a'));
    System.out.println("Mary Bella Abracadabra with a emphasized to: " + emphasize("Mary Bella Abracadabra", 'a'));
    }
    
    void testReplaceVowels(){
    System.out.println(replaceVowels("Hello world", '*') + " is changed \"Hello world\"");
    System.out.println(replaceVowels("Ombuderiado", '*') + " is changed \"Ombuderiado\"");
    }
    
    void testIsVowel(){
        System.out.println("Char F is vowel: " + isVowel('F'));
        System.out.println("Char f is vowel: " + isVowel('f'));
        System.out.println("Char A is vowel: " + isVowel('A'));
        System.out.println("Char a is vowel: " + isVowel('a'));
        System.out.println("Char ! is vowel: " + isVowel('!'));
        System.out.println("Char   is vowel: " + isVowel(' '));    
    }
}
