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
package org.sonar.samples.java;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.samples.java.checks.KuralAlti;
import org.sonar.samples.java.checks.KuralBes;
import org.sonar.samples.java.checks.KuralDort;
import org.sonar.samples.java.checks.KuralIki;
import org.sonar.samples.java.checks.KuralSekiz;
import org.sonar.samples.java.checks.KuralUc;
import org.sonar.samples.java.checks.KuralYedi;
import org.sonar.samples.java.checks.KuralBir;

public final class MyRulesList {

  private MyRulesList() {
  }

  public static List<Class> getChecks() {
    return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
  }

  public static List<Class<? extends JavaCheck>> getJavaChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .add(KuralBir.class)
      .add(KuralIki.class)
      .add(KuralUc.class)
      .add(KuralDort.class)
      .add(KuralBes.class)
      .add(KuralAlti.class)
      .add(KuralYedi.class)
      .add(KuralSekiz.class)
      .build();
  }

  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .build();
  }
}
