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
 
 To run the unit tests, simply execute the test phase of Maven's build lifecycle, `mvn test`. Jacoco will produce a 
 coverage report at `/target/site/jacoco/index.html` which can be used to view the project's line coverage. It should
 look something like this:
 
 ![line_coverage_report](https://github.com/tlaughlan/commissionator/blob/master/src/main/resources/line_coverage_report.PNG)
 
 Jacoco has been configured to maintain the project's line coverage at 95%+. If the coverage falls bellow this standard
 the build will fail.
 
 
