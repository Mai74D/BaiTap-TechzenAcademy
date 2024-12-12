package vn.techzen.academy_pnv_24.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "Da Nang") String address){
        return "Hello World"+" "+name+","+address+"!";
    }
}
