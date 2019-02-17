package com.j4mt.app.web.ui.tests.util;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelenideLogger.class);

    public static void waitABit(long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException var4) {
            LOGGER.warn("Wait a bit method was interrupted.", var4);
        }

    }
}
