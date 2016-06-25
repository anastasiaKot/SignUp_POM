import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.xml.internal.messaging.saaj.util.SAAJUtil;
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
            signupPage.jjj();
            Assert.assertTrue(signupPage.verifyTitle(signupPage.readResourses("title_exp")));
        }


        @AfterClass
        public void tearDown()
        {
            signupPage.closeDriver();
        }



    }
