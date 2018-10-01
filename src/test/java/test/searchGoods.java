package test;

import ManagerApplication.findHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class searchGoods extends findHelper {

    @Test
    //Поиск смартфона Самсунг, применение фильтра по цене от 40000
    //Сравнивание названия телефона на списке и описании
    public void searchPhone() throws InterruptedException {
        app.openURL("https://yandex.ru/");
        app.fintTelephoneOnMarket();
        Thread.sleep(2000);
            String nameOnList = app.findTitle().getText();
        app.findTitle().click();
        Thread.sleep(2000);
            String nameOnDescription = app.getH1().getText();
        Assert.assertEquals(nameOnList,nameOnDescription);
                }

    @Test
    //Поиск наушников, применение фильтра по цене от 17000 до 25000
    //сСравнивания названия на списке и описании
    public void searchHeadphones() throws InterruptedException {
        app.openURL("https://yandex.ru/");
        app.searchHeadPhones();
        Thread.sleep(2000);
        String nameOnList = app.findTitle().getText();
        app.findTitle().click();
        Thread.sleep(2000);
        String nameOnDescription = app.getH1().getText();
            Assert.assertEquals(nameOnList,nameOnDescription);
    }

    @Test
    //Сохранение текста со страницы "о работе в банке"
    public void inportInfointoFile() throws InterruptedException {
        String browserName = app.getbrowser();
        List<String> listStr= new ArrayList<>();
        String title,test;

        app.openURL("https://www.google.ru/");
        String searchPageName = app.wd.getTitle();
        String fileName = " " + browserName + " " +searchPageName;
        app.goToAlfaBankPage();
            Thread.sleep(2000);
        for (String tab: app.wd.getWindowHandles()){
            app.wd.switchTo().window(tab);
        }
        app.openWorkPage();
        title = app.wd.findElement(By.xpath(".//*[@class='message']")).getText();
        test =  app.wd.findElement(By.xpath(".//*[@class='info']")).getText();
        listStr.add(title);
        listStr.add(test);
        app.createAndWriteFile(listStr, fileName);
    }

}
