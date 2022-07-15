/*
Name       : N Queens
Difficulty : Medium
Link       : https://practice.geeksforgeeks.org/problems/word-break-part-23249/
Author     : Chandra Mouli
*/


class Solution{
    
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> sentences = new ArrayList<String>();
        Set<String> words = new HashSet<>();
        for(String str: dict) words.add(str);
        
        constructSentences(s, "", words, sentences);
        return sentences;
    }
    
    static void constructSentences(String str,String ans,Set<String> words, List<String> sentences){
        int n = str.length();
        if(n == 0){
            // We have to remove Initial space
            sentences.add(ans.substring(1));
        }
        
        String curr = "";
        
        for(int i=0; i<n;i++){
            curr += str.charAt(i);
            if(words.contains(curr)){
                constructSentences(str.substring(i+1), ans + " " + curr, words, sentences);
            }
        }
    }
}
