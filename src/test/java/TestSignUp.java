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
        SignUp signupPage;


        @BeforeClass
        public void loadPage()
        {
            WebDriver driver = new FirefoxDriver();

            signupPage = new SignUp(driver);
            signupPage.loadPage();


        }

        @Test
        public  void verifyTitle() throws IOException
        {
            Assert.assertTrue(signupPage.verifyTitle("Welcome to Sign Up v1"));
        }


//        @AfterClass
//        public void tearDown()
//        {
//            driver.quit();
//        }



    }
