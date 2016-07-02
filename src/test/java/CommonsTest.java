import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class CommonsTest
{

    SignUp signUpMain;
    Commons commonsMain;
    WebDriver driver;


    @BeforeClass
    public void setUp()
    {
        driver = new FirefoxDriver();
        signUpMain = new SignUp();
        commonsMain = new Commons(driver);
        commonsMain.loadPage();

    }
@AfterClass
public void closeDriver()
    {
    commonsMain.closeBrowser();
    }


public String readTestData(String inputKey) {

String tempValue = null;
Properties properties = new Properties();

try
    {
    properties.load(new FileInputStream("./src/test/resources/TestData.properties"));
    tempValue = properties.getProperty(inputKey);
    }
catch (IIOException e)
    {
    e.printStackTrace();
    }

catch (FileNotFoundException e)
    {
    return e.getMessage();
    }
catch (IOException e)
    {
    return e.getMessage();
    }
return tempValue;
}

public String handleWindows()
    {
    ArrayList<String> handleWindows = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(handleWindows.get(1));
    String new_title = driver.getTitle();
    driver.close();
    driver.switchTo().window(handleWindows.get(0));
    return new_title;
    }



}
