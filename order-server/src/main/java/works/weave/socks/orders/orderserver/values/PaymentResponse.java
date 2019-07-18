package works.weave.socks.orders.orderserver.values;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 21:45
 * @Description:
 */
public class PaymentResponse {
    private boolean authorised = false;
    private String  message;

    // For jackson
    public PaymentResponse() {
    }

    public PaymentResponse(boolean authorised, String message) {
        this.authorised = authorised;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "authorised=" + authorised +
                ", message=" + message +
                '}';
    }

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

