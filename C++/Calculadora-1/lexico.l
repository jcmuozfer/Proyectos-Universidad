%{
#include "expresiones.h"
#include <math.h>

int n_lineas;
%}

%option noyywrap

digito [0-9]
letra [a-zA-Z]
identificador ({letra}|_)({letra}|{digito}|_)*
entero {digito}+
real1 {entero}*[.]{entero} 
real2 {entero}[.]{entero}*


    
%%

\/\/(.*)	                       ;

[<][=]					return MENORI;
[>][=]					return MAYORI;
[=][=]					return IGUAL;
[<][>]					return DISTINTO;
[<][-]                      		return ASIG;
[c][i][e][r][t][o]			return CIERTO;
[f][a][l][s][o]			return FALSO;
[y]					return Y;
[n][o]					return NO;
[o]					return O;
{identificador}			strcpy(yylval.c_cadena, yytext); return IDENTIFICADOR;
{real1}				yylval.c_real = atof(yytext); return REAL;
{real2}				yylval.c_real = atof(yytext); return REAL;
{entero}				yylval.c_entero = atoi(yytext);return ENTERO;                              
\n					n_lineas++; return (yytext[0]);
[\t ]					;	
. 					return (yytext[0]);

%%
