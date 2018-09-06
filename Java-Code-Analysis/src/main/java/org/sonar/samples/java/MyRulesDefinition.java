package org.sonar.samples.java;

import com.google.common.collect.Iterables;
import java.util.List;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;
import org.sonar.plugins.java.Java;

public class MyRulesDefinition implements RulesDefinition {
	public static final String REPOSITORY_KEY="Berk-Internship";
	public static final String REPOSITORY_NAME="Berk-Internship";
	
	@Override
	public void define(Context arg0) {
		NewRepository repository = arg0.createRepository(REPOSITORY_KEY, Java.KEY).setName(REPOSITORY_NAME);
		
		List<Class> checks = MyRulesList.getChecks();
		new RulesDefinitionAnnotationLoader().load(repository, Iterables.toArray(checks, Class.class));
		repository.done();
		
	}
	
	

}
