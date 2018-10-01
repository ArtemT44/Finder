package ManagerApplication;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class appManager {
    public WebDriver wd;

    public void fintTelephoneOnMarket() {
        wd.findElement(By.xpath("//a[contains(@data-statlog,'tabs.market')]")).click();
        wd.findElement(By.xpath("//a[@class='link topmenu__link'][contains(.,'Электроника')]")).click();
        wd.findElement(By.xpath("//*[@class='_1Y6X2G3jjK']/a[contains(.,'Мобильные телефоны')]")).click();
        wd.findElement(By.xpath("(//span[@class='NVoaOvqe58'][contains(.,'Samsung')])[1]")).click();
        wd.findElement(By.xpath("//input[contains(@class,'_2yK7W3SWQ- _1d02bPcWht')]")).sendKeys("40000");
    }
    public void goToAlfaBankPage() {
        wd.findElement(By.xpath("(//input[contains(@class,'gsfi')])[1]")).sendKeys("Альфа - Банк");
        wd.findElement(By.xpath("(//input[contains(@class,'gsfi')])[1]")).sendKeys(Keys.ENTER);
        wd.findElement(By.xpath("(.//a[starts-with(text(),'Альфа-Банк')])[1]")).click();
    }
    public void openWorkPage() {
        wd.findElement(By.xpath(".//a[@title='Вакансии']")).click();
        wd.findElement(By.xpath(".//span[contains(text(),'О работе в банке')]")).click();
    }

    public void searchHeadPhones() {
        wd.findElement(By.xpath("//a[contains(@data-statlog,'tabs.market')]")).click();
        wd.findElement(By.xpath("//*[@class='_1Y6X2G3jjK'][contains(.,'Наушники и Bluetooth-гарнитуры')]/a[1]")).click();
        wd.findElement(By.xpath("//span[contains(.,'Beats')]")).click();
        wd.findElement(By.xpath("//input[contains(@class,'1d02bPcWht')]")).sendKeys("17000");
        wd.findElement(By.xpath("//input[contains(@class,'1f2usTwyAs')]")).sendKeys("25000");
    }

    public WebElement findTitle() {
        return wd.findElement(By.xpath("(.//div[@class='n-snippet-cell2__title']/a)[1]"));
    }

    public WebElement getH1() {
        return wd.findElement(By.xpath(".//div[@class='n-title__text']/h1"));
    }

    public void openURL(String urlName){
        wd.get(urlName);

    }

    public void createAndWriteFile(List<String> item, String fileName){
        String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
         try{
            String path="./src/test/java/"+out+fileName+".txt";
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String str : item)
            {
                bw.write(str);
                bw.newLine();
            }
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String getbrowser() {
        Capabilities cap = ((RemoteWebDriver) wd).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void stop() {
        wd.quit();
    }
}
