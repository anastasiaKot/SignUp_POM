import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
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
public void test003_Facebooklink()
    {
    driver.findElement(By.xpath(".//*[@id='id_img_facebook']")).click();
    String new_title = handleWindows();
    Assert.assertEquals(new_title, readTestData("link_title"), "Not equal");
    }

@Test
public void test004_TwitterLink()
    {
    driver.findElement(By.xpath(".//*[@id='id_img_twitter']")).click();
    String title = handleWindows();
    Assert.assertEquals(title, readTestData("linkTwitter"));
    }
@Test
public void test005_FlickerLink()
    {
    driver.findElement(By.xpath(".//*[@id='id_img_flickr']")).click();
    String title = handleWindows();
    Assert.assertEquals(title, readTestData("linkFlicker"));
    }
@Test
public void test006_YouTubeLink()
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
@Test
public void test008_testFieldIsEmpty()
    {
   // List<String> actual = (List<String>) Arrays.asList(".//*[@id='id_fname']", ".//*[@id='id_lname']");
      boolean empty = driver.findElement(By.xpath(".//*[@id='id_fname']")).getAttribute("value").isEmpty();
        Assert.assertTrue(empty);
    }






}
