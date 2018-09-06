package org.sonar.samples.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier;
import org.junit.Test;



public class KuralDortTest  {
	@Test
	  public void test() {
	    JavaCheckVerifier.verify("src/test/files/KuralDort.java", new KuralDort());
	  }

	  @Test
	  public void test2() {
	    KuralDort check = new KuralDort();
	    check.format = "^[a-zA-Z0-9]*$";
	    JavaCheckVerifier.verifyNoIssue("src/test/files/KuralDort_2.java", check);
	  }

	  //ilgili format için doğrulama yapar.
	  @Test
	  public void testOverrideWithoutAnnotation() throws Exception {
		KuralDort check = new KuralDort();
	    check.format = "^[A-Z0-9]*$";
	    JavaCheckVerifier.verify("src/test/files/KuralDort_3.java", check);
	  }
	

}
