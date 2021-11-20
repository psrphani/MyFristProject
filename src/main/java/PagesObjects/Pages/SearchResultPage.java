package PagesObjects.Pages;

import PagesObjects.Locators.SearchResultsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResultPage extends SearchResultsLocators {
    WebDriver driver;
    SearchResultsLocators searchResultsLocators = new SearchResultsLocators();
    String expectedText = "iPhone 13. Your new superpower.";

    public SearchResultPage(WebDriver driver) {

        this.driver = driver;
    }


    public void VerifySearchedResults() {
        WebElement element2 = driver.findElement(searchResultsLocators.SEARCHED_RESULT_TEXT);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchResultsLocators.SEARCHED_RESULT_TEXT));
        String actualTest = element2.getText();
        Assert.assertTrue(actualTest.contains(expectedText));
    }
}