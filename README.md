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

# License

This project is licensed under [The MIT License](http://opensource.org/licenses/MIT)
