package com.jpmc.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.util.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class UtilSteps extends TestBase {

    public void searchGooglePageForSimilarNews(String locator, String news){
        ElementsCollection googleCol = $$(By.xpath(locator));
        googleCol.shouldHave(CollectionCondition.sizeGreaterThan(5));
        Assert.assertTrue(googleCol.size() > 5);
    }

    public void searchOtherNewsPageForSimilarNews(String news, String locator, String newsFeed, ArrayList<String> createSentence){
        ArrayList<String> newsFeeds = new ArrayList<>();
        ElementsCollection newFeedLocator = $$(By.xpath(locator));
        for (SelenideElement text : newFeedLocator){
            newsFeeds.add(text.getOwnText());
        }
        for (int i = 0; i < newsFeeds.size(); i++){
            System.out.println(newsFeeds.get(i));
        }
        Assert.assertFalse(String.format("%s is not on present on %s news", news, newsFeed),
                Arrays.asList(createSentence).contains(newsFeed));
    }

    public String createSearchWordFromNewsFeed(String feedWord){
        String[] searchNews = feedWord.split(" ");
        ArrayList<String> createSentence = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            createSentence.add(searchNews[i]);
        }
        String searchNewsWord = String.join(", ", createSentence)
                .replace(",", "")
                .replace(":", "");
        return searchNewsWord;
    }

    public void getNewsURL(String feed, String searchNewsWord, ArrayList<String> createSentence){
        if (feed.contains("Times")){
            open("https://www.thetimes.co.uk/");
            searchOtherNewsPageForSimilarNews(searchNewsWord, "//h3/a", feed, createSentence);
        }else if (feed.contains("Telegraph")){
            open("https://www.telegraph.co.uk/");
            searchOtherNewsPageForSimilarNews(searchNewsWord, "//h3/a", feed, createSentence);
        }
        else if (feed.contains("BBC")) {
            open("https://www.bbc.co.uk/");
            searchOtherNewsPageForSimilarNews(searchNewsWord, "//a/span/p", feed, createSentence);
        }
    }
}
