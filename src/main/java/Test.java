import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Pages mainPage = new Pages();
        mainPage.open();
        mainPage.chooseCity("New York");
        mainPage.chooseDate("1 December 2022", "31 December 2022");
        mainPage.search();
        mainPage.checkCity();
        mainPage.checkDates();
        mainPage.quit();
    }
}
