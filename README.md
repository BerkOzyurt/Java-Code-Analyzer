#SonarQube Plugin
Berk Özyurt
Università degli Studi di Milano Bicocca
July - August 2018

1. Abstract
  This Plugin was developed for the detection of code smells. It examines the code with special
rules. This project includes 10 rules. This rules about; naming, code length, variables and some controls.
Project is a maven application developed with sonarqube. It will be used for code analysis.

2. Java Package's Structure
  This part includes details of the analyzer project. It's about main package and main classes and
introduce the details of the rules. This topics was supported with sample codes.
 The required dependencies are not installed and not added in the pom.xml file. After adding new
dependecies to the pom.xml file, this page should be saved and build with maven. Otherwise, imports will
not be accepted as dependencies are not downloaded.

2.1. MyJavaMain.java
  I created a new class in the main package and named MyJavaMain.class. This class expanded with
the MyRulesDefinition.class and MyFileCheckRegistar.class classes. And this main class will be
implements “Plugin”. This class is one of the most important classes of the project. And I printing "11111"
on the screen for test the work steps. If I see this article first when I run the project, it means that this class
works correctly.

 | @Override
 | public void define(Context context) {
 |  context.addExtension(MyRulesDefinition.class);
 |  context.addExtension(MyFileCheckRegistrar.class);
 |  context.addExtension(MyRulesList.class);
 |  System.out.println("1111111111111111111111111111111111111111111111111");
 | }
 
2.2. MyRulesDefinition.java
  MyRulesDefinition.class must be implemented with RuleDefinition. And I defined in this class
REPOSITORY_KEY and REPOSITORY_NAME as a “public static final String”. And the contents of
this class have been completed with the RulesDefinitonAnnotationLoader method. This metgod loads
additional explanations for rule definitions.
 
 | @Override
 | public void define(Context arg0) {
 |  NewRepository repository = arg0.createRepository(REPOSITORY_KEY,
 |  Java.KEY).setName(REPOSITORY_NAME);
 |  List<Class> checks = MyRulesList.getChecks();
 |  new RulesDefinitionAnnotationLoader().load(repository, Iterables.toArray(checks, Class.class));
 |  repository.done();
 | }
 
2.3. MyFileCheckRegistar.java
  MyFileCheckRegistrar.class was constructed similar to the MyRulesDefinition.Class. The
necessary methods were written and MyRuleList.class was introduced as a list for check.
 
 | @Override
 | public void register(RegistrarContext registrarContext) {
 |  registrarContext.registerClassesForRepository(MyRulesDefinition.REPOSITORY_KEY,
 |  checkClasses(), testCheckClasses());
 | }
 | public static List<Class<? extends JavaCheck>> checkClasses() {
 |  return MyRulesList.getJavaChecks();
 | }
 | public static List<Class<? extends JavaCheck>> testCheckClasses() {
 |  return MyRulesList.getJavaTestChecks();
 | }

2.4. MyRuleList.java
  And the final class MyRuleList of the main package is created and the classes that the rules are
written are edded as a list. I don't have any class for rules at the moment. However, it should not be an
error when runnung the project. My rules should be related to architectural smell detection. I will write
these rules according to the architectural smell characteristics.
 
 | public static List<Class<? extends JavaCheck>> getJavaChecks() {
 |  return ImmutableList.<Class<? extends JavaCheck>>builder()
 |  .add(KuralBir.class)
 |  .add(KuralIki.class)
 |  .add(KuralUc.class)
 |  .add(KuralDort.class)
 |  .add(KuralBes.class)
 |  .add(KuralAlti.class)
 |  .add(KuralYedi.class)
 |  .add(KuralSekiz.class)
 |  .build();
 | }
 
3. Checks Package
  This part includes details of the rules which included project. It's about checks package and rule
classes and introduce the details of the rules. This topics was supported with sample codes. This project
includes 8 diffirent code smell rules. Four of these rules are naming rules.Four of these rules are naming
rules.The other four are special rules developed for code smells. Details of each rule are included in the
relevant title. Classes are named in Turkish. The meaning of class names; It is the number of rules and
rules. The meaning of "Kural" is the “rule”.

3.1. KuralBir.java
  For add a rule to the project, I created a package and called “checks” in the path of src/java/main.
And I created a standart Java class. Each rule must be defined in a separate class. The name of the first
class required to create the rule is “Kural1”. This rule will control to class names. I defined a specific
format for class names as a “private static final String”. I wrote a method. This method searchs in project
and founds class name. And it compares them to the specified format. If this method found a nonmatching characters, ona code-smell notification will occur.
  
  And I have to one class more for the test. I created a class and called “KuralBirTest” in the path of
“src/test/java”. This class will check my first rule. This class need to 2 class more for use to testing
process. And I have to introduce this classes in the “KuralBirTest.class”. I called the other class
“KuralBir.java” and “KuralBir_2.java”. These clases will be in the projects main folder. So,
“src>test>files”. They arent so important classes. They include just some dependency and special class for
code smell detection and compare class name.

  And I think one of the most import point is rule defination. I have to define the rules and assign to
some important key. The structure of this code chould be identical for every rule. Only the descrptions
should be changed according to the rule. Otherwise the project will not be compiled. I done it this code
line;

| @Rule(key = "Rule_Uno", name = "Rule_Uno", description = "Bad class name",
| tags = { "codesmells" })

  Finally I have rule. Now I need to define in RuleList.java class to use this rule. I created a list for
this and extends it with “JavaCheck>> getJavaCheck”. I added this rule with .add() method and I wrote
the .build() command.

3.2. KuralIki.java
  My second rule about bad abstract class name. This rule will identifybad named abstract class.
Class, package and method etc. names are very important to create a stand-in project. With this rules, the
code will be better quality. In the group work, the code will look like a single person's code. And code will
become easier to read and understand.

  As I did last rule, I created a class and called it “KuralIki.java”. I defined a specific format for
class names as a “private static final String”. I wrote a method. This method searchs in project and founds
class name. But this methods difference from the other method, this method is doing a more extensive
search. And it compares them to the specified format. If this method found a non-matching characters, ona
code-smell notification will occur.

  After than I create a test class for my secont rule. This test class contain just one verify. Because
each comparison requires diffirent testing procedures. And I did a redirect to the “KuralIki.java” class in
the src > test > files folder.
“Rule_Due” is the key to this rule, and the decription is“bad abstract class name” called. I have
specified that DEFAULT__FORMAT is the same as DEFAULT_FORMAT in KuralBir.java . 

3.3. KuralUc.java
  My third rule is about bad package names. Similar to first and secont rules, it detect to bad named
packages. I have specified a slightly diffirent DEFAULT_FORMAT for package names. I access the
package names with similar search algorithms. And I used 3 diffirent verify in the “KuralUcTest.java”
class. Because each comparison requires diffirent testing procedures.I did three diffirent guidance. These
class names are “KuralUc” , “KuralUc_1” and “KuralUc_2”

 | @Override
 | public void visitCompilationUnit(CompilationUnitTree tree) {
 |  if (tree.packageDeclaration() != null) {
 |    String name = PackageUtils.packageName(tree.packageDeclaration(), ".");
 |    if (!pattern.matcher(name).matches()) {
 |      context.reportIssue(this, tree.packageDeclaration().packageName(),
 |                          "Rename this package name to match the regular expression '" + format + "'.");
 |    }
 |  }
 | }
 
3.4. KuralDort.java
  My fourth rule about method names. If you want to develop a good project, your naming ways
should be the same. This way will make it easier to understand. Here I also added a description to the
SonarQube Web Server. I did it this code lines;
 
 | @RuleProperty( key = "format", description = "Regular expression used to check the method names
                                                 against.", defaultValue = "" + DEFAULT_FORMAT)

  The search algrithm for this class is similar to others. I needed 3 verify method for my fourth
rule's test class. Therefore I created 3 diffirent class in the src > test > files folder.

3.5. KuralBes.java
  The fifth rule relates to assignment operators. In this rule, mistakes are made when assigning a
variable value. For example, if there is a gap in the use of "+ =", it will be an error. The operators used for
this were given access. And these structures have been examined. For each assignment, a different method
was written. A different error message was written in each method. This rule is one of the most specific
rules of the project. The line of code is examined. And assignments were detected. Then, according to the
assignment type, the corresponding function is activated. The code details are as follows.

 | public void visitNode(Tree tree) {
 |  AssignmentExpressionTree AE_Tree = (AssignmentExpressionTree) tree;
 |  SyntaxToken Operator_T = AE_Tree.operatorToken();
 |  SyntaxToken First_Token = AE_Tree.expression().firstToken();
 |  SyntaxToken Last_Token = AE_Tree.variable().lastToken();
 |  if (isSuspiciousToken(First_Token) && Non_Spacing(Operator_T, First_Token) && !Non_Spacing(Last_Token, Operator_T)) {
 |    reportIssue(Operator_T, First_Token, getMessage(First_Token, AE_Tree));
 
3.6. KuralAlti.java
  In rule 6, the lines of code are calculated. It is desirable to have a maximum of 500 lines of code in
a class. For this reason, very large classes make it difficult to read the code. Also, it is more difficult to
detect errors in classes that contain long lines. Such a rule has been developed to remove such problems
and improve the quality of the code.

  After counting the number of codes in each class, if this number is more than 500, the user will be
informed of the number of lines and the maximum number of lines. In this case the user needs to classify
the class. This rule is another important rule of the project. Because it aims to increase the quality of the
code. On this count, the code can be analyzed more easily.

 | private static final int MAX_LINE = 500;
 | public int max = MAX_LINE;
 | @Override
 | public List<Tree.Kind> nodesToVisit() {
 |  return ImmutableList.of(Tree.Kind.COMPILATION_UNIT);
 | }
 | @Override
 | public void visitNode(Tree tree) {
 |  int lines = new LinesOfCodeVisitor().linesOfCode(tree);
 |  if (lines > max) {
 |    addIssueOnFile(MessageFormat.format("You have {0} lines, it would be {1} . Split it into smaller files.", lines, max));
 |  }
 | }
 
3.7. KuralYedi.java
  Rule number seven is about tab usage. Using unnecessary tabs causes the code to look long and
ugly. In this case, errors in rule 6 occur. The reason I write a rule about tab usage is that it supports rule 6.
these two rules are closely related to each other.
In this rule, all the rows in the class are imported into a list. Then "\ t" characters are searched in
this list. If the tab character is found, the user is prompted to check it. So the code view will be smooth. In
addition, the code will be easier to read. The details of the rule are as follows.

 | @Override
 | public void scanFile(JavaFileScannerContext context) {
 |  super.context = context;
 |  List<String> lines = context.getFileLines();
 |  for (String line : lines) {
 |    if (line.contains("\t")) {
 |      addIssueOnFile("Replace all tab characters in this class.");
 |      break;
 |    }
 |  }
 | }
 
3.8. KuralSekiz.java
  Rule number eight is similar to rule six. In rule 8, the length of the method can be controlled. In
software engineering, method length is very important. In my lessons, the professors always talked about
this subject. Longer methods reduce code performance. And every method should be a task alone.
Otherwise, the code quality drops. This leads to code smell.
 
 | @Override
 | public void visitNode(Tree tree) {
 |  MethodTree mt = (MethodTree) tree;
 |  BlockTree bt = mt.block();
 |  if (bt != null) {
 |    int lines = new LinesOfCodeVisitor().linesOfCode(bt);
 |    if (lines > max) {
 |      reportIssue(mt.simpleName(),"You have " + lines + " lines, it, would be " + max + " lines. Split this method.");
 |    }
 |  }
 | }
