import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class TableForHome {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void testForTableRows() {
        //how menu rows in table with data
        //print row 2
        ////print row 7
        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        System.out.println("Rows: " + rows.size());

        System.out.println("Second Row:");
        System.out.println(wd.findElement(By.cssSelector("#customers tr:nth-child(2)")).getText());

        System.out.println("Seven Row:");
        System.out.println(wd.findElement(By.cssSelector("#customers tr:nth-child(7)")).getText());
    }

    @Test
    public void testForTableColumns(){
        //how menu columns in table with data
        //print all Country
        List<WebElement> columns = wd.findElements(By.cssSelector("#customers tr:first-child th"));
        System.out.println("Columns: " + columns.size());

        System.out.println("All countries in table:");
        List<WebElement> country = wd.findElements(By.cssSelector("#customers td:last-child"));
        for (WebElement el:country) {
            System.out.println(el.getText());
        }
    }

    @Test
    public void testForTableCells() {
        // print:  Helen Bennett
        //print:  Italy
        System.out.println(wd.findElement(By.cssSelector("#customers tr:nth-child(6) td:nth-child(2)")).getText());
        System.out.println(wd.findElement(By.cssSelector("#customers tr:last-child td:last-child")).getText());

    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}