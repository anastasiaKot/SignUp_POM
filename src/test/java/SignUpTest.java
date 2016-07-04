import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class SignUpTest extends CommonsTest
{
@Test
public  void test001_PageTitle() throws IOException
    {
    String titleOfThePage = commonsMain.getTitle();
    String titleExpected = readTestData("title_exp");
    }

@Test
public void test002_quotesDynamic()
    {
    String text1 = driver.findElement(By.xpath(".//*[@id='id_quotes']")).getText();
    int length1 = text1.length( );
    driver.navigate().refresh();
    String text2 = driver.findElement(By.xpath(".//*[@id='id_quotes']")).getText();
    int length2 = text2.length();
    Assert.assertNotEquals(length1,length2, "JAJA");
    }

@Test
public void test003_Facebooklink() throws IOException
    {
    driver.findElement(By.xpath(".//*[@id='id_img_facebook']")).click();
    String new_title = handleWindows();
    Assert.assertEquals(new_title, readTestData("link_title"), "Not equal");
    }

@Test
public void test004_TwitterLink() throws IOException
    {
    driver.findElement(By.xpath(".//*[@id='id_img_twitter']")).click();
    String title = handleWindows();
    Assert.assertEquals(title, readTestData("linkTwitter"));
    }
@Test
public void test005_FlickerLink() throws IOException
    {
    driver.findElement(By.xpath(".//*[@id='id_img_flickr']")).click();
    String title = handleWindows();
    Assert.assertEquals(title, readTestData("linkFlicker"));
    }
@Test
public void test006_YouTubeLink() throws IOException
    {
    driver.findElement(By.xpath(".//*[@id='id_img_youtube']")).click();
    String title = handleWindows();
    Assert.assertEquals(title, readTestData("linkYoutube"));
    }
@Test
public void test007_checkboxDefault()
    {
    boolean checked = driver.findElement(By.xpath(".//*[@id='id_checkbox']")).isSelected();
    Assert.assertFalse(checked);
    }
//@Test
//public void test008_testFieldIsEmpty() throws IOException
//    {
//    ArrayList <String> locatorsByID = new ArrayList <String> (Arrays.asList("id_lname, id_fname, id_f_title, id_email, id_phone, id_stateferew"));
//    //ArrayList <String> locatorsByID = readCSVfile();
//
//    for (String tempString : locatorsByID)
//
//        {
//        String newId = tempString;
//        boolean isPresent = driver.findElements(By.id(newId)).size()>0;
//
//        Assert.assertTrue(isPresent,"Locator " + locatorsByID);
//        //  boolean empty = driver.findElement(By.xpath(".//*[@id='id_fname']")).getAttribute("value").isEmpty();
//        // Assert.assertTrue(empty);
//        }
//
//    }


@Test
public void test009_submitForm()
    {
    driver.findElement(By.xpath(".//*[@id='id_fname']")).sendKeys("Ana");
    driver.findElement(By.xpath(".//*[@id='id_lname']")).sendKeys("Shpak");
    driver.findElement(By.xpath(".//*[@id='id_email']")).sendKeys("ana@yha.com");
    driver.findElement(By.xpath(".//*[@id='id_phone']")).sendKeys("555-555-5656");
    driver.findElement(By.xpath(".//*[@id='id_g_radio_02']")).click();
    WebElement element = (driver.findElement(By.xpath(".//*[@id='id_state']")));
    Select select = new Select(element);
    select.selectByVisibleText("California");
    driver.findElement(By.xpath(".//*[@id='id_checkbox']")).click();
    driver.findElement(By.xpath(".//*[@id='id_submit_button']")).submit();
     String img = driver.getTitle();
    Assert.assertEquals(img, "Confirmation", "Failed");
    }





}
