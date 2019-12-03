package sintasissql;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
LL=[a-zA-Z]
L=[a-zA-Z_0-9]
LLL=[a-z0-9]
LLLL=[_-]
LLLLL=[a-z_0-9-]
LLLLLL=[a-zA-Z_0-9-]+
LLLLLLL=[^a-zA-Z_0-9-]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

"ALTER TABLE" {return new Symbol(sym.ALTER_TABLE, yychar, yyline, yytext());}
"ADD" {return new Symbol(sym.ADD, yychar, yyline, yytext());}
"CONSTRAINT" {return new Symbol(sym.CONSTRAINT, yychar, yyline, yytext());}
"PRIMARY KEY" {return new Symbol(sym.PRIMARY_KEY, yychar, yyline, yytext());}
"UNIQUE" {return new Symbol(sym.UNIQUE, yychar, yyline, yytext());}
"FULLTEXT" {return new Symbol(sym.FULLTEXT, yychar, yyline, yytext());}
"SPATIAL" {return new Symbol(sym.SPATIAL, yychar, yyline, yytext());}
"FOREING KEY" {return new Symbol(sym.FOREING_KEY, yychar, yyline, yytext());}
"FIRST" {return new Symbol(sym.FIRST, yychar, yyline, yytext());}
"AFTER" {return new Symbol(sym.AFTER, yychar, yyline, yytext());}
"INDEX" {return new Symbol(sym.INDEX, yychar, yyline, yytext());}

"//".* {/*Ignore*/}
"[" {return new Symbol(sym.ICOR, yychar, yyline, yytext());}
"]" {return new Symbol(sym.CCOR, yychar, yyline, yytext());}
("," | ", ") {return new Symbol(sym.COMA, yychar, yyline, yytext());}
"(" {return new Symbol(sym.IPAR, yychar, yyline, yytext());}
")" {return new Symbol(sym.CPAR, yychar, yyline, yytext());}

({L})({L})*  {return new Symbol(sym.CCaracter, yychar, yyline, yytext());}
({LL})({L})* {return new Symbol(sym.Caracter, yychar, yyline, yytext());}
({LLL})({LLLLL})* |({LLLL})({LLLLL})+  {return new Symbol(sym.TituloCaracter, yychar, yyline, yytext());}
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
