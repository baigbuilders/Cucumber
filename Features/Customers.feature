Feature: Customers


Background: Common Steps For Each Scenario
		Given User Launch Chrome Browser
		When User Opens URL "https://admin-demo.nopcommerce.com/login"
		And User Enters Email As "admin@yourstore.com" and Pasword As "admin"
		And Click On Login
		Then User Can View Dashboad

@sanity
Scenario: Add New Customer
		When User Click On Customers Menu
		And Click on Customer Menu Item
		And Click On Add New button
		Then User Can View Add New Customers
		When User Enter Customer Info
		And Click On Save button
		Then User Can View Confirmation Message "The new customer has been added successfully."
		And Close Browser 

@Regression		
Scenario: Search Customer by Email Id
		When User Click On Customers Menu
		And Click on Customer Menu Item
		And Enter customer Email
		When Click On Search button
		Then User should found email in the Search Table
		And Close Browser

@Regression		
Scenario: Search Customer by Name
		When User Click On Customers Menu
		And Click on Customer Menu Item
		And Enter Customer First Name
		And Enter Customer Last Name
		When Click On Search button
		Then User should found email in the Search Table
		And Close Browser