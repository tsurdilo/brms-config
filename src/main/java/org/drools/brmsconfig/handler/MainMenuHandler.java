package org.drools.brmsconfig.handler;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.drools.runtime.process.WorkflowProcessInstance;

public class MainMenuHandler implements WorkItemHandler {

	private StatefulKnowledgeSession ksession;
	
	public void abortWorkItem(WorkItem i, WorkItemManager m) {
	}

	public void executeWorkItem(WorkItem i, WorkItemManager m) {
		
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) ksession.getProcessInstance(i.getProcessInstanceId());
		processInstance.signalEvent("move", "Action1");
		m.completeWorkItem(i.getId(), null);
	}
	
	public void setSession(StatefulKnowledgeSession ksession) {
		this.ksession = ksession;
	}
	
}
