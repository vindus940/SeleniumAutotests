package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaptopPage {

    protected WebDriver driver;

    private String TitleFirstSnippet;
    private  WebElement clickToSearchButton;
    private  WebElement headerSearch;

    public LaptopPage(WebDriver driver) {
        this.driver = driver;
        TitleFirstSnippet = driver.findElement(By.xpath("//span[@data-tid='ce80a508'][1]")).getText();
        clickToSearchButton = driver.findElement(By.xpath("//button[@data-r='search-button']"));
        headerSearch = driver.findElement(By.xpath("//input[@id='header-search']"));
    }

    private List<String> productSnippetList = new ArrayList<>();

    public void get12Laptops() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//article[@data-autotest-id='product-snippet'][1]")));
        for (int i = 0; i <= 12; i++){
            productSnippetList.add("//article[@data-autotest-id='product-snippet'])[" + i + "]");
        }
        int size = productSnippetList.size();
        assertTrue((size != 12), "the size of the elements is not 12");
    }

    public void searchByFirstSnippet() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-tid='ce80a508'][1]")));
        headerSearch.click();
        headerSearch.sendKeys(TitleFirstSnippet);
        clickToSearchButton.click();
        assertTrue((driver.getPageSource().contains(TitleFirstSnippet)), "the product name does not match the stored value");
    }
}

