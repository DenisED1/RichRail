/**
 * Define a grammar called Hello
 */
grammar RichRail;

options {
language = Java;
}

command     : newcommand | addcommand | getcommand | delcommand | remcommand;

newcommand : newtraincommand | newwagoncommand;
newtraincommand : 'new' 'train' ID;
newwagoncommand   : 'new' 'wagon' ID ('numseats' NUMBER)?;
addcommand : 'add' ID 'to' ID;
getcommand : 'getnumseats' type ID;
delcommand : 'delete' type ID;
remcommand  : 'remove' ID 'from' ID;

type        : ('train') | ('wagon');
ID          : ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER            : ('0'..'9')+;
WS : [ \t\n]+ -> skip ;
