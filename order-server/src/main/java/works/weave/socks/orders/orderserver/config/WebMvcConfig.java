//package works.weave.socks.orders.orderserver.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.MappedInterceptor;
//
///**
// * @Auther: yaya
// * @Date: 2019/7/2 21:39
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
