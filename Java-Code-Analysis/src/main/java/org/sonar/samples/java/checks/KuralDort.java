package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import java.util.List;
import java.util.regex.Pattern;
import org.sonar.check.RuleProperty;
import org.sonar.java.RspecKey;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import com.google.common.collect.ImmutableList;


//Rule formatı hepsinde aynı olmak zorunda.
@Rule(key = "Rule_Quattro", name = "Rule_Quattro", description = "Bad method name",  tags = { "codesmells" })


public class KuralDort extends IssuableSubscriptionVisitor {

	  private static final String DEFAULT = "^[a-z][a-zA-Z0-9]*$";

	  //ekranda açıklama göstermeyi sağlar.
	  @RuleProperty(
	      key = "format",
	      description = "Bad method named.",
	      defaultValue = "" + DEFAULT)
	  public String format = DEFAULT;

	  private Pattern pat = null;

	  @Override
	  public List<Tree.Kind> nodesToVisit() { return ImmutableList.of(Tree.Kind.METHOD); }

	  @Override
	  public void scanFile(JavaFileScannerContext context) {
	    if (pat == null) {
	      pat = Pattern.compile(format, Pattern.DOTALL);
	    }
	    super.scanFile(context);
	  }


	  @Override
	  public void visitNode(Tree tree) {
	    MethodTree M_Tree = (MethodTree) tree;
	    if (!pat.matcher(M_Tree.simpleName().name()).matches()) {
	      reportIssue(M_Tree.simpleName(), "Rename this method" + format + "'.");
	    }
	  }
	}
