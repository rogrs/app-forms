package br.com.rogrs.model;

public class CommandOutput {
	
	private String command;
	private String msgOutput;
	private String msgError;
	private int code;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMsgOutput() {
		return msgOutput;
	}
	public void setMsgOutput(String msgOutput) {
		this.msgOutput = msgOutput;
	}
	public String getMsgError() {
		return msgError;
	}
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

}
