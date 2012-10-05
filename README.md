varargosy
=========

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
    
By contrast, here's the varargosy version:

    public void frobulateFooAndOptionalBar(String foo, String... bar) {
    
        frobulate(foo);  
    
        frobulate(Varargosy.defaultIfNotProvided(bar, "defaultBar"));
    }

Using varargs can make for great code reuse, for example in tests.

Installing
----------
Add varargosy to your project's `pom.xml` (if using Maven) or add it to your classpath if using some other build tool such as ant.

Usage
-----

Recognising the immense popularity of dependency-injection frameworks such as Spring, varargosy supports both
"classic `static` methods" and "injected collaborator" modes:

**Static methods:**

    Varargosy.defaultIfNotProvided(V... args, V default);
    Varargosy.numArgs(V... args);
    
**Collaborator (instance) methods:**
    
    @Autowired
    private InjectableVarargosy varargHelper;
    
    ...
     
    varargHelper.defaultIfNotProvided(V... args, V default);
    varargHelper.numArgs(V... args);
     
By using varargosy in the injected style, you can trivially mock out interactions when writing unit tests.    
    
    

Building from Source
--------------------

varargosy uses Maven for its build system.

In order to create a distribution, simply run the mvn package -DskipTests command in the cloned directory.