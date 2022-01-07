Feature: Project


@sanity
Scenario: Successful Login with Valid Credentials
		Given: Use Launch Chrome Browser
  	When: User Opens URL "http://admin-demo.nopcommerce.com/login"
  	And: User Enters Email as "admin@yourstore.com" and Passwrod "admin"
  	And: Click On Login
  	Then: Page Tittle Should Be "Dashborad / nopCommerce administration"
  	When: Click On Logout Link
  	Then: Page Tittle Should Be "Your Store. Login"
  And: Close Browser
 
 @Regression 
 Scenario Outline: Login Data Driven
 		Given: Use Launch Chrome Browser
  	When: User Opens URL "http://admin-demo.nopcommerce.com/"
  	And: User Enters Email as "<email>" and Passwrod "<password>"
  	And: Click On Login
  	Then: Page Tittle Should Be "Dashborad / nopCommerce administration"
  	When: Click On Logout Link
  	Then: Page Tittle Should Be "Your Store. Login"
  	And: Close Browser
 	
 	Examples:
 			| email | password |
 			| admin@yourstore.com| admin |
 			| admin@yourstore.com| admin123 |