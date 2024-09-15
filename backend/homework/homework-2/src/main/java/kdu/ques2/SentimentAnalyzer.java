package kdu.ques2;

import java.lang.reflect.Array;
import java.util.Arrays;


public class SentimentAnalyzer {

    public static int[] detectProsAndCons(String review, String[][]
            featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        //    convert review to lower-case
        review = review.toLowerCase();

        for(int type=0;type<featureSet.length;type++){
            int isFeatureFound = 0;
            for(int feature = 0; feature<featureSet[type].length && isFeatureFound==0; feature++){
                // your code ~ you will be invoking getOpinionOnFeature
                isFeatureFound = getOpinionOnFeature(review, featureSet[type][feature], posOpinionWords, negOpinionWords);
            }
            featureOpinions[type] = isFeatureFound;
        }
        return featureOpinions;
    }

// First invoke checkForWasPhrasePattern and if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature,
                                           String[] posOpinionWords, String[] negOpinionWords) {
        int wasPhrasePattern = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        return (wasPhrasePattern==0)?checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords):wasPhrasePattern;
    }

    // Tip: Look at String API doc. Methods like indexOf, length,
//    substring(beginIndex), startsWith can come into play
// Return 1 if positive opinion found, -1 for negative opinion, 0
//for no opinion
    // You can first look for positive opinion. If not found, only
//    then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        int indexOfPattern = review.indexOf(pattern);
        if(indexOfPattern != -1){

            if(Arrays.stream(posOpinionWords).anyMatch(str -> str.equals(review.substring(indexOfPattern + pattern.length(), indexOfPattern + pattern.length() + posOpinionWords.length+1)))){
                return 1;
            }
            if(Arrays.stream(negOpinionWords).anyMatch(str -> str.equals(review.substring(indexOfPattern + pattern.length(), indexOfPattern + pattern.length() + posOpinionWords.length+1)))){
                return -1;
            }
        }
        return opinion;
    }
    // You can first look for positive opinion. If not found, only//    then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String
            feature, String[] posOpinionWords, String[] negOpinionWords) {
// Extract sentences as feature might appear multiple times.
// split() takes a regular expression and "." is a special
//        character
// for regular expression. So, escape it to make it work!!

        String[] sentences = review.split("\\.");
        int opinion = 0;

// your code for processing each sentence. You can return if
//        opinion is found in a sentence (no need to process subsequent ones)

        for(String sentence:sentences){
            int indexOfPattern = sentence.indexOf(feature);

            if(indexOfPattern > 0){
                for(String posOpinion:posOpinionWords){
                    int indexOfOpinion = sentence.indexOf(posOpinion);
                    if(indexOfOpinion!=-1 && (indexOfOpinion + posOpinion.length()+1 == indexOfPattern)){
                        opinion = 1;
                        return 1;
                    }
                }
                for(String negOpinion:negOpinionWords){
                    int indexOfOpinion = sentence.indexOf(negOpinion);
                    if(indexOfOpinion!=-1 && (indexOfOpinion + negOpinion.length()+1 == indexOfPattern)){
                        opinion = 1;
                        return -1;
                    }
                }
            }
        }
        return opinion;
    }

}