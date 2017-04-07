Meta:

Narrative:
As a user
I want to pick a date
So that I can have it chosen in calendar

Scenario: Go to Frame 1
Given the user is logged in
When the user clicks Go to frm1
Then they should be on frm1 page

Scenario: Pick a date
Given the user is on frm1 page
When the user enters a date 2015-09-15
Then they should see it chosen