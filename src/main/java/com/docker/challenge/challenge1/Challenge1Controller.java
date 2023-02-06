package com.docker.challenge.challenge1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hadi Zahedian
 * @since 2/6/2023
 */
@RestController
public class Challenge1Controller {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return "Hello " + name;
        }

        return "Hello Stranger";
    }
}
