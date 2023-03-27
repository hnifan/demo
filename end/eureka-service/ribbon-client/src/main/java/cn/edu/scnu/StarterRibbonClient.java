package cn.edu.scnu;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
public class StarterRibbonClient {
    public static void main(String[] args) {
        SpringApplication.run(StarterRibbonClient.class, args);
    }
    // 想在Ribbon客户端发起一个服务的调用，则要创建一个RestTemplate对象
//如果光是new一个RestTemplate对象，
//则无法实现通过服务名称调用服务的功能，只能具体访问某个服务器，
//必须加上@LoadBalanced注解，生成一个具备ribbon拦截功能的restTemplate
    @Bean
    @LoadBalanced//加了该注解，就开启负载均衡的功能
//加了注解后，在创建RestTemplate后会对它实现监听,通过它发起请求做到一个拦截
// 会根据负载均衡策略对象(IRule接口的实现类)
    // 实现访问服务的负载均衡方式 默认roundRobin轮询
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    // 创建一个自定义负载均衡策略
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
