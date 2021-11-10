package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class YandexBeforeSearchIPhone{

    protected WebDriver driver;

    public YandexBeforeSearchIPhone(WebDriver driver, String search){
        this.driver = driver;
        this.driver.get("https://yandex.ru/search?text=" + search);
        driver.findElement(By.xpath("//a[@accesskey='1']")).click();
    }

    public void YandexBeforeSearchIPhone(){

        Set<String> windows = driver.getWindowHandles();
        List<String> windows1 = new ArrayList<>(windows);

        driver.switchTo().window(windows1.get(1));
        driver.findElement(By.xpath("//a[@href='/catalog--elektronika/54440']")).click();

        driver.switchTo().window(windows1.get(1));
        driver.findElement(By.xpath("//a[@href='/catalog--mobilnye-telefony/26893750/list?hid=91491']")).click();

    }
}