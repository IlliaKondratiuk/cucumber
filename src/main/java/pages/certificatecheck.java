package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class certificatecheck {
    @FindBy(name = "certificate")
    WebElement certificate_input;
    @FindBy(xpath = "//button[contains(@class, 'certificate-check_submit')]")
    WebElement check_button;

    WebDriver driver;

    public certificatecheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void certificate_input(String number) {
        certificate_input.sendKeys(number);
    }

    public void checkbutton_click() {
        check_button.click();
    }

    public boolean checkcertifChekForm() throws Exception {
        System.out.println(checkFormMassage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMassage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate cheker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMassage;

    private boolean checkLinkCertificate() {
        return driver.getCurrentUrl().contains("view");
    }
}

