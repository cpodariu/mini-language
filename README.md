# mini-language
## Regexes
Identifier: 

    "^[a-z][a-zA-Z0-9]{0,248}" 
    
Number constant: 

    "([-]?[1-9][0-9]*)|[0]"


a string of at most 250 alphanumeric characters that must start with a small letter

String: 

    "\"\\w*\""

Char: 

    "'\\w?\'"

## Symbol table
The symbol table is a lexicographically sorted table that has an integer as key and a string as a value.

Whenever a value is added to the table, it is inserted in its corresponding lexicographic position. And the PIF is 
modified accordingly

## PIF

The pif is a table that maps a integer to another integer. 

The first integer represents the code of the token. 

The second integer represents a position in the symbol table, or -1 if the entry does not represent a constant or an identifier.