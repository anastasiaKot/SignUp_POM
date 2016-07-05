import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

     String ana = "Ana";
     String phone = "6543210000";



    public void loadPage() {
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
    public void submitFormSuccessfully()
        {
        //String ana = "Ana";
        driver.findElement(By.xpath(".//*[@id='id_fname']")).sendKeys(ana);
        driver.findElement(By.xpath(".//*[@id='id_lname']")).sendKeys("Shpak");
        driver.findElement(By.xpath(".//*[@id='id_email']")).sendKeys("ana@yha.com");
        driver.findElement(By.xpath(".//*[@id='id_phone']")).sendKeys(phone);
        driver.findElement(By.xpath(".//*[@id='id_g_radio_02']")).click();
        WebElement element = (driver.findElement(By.xpath(".//*[@id='id_state']")));
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
        select.selectByVisibleText("California");
        driver.findElement(By.xpath(".//*[@id='id_checkbox']")).click();
        driver.findElement(By.xpath(".//*[@id='id_submit_button']")).submit();
        }

    }
