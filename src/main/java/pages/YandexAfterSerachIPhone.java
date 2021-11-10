package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.stream.Collectors;


public class YandexAfterSerachIPhone {

    private WebElement clickCheckApple;
    private WebDriver driver;
    private List<String> findResults;

    public YandexAfterSerachIPhone(WebDriver driver) {
        this.driver = driver;
        clickCheckApple = driver.findElement(By.xpath("//label[@for='7893318_153043']"));
    }

    public void chooseManufacturer(){
        clickCheckApple.click();
    }

    public void visabilityOfElementsLoacated(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, '_2cmzC')]")));
    }

    public void dropDownClick() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_8v6CF']")));
        driver.findElement(By.xpath("//div[contains(@data-tid, '1c7202ea')]")).click();
        driver.findElement(By.xpath("//button[contains(@data-tid, '65f9fd17')]")).click();
    }

    public List<String> collectResultsFromPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_8v6CF']")));
        List<WebElement> resultsNameWebElement = driver.findElements(By.xpath("//article//h3[@data-zone-name = 'title']//span"));

        Assertions.assertTrue(resultsNameWebElement.stream().anyMatch(x->x.getText().contains("Apple")),
                "the snippet does not contain the name of the apple");

        return resultsNameWebElement.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private boolean initNextPageButton() {
        List<WebElement> goNextPageButton = driver.findElements(By.xpath("//a[contains(@class, '_3OFYT')]"));
        if(goNextPageButton.size() > 0){
            goNextPageButton.get(0).click();
            return true;
        }
        else
            return false;
    }

    public void collectResults() {
        findResults = collectResultsFromPage();
        while (initNextPageButton()) {
            findResults.addAll(collectResultsFromPage());
        }
    }
}
