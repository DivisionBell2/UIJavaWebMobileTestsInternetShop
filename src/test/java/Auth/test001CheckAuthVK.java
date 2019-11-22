package Auth;

import helpers.ConfigParse;
import helpers.MainClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class test001CheckAuthVK extends MainClass {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    void setUp(ITestResult tr) {
        driver = setupDriver(tr);
        mainPage = new MainPage(driver);
    }

    @Test
    public void test0001checkAuthVK() {
        mainPage
                .openAuthPopup()
                .enterVKData(ConfigParse.getProp("social_login"), ConfigParse.getProp("social_password"))
                .checkUserLogined()
        ;
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}

