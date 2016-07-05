import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.dom.XDom;

public class ConfirmationPageTest extends CommonsTest
{
SignUp signUpmain = new SignUp();


    @Test
    public void test001_enteredMatches()
     {
   // commonsMain.submitFormSuccessfully();
    String text = driver.findElement(By.xpath(".//*[@id='id_fname_conf']")).getText();
     String input = signUpmain.ana;
     Assert.assertEquals(text, input, "FAIL");
    }


    @Test
    public void test002_phone()
        {
       // commonsMain.submitFormSuccessfully();
        String text  = driver.findElement(By.xpath(".//*[@id='id_phone_conf']")).getText();
        String phone = signUpmain.phone;
        Assert.assertEquals(text, phone, "FAIL");
    }


@BeforeClass
public void setUp()
    {
    driver = new FirefoxDriver();
    signUpMain = new SignUp();
    commonsMain = new Commons(driver);
    commonsMain.loadPage();
    commonsMain.submitFormSuccessfully();
    }

}
