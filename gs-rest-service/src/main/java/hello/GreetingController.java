package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${name:World}")
    private String defaultValue;

    @Value("${age:defaultAge}")
    private String age;

    @Value("${weight:defaultWeight}")
    private String weight;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false) String name) {
        if (name == null) {
            name = this.defaultValue;
        } 
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name), age, weight);
    }
}
