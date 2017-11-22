package cloudWebapp;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by mohaiqiu on 2017/8/30.
 */
@RestController
public class OneAction {

    @Resource
    RestTemplate restTemplate;

    @Resource
    EurekaClient eurekaClient;

    @RequestMapping("/webapp/{id}")
    public Object test(@PathVariable int id){

        try {
            id = restTemplate.getForObject("http://127.0.0.1:8081/s/"+id, Integer.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return "ok---"+id;
    }

    /**
     * 通过eurekaClient获取当前应用信息
     * 如本机地址
     * @return
     */
    @RequestMapping("/eureka-instance")
    public Object test2(){

        //参数为(注册中心的应用名称,false)
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("WEBAPP", false);
        return instanceInfo.getHomePageUrl();
    }
}
