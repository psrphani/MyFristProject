import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
        String actualTitle;

        //System.setProperty("webdriver.gecko.driver","C:\\Users\\psrph\\IdeaProjects\\MyFirstProject\\src\\main\\Drivers\\geckodriver.exe");

        //System.setProperty("webdriver.edge.driver","C:\\Users\\psrph\\IdeaProjects\\MyFirstProject\\src\\main\\Drivers\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\psrph\\IdeaProjects\\MyFirstProject\\src\\main\\Drivers\\chromedriver.exe");

       // WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String baseUrl = null;
        driver.get(baseUrl);
        actualTitle = driver.getTitle();

        if (actualTitle.equals("Welcome: Mercury Tours")){
            System.out.println("Passed");
        }
        else
        {
            System.out.println("Failed");
        }
       // driver.quit();
    }
}
