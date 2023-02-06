package com.docker.challenge.challenge1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hadi Zahedian
 * @since 2/6/2023
 */
@RestController
public class Challenge1Controller {

    @GetMapping("/hello")
    String hello() {
        return "Hello Stranger";
    }
}
