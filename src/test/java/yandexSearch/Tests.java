package yandexSearch;

import org.junit.jupiter.api.Test;
import pages.*;

public class Tests extends BaseTests {

    @Test
    public void YandexLaptopOpen(){
        YandexBeforeLaptopSearch yandexBeforeSearch = new YandexBeforeLaptopSearch(chromeDriver, "yandex market");
        yandexBeforeSearch.goToCategoryLaptop();
        YandexAfterLaptopSearch yandexAfterLaptopSearch = new YandexAfterLaptopSearch(chromeDriver);
        yandexAfterLaptopSearch.priceFrom(String.valueOf(10000));
        yandexAfterLaptopSearch.priceTo(String.valueOf(30000));
        yandexAfterLaptopSearch.chooseManufacturer();
        yandexAfterLaptopSearch.dropDownClick();
        LaptopPage laptopPage = new LaptopPage(chromeDriver);
        laptopPage.get12Laptops();
        laptopPage.searchByFirstSnippet();
    }

    @Test
    public void YandexIphoneOpen(){
        YandexBeforeSearchIPhone yandexBeforeSearchIPhone = new YandexBeforeSearchIPhone(chromeDriver, "yandex market");
        yandexBeforeSearchIPhone.YandexBeforeSearchIPhone();
        YandexAfterSerachIPhone yandexAfterSerachIPhone = new YandexAfterSerachIPhone(chromeDriver);
        yandexAfterSerachIPhone.chooseManufacturer();
        yandexAfterSerachIPhone.visabilityOfElementsLoacated();
        yandexAfterSerachIPhone.dropDownClick();
        yandexAfterSerachIPhone.collectResultsFromPage();
        yandexAfterSerachIPhone.collectResults();
    }

    @Test
    public void AuthorizeTest(){

        LmsliteAuthorize lmsliteAuthorize = new LmsliteAuthorize(chromeDriver);
        lmsliteAuthorize.elementsClickable();
        lmsliteAuthorize.goToLogin("fominaelena","1P73BP4Z");
        lmsliteAuthorize.assertNewPage();

    }
}
