package br.com.rogrs.batch;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogrs.model.CommandOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RunShellCommandTest {
	
	@Autowired
	private RunShellCommand runShellCommand;
	
	
	@Test
	public void sendSimpleMessage() throws Exception {
		CommandOutput output = runShellCommand.execute("ls -l");
		
		assertNotNull(output);
		
	}
	
	

}
