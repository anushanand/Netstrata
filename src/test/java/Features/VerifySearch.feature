Feature: Verifying search suburb on Domain Homepage
As a Domain user
I want to make sure that I can search for a suburb
So that properties in the relevant suburb are displayed to me

Scenario: Verify that the selected suburb results are displayed
Given that I am viewing the Domain Homepage
When I enter a given term into the search field
Then a list of suggestions are displayed to me
And I select the first option suggested to me
And I click on the Search button
Then the properties from the selected suburb are displayed