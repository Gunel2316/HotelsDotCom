package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.List;
import java.util.Set;

public class test {





    public static void main(String[] args) {

        System.out.println(SharedSD.getDriver().findElement(By.xpath("//span[@class='summary swap']")));
    }}
