import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CssLocator {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("file:///C:/Users/madin/Downloads/Microsoft.SkypeApp_kzf8qxf38zg5c!App/All/index.html#item4");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }
    @Test
    public void testItem(){
        wd.findElement(By.cssSelector("#nav ul li:first-child"));
        wd.findElement(By.cssSelector("#nav ul li:last-child"));
        wd.findElement(By.cssSelector("#nav ul li:nth-child(2)"));
        wd.findElement(By.cssSelector("#nav ul li:nth-child(3)"));
    }
    @Test
    public void testTowsTable(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#country-table tr"));
        System.out.println("Rows in table: " + rows.size());

        WebElement firstLine = wd.findElement(By.cssSelector("tr:first-child"));
        System.out.println("First row: " + firstLine.getText());

        WebElement lastLine = wd.findElement(By.cssSelector("tr:last-child"));
        System.out.println("Lasst row: " + lastLine.getText());

        WebElement secondLine = wd.findElement(By.cssSelector("tr:nth-child(2)"));
        System.out.println("Second row: " + secondLine.getText());
    }

    @Test
    public void testColumnsTable(){
        //List <WebElement> columns = wd.findElements(By.cssSelector("#country-table tr:first-child td"));
        List <WebElement> columns = wd.findElements(By.cssSelector("tr:first-child td"));
        System.out.println("All columns in table: " + columns.size());

        List <WebElement> firstColumn = wd.findElements(By.cssSelector("td:first-child"));
        System.out.println("First column");
        for (WebElement el:firstColumn) {
            System.out.println(el.getText());
        }

        List <WebElement> secondColumn = wd.findElements(By.cssSelector("td:nth-child(2)"));
        System.out.println("Second column");
        for (WebElement el:secondColumn) {
            System.out.println(el.getText());
        }
        System.out.println("+++++++++++++++++++++++++++++++");

        WebElement asia = wd.findElement(By.cssSelector("tr:first-child td:nth-child(2)"));
        System.out.println(asia.getText());

        System.out.println("+++++++++++++++++++++++++++++++");
        WebElement usa = wd.findElement(By.cssSelector("tr:nth-child(2) td:last-child"));
        System.out.println(usa.getText());
        }
    }

