package com.j4mt.app.web.ui.tests.pages.google;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    public static String url = "https://www.google.ie/";

    public GoogleResultsPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }

    public boolean isGoogplePage(){
        return $("#hplogo").exists();
    }
}

