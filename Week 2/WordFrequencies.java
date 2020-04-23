
/**
 * Write a description of class WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
    }
    void findUnique(){
    myWords.clear();
    myFreqs.clear();
    FileResource fr = new FileResource();
    for (String s : fr.words()){
    s = s.toLowerCase();
    int index = myWords.indexOf(s);
    if(index == -1){
    myWords.add(s);
    myFreqs.add(1);    
    }
    else{
    int value = myFreqs.get(index);
    myFreqs.set(index, value+1);
    }
    }
    }
    void tester(){
    findUnique();
    for(int k =0; k < myWords.size(); k++){
    System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
    }    
    System.out.println("Total unique words: " + myFreqs.size());
    int index = findIndexOfMax();
    System.out.println("Most popular word: \n" +myFreqs.get(index) + "\t" + myWords.get(index));
    }
    int findIndexOfMax(){
    int index = -1;
    int maxFreq = 0;
    for(int k = 0; k< myFreqs.size(); k++){
    if(myFreqs.get(k) > maxFreq){
        index = k;
        maxFreq = myFreqs.get(k);
    }
    }
    return index;
    }    
}
