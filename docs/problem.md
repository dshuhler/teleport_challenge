### Teleporation Coding Challenge

You have discovered the secrets of teleportation and have several teleportation routes up and running. Each route
allows instantaneous travel from one city to another. All routes are two way: if you can teleport from city A
to city B, you can also teleport from city B to city A. You want to create a system to make it easier for you to
answer specific questions about your network. You should assume anyone using your network wants to travel only by teleportation.
Questions you must be able to answer:
1. What cities can I reach from city X with a maximum of N jumps?
2. Can someone get from city X to city Y?
3. Starting in city X, is it possible to travel in a loop (leave the city on one route and return on another, without traveling along the same route twice)?

Input to the program will be a list of teleportation routes, followed by a list of queries. Your solution should take a 
text file as input and output to the console. Example input is described below but your program should be able to handle
 any reasonable input.

Example input:
~~~~
Washington - Baltimore
Washington - Atlanta
Baltimore - Philadelphia
Philadelphia - New York
Los Angeles - San Fransisco
San Fransisco - Oakland
Los Angeles - Oakland
Seattle - New York
Seattle - Baltimore
cities in jumps: Seattle, 1
cities in jumps: Seattle, 2
teleport between: New York, Atlanta
teleport between: Oakland, Atlanta
loop possible: Oakland
loop possible: Washington
~~~~

Example output:
~~~~
Cities from Seattle in 1 jumps: New York, Baltimore
Cities from Seattle in 2 jumps: New York, Baltimore, Philadelphia, Washington
Can I teleport from New York to Atlanta: true
Can I teleport from Oakland to Atlanta: false
Loop possible from Oakland: true
Loop possible from Washington: false
~~~~

You may not use any outside libraries **except** for testing.