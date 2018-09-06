package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import com.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.java.RspecKey;
import org.sonar.java.ast.visitors.LinesOfCodeVisitor;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;

import java.text.MessageFormat;
import java.util.List;

@Rule(key = "Rule_Sei", name = "Rule_Sei", description = "Much Lines",  tags = { "codesmells" })


public class KuralAlti extends IssuableSubscriptionVisitor {

	  private static final int MAX_LINE = 500;
	  public int max = MAX_LINE;

	  @Override
	  public List<Tree.Kind> nodesToVisit() {
	    return ImmutableList.of(Tree.Kind.COMPILATION_UNIT);
	  }

	  @Override
	  public void visitNode(Tree tree) {
	    int lines = new LinesOfCodeVisitor().linesOfCode(tree);
	    if (lines > max) {
	      addIssueOnFile(MessageFormat.format("You have {0} lines, it would be {1} . Split it into smaller files.", lines, max));
	    }
	  }
	}