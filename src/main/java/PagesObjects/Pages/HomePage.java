package PagesObjects.Pages;

import PagesObjects.Locators.HomePageLocators;
import PagesObjects.Locators.SearchResultsLocators;
//import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends HomePageLocators {
    public WebDriver driver;
    private Logger log = Logger.getLogger("HomePage");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBarFields;

    /**
     * Purpose- To Search for a product
     * @param searchCriteria - product name
     */
   // @Description("To Search for a product")
    public void SearchForProduct(String searchCriteria){

         WebElement element =  driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys(searchCriteria);
        log.info("Eneterd search criteria");
        WebElement element1 =  driver.findElement(SEARCH_BUTTON);
        element1.click();
        log.info("Clicked on search button");
    }
}