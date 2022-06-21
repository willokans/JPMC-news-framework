package com.jpmc.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    public void searchGoogle(String searchNews){
        open("https://www.google.com/");
        if ($x("//div[text()='Accept all']").isDisplayed())
            $x("//div[text()='Accept all']").click();

        if ($x("//div[text()='I agree']").isDisplayed())
            $x("//div[text()='I agree']").click();

        $x("//input[@aria-label='Search']").val(searchNews).pressEnter();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
