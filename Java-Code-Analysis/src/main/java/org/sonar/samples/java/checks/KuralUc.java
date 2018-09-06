package org.sonar.samples.java.checks;

import java.util.regex.Pattern;

import org.sonar.check.Rule;
import org.sonar.java.model.PackageUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.check.RuleProperty;
import org.sonar.java.RspecKey;

@Rule(key = "Rule_Tre", name = "Rule_Tre", description = "Bad package name",  tags = { "codesmells" })

public class KuralUc extends BaseTreeVisitor implements JavaFileScanner {

	private static final String DEFAULT = "^[a-z_]+(\\.[a-z_][a-z0-9_]*)*$";
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
	  public void visitCompilationUnit(CompilationUnitTree tree) {
	    if (tree.packageDeclaration() != null) {
	      String name = PackageUtils.packageName(tree.packageDeclaration(), ".");
	      if (!pat.matcher(name).matches()) {
	        context.reportIssue(this, tree.packageDeclaration().packageName(), "Rename this package '" + format + "'.");
	      }
	    }
	  }

}
