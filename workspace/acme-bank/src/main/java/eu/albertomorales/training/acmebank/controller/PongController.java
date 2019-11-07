package eu.albertomorales.training.acmebank.controller;

import eu.albertomorales.training.acmebank.dto.Pong;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PongController {
	
private static final String pongMsg = "Pong Mr./Ms. %s!";

    @GetMapping("/pong/{name}")
    @RequestMapping(value={"/pong/{name}","/pong"}, method=RequestMethod.GET)    
    @ResponseBody
    public ResponseEntity<Pong> pongUser(@PathVariable(name = "name", required = false) String name) {
        String username = StringUtils.isEmpty(name) ? "Trainee" : name;
        return ResponseEntity.ok().body(new Pong(String.format(pongMsg, username)));    	
    }
    
}