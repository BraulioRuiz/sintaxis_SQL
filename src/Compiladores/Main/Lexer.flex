package Compiladores.Main;
import static Compiladores.Main.Tokens.*;

%%
%class Lexico
%type Tokens
L=[a-zA-Z_0-9-]
Lm=[-a-z_0-9]
espacio=[ ,\t,\r,\n]+
D=[0-9]
%{
    public String lexeme;
%}
%%
"SELECT" {lexeme=yytext(); return Reservadas;}
"DISTINCT" {lexeme=yytext(); return Reservadas;}
"FROM" {lexeme=yytext(); return Reservadas;}
"WHERE" {lexeme=yytext(); return Reservadas;}
"ORDER BY" {lexeme=yytext(); return Reservadas;}


"//".* {/*Ignore*/}
"'" {lexeme=yytext(); return Agrupaciones ;}
"'" {lexeme=yytext(); return Agrupaciones ;}
"," {lexeme=yytext(); return Agrupaciones ;}
"." {lexeme=yytext(); return Agrupaciones ;}
":" {lexeme=yytext(); return Agrupaciones ;}
";" {lexeme=yytext(); return Agrupaciones ;}
"/" {lexeme=yytext(); return Agrupaciones ;}

"<" {lexeme=yytext(); return Operadores ;}
"<=" {lexeme=yytext(); return Operadores ;}
">=" {lexeme=yytext(); return Operadores ;}
">" {lexeme=yytext(); return Operadores ;}
"!=" {lexeme=yytext(); return Operadores ;}
"=" {lexeme=yytext(); return Operadores ;}
"*" {lexeme=yytext(); return Columnas ;}
({L})({L})+ {lexeme=yytext(); return Caracteres;}
({L})({L})+ {lexeme=yytext(); return Columnas;}
({D})({D})+  {lexeme=yytext(); return Digitos;}
({Lm})({Lm})+  {lexeme=yytext(); return DB;}
. {return ERROR;}