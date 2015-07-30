# test-javascript-with-junit-example

This project is exmaple to test JavaScript codes in JUnit and Nashorn. The project depends on Spring Boot and IO Platform.

This project does,

- Load [Sugar.js](http://sugarjs.com/) in webjar,
- Evaluate test code in Nashorn,
(Test is invoking a method of Sugar.js) 
- Check the result by Junit.

# Build and Run

Under the project root directry:

```
$ gradle test
```

# Appendix: My environment

```
$ gradle -version

------------------------------------------------------------
Gradle 2.4
------------------------------------------------------------

Build time:   2015-05-05 08:09:24 UTC
Build number: none
Revision:     5c9c3bc20ca1c281ac7972643f1e2d190f2c943c

Groovy:       2.3.10
Ant:          Apache Ant(TM) version 1.9.4 compiled on April 29 2014
JVM:          1.8.0_45 (Oracle Corporation 25.45-b02)
OS:           Mac OS X 10.10.4 x86_64
```

# License

This project is licensed under [The MIT License](http://opensource.org/licenses/MIT)
