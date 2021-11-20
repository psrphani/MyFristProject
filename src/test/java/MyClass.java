import PagesObjects.Pages.HomePage;
import PagesObjects.Pages.SearchResultPage;
import Utilities.ConfigManager;
import Utilities.ExcelManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MyClass {

    WebDriver driver;
    String file = System.getProperty("user.dir") + "//" +"TestData"+"//"+ "AmazonData.xlsx";
    HomePage homePage ;
    SearchResultPage searchResultPage;
    private Logger log = Logger.getLogger("MyClass");




    @BeforeMethod(alwaysRun = true)
    public void BaseStep(){
        ConfigManager appData = new ConfigManager();
        final String baseUrl = appData.getProperty("URL");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\psrph\\IdeaProjects\\MyFirstProject\\src\\main\\java\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        log.info("----Started My first Test-----");
    }

    @DataProvider(name = "GetDataFromExcel")
    public Object[][] getAddressToAdd() {
        ExcelManager excel = new ExcelManager();
        return excel.getExcelData(file,"SearchData");
    }


    @Test(dataProvider = "GetDataFromExcel")
    public void MyTest(String searchCriteria){

        //search for a product
        homePage.SearchForProduct(searchCriteria);
        log.info("Searched For Product");
        //verify the searched results
        searchResultPage.VerifySearchedResults();
        log.info("Searched Results Were Displayed");


    }

    @AfterMethod
    public void close(){
        log.info("------My First Is Completed------");

        driver.close();
    }

}