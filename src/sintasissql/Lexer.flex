package sintasissql;
import static sintasissql.Tokens.*;

%%
%class Lexico
%type Tokens
LL=[a-zA-Z]
L=[a-zA-Z_0-9]
LLL=[a-z0-9]
LLLL=[_-]
LLLLL=[a-z_0-9-]
LLLLLL=[a-zA-Z_0-9-]+
LLLLLLL=[^a-zA-Z_0-9-]+
espacio=[ ,\t,\r,\n]+
E = " "

%{
    public String lexeme;
%}
%%
"ALTER" {lexeme=yytext(); return Reservadas;}
"TABLE" {lexeme=yytext(); return Reservadas;}
"ADD" {lexeme=yytext(); return Reservadas;}
"CONSTRAINT" {lexeme=yytext(); return Reservadas;}
"PRIMARY KEY" {lexeme=yytext(); return Reservadas;}
"UNIQUE" {lexeme=yytext(); return Reservadas;}
"FULLTEXT" {lexeme=yytext(); return Reservadas;}
"SPATIAL" {lexeme=yytext(); return Reservadas;}
"FOREING KEY" {lexeme=yytext(); return Reservadas;}
"FIRST" {lexeme=yytext(); return Reservadas;}
"AFTER" {lexeme=yytext(); return Reservadas;}
"INDEX" {lexeme=yytext(); return Reservadas;}

"//".* {/*Ignore*/}
"[" {lexeme=yytext(); return Agrupaciones ;}
"]" {lexeme=yytext(); return Agrupaciones ;}
("," | ", ") {lexeme=yytext(); return Agrupaciones ;}
"(" {lexeme=yytext(); return Agrupaciones ;}
")" {lexeme=yytext(); return Agrupaciones ;}

 ^a\(({LL})({L})*)a$ {lexeme=yytext(); return Caracteres;}
({LLL})({LLLLL})* |({LLLL})({LLLLL})+  {lexeme=yytext(); return CaracteresTable;}
. {return ERROR;}