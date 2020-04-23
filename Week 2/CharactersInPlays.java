
/**
 * Write a description of class CharactersInPlays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlays {
    ArrayList<String> names;
    ArrayList<Integer> counts;
    public CharactersInPlays(){
    names = new ArrayList<String>();
    counts = new ArrayList<Integer>();
    }
    void update(String person){
        if(names.indexOf(person) == -1){
        names.add(person);        
        counts.add(1);
        }
        else{
        int index = names.indexOf(person);
        int count = counts.get(index);
        counts.set(index, count+1);
        }    
    }
    void findAllCharacters(){
    FileResource fr = new FileResource();
    for (String s: fr.lines()){
    if(s.indexOf('.') != -1){
        int dotIndex = s.indexOf('.');
        int firstLetter= -1;
        String person;
        if(s.substring(0, dotIndex).split("\t").length < 3){
        person = s.substring(0, dotIndex).toLowerCase().trim();        
        update(person);
    }
    }
    }
    }
    void tester(){
        int indexOfMain =-1;
        int speakingMain = 0;
    findAllCharacters();
    for(int k=0; k<names.size(); k++){
        if(counts.get(k) > 1){
    System.out.println(names.get(k) + "\t" + counts.get(k));
    }
}
    for(int i=0; i<names.size();i++){
    if(counts.get(i)>speakingMain){
        indexOfMain = i;
        speakingMain = counts.get(i);
    }
    }
    System.out.println("Main character is: " + names.get(indexOfMain));
    characterWithNumParts(10, 15);
    }  

    void characterWithNumParts(int num1, int num2){
    if(num1<=num2){
        System.out.println("Persons, who have more than " + num1 +" but less than " + num2 + " speaking parts: \n");
        for(int i=0; i< counts.size(); i++){
        if(counts.get(i)>=num1 && counts.get(i)<=num2){
        System.out.println(names.get(i) + "\t" + counts.get(i));
        }
        }
    }
    else{
        System.out.println("Wrong numbers: num1 is greater than num2");
    }
} 
}
