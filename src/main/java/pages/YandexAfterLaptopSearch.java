package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexAfterLaptopSearch {

    protected WebDriver driver;

    private WebElement priceFrom;
    private WebElement priceTo;
    private WebElement clickCheckBoxHP;
    private WebElement clickCheckBoxLenovo;

    public YandexAfterLaptopSearch (WebDriver driver){
        this.driver = driver;
        priceFrom = driver.findElement(By.xpath("//input[@id='glpricefrom']"));
        priceTo = driver.findElement(By.xpath("//input[@id='glpriceto']"));
        clickCheckBoxHP = driver.findElement(By.xpath("//label[@for='7893318_152722']"));
        clickCheckBoxLenovo = driver.findElement(By.xpath("//label[@for='7893318_152981']"));
    }

    public void priceFrom(String sendKeyFrom){
        priceFrom.click();
        priceFrom.sendKeys(sendKeyFrom);
    }

    public void priceTo(String sendKeyTo){
        priceTo.click();
        priceTo.sendKeys(sendKeyTo);
    }

    public void chooseManufacturer(){
        clickCheckBoxHP.click();
        clickCheckBoxLenovo.click();
    }

    public void dropDownClick(){
         new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_8v6CF']")));
         driver.findElement(By.xpath("//div[contains(@data-tid, '1c7202ea')]")).click();
         driver.findElement(By.xpath("//button[contains(@data-tid, '65f9fd17')]")).click();
    }
}
