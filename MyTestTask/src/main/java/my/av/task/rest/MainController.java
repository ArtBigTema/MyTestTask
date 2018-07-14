package my.av.task.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping
    public Object main() {
        System.out.println("called");
        return "test";
    }
}
