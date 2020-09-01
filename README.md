## Commissionator :chart_with_upwards_trend: >> :robot: >> :money_with_wings:

A simple Spring MVC application which calculates your monthly sales commission for you.

### About

Commissionator takes three arguments in order to generate your final sales commission figure:

- Actual - This refers to your actual amount of sales for the month. How many units did you sell? This value must be an
integer equal to or greater than 0.

- Target - How many units did you aim to sell this month? Target must be an integer greater than 0.

- Monthly On-Target Commission (MOTC) - This is the agreed amount in dollars which you will be paid if your sales target
 is met. This value must be an integer greater than 0 but no more than 10,000.
 
 Once you have submitted the above figures some calculations will be performed which output the following:
 
 - Achievement - A decimal value representing how well you met your target. For example, if your actual is 150 and your 
 target was 200 then your achievement would be 0.75 (75%). The maximum achievement is capped at 99.98.
 
 - Commissison rate - This is the multiplier which is derived in part from your achievement. This will be used to
 calculate your final figure.
 
 - Commission - Money in the bank :moneybag:! This is your monthly commission pay. It is calculated by multiplying the 
 MOTC by your commission rate.
 
 ### Technologies
 
 Commissionator leverages the following technologies:
 
 - Apache Maven for dependency management and project structure.
 - Jacoco for test coverage reporting and build-enforced line coverage standards.
 - Bootstrap for a fully responsive frontend.
 - Junit and Mockito for unit testing.
 - Thymeleaf for the frontend templating engine.
 - Spring Boot Framework for swift and reliable development in the MVC pattern.
 - Java 8 at language level.
 
 ### Testing the application
 
 To run the unit tests, simply execute the test phase of Maven's build lifecycle, `mvn test`. If you wish to trigger 
 Jacoco's test coverage reporting then run `mvn verify` or some later build lifecycle phase. Jacoco will produce a 
 coverage report at `/target/site/jacoco/index.html` which can be used to view the project's line coverage. It should
 look something like this:
 
 ![line_coverage_report](https://github.com/tlaughlan/commissionator/blob/master/src/main/resources/line_coverage_report.PNG)
 
 Jacoco has been configured to maintain the project's line coverage at 95%+. If the coverage falls bellow this standard
 the build will fail. Note that the `com.tlaughlan.commissionator.constants` package and the 
 `com/tlaughlan/commissionator/CommissionatorApplication.java` file have been excluded from the test coverage checks 
 since their functionality is minimal and need not be unit tested.
 
 ### Running the application
 
 To run the application simply execute `mvn spring-boot:run` from the root project directory. The application will be
 live on `localhost:8080`. You will be met with a welcome message with a link that takes you to the main calculator 
 page.
 
 ### Learnings
 
 This project has been an excellent learning experience. As someone who had minimal practical experience with Spring 
 there was a lot to learn. Thank goodness for all the Spring.io guides!
 
 ##### Challenges
 
 For the input validation I decided to focus on implementing server-side checks instead of doing it before submission 
 in the frontend. This was a deliberate choice for the sake of learning. I found the `javax.validation.constraints` 
 annotations to be useful and intuitive. The main challenge was getting the validated model to interact properly with 
 the controller. Once I learned how to use the BindingResult object to pass the errors things fell into place.
 
 At first I was confused about how to unit test the controller. Unit test by nature should be as isolated as possible
 but the controller seemed so strongly coupled to the other parts of the application to me that I was unsure how I would
 test it. Once I learned that I could use the `@AutoConfigureMockMvc` annotation to provide a mocked context I was very
 impressed at how simple it was to craft the test http requests and assert based on the responses.
 
 ##### If I could go back in time...
 
 I regret the way that I decided to pass the Commission object around the whole application. I should have written the 
 services so that they provided values for the commission object to consume instead of making operations on the object
 directly and then returning it. This made unit testing difficult at times, such as for `CommissionServiceTests.java`, 
 in which I had to use setters and allow the whole application flow to operate on `testCommission`. This strongly 
 couples the outcome of the tests on the other classes, instead of just testing its own logic.
 
 I was a bit of a cowboy with my git commits at times; stuffing lots of progress into single commits which couldn't be 
 described aptly by the commit message. I wish I had done fewer of these "big bang" commits and been more segmented and
 concise instead.
 
 One of Spring MVC's strengths is its ability to use multiple view templates. I wish I had implemented multiple 
 templates instead of just putting the whole calculator into one html file. Perhaps I could have implemented a results 
 template which would have simplified handling of the completed Commission model object.
 
 ##### Future improvements
 
 If I were to work on this project more in the future, or produce another one like it, there are a few things I'd like
 to try:
 
 - Using JSP instead of Thymeleaf so that I can see how the Spring view layer works natively.
 - Producing a more mature frontend. I didn't focus on frontend much in this project since I was mainly learning to 
 implement Spring's server-side concepts. I wonder how mature scale Spring MVC apps structure their frontend...
 - Implement Sass CSS so I can build a light/dark mode toggle into the header! :last_quarter_moon_with_face: :sun_with_face: