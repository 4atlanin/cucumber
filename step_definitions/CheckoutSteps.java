package step_definitions;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import implementation.Checkout;
import static org.junit.Assert.*;

public class CheckoutSteps {

    int bananaPrice;
    int applePrice;
    Checkout checkout;

    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        bananaPrice = price;
    }

    @Given("^the price of an \"([^\"]*)\" is (\\d+)c$")
    public void thePriceOfAnIsC(String name, int price) {
        applePrice = price;
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {
        checkout = new Checkout();
        checkout.add(itemCount, bananaPrice);
    }
    
    @When("^I checkout (\\d+) additional \"([^\"]*)\"$")
    public void iCheckoutAdditional(int itemCount, String itemName) {
        checkout.add(itemCount, applePrice);
    }
    
    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
        assertEquals(total, checkout.total());
    }
}
