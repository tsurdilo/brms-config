package org.drools.brmsconfig;

import org.drools.brmsconfig.handler.MainMenuHandler;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkflowProcessInstance;

public class BrmsConfigMain {
	public static void main(String[] args) {
		final StatefulKnowledgeSession ksession = new DroolsUtil().getStatefulSession();
		MainMenuHandler mmh = new MainMenuHandler();
		ksession.getWorkItemManager().registerWorkItemHandler("Main Menu", mmh);
		mmh.setSession(ksession);
				
		new Thread(new Runnable() {
            public void run() {
              ksession.fireUntilHalt();
            }
          }).start();
		
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) ksession.startProcess("org.drools.brmsconfig.mainflow");
	}
}
