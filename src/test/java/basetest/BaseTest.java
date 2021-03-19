package basetest;

import datafetchfromexcel.DataFetchFromExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    protected HomePage homePage;
    protected int WaitTime = 15;
    public static DataFetchFromExcel configSheet = new DataFetchFromExcel();
    private static String baseURL;
    protected static boolean isUserLoggedIn = false;


    @BeforeTest
    @Parameters({"browser"})
    public void Setup(@Optional("chrome") String browserName){

        //choose the excel sheet that contains the configurations
        configSheet.fileNameRead("config.xlsx");
        //get the application base url from excel
        baseURL = configSheet.getStringUnderTitle("URL", 0);

        if(browserName.equalsIgnoreCase( "chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @BeforeClass
    public void NavigateToBaseURL() {

        driver.get(baseURL);

        homePage = new HomePage(driver);
    }

    @AfterTest
    public void terminate(){
        isUserLoggedIn = false;
        driver.quit();
    }
}
