package com.jpmc.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class HomePage {

    public void closeAlart(){
        switchTo().frame($x("//iframe[@title='Iframe title']"));
        if ($x("//button[@title='Yes, I’m happy']").isDisplayed()) {
            $x("//button[@title='Yes, I’m happy']").click();
        }
        switchTo().defaultContent();
    }

    public String getNewsFeedTextByIndex(int index){
        return $x(String.format("(//a[@class='u-faux-block-link__overlay js-headline-text'])[%s]",index)).getOwnText();
    }
}
