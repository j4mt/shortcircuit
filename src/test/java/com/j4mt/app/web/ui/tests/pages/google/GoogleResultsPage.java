package com.j4mt.app.web.ui.tests.pages.google;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GoogleResultsPage {

public ElementsCollection results() {
    return $$("#ires li.g");
}

    public GoogleResultsPage resultLink(String resultLink){
        $(By.xpath("//cite[contains(text(),'" + resultLink +"')]")).exists();
        return page(GoogleResultsPage.class);
    }

}
