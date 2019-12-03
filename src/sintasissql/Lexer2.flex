package sintasissql;
import static sintasissql.Tokens2.*;

%%
%class Lexico2
%type Tokens2
LL=[a-zA-Z]
L=[a-zA-Z_0-9]
LLL=[a-z0-9]
LLLL=[_-]
LLLLL=[a-z_0-9-]
LLLLLL=[a-zA-Z_0-9-]+
LLLLLLL=[^a-zA-Z_0-9-]+
espacio=[ ,\t,\r,\n]+

%{
    public String lexeme;
%}
%%
"ALTER TABLE" {lexeme=yytext(); return ALTER_TABLE;}
"ADD" {lexeme=yytext(); return ADD;}
"CONSTRAINT" {lexeme=yytext(); return CONSTRAINT;}
"PRIMARY KEY" {lexeme=yytext(); return PRIMARY_KEY;}
"UNIQUE" {lexeme=yytext(); return UNIQUE;}
"FULLTEXT" {lexeme=yytext(); return FULLTEXT;}
"SPATIAL" {lexeme=yytext(); return SPATIAL;}
"FOREING KEY" {lexeme=yytext(); return FOREING_KEY;}
"FIRST" {lexeme=yytext(); return FIRST;}
"AFTER" {lexeme=yytext(); return AFTER;}
"INDEX" {lexeme=yytext(); return INDEX;}

"//".* {/*Ignore*/}
"[" {lexeme=yytext(); return ICOR ;}
"]" {lexeme=yytext(); return CCOR ;}
("," | ", ") {lexeme=yytext(); return COMA ;}
"(" {lexeme=yytext(); return IPAR ;}
")" {lexeme=yytext(); return CPAR ;}

({L})({L})*  {lexeme=yytext(); return CCaracter;}
({LL})({L})* {lexeme=yytext(); return Caracter;}
({LLL})({LLLLL})* |({LLLL})({LLLLL})+  {lexeme=yytext(); return TituloCaracter;}
. {return ERROR;}
