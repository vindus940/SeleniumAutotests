package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class YandexBeforeLaptopSearch {

        protected WebDriver driver;

        public YandexBeforeLaptopSearch(WebDriver driver, String search){
            this.driver = driver;
            this.driver.get("https://yandex.ru/search?text=" + search);
            driver.findElement(By.xpath("//a[@accesskey='1']")).click();
        }

         public void goToCategoryLaptop(){

             Set<String> windows = driver.getWindowHandles();
             List<String> windows1 = new ArrayList<>(windows);

             driver.switchTo().window(windows1.get(1));
             driver.findElement(By.xpath("//a[@href='/catalog--elektronika/54440']")).click();

             driver.switchTo().window(windows1.get(1));
             driver.findElement(By.xpath("//a[@href='/catalog--noutbuki/26895412/list?hid=91013']")).click();
        }
}
