//package works.weave.socks.shipping.shippingserver.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.MappedInterceptor;
//import works.weave.socks.shipping.shippingserver.middleware.HTTPMonitoringInterceptor;
//
///**
// * @Auther: yaya
// * @Date: 2019/7/3 14:23
// * @Description:
// */
//@Configuration
//public class WebMvcConfig {
//    @Bean
//    HTTPMonitoringInterceptor httpMonitoringInterceptor() {
//        return new HTTPMonitoringInterceptor();
//    }
//
//    @Bean
//    public MappedInterceptor myMappedInterceptor(HTTPMonitoringInterceptor interceptor) {
//        return new MappedInterceptor(new String[]{"/**"}, interceptor);
//    }
//}
