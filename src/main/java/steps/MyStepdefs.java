package steps;

import config.base;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.certificatecheck;

public class MyStepdefs extends base {

    certificatecheck checkpage = new certificatecheck(driver);

    static {
        if (driver == null){
            base.base_before();
        }
    }

    @Before("@Launch")
    public void launch() {
        driver.get("https://certificate.ithillel.ua/");
    }

    @And("the check button is clicked")
    public void checkButtonIsClicked() {
        checkpage.checkbutton_click();
    }


    @Then("confirm that the certificate is found")
    public void confirmThatTheCertificateIsFound() {
        System.out.println(driver.getCurrentUrl());
        //Assert.assertTrue(driver.getCurrentUrl() == "https://certificate.ithillel.ua/view/45924126");
    }

    @When("the certificate number is entered {string}")
    public void theCorrectCertificateIsEntered(String number) {
        checkpage.certificate_input(number);
    }

    @Then("confirm {string}")
    public void confirm(String results) throws Exception {
        Assert.assertEquals(Boolean.valueOf(results), checkpage.checkcertifChekForm());
    }
}
