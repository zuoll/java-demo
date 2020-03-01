package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Spring Cloud Gateway 是使用 netty+webflux 实现因此不需要再引入 web 模块。
 */
@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    /**
     * 代码实现
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        final String uri = "http://localhost:9898";
        return builder.routes()
                .route("r-test-get",
                        r -> r.path("/demo/get").uri(uri))

                .route("r-test-post", r -> r.path("/demo/save/user").uri(uri))


                .route("r-test-host",r -> r.host("*.zll.com:8080").and().path("/demo/get2")
                        .filters(f ->f.addResponseHeader("X-TestHeader", "foobar"))
                        .uri(uri)
                )
                .build();
    }

}