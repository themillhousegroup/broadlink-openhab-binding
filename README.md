argon
=====

Helper methods and utilities for getting the most out of Java's varargs

Introduction
------------
Since Java 5, variable-length argument lists (or "varargs") have been available to developers on the JVM.
Varargs have the potential to greatly simplify APIs through simpler method signatures, but often the code to deal
with vararg parameters ends up being unsightly. For example, dealing with possibly-null varargs, zero-length lists,
and specifying default values can quickly double the size of a method:

    public void frobulateFooAndOptionalBar(String foo, String... bar) {
    
        frobulate(foo);  
    
        if (bar == null || bar.length == 0 || bar[0] == null) {          
            frobulate("defaultBar"); // Default if no other bar supplied
        } else {
            frobulate(bar[0]);
        }
    }
    
By contrast, here's the Argon version:

    public void frobulateFooAndOptionalBar(String foo, String... bar) {
    
        frobulate(foo);  
    
        frobulate(Argon.defaultIfNotProvided(bar, "defaultBar"));
    }

Using varargs can make for great code reuse, for example in tests.

Installing
----------
Add Argon to your project's `pom.xml` (if using Maven) or add it to your classpath if using some other build tool such as ant.

    <dependency>
        <groupId>com.themillhousegroup</groupId>
        <artifactId>argon</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

Usage
-----

Recognising the immense popularity of dependency-injection frameworks such as Spring, argon supports both
"classic `static` methods" and "injected collaborator" modes:

**Static methods:**

    Argon.defaultIfNotProvided(V... args, V default);
    Argon.numArgs(V... args);
    
**Collaborator (instance) methods:**
    
    @Autowired
    private InjectableArgon varargHelper;
    
    ...
     
    varargHelper.defaultIfNotProvided(V... args, V default);
    varargHelper.numArgs(V... args);
     
By using Argon in the injected style, you can trivially mock out interactions when writing unit tests.    
    
    

Building from Source
--------------------

Argon uses Maven for its build system.

In order to create a distribution, simply run the `mvn package -DskipTests` command in the cloned directory.

If you have a site-local repository (such as Nexus or Artifactory), configure the `site.local.nexus` property in the Argon `pom.xml` to the correct location, and you'll be able to perform a `mvn deploy` to get the JAR into position for all site users. 
