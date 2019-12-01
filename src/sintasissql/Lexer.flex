package sintasissql;
import static sintasissql.Tokens.*;

%%
%class Lexico
%type Tokens
LL=[a-zA-Z]
L=[a-zA-Z_]+
LLL=[a-z_-]
LLLL=[a-z_-]+

espacio=[ ,\t,\r,\n]+

%{
    public String lexeme;
%}
%%
"ALTER" {lexeme=yytext(); return Reservadas;}
"TABLE" {lexeme=yytext(); return Reservadas;}
"ADD" {lexeme=yytext(); return Reservadas;}
"CONSTRAINT" {lexeme=yytext(); return Reservadas;}
"PRIMARY" {lexeme=yytext(); return Reservadas;}
"KEY" {lexeme=yytext(); return Reservadas;}
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

({LL})({L})* {lexeme=yytext(); return Caracteres;}
({LLL})({LLL})+ {lexeme=yytext(); return CaracteresTable;}
. {return ERROR;}