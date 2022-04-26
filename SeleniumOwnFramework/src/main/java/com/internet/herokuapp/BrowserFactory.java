package com.internet.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxProfile;
import util.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

        private static WebDriver driver;

        public static WebDriver getDriver() {

            String language = ConfigManager.getParam("language");
            String browser = ConfigManager.getParam("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--lang=" + language);
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("intl.accept_languages", language);
                    firefoxOptions.setProfile(profile);
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    break;
                default:
                    throw new NullPointerException("Undefined browser name");

            }
            return driver;
        }
}
