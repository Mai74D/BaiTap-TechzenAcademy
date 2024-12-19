package vn.techzen.academy_pnv_24.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class HelloWorldController {
    @PostMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "Da Nang") String address){
        return "Hello Mr./Ms. "+name+"\nYou are come from "+address+"!";
    }
}
