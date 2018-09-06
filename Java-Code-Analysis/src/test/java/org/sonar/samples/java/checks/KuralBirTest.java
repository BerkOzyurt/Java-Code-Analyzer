package org.sonar.samples.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class KuralBirTest {

	@Test
	  public void test() {
	    JavaCheckVerifier.verify("src/test/files/KuralBir_2.java", new KuralBir());
	  }

	  @Test
	  public void test2() {
	    KuralBir check = new KuralBir();
	    check.format = "^[a-zA-Z0-9]*$";
	    JavaCheckVerifier.verifyNoIssue("src/test/files/KuralBir.java", check);
	  }
}
