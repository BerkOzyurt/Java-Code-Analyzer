package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import com.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.java.ast.visitors.LinesOfCodeVisitor;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.BlockTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

@Rule(key = "Rule_Otto", name = "Rule_Otto", description = "Long Method",  tags = { "codesmells" })


public class KuralSekiz extends IssuableSubscriptionVisitor {

	  private static final int MAX = 75;
	  public int max = MAX;

	  @Override
	  public List<Tree.Kind> nodesToVisit() {
	    return ImmutableList.of(Tree.Kind.METHOD, Tree.Kind.CONSTRUCTOR);
	  }

	  @Override
	  public void visitNode(Tree tree) {
	    MethodTree mt = (MethodTree) tree;
	    BlockTree bt = mt.block();
	    if (bt != null) {
	      int lines = new LinesOfCodeVisitor().linesOfCode(bt);
	      if (lines > max) {
	        reportIssue(mt.simpleName(),
	          "You have " + lines + " lines, it, would be " + max + " lines. Split this method.");
	      }
	    }
	  }
	}
