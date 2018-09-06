/*
 * SonarQube Java Custom Rules Example
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.samples.java.checks;

import java.util.regex.Pattern;
import org.sonar.check.Rule;
import org.sonar.java.model.ModifiersUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Modifier;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.check.RuleProperty;
import org.sonar.java.RspecKey;


@Rule(key = "Rule_Due", name = "Rule_Duo", description = "Bad abstract class name",  tags = { "codesmells" })

public class KuralIki extends BaseTreeVisitor implements JavaFileScanner {

	private static final String DEFAULT = "^Abstract[A-Z][a-zA-Z0-9]*$";
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
	    IdentifierTree Name = tree.simpleName();
	    if (tree.is(Tree.Kind.CLASS) && Name != null) {
	      if (pat.matcher(Name.name()).matches()) {
	    	  context.reportIssue(this, Name, "Rename this abstract class");
		        
	      }
	    }
	    super.visitClass(tree);
	  }
}
