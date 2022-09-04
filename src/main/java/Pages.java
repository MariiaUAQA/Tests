import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Pages {
    WebDriver driver = new ChromeDriver();
    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void open() {
        driver.get("https://www.booking.com");
    }

    public void chooseCity(String city) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='ss']"));
        searchBox.click();
        searchBox.sendKeys(city);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-i='0']")).click();
    }

    public void chooseDate(String startDate, String endDate) {
        WebElement calendar = driver.findElement(By.cssSelector(".bui-calendar__month"));
        w.until(ExpectedConditions.elementToBeClickable(calendar));
        WebElement btn = driver.findElements(By.cssSelector("[data-bui-ref='calendar-next']")).get(0);
        while (!driver.findElement(By.cssSelector(".bui-calendar__month")).getText().equals("December 2022")) {
            btn.click();
        }
        driver.findElement(By.cssSelector("[aria-label='"+startDate+"']")).click();
        driver.findElement(By.cssSelector("[aria-label='"+endDate+"']")).click();
    }

    public void search() {
        WebElement searchBtn = driver.findElement(By.cssSelector(".js-sb-submit-text"));
        searchBtn.click();
    }

    public void checkCity() {
        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='address']")));
        driver.findElements(By.cssSelector("[data-testid='address']")).forEach(webElement -> {
            if (webElement.getText().contains("New York")) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect city in list");
            }
        });
    }
    public void checkDates(){
        WebElement startD = driver.findElement(By.cssSelector("[data-testid='date-display-field-start']"));
        if (startD.getText().contains("December 1, 2022")) {
            System.out.println("right sd");
        } else {
            System.out.println("incorrect start date");
        }
        WebElement endD = driver.findElement(By.cssSelector("[data-testid='date-display-field-end']"));
        if (endD.getText().contains("December 31, 2022")) {
            System.out.println("right ed");
        } else {
            System.out.println("incorrect end date");
        }
    }

    public void quit() {
        driver.quit();
    }
}
