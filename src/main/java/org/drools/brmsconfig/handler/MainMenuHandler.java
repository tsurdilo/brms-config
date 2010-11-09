package org.drools.brmsconfig.handler;

import org.drools.brmsconfig.command.CommandFactoryService;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;

public class MainMenuHandler implements WorkItemHandler {

	private StatefulKnowledgeSession ksession;
	
	public void abortWorkItem(WorkItem i, WorkItemManager m) {
	}

	public void executeWorkItem(WorkItem i, WorkItemManager m) {
		m.completeWorkItem(i.getId(), null);
		ksession.insert(CommandFactoryService.getInstance().getCommandFromMainMenuInput(i.getProcessInstanceId(), 4));
	}
	
	public void setSession(StatefulKnowledgeSession ksession) {
		this.ksession = ksession;
	}
}
