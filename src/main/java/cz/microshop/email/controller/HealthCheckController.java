package cz.microshop.email.controller;

import cz.microshop.email.model.HealthCheck;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;*/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HealthCheckController {

    /*@Autowired
    private MongoTemplate mongoTemplate;*/

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/health")
    @ResponseBody
    public Map<String, List<HealthCheck>> getHealth() {
        Map<String, List<HealthCheck>> map = new HashMap<>();
        List<HealthCheck> healthChecks = new ArrayList<>();
        Date dateNow = Calendar.getInstance().getTime();

        HealthCheck app = new HealthCheck("email", "OK", dateNow);
       /* HealthCheck database = new HealthCheck("email-db", "OK", dateNow);

        try {
            mongoTemplate.executeCommand("{ buildInfo: 1 }");
        } catch (Exception e) {
            database.setStatus("err");
        }*/

        healthChecks.add(app);
        //healthChecks.add(database);

        map.put("health", healthChecks);
        return map;
    }
}