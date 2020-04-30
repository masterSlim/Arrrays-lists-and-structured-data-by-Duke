 

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> subList;
    private ArrayList<String> usedArrays;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    
    public GladLibMap(){
        myMap = new HashMap();
        subList = new ArrayList();
        usedArrays = new ArrayList();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        myMap = new HashMap();        
        subList = new ArrayList();
        usedArrays = new ArrayList();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        ArrayList<String> categories = new ArrayList(Arrays.asList("adjective", "noun", "color", 
            "country", "name", "animal", "timeframe", "verb", "fruit"));
            for(String s : categories){
            myMap.put(s, readIt(source+ "/" + s + ".txt"));
            }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        for(String s: myMap.keySet()){
        if(label.equals(s)){
            usedArrays.add(s);
            return randomFrom(myMap.get(s));        
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        }
        return "**UNKNOWN**";

    }
    
        int totalWordsInMap(){
        int counter = 0;
        for(ArrayList<String> al : myMap.values()){
            for(String s: al){
                counter +=1;
            }
        }
        return counter;
    }
    
        int totalWordsConsidered(){
            int counter = 0;
            for(String s: usedArrays){
             for(String st: myMap.get(s)){
             counter +=1;   
             }         
            }
            return counter;
        }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while (subList.indexOf(sub) != -1){
            sub = getSubstitute(w.substring(first+1,last));
        }
        subList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
            String story = fromTemplate("datalong/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nWords replaced: " + subList.size());
        subList.clear();
    }  
}
