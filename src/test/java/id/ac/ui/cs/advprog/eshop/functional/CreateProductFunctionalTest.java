package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void homePage_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        // Verify
        assertEquals("ADV Shop", pageTitle);
        assertEquals("Welcome", welcomeMessage);
    }

    @Test
    void productListPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        String titleProductList = driver.getTitle();
        assertEquals("Product List", titleProductList);
    }

     @Test
    void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();
        
        WebElement createProductButton = driver.findElement(By.linkText("Create Product"));
        createProductButton.click();

        String titleCreateProduct = driver.getTitle();
        assertEquals("Create New Product", titleCreateProduct);
    }

    @Test
    void CreateProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        WebElement createProductButton = driver.findElement(By.linkText("Create Product"));
        createProductButton.click();

        WebElement nameProductInput = driver.findElement(By.id("nameInput"));
        nameProductInput.clear();
        nameProductInput.sendKeys("Testing1");

        WebElement quantityProductInput = driver.findElement(By.id("quantityInput"));
        quantityProductInput.clear();
        quantityProductInput.sendKeys("150");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        WebElement productNameInTable = driver.findElement(By.xpath("//tr[last()]/td[1]"));
        String productName = productNameInTable.getText();
        assertEquals("Testing1", productName);

        WebElement productQuantityInTable = driver.findElement(By.xpath("//tr[last()]/td[2]"));
        String productQuantity = productQuantityInTable.getText();
        assertEquals("150", productQuantity);
    }
    
}