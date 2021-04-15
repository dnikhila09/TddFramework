Feature: feature description
	In order to do something
	As someone
	I want something else to happen
	
	#Scenario Outline:
    #Given User is on Home Page
    #Then User enters search keyword "<item>"
    #When User hits on search button
    #Then User should land in results page
    #Then User hits add to cart button
    #Then User clicks proceed to buy

    #Scenario:
    #Given User is on Home Page
    #Then
    
    #Examples:
    #|item|
    #|iphone|
    #|ipad|
    #|samsung|
    
  Scenario:
    Given User is on Home Page
    Then User clicks on mobiles category
    When User hits on checkBox button
    Then User click on product
    Then User hits add to cart button
    