# VOIS_task

Selenium Task:

Design Patterns Used for Selenium task:
Page Object Model (POM) Design and Data Driven Test (DDT) design using DataProvider TestNG annotation

Tools Used For UI testing:
Java + Maven + TestNG + Selenium (UI automation) + intelliJ + webdrivermanager + poi (excel sheets manipulation) 

Included Scenarios:
1- valid registration
2- valid login
3- valid add to cart and cart checkout

**Note 
- that Data Driven Test is used in all Scenarios
- All test data can be fetched automatically from excell sheet (config.xslsx), and the number of test data can be increased by adding a new row.

How to Run:
- Run testng.xml that contains all tests on chrome, firefox and also the api tests using rest assured.
- You can run mnv command in the CMD in the project directory like:
	mvn test
	
API Testing:

Used tools:
Java + Maven + TestNG + restassured (Api Testing)

2 APIs were tested:
1- Get All Posts: 
	
	Scenarios:
		- ResPonse status code is 200
		- Response is in json form
		- Check that userID is included in the response body
		- Check that post ID is included in the response body
		- Check that post title is included in the response body
		- Check that post body is included in the response body
		
2- Get Post By ID

	Scenarios:
		- ResPonse status code is 200
		- Response is in json form
		- Get Request with a certain Post ID and check that the title received is as expected
		- Get Request with a certain Post ID and check that the body received is as expected
		
**Note that data driven test is used in two test methods

Video Record likn: https://drive.google.com/file/d/1k6c3DTt9MbL9FJ5c3IApnZ1eIos4JbEK/view?usp=sharing
