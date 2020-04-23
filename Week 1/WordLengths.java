
/**
 * Write a description of class WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    int[] countWordLengths(FileResource resource, int[] counts){
        for (String word : resource.words()){
        if(word.length() != 0){
            if(!Character.isLetter(word.charAt(word.length()-1))){
            word = word.substring(0, word.length()-1);            
        }
    
        if(word.length() <= counts.length){
            counts[word.length()] += 1;
        }else{
            counts[counts.length] +=1;
        }
    }
}
    for(int i=0; i< counts.length; i++){
        if(counts[i] !=0){
    System.out.println("length is " + i + " : counts is " + counts[i]);
}
}
return counts;
}
int indexOfMax(int[] values){
int max = -1;
for(int i = 0; i<values.length; i++){
if (values[i] != 0 && values[i] > max){
max = i;
}
}
return max;
}
void testIndexOfMax(){
FileResource fr= new FileResource();
int [] counts = new int [150];
System.out.println("Index of max counts: " + indexOfMax(countWordLengths(fr, counts)));
}
void testCountWordLengths (){
FileResource fr = new FileResource();
int[] counts = new int[31];
countWordLengths(fr, counts);
}
}
