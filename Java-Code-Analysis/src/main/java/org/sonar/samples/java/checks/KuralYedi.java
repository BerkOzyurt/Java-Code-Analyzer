package org.sonar.samples.java.checks;
import org.sonar.check.Rule;
import org.sonar.java.RspecKey;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

import org.sonar.check.Rule;

@Rule(key = "Rule_Sette", name = "Rule_Sette", description = "Tab Control",  tags = { "codesmells" })


public class KuralYedi extends IssuableSubscriptionVisitor {

	  @Override
	  public List<Tree.Kind> nodesToVisit() {
	    return Collections.emptyList();
	  }

	  @Override
	  public void scanFile(JavaFileScannerContext context) {
	    super.context = context;
	    List<String> lines = context.getFileLines();
	    for (String line : lines) {
	      if (line.contains("\t")) {
	        addIssueOnFile("Replace all tab characters in this class.");
	        break;
	      }
	    }
	  }

}
