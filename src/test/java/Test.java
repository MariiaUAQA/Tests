public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
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
