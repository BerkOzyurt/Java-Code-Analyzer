package org.sonar.samples.java;

import java.util.Arrays;
import java.util.List;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.samples.java.checks.KuralBir;
import org.sonar.samples.java.checks.KuralIki;
import org.sonar.samples.java.checks.KuralUc;
import org.sonarsource.api.sonarlint.SonarLintSide;

@SonarLintSide
public class MyFileCheckRegistrar implements CheckRegistrar {

  @Override
  public void register(RegistrarContext registrarContext) {
    registrarContext.registerClassesForRepository(MyRulesDefinition.REPOSITORY_KEY, checkClasses(), testCheckClasses());
  }

  public static List<Class<? extends JavaCheck>> checkClasses() {
    return MyRulesList.getJavaChecks();
  }

  public static List<Class<? extends JavaCheck>> testCheckClasses() {
    return MyRulesList.getJavaTestChecks();
  }
}
