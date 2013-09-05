no-type-checking
================

Refactoring kata for training removal of type checking or variations of "instanceof" or indeed any case where 
we use some sort of a.getB() in a conditional statement.

This kata illustrates the problem of disociating data and behavior. Using data as interfaces or apis is
often refered to as data-oriented architecture and it leads to breaking the Liskow Substitution Principle and the 
Open-Closed Principle as well as it generates unnecessary coupling. 

This kata is derived from a real project and made as simple as possible, hence expect the solution te be a bit 
over-design in this particular context.

[Further instructions](https://docs.google.com/presentation/d/13KAaOBbEAPSOfTRel6wH9Te-RPKBT8KQAC5wFSxRuS4/edit?usp=sharing) in slides

