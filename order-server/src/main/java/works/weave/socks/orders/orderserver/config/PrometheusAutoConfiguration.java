//package works.weave.socks.orders.orderserver.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Auther: yaya
// * @Date: 2019/7/2 21:41
// * @Description:
// */
//@Configuration
//@ConditionalOnClass(SpringBootMetricsCollector.class)
//class PrometheusAutoConfiguration {
//    @Bean
//    @ConditionalOnMissingBean(SpringBootMetricsCollector.class)
//    SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {
//        SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector
//                (publicMetrics);
//        springBootMetricsCollector.register();
//        return springBootMetricsCollector;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "prometheusMetricsServletRegistrationBean")
//    ServletRegistrationBean prometheusMetricsServletRegistrationBean(@Value("${prometheus.metrics" +
//            ".path:/metrics}") String metricsPath) {
//        DefaultExports.initialize();
//        return new ServletRegistrationBean(new MetricsServlet(), metricsPath);
//    }
//}
//
