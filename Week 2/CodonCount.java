
/**
 * Write a description of class CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CodonCount {
    private HashMap<String, Integer> dna;
    public void CodonCount(){
    dna = new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start, String dna){
    this.dna.clear();
    System.out.print("\n" + dna);
    for(int i=start; i<=dna.length()-3; i+=3){        
        String temp = dna.substring(i, i+3).trim();
        System.out.print(temp + " | ");
        if(temp.length()%3 ==0){
    if(this.dna.containsKey(temp)) this.dna.put(temp, this.dna.get(temp) + 1);
          else this.dna.put(temp, 1);
    }
}
}
    public String getMostCommonCodon(){
    int max = 0;
    String mostCommonsKey= "";
        for(String key : this.dna.keySet()){
            int commons = this.dna.get(key);
            if(commons > max) {
                max=commons; 
                mostCommonsKey= key;
            }
    }
    return mostCommonsKey;
    }
    void printCodonCounts(int start, int end){
            for(String key : this.dna.keySet()){
            int counts = this.dna.get(key);
            if(counts >= start && counts <=end) {
                System.out.println(key + " counts: " + counts);
            }
    }
    }
    void tester(){
        FileResource fr = new FileResource();
    for(int i = 0; i<3; i++){
    buildCodonMap(i, fr.asString());
    System.out.println("\n Started at " + i+ "\n Total codons: " + this.dna.size() + "\n Most common codon is:" 
    + getMostCommonCodon()+ " with " + this.dna.get(getMostCommonCodon())+ " counts.\nBetween 4 and 4 occurences inclusive are: ");
    printCodonCounts(4, 4);   
    }
    }
}
