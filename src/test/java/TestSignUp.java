import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestSignUp
    {
        private WebDriver driver;

        @BeforeClass
        public void loadPage()
        {
            driver = new FirefoxDriver();
            driver.get("http://learn2test.net/qa/apps/sign_up/v1/");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @Test
        public  void verifyTitle() throws IOException
        {
            String title = driver.getTitle();
            String title_exp = "Welcome to Sign Up v1";
            Assert.assertEquals(title, title_exp, "FAIL: expected  ");
        }


        @AfterClass
        public void tearDown()
        {
            driver.quit();
        }



    }
