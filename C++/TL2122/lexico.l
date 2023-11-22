%{
#include "listas.h"
#include <iostream>
#include <math.h>
using namespace std;
int n_lineas;
%}

%option noyywrap

digito [0-9]
letraMinuscula [a-z]
letraMayuscula[A-Z]
letra [a-zA-Z]
entero {digito}+
real1 {entero}*[.]{entero} 
real2 {entero}[.]{entero}*
identificador2 ({letraMinuscula})({letra}|{digito}|_)*
identificador ({letraMayuscula})({letra}|{digito}|_)*
texto {letra}|{digito}|[ ]
lista   [ ]*[=][ ]*[{] 
 


%x COM1
    
%%

"#" BEGIN(COM1)		;
<COM1>"\n" BEGIN(0);		n_lineas++;
<COM1>. 			;


LISTAS				{return LISTAS;}
VARIABLES 			{return VARIABLES;}
INICIO 				{return INICIO;}
FIN 				{return FIN;}

Escribir			{return ESCRIBIR;}
cierto                         return CIERTO;
falso                          return FALSO;
NuevaLinea			{return NUEVALINEA;}
primero			{return PRIMERO;}
ultimo				{return ULTIMO;}
enesimo			{return ENESIMO;}
Si                             {return SI;}
Si_no                          {return SI_NO;}

Entero				{return NOMENTERO;}
Real				{return NOMREAL;}
Logico				{return LOGICO;}



[.][.]				{return DOBLEPUNTO;}
{lista}			{return ASIGLISTA;}


[<][=]                  	return MENORI;
[>][=]                    	return MAYORI;
[=][=]                    	return IGUAL;
[<][>]                    	return DISTINTO;
[ ]*[<][-][ ]*                         return ASIG;
[y]                    	return Y;
[n][o]                    	return NO;
[o]   				return O;




{entero}			{yylval.c_entero = atoi(yytext);return ENTERO;}
{real1}			{yylval.c_real = atof(yytext); return REAL;}
{real2}			{yylval.c_real = atof(yytext); return REAL;}


{identificador}		{strcpy(yylval.c_cadena, yytext); return IDENTIFICADOR;}
{identificador2}		{strcpy(yylval.c_cadena, yytext); return IDENTIFICADOR2;}


["][^"]*["]			{strcpy(yylval.c_cadena, yytext); return TEXTO;}
[ ]+            		;


\n				{n_lineas++; return (yytext[0]);}
[\t ]				;

. 				return (yytext[0]);

%%



