package org.drools.brmsconfig.command;

public class CommandFactoryService {
	private static final CommandFactoryService instance = new CommandFactoryService();
	
	public static CommandFactoryService getInstance() {
		return instance;
	}
	
	private CommandFactoryService() {
		
	}
	
	public CommandImpl getCommandFromMainMenuInput(long pid, int userInput) {
		// just for now...
		CommandImpl c = new CommandImpl();
		c.setSignalType("signal");
		c.setSignalData("Action1");
		c.setPid(pid);
		return c;
	}
}
