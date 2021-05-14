package spellCheker;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
public class SpellChecker {
    public static void main(String args[]) throws FileNotFoundException{                 
     try { //for reading word.txt file
         Scanner filein = new Scanner(new File ("words.txt"));
          HashSet<String> hash = new HashSet();
           while (filein.hasNext()) {
                String tk = filein.next();
                hash.add(tk.toLowerCase());
           } 
         Scanner userFile = new Scanner(getInputFileNameFromUser());                     
         userFile.useDelimiter("[^a-zA-Z]+");
         while (userFile.hasNext()){                          
             String two = userFile.next();
             String two1 = two.toLowerCase();                                 
             if(!hash.contains(two1)){
                 System.out.println(two1 + ":" + corrections(two1, hash));                      
             }
         }        
     }
            catch (IOException e) {
                System.out.println("Not found file words.txt");   
            }
    }
    static TreeSet corrections(String badWord, HashSet dictionary){                 
         TreeSet<String> tree = new TreeSet<String>();
         for (int i=0; i<badWord.length(); i++){
             String s = badWord.substring(0,i) + badWord.substring(i+1);    
             if(dictionary.contains(s)){
                 tree.add(s);    
             }
        }  
     
         for (int i=0; i<badWord.length(); i++){
             for (char ch = 'a'; ch <= 'z'; ch++) {
                 String s = badWord.substring(0,i) + ch + badWord.substring(i+1);     
                 if(dictionary.contains(s)){
                     tree.add(s);     
                 }
             }   
         }
         for (int i=0; i<=badWord.length(); i++){
             for (char ch = 'a'; ch <= 'z'; ch++) {     
                 String s = badWord.substring(0,i) + ch + badWord.substring(i);     
                 if(dictionary.contains(s)){
                     tree.add(s);     
                 }
             }       
        }
         for (int i=1; i<badWord.length(); i++){
             String stringInput = badWord.substring(0,i) + " " + badWord.substring(i);    
             String tempString = "";
             StringTokenizer tempWords = new StringTokenizer(stringInput);
             while(tempWords.hasMoreTokens()){
         
                 String stringWord1 = tempWords.nextToken();
                 String stringWord2 = tempWords.nextToken();
                 if(dictionary.contains(stringWord1) && dictionary.contains(stringWord2)){      
                     tempString = stringWord1 + " " + stringWord2;
                 }
         else      
            break;
                tree.add(tempString);    
             }
         }
         if(tree.isEmpty()){
             tree.add("no suggestions");   
         }
         return tree; 
    }
static File getInputFileNameFromUser() {
    JFileChooser fileDialog = new JFileChooser();   
    fileDialog.setDialogTitle("Select File for Input");   
    int option = fileDialog.showOpenDialog(null);   
    if (option != JFileChooser.APPROVE_OPTION)    
        return null;
    else
        return fileDialog.getSelectedFile();  
}
}

//References:
//Eck, D. J. (2019). Introduction to programming using Java, version 8.1. Hobart and William Smith Colleges. http://math.hws.edu/javanotes

