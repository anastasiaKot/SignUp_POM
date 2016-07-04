
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;


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


    public String readTestData(String inputKey) throws FileNotFoundException, IOException
        {

        String tempValue = null;
        Properties properties = new Properties();

        try
            {
            properties.load(new FileInputStream("./src/test/resources/TestData.properties"));
            tempValue = properties.getProperty(inputKey);
            } catch (IIOException e)
            {
            e.printStackTrace();
            } catch (FileNotFoundException e)
            {
            return e.getMessage();
            } catch (IOException e)
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

    public ArrayList readCSVfile() throws IOException
        {
//        String csvFile = "./src/test/resources/Elements.csv";
//        BufferedReader bufReader = null;
//        String line = null;
//        String splitBy = ",";
//        String xpath = null;
//
//        bufReader = new BufferedReader(new FileReader(csvFile));
        ArrayList list = new ArrayList();
//        while ((line = bufReader.readLine()) != null)
//            {
//            String[] csv = line.split(splitBy);
//            xpath = csv[0];
            list.add("id_lname, id_fname, id_f_title, id_email, id_phone, id_stateferew");
//            }
     return list;
        }
    }
