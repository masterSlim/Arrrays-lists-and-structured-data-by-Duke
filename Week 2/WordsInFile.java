
/**
 * Write a description of class WordsInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*; 
import edu.duke.*; 
import java.io.*;

public class WordsInFile {
    private HashMap <String, ArrayList> words;
    void WordsInFIle(){
        words = new HashMap();
    }
    private void addWordsFromFile(File f){
    FileResource fr = new FileResource(f);
    for(String s : fr.words()){
        if(words.containsKey(s)){
        ArrayList temp = words.get(s);
        temp.add(f.getName());
        words.put(s, temp);
        } else{
            ArrayList temp = new ArrayList();
            temp.add(f.getName());
            words.put(s, temp);
        }
        
    }
}
    void buildWordFileMap(){
        words.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max = 0;
        for(ArrayList al : words.values()){
            if(al.size() > max){
                max = al.size();
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordsInNum = new ArrayList<String>(); 
        for(String key : words.keySet()){
            ArrayList temp = words.get(key);
            if(temp.size() == number){
            wordsInNum.add(key);
            }
        }        
        return wordsInNum;
    }
    void printFilesIn(String word){
    for (String key : words.keySet()){
    if(key.equals(word)){
        ArrayList files = words.get(key);
        for (int i = 0; i< files.size(); i++){
            System.out.println(files.get(i));
        }
    }
    }
    }
    void tester(){
    buildWordFileMap();
    System.out.println("Max number is: " + maxNumber());
    System.out.println(words.keySet());
    System.out.println(words.values());
    }    
}
