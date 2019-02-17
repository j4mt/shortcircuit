package com.j4mt.app.web.ui.tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author j4mt
 */
public class DriverProvider {

    public static Properties config = null;
    public static WebDriver driver = null;

    public static void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
        config.load(ip);
    }

    public static WebDriver getDriver() throws Exception{
        // loads the config options
        LoadConfigProperty();
        // configures the driver path
        configureDriverPath();
        if (config.getProperty("browserType").equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (config.getProperty("browserType").equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--start-maximized");
            options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }


    public static void configureDriverPath() throws IOException {
//        if(System.getProperty("os.name").startsWith("Linux")) {
//            String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
//            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
//            String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
//            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        }
//        if(System.getProperty("os.name").startsWith("Mac")) {
//            String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
//            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
//            String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
//            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        }
        if(System.getProperty("os.name").startsWith("Windows")) {
//            String firefoxDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//geckodriver.exe";
//            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
    }

//    public static WebDriver getChromeDriver() throws IOException {
//
//        configureDriverPath();
//        ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.setExperimentalOption("useAutomationExtension", false);
//        driver = new ChromeDriver(options);
//
//        return driver;
//    }
//
//    public static void openBrowser() throws Exception {
//        // loads the config options
//        LoadConfigProperty();
//        // configures the driver path
//        configureDriverPath();
//        if (config.getProperty("browserType").equals("firefox")) {
//            driver = new FirefoxDriver();
//        } else if (config.getProperty("browserType").equals("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            //options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.setExperimentalOption("useAutomationExtension", false);
//            driver = new ChromeDriver(options);
//        }
//    }
//
//    public static void maximizeWindow() {
//        driver.manage().window().maximize();
//    }
//
//    public static void implicitWait(int time) {
//        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//    }
//
//    public static void explicitWait(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 3000);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public static void pageLoad(int time) {
//        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
//    }
//
//    public static void deleteAllCookies() {
//        driver.manage().deleteAllCookies();
//    }
//
//    public static void setEnv() throws Exception {
//        LoadConfigProperty();
//        String baseUrl = config.getProperty("siteUrl");
//        driver.get(baseUrl);
//    }
//
//    public static String currentDateTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        String cal1 = dateFormat.format(cal.getTime());
//        return cal1;
//    }
}
