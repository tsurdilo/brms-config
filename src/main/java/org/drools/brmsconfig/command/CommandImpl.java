package org.drools.brmsconfig.command;

public class CommandImpl {
	
	private String signalType;
	private Object signalData;
	private String type;
	private long pid;
	
	public String getSignalType() {
		return signalType;
	}

	public Object getSignalData() {
		return signalData;
	}

	public String getType() {
		return type;
	}
	
	public long getPid() {
		return pid;
	}

	public void setSignalType(String signalType) {
		this.signalType = signalType;
	}

	public void setSignalData(Object signalData) {
		this.signalData = signalData;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setPid(long pid) {
		this.pid = pid;
	}
	
}
