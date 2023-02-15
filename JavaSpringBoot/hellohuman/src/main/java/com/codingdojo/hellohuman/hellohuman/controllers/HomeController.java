package com.codingdojo.hellohuman.hellohuman.controllers;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class HomeController {
    @GetMapping("/")
    public String index(@RequestParam(value="name", required=false) String firstName,
                        @RequestParam(value="last_name", required=false) String lastName,
                        @RequestParam(value="times", required=false) Integer times
                        ) {
        if (times == null){
            times = 1;
        }
        String output = "Hello ";
        for (int i = 0; i < times; i++){
            if (firstName == null && lastName == null){
                output += "Human";
            }
            else if (lastName == null) {
                output += firstName + " ";
            }
            else {
                output += firstName + " " + lastName + " ";
            }
        }
        return output;
    }
}
