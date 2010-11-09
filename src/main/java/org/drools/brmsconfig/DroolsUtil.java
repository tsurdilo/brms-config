package org.drools.brmsconfig;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsUtil {
	private KnowledgeBase kbase;
	
	public DroolsUtil setupRuleEngine() {
		if(kbase == null) {
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(ResourceFactory.newClassPathResource("rules/dispatcher.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("flows/main.rf"), ResourceType.DRF);
			KnowledgeBuilderErrors errors = kbuilder.getErrors();
			if (errors.size() > 0) {
				for (KnowledgeBuilderError error : errors) {
					System.err.println(error);
				}
				throw new IllegalArgumentException("Could not parse knowledge.");
			}
			kbase = KnowledgeBaseFactory.newKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		}
		return this;
	}
	
	public StatefulKnowledgeSession getStatefulSession() {
		return kbase.newStatefulKnowledgeSession();
	}
	
	public StatelessKnowledgeSession getStatelessSession() {
		return kbase.newStatelessKnowledgeSession();
	}

}
