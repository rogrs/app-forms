package br.com.rogrs.batch;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.rogrs.model.CommandOutput;

@Service
public class RunShellCommand {

	private final Logger log = LoggerFactory.getLogger(RunShellCommand.class);

	public CommandOutput execute(String command) {
		CommandOutput output = new CommandOutput();
		log.info("Executando o comando " + command.toString());
		StringBuffer sb = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			log.info("output:", p.exitValue());
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			output.setMsgOutput(sb.toString());
			output.setCode(p.exitValue());

		} catch (Exception e) {
			output.setMsgError(e.getMessage());
			log.error("Erro na execução do comando  " + command, e);
			e.printStackTrace();
		}

		return output;

	}
}
