import MagentoPage.*;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class magentoTest {
    private static WebDriver driver;


    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @BeforeEach
    public void setUp() {
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testHome1() {
        homesPage homes = new homesPage(driver);

        String url = homes.getUrlHome();
        assertEquals("https://magento.softwaretestingboard.com/", url);
    }

//    @Test
//    public void testCreateAccount() {
//        homesPage homes = new homesPage(driver);
//        homes.clickAccount();
//
//        createAccountPage form = new createAccountPage(driver);
//        form.setFirstName("Afifah");
//        form.setLastName("Laily");
//        form.setCheckbox();
//        form.setEmail("afilaily2@gmail.com");
//        form.setPassword("Lilyihsanyahya123");
//        form.setConfirmPassword("Lilyihsanyahya123");
//        form.clickButton();
//        accountPage succes = new accountPage(driver);
//        String url = succes.getUrlPageAccount();
//        //Assert.assertTrue(url.contains("account"));
//        assertEquals("https://magento.softwaretestingboard.com/customer/account/", url);
//    }
    @Test
    @Order(2)
    public void testChooseMenuProduct() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();
        produkPage show = new produkPage(driver);
        String url = show.getUrlPageProduct();
        assertEquals("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html", url);
    }
    @Test
    @Order(3)
    public void testChooseProduct() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();

        produkPage clothes = new produkPage(driver);
        clothes.clickProduk1();

        detailProductPage show = new detailProductPage(driver);
        String url = show.getUrlDetailPageProduct();
        assertEquals("https://magento.softwaretestingboard.com/grayson-crewneck-sweatshirt.html", url);
    }

    @Test
    @Order(4)
    public void testAddCart() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();

        produkPage clothes = new produkPage(driver);
        clothes.clickProduk1();

        detailProductPage product1 = new detailProductPage(driver);
        product1.selectSize("L");
        product1.selectColor1("Red");
        product1.setQuantity("2");
        product1.setAddCart();
        product1.setClickBackProduct();

        clothes.clickProduk2();
        product1.selectSize("M");
        product1.selectColor2("Grey");
        product1.setQuantity("1");
        product1.setAddCart();

        assertEquals("3", product1.getCart());
    }

    @Test
    @Order(5)
    public void testCheckout() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage checkOut = new accountPage(driver);
        checkOut.setClickCart();
        checkOut.clickCheckout();

        shippingPage show = new shippingPage(driver);
        String url = show.getUrlPageShipping();
        assertEquals("https://magento.softwaretestingboard.com/checkout/", url);
    }
    @Test
    @Order(6)
    public void testSignOut() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage signOut = new accountPage(driver);
        signOut.setClickMenu();
        signOut.setClickSignOut();
        logOutPage logout = new logOutPage(driver);
        String url = logout.getUrlPageLogOut();
//        assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", url);
    }
}
