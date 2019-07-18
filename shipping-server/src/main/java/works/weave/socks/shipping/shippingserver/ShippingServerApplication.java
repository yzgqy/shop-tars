package works.weave.socks.shipping.shippingserver;

import com.qq.tars.spring.annotation.EnableTarsServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTarsServer
public class ShippingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingServerApplication.class, args);
    }

}
