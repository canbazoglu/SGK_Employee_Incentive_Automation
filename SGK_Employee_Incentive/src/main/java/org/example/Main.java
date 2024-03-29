package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver Draver = new ChromeDriver();
        Draver.get("https://uyg.sgk.gov.tr/SigortaliTescil/amp/loginldap");
        Draver.manage().window().maximize();
        WebElement kullaniciadi = Draver.findElement(By.name("j_username"));
        kullaniciadi.click();
        WebElement buton = Draver.findElement(By.name("isyeri_kod"));
        buton.click();
        WebElement sistem = Draver.findElement(By.name("j_password"));
        sistem.click();
        WebElement işyeri = Draver.findElement(By.name("isyeri_sifre"));
        işyeri.click();
        kullaniciadi.sendKeys("");
        sistem.sendKeys("");
        buton.sendKeys("");
        işyeri.sendKeys("");

        Thread.sleep(9000);
        WebElement giriş = Draver.findElement(By.name("buttonOK"));
        giriş.click();
        WebElement görüntüle = Draver.findElement(By.xpath("/html/body/center/table[3]/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr[14]/td[1]/font/a"));
        görüntüle.click();

        String[] tckimliknumaraları = {
                ("tc"),
        };
        for (String TC : tckimliknumaraları) {
            System.out.println(TC);
            WebElement numara = Draver.findElement(By.name("kimlikno"));
            //numara.click();
            numara.sendKeys(TC);
            WebElement sorgula = Draver.findElement(By.name("sorgulabtn"));
            sorgula.click();
            WebElement tıkla = Draver.findElement(By.xpath("//*[@id=\"form1\"]/span/table/tbody/tr[6]"));
            tıkla.click();
            WebElement anamenü = Draver.findElement(By.xpath("//*[@id=\"div111\"]/a[1]"));
            anamenü.click();
            görüntüle = Draver.findElement(By.xpath("/html/body/center/table[3]/tbody/tr/td/table/tbody/tr[2]/td[2]/table[2]/tbody/tr[14]/td[1]/font/a"));
            görüntüle.click();
        }

    }
}