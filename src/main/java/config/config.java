package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class config {
    static WebDriver driv;
    static public WebDriver create(drivers driver) {

        switch (driver) {
            case CHROME -> createchrome();
            case CHROME_INC -> createchromeinc();
        }

        return driv;
    }

    private static void createchromeinc() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driv = new ChromeDriver(options);
    }

    private static void createchrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driv = new ChromeDriver(options);
    }
}
