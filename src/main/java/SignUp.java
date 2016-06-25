import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


/**
 * Created by anastasia on 6/24/16.
 */
public class SignUp {

    WebDriver driver;
    public SignUp(WebDriver driver)
    {
        this.driver = driver;
    }



    public  void loadPage()
    {
        driver.get("http://learn2test.net/qa/apps/sign_up/v1/");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    public boolean verifyTitle(String expectedTitle)
    {
        String actualTitle = driver.getTitle();
        return expectedTitle.equals(actualTitle);
    }


}
