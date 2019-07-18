//package works.weave.socks.cart.cartserver.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import works.weave.socks.cart.cartserver.entities.HealthCheck;
//
//import java.util.*;
//
///**
// * @Auther: yaya
// * @Date: 2019/7/2 22:40
// * @Description:
// */
//@RestController
//public class HealthCheckController {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.GET, path = "/health")
//    public
//    @ResponseBody
//    Map<String, List<HealthCheck>> getHealth() {
//        Map<String, ListHealthCheck>> map = new HashMap<String, List<HealthCheck>>();
//        List<HealthCheck> healthChecks = new ArrayList<HealthCheck>();
//        Date dateNow = Calendar.getInstance().getTime();
//
//        HealthCheck app = new HealthCheck("carts", "OK", dateNow);
//        HealthCheck database = new HealthCheck("carts-db", "OK", dateNow);
//
//        try {
//            mongoTemplate.executeCommand("{ buildInfo: 1 }");
//        } catch (Exception e) {
//            database.setStatus("err");
//        }
//
//        healthChecks.add(app);
//        healthChecks.add(database);
//
//        map.put("health", healthChecks);
//        return map;
//    }
//}
//
