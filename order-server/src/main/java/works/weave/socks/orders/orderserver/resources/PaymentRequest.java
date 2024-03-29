package works.weave.socks.orders.orderserver.resources;

import works.weave.socks.orders.orderserver.entities.Address;
import works.weave.socks.orders.orderserver.entities.Card;
import works.weave.socks.orders.orderserver.entities.Customer;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 21:42
 * @Description:
 */
public class PaymentRequest {
    private Address address;
    private Card card;
    private Customer customer;
    private float amount;

    // For jackson
    public PaymentRequest() {
    }

    public PaymentRequest(Address address, Card card, Customer customer, float amount) {
        this.address = address;
        this.customer = customer;
        this.card = card;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "address=" + address +
                ", card=" + card +
                ", customer=" + customer +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
