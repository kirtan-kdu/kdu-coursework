package kdu.ques2;

import kdu.LoggingClass;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
        String[][] featureSet = {{ "ambiance", "ambience", "atmosphere", "decor" },{ "dessert", "ice cream", "desert" },{ "food" },{ "soup" },{ "service", "management", "waiter", "waitress","bartender", "staff", "server" }};
        String[] posOpinionWords = { "good", "fantastic", "friendly","great", "excellent", "amazing", "awesome","delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible","awful", "unprofessional", "poor" };
        int[] featureOpinions = SentimentAnalyzer.detectProsAndCons(review, featureSet,posOpinionWords, negOpinionWords);
        LoggingClass.logger.info("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}