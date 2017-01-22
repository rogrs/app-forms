package br.com.rogrs.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogrs.model.Greeting;

@RestController
public class GreetingController {
	
	public static final String BASE_URL = "/greeting";

    private static final String template = "Hello, %s!";

    @RequestMapping(GreetingController.BASE_URL)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting( String.format(template, name));
    }
}
