package br.com.rogrs.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogrs.batch.RunShellCommand;
import br.com.rogrs.model.CommandOutput;
import br.com.rogrs.model.Greeting;

@RestController
public class GreetingController {

	public static final String BASE_URL = "/greeting";

	private static final String template = "Hello, %s!";

	@Autowired
	private RunShellCommand runShellCommand;

	@RequestMapping(GreetingController.BASE_URL)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(String.format(template, name));
	}

	@RequestMapping(GreetingController.BASE_URL + "/execute")
	public Greeting execute(@RequestParam(value = "command", defaultValue = "ls -l") String command) {

		CommandOutput result = runShellCommand.execute(command);
		StringBuilder sb = new StringBuilder();
		sb.append("output: " + result.getMsgOutput());
		sb.append("code: " + result.getCode());
		sb.append("error: " + result.getMsgError());

		return new Greeting(String.format(template, sb.toString()));
	}
}
