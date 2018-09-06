package org.sonar.samples.java.checks;

import java.util.List;
import java.util.regex.Pattern;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.java.RspecKey;


@Rule(key = "Rule_Uno", name = "Rule_Uno", description = "Bad class name",  tags = { "codesmells" })

public class KuralBir extends BaseTreeVisitor implements JavaFileScanner {

	private static final String DEFAULT = "^[A-Z][a-zA-Z0-9]*$";
	  public String format = DEFAULT;
	  private Pattern pat = null;
	  private JavaFileScannerContext context;

	  @Override
	  public void scanFile(JavaFileScannerContext context) {
	    if (pat == null) {
	      pat = Pattern.compile(format, Pattern.DOTALL);
	    }
	    this.context = context;
	    scan(context.getTree());
	  }

	  @Override
	  public void visitClass(ClassTree tree) {
	    if (tree.is(Tree.Kind.CLASS) && tree.simpleName() != null && !pat.matcher(tree.simpleName().name()).matches()) {
	      context.reportIssue(this, tree.simpleName(), "Rename this class'" + format + "'.");
	    }

	    super.visitClass(tree);
	  }
}
