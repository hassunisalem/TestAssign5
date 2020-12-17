import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PracticeTables {
static WebDriver driver;

public static void launchBrowser(){
 System.setProperty("webdriver.gecko.driver", "C:\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://sqengineer.com/practice-sites/practice-tables-selenium/");
}


public static void ClickLinks(){


    for (int i = 2; i < 6; i++) {
        driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+i+"]/td[3]/a")).click();
        driver.navigate().back();
    }
/*
    driver.findElement(By.linkText("https://www.seleniumhq.org/")).click();
    driver.navigate().back();
    driver.findElement(By.linkText("Unified Functional Tester")).click();
    driver.navigate().back();
    driver.findElement(By.linkText("https://www.ranorex.com/")).click();
    driver.navigate().back();
    driver.findElement(By.linkText("Test Complete")).click();
    driver.navigate().back();

 */
}
    //*[@id="contents"]/ytd-item-section-renderer[1]
public static ArrayList<String> GetCatURLs(){
    ArrayList<String> catList = new ArrayList<String>();

    driver = new ChromeDriver();
    driver.get("https://www.youtube.com/results?search_query=cat+videos&sp=EgQIAhAB");

    for (int i = 1; i < 11; i++) {
    driver.findElement(By.xpath("//*[@id=\"contents\"]["+ i +"]")).click();

    // youtube spørg om jeg gerne vil logge ind og knappen "no thanks" bliver trykket
    driver.findElement(By.xpath("//*[@id=\"button\"]")).click();

    // agree knap bliver trykket for cookies
    driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();

    catList.add(driver.getCurrentUrl());
    System.out.println(driver.getCurrentUrl());
    driver.navigate().back();

    }
        return catList;

}
public static void SaveURLsToFile(ArrayList<String> cList) throws IOException {
    File output = new File("catURLs.txt");
    FileWriter writer = new FileWriter(output);
    for (int i = 0; i < cList.size(); i++) {
        writer.write(cList.get(i));
        writer.flush();
    }
    writer.close();
}

public static void main(String[] args) throws IOException {
    launchBrowser();
    ClickLinks();
    SaveURLsToFile(GetCatURLs());
}


}
