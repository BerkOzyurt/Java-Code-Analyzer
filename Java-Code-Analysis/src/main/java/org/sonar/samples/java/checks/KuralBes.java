package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import com.google.common.collect.ImmutableSet;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Rule(key = "Rule_Cinque", name = "Rule_Cinque", description = "Wrong Assignment",  tags = { "codesmells" })

public class KuralBes extends IssuableSubscriptionVisitor {

	  private static final Set<String> VALUES = ImmutableSet.of("!", "+", "-");

	  @Override
	  public List<Tree.Kind> nodesToVisit() {
	    return Collections.singletonList(Tree.Kind.ASSIGNMENT);
	  }

	  @Override
	  public void visitNode(Tree tree) {
	    AssignmentExpressionTree AE_Tree = (AssignmentExpressionTree) tree;
	    SyntaxToken Operator_T = AE_Tree.operatorToken();
	    SyntaxToken First_Token = AE_Tree.expression().firstToken();
	    SyntaxToken Last_Token = AE_Tree.variable().lastToken();
	    if (isSuspiciousToken(First_Token)
	      && Non_Spacing(Operator_T, First_Token)
	      && !Non_Spacing(Last_Token, Operator_T)) {
	      reportIssue(Operator_T, First_Token, getMessage(First_Token, AE_Tree));
	    }
	  }

	  private static String getMessage(SyntaxToken First_Token, AssignmentExpressionTree AE_Tree) {
	    if (is_Single_Negation(First_Token, AE_Tree)) {
	      return "Add a space between \"=\" and \"!\" .";
	    }
	    return "Was \"" + First_Token.text() + "=\" meant instead?";
	  }

	  private static boolean is_Single_Negation(SyntaxToken FirstToken, AssignmentExpressionTree AE_Tree) {
	    return "!".equals(FirstToken.text()) && (AE_Tree.parent() == null || !AE_Tree.parent().is(Tree.Kind.ASSIGNMENT));
	  }

	  private static boolean Non_Spacing(SyntaxToken FirstToken, SyntaxToken SecondToken) {
	    return FirstToken.line() == SecondToken.line()
	      && FirstToken.column() + FirstToken.text().length() == SecondToken.column();
	  }

	  private static boolean isSuspiciousToken(SyntaxToken FirstToken) {
	    return VALUES.contains(FirstToken.text());
	  }
	}	