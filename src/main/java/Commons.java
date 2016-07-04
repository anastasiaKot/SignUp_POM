import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Commons
    {
       static WebDriver driver;

        public Commons(WebDriver driver)
        {
            this.driver = driver;
        }

        public Commons()
        {

        }
    public static void main (String[]args){
    System.out.println("main class");
    }

        public void loadPage()
        {
            driver.get("http://learn2test.net/qa/apps/sign_up/v1/");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        public void closeBrowser()
        {
            driver.quit();
        }

        public String getTitle()
        {
            //commons = new Commons();
            String title = driver.getTitle();
            return title;
        }

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
                return e.getMessage();
            }
            catch (IOException e)
            {
                return e.getMessage();
            }
            return tempValue;
        }

        public boolean isElementPresent(String element_id) throws IOException
        {
            Boolean existOrNot = driver.findElements(By.id(readResourses(element_id))).size() > 0;

            return existOrNot;

        }





    }
