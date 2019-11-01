package eu.albertomorales.training.acmebank.controller;

import eu.albertomorales.training.acmebank.dto.Pong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class PongController {
	
private static final String pongMsg = "Pong Mr./Ms. %s!";

    @GetMapping("/pong/user")
    @ResponseBody
    public Pong pongUser(@RequestParam(name="name", required=false, defaultValue="Trainee") String name) {
        return new Pong(String.format(pongMsg, name));
    }
    
}