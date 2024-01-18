Scenario: File OK
Given File path :  "data.txt"
When mow it now
Then The mower 1 must be positioned at (1, 3) and oriented towards N
And The mower 2 must be positioned at (5, 1) and oriented towards E