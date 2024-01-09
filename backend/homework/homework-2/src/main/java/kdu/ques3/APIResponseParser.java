package kdu.ques3;

import kdu.LoggingClass;

public class APIResponseParser {
    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     *
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */


    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

// Your code
        String name = parse(response, "<name>", "<");
        String year = parse(response, "<original_publication_year type =\"integer\">", "<");
        String rating = parse(response, "<average_rating>", "<");
        String count = parse(response, "<ratings_count type =\"integer\">",  "<");
        String url = parse(response, "<image_url>", "<");


        book.setTitle(title);
        book.setAuthor(name);
        book.setPublicationYear(Integer.parseInt(year));
        book.setAverageRating(Double.parseDouble(rating));

        count = count.replaceAll(",","");
        book.setRatingsCount(Integer.parseInt(count));

        book.setImageUrl(url);

        LoggingClass.logger.info(book.getTitle());
        LoggingClass.logger.info(book.getAuthor());
        LoggingClass.logger.info(book.getPublicationYear() + "");
        LoggingClass.logger.info(book.getAverageRating() + "");
        LoggingClass.logger.info(book.getRatingsCount() + " ");
        LoggingClass.logger.info(book.getImageUrl());

        return book;
    }


    public static String parse(String response, String startRule, String endRule){
        int startRuleIndex = response.indexOf(startRule);
        int endRuleIndex = response.substring(startRuleIndex+startRule.length()).indexOf(endRule) + startRuleIndex + startRule.length();

        return response.substring(startRuleIndex + startRule.length(),endRuleIndex);
    }

}
