/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author jirka
 */

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class Analysis {

    public static Map<Character, Integer> analyzeChar(String text){

        Map<Character, Integer> analyzed = new HashMap<>();
        for (char c : text.toCharArray() ) {
            if(Character.isSpaceChar(c)){
                continue;
            }
            if(analyzed.containsKey(c)){
                analyzed.put(c , analyzed.get(c) + 1);
            }else{
                analyzed.put(c , 1);
            }
        }

        return analyzed;

    }

    public static Map<String, Integer> analyzeWordCount(String wordLimiter, String sentenceLimiter, String text){

        Map<String, Integer> analyzed = new HashMap<>();
        String splited[] = text.split("("+Pattern.quote(sentenceLimiter)+")|("+Pattern.quote(wordLimiter)+")");
        for (String c : splited ) {
            
            if(analyzed.containsKey(c)){
                analyzed.put(c , analyzed.get(c) + 1);
            }else{
                analyzed.put(c , 1);
            }
        }

        return analyzed;

    }

    public static Map<Integer, Integer> analyzeSentence(String limiter, String text){

        Map<Integer, Integer> analyzed = new HashMap<>();
        String splited[] = text.split(Pattern.quote(limiter));
        for (String c : splited ) {
            Integer len = c.length();
            if(analyzed.containsKey(len)){
                analyzed.put(len , analyzed.get(len) + 1);
            }else{
                analyzed.put(len , 1);
            }
        }

        return analyzed;

    }

    public static double analyzeSentenceAverage(String limiter, String text){

        Map<Integer, Integer> map = analyzeSentence(limiter, text);
        double lenghts = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            lenghts += entry.getKey()*entry.getValue();
        }
        return lenghts / (text.split(Pattern.quote(limiter)).length);

    }

    public static String writeAnalyze(Map analyzed){
        AtomicReference<String> toReturn = new AtomicReference<>("");
        analyzed.forEach((key, value) -> toReturn.set(toReturn.toString() + key + " : "+value+"\n"));
        
        return toReturn.toString();
    }
    
    public static String writeAnalyze(boolean analyzed){
        return Boolean.toString(analyzed);
    }

    public static String writeAnalyze(String analyzed){
        return analyzed;
    }
    
    public static String writeAnalyze(double analyzed){
        return Double.toString(analyzed);
    }
    
    public static String writeAnalyze(int analyzed){
        return Integer.toString(analyzed);
    }

    public static String writeAnalyze(int[] analyzed){
        int count = 0;
        String toReturn = "";
        
        for(int i : analyzed){
            count ++ ;
            toReturn += count + " : "+i+"\n";
        }
        
        return toReturn;
    }

    public static int[] analyzeRandomInt(){
        int length = 10;
        int integers[] = new int[length];

        for(int i = 0; i < length; i++){
            integers[i] = new Random().nextInt(21);
        }

        return integers;
    }

    public static String analyzeMirror(String text){
        int len = text.length();
        char letters[] = new char[len];

        for(char c : text.toCharArray()){
            len--;
            letters[len] = c;
        }

        return String.valueOf(letters);
    }
    
    
    
    
    
    /**
     * prints out letter  = letter count in text
     * @param input text
     */
   /* public static String analyzeLetterFreq (String input) {
        int letterCount []= new int [26];
        char [] fInput = input.toLowerCase().toCharArray();
        for (int x : fInput) {
            if(x - 'a' > 25 || x - 'a' < 0){
                continue;
            } else {
                letterCount[x - 'a'] +=1;
            }
        }
        StringBuilder tr = new StringBuilder();
        for (int i = 0; i <= 25; i++) {
            char toPrint = ((char)('a'+i));
            tr.append(String.format("%s = %s \n", toPrint, letterCount[i]));
        }
        return tr.toString();
    }*/
    /**
     * returns number of spaces
     * @param input text
     */
    public static int analyzeSpaceCount (String input){
        return analyzeWordDelimiterCount(" ", input);
    }
    /**
     * returns number of wordDelimiters
     * @param input
     * @param endOfWord
     * @return 
     */
    public static int analyzeWordDelimiterCount (String wordLimiter, String input){
       /* char [] fInput = input.toLowerCase().toCharArray();
        int count = 0;
        for (char c : fInput) {
            if (c == endOfWord){
            count ++;
            }
        }*/
        String spilts[] = input.split(wordLimiter);
        return spilts.length -1;
        /*
        StringBuilder rt = new StringBuilder(count);
        return rt.toString();*/
    }
    /**
     * returns int [] of words of length [i] count
     * @param input text
     * @param enOfSentence
     * @param endOfWord
     * @return 
     */
    public static Map<Integer, Integer> analyzeWordsLengthFrequency (String input, String wordLimiter, String sentenceLimiter){
        Map<Integer, Integer> wordsLength = new HashMap<>();
        String splitted [] = input.split("("+Pattern.quote(sentenceLimiter)+")|("+Pattern.quote(wordLimiter)+")|(\\n)");
        for (String x : splitted) {
            if(x.equals("")){
                continue;
            }
            int lengthOfX = x.length();
            if(wordsLength.containsKey(lengthOfX)){
                wordsLength.put(lengthOfX, wordsLength.get(lengthOfX) + 1);
            }else{
                wordsLength.put(lengthOfX, 1);
            }
            /*int lengthOfX = x.length();
            if (lengthOfX > 19){
                wordsLength[20] ++;
            } else{
                wordsLength[lengthOfX]++;
            }*/
        }
        return wordsLength;
    }
    /**
     * prints out words length frequency
     * @param wordsLength 
     */
    /*public static String analyzeWordsFreqToString (String input, String enOfSentence, String endOfWord){
        int [] wordsLength = analyzeWordsLengthFrequency(input, enOfSentence, endOfWord);
        StringBuilder rt = new StringBuilder();
        for (int i = 0; i < wordsLength.length - 1; i++) {
            rt.append(String.format("%s = %s", i, wordsLength[i]));
        }
        rt.append("more than 20 = " + wordsLength[20]);
        return rt.toString();
    }*/
    /**
     * returns and prints word avg length
     * @param wordsLength
     * @return 
     */
    public static double analyzeWordsLengthAverage (String input, String wordLimiter, String sentenceLimiter) {
        Map<Integer, Integer> words = analyzeWordsLengthFrequency(input, wordLimiter, sentenceLimiter);
        double lenghts = 0;
        int count= 0;
        for (Map.Entry<Integer,Integer> entry: words.entrySet()) {
            lenghts += entry.getKey()*entry.getValue();
            count += entry.getValue();
        }
        return lenghts / count;
        /*double total = 0;
        double count = 0;
        for (int i = 0; i <= wordsLength.length -1 ; i++) {
            total += wordsLength[i] * i;
            count += wordsLength[i];
        }
        return String.valueOf(total/count);*/
        
    }
    /**
     * returns differnce of longest - shortest word
     * @param input
     * @param enOfSentence
     * @param endOfWord
     * @return 
     */
    public static int analyzeDifferenceMinMaxWordLength(String input, String enOfSentence, String endOfWord){
        int min = Integer.MAX_VALUE;
        int max = 0;
        /*String splitted [] = input.split("("+Pattern.quote(endOfWord)+")|("+Pattern.quote(enOfSentence)+")|(\\n)");
        for (String x : splitted) {
            int lengthOfX = x.length();
            if (x.endsWith(enOfSentence)){
                lengthOfX = x.length()-1;
            }
            if(min > lengthOfX){
                min = lengthOfX;
            }
            if(max < lengthOfX){
                max = lengthOfX;
            }
        }*/
        Map<Integer, Integer> map = analyzeWordsLengthFrequency(input, endOfWord, enOfSentence);
        for(int i : map.keySet()){
            max = i > max ? i : max;
            min = i < min ? i : min;
        }
        return max - min;
    }
    /**
     * returns if input contains chockolate 4okolada chocko
     * @param input
     * @param enOfSentence
     * @param endOfWord
     * @return 
     */
    public static boolean analyzeContainsChockolate (String wordLimiter, String sentenceLimiter, String input) {
        List <String> chocko = Arrays.asList("chockolate" , "čokolada" , "chocko");
        /*String splitted [] = input.split("("+Pattern.quote(endOfWord)+")|("+Pattern.quote(enOfSentence)+")|(\\n)");
        for (String x : splitted) {
        if (chocko.contains(x)){
        return String.valueOf(true);            
        }
        }
        return String.valueOf(false);*/       
        return chocko.stream().anyMatch((s) -> (input.contains(s)));
    }
    /**
     * asks for input then returns true if input text contains word
     * @param input text
     * @param enOfSentence
     * @param endOfWord
     * @return 
     */
   /* public static String containsInput(String input, String enOfSentence, String endOfWord){
        Scanner scanner = new Scanner(System.in);
        String inputted = scanner.next();
        String splitted [] = input.split("("+Pattern.quote(endOfWord)+")|("+Pattern.quote(enOfSentence)+")|(\\n)");
        for (String x : splitted) {
            if(x.equals(inputted)){
                scanner.close();
                return String.valueOf(true);
            }
        }
        scanner.close();
        return String.valueOf(false);
    }
*/
    
    public static  int analyzeCharAllCount(String input){
        return input.length();
    }
}

