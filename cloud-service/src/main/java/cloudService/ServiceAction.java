package cloudService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohaiqiu on 2017/8/30.
 */
@RestController
public class ServiceAction {


    @RequestMapping("/s/{id}")
    public Object test(@PathVariable int id){
        System.out.println("-----service-");
        System.out.println("-----service-");
        System.out.println("-----service-");
        System.out.println("-----service-");
        id = id + 1;
        return id;
    }
}
