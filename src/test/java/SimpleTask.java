import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTask {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("file:///C:/Users/madin/Downloads/Microsoft.SkypeApp_kzf8qxf38zg5c!App/All/index.html#item4");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }
    @Test
    public void fillForm(){
        WebElement name = wd.findElement(By.name("name"));
        WebElement surename = wd.findElement(By.name("surename"));
        WebElement sendBtn = wd.findElement(By.tagName("button"));
        WebElement textBox = wd.findElement(By.className("message"));

        fillField(name, "Tom");
        //name.click();
        //name.clear();
        //name.sendKeys("Tom");

        String text = "Doe";
        fillField2(surename, text);

        sendBtn.click();

        String result = textBox.getText();
        System.out.println(result);

        Assert.assertEquals(result, "Tom Doe");

    }

    public void fillField2(WebElement el, String text) {
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public void fillField(WebElement el, String text){
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    @Test
    public void selectItemTest(){
        WebElement item = wd.findElement(By.tagName("a"));
        item.click();
        String itemText = item.getText();
        System.out.println(itemText);

        WebElement textBox = wd.findElement(By.className("message"));
        String result = textBox.getText();
        System.out.println(result);

        Assert.assertTrue(result.contains(item.getText()));
    }

    @Test
    public void selectItemFromlist(){
        List<WebElement> items = wd.findElements(By.tagName("a"));
        System.out.println(items.size());

        items.get(2).click();
        String itemText = items.get(2).getText();
        System.out.println(itemText);

        WebElement textBox = wd.findElement(By.className("message"));
        String result = textBox.getText();
        System.out.println(result);

        Assert.assertTrue(result.contains(itemText));
    }

    @AfterMethod
    public void tearDown(){
       // wd.quit();
    }
}
