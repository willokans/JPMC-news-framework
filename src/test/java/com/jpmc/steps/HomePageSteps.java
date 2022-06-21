package com.jpmc.steps;

import com.codeborne.selenide.*;
import com.jpmc.pages.GooglePage;
import com.jpmc.pages.HomePage;
import com.util.Urls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class HomePageSteps extends UtilSteps{

    private static String NEWS_FEED_HEADLINE;

    HomePage homePage = new HomePage();
    GooglePage googlePage = new GooglePage();


    @Given("{} navigate to The Guardian news feed page")
    public void navigateToNewsFeedPage(String user) {
        open(Urls.getURL("theguardian"));
        //Selenide.executeJavaScript("argument[0].click();","return document.querySelector('div.site-message--banner').shadowRoot.querySelector('button')");
        //homePage.closeAlart();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        $x("//div[@class='new-header__cta-bar']").shouldBe(Condition.visible);
    }

    @And("{} needs to check other sources to confirm a news article is valid")
    public void needsToCheckOtherSourcesToConfirmANewsArticleIsValid(String user) {
        NEWS_FEED_HEADLINE = homePage.getNewsFeedTextByIndex(1);
    }

    @Then("{} can confirm the validity on the article on {} search engine")
    public void userCanConfirmTheValidityOnTheArticleOnGoogle(String user, String feed) {
        String[] searchNews = NEWS_FEED_HEADLINE.split(" , ", 15);
        googlePage.searchGoogle(searchNews[0]);
        searchGooglePageForSimilarNews("//a/h3", searchNews[0]);
    }

    @Then("{} can confirm the validity of the article on the following source {}")
    public void UserCanConfirmTheValidityOnTheArticleOnTheFollowingSource(String user, String feed) {
        String searchNewsWord = createSearchWordFromNewsFeed(NEWS_FEED_HEADLINE);
        ArrayList<String> arrayListOfNewsFeeds = getSearchWords(searchNewsWord);
        getNewsURL(feed, searchNewsWord, arrayListOfNewsFeeds);
    }

    private ArrayList<String> getSearchWords(String searchNewsWord) {
        ArrayList<String> arrayListOfNewsFeeds = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            arrayListOfNewsFeeds.add(searchNewsWord);
        }
        return arrayListOfNewsFeeds;
    }

    @Given("{} navigate to a broken Guardian link")
    public void johnNavigateToAGuardianNewsFeedPage(String url_state) {
       RestAssured.get(Urls.getURL("broken_url_guardian"));
    }

    @Then("{} can't access The Guardian news")
    public void johnCanTAccessTheGuardianNews(String user) {
        try {
            RestAssured.get(Urls.getURL("broken_url_guardian"));
        }catch (Exception unknownHostException){
            Assert.assertTrue("Error should be thrown to user", !unknownHostException.getMessage().isEmpty());
        }
    }
}
