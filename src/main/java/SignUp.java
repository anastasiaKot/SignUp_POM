import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import javax.imageio.IIOException;


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
        
        driver.get(readResourses("url"));
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
    public void jjj()
    {
        System.out.println(driver.getTitle());
    }

    public boolean verifyTitle(String expectedTitle)
    {
        String actualTitle = driver.getTitle();
        return expectedTitle.equals(actualTitle);
    }
    
    public void closeDriver()
    {
        driver.quit();
    }
    
//    public Properties getAppTestData() throws IOException
//    {
//        Properties properties = new Properties();
//        InputStream stream = SignUp.class.getClassLoader().getResourceAsStream("/AppData.properties");
//        properties.load(stream);
//        stream.close();
//        return properties;
//
//    }
    public String readResourses(String inputKey) {

       String tempValue = null;
       Properties properties = new Properties();

        try
          {
              properties.load(new FileInputStream("./src/main/resources/AppData.properties"));
              tempValue = properties.getProperty(inputKey);
          }
          catch (IIOException e)
          {
              e.printStackTrace();
          }
  
          catch (FileNotFoundException e)
          {
              System.out.println("Method 'readProperties()' - BLOCK");
              return e.getMessage();
          }
          catch (IOException e)
          {
              System.out.println("Method 'readProperties()' - BLOCK");
              return e.getMessage();
          }
          return tempValue;
      }


    }
