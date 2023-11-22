%{
/*
 *     Realiza un analizador léxico que, a partir de un fichero de entrada, genere un fichero
 *     de salida en el que se sustituyan los elementos que se describen en la primera
 *     columna por el texto que aparece en la segunda
 */

#include <iostream>
#include "analizador.h"
using namespace std;

analizadorAux a;
int n_lineas;      /* variables globales: contadores */
%}

%option noyywrap

digito [0-9]

caracter [a-zA-Z0-9]

id1    [A-Za-z_]

id2    [a-zA-Z0-9_]

expo   [Ee][-+]?{digito}+

%x COM1 COM2

%%

"/*" BEGIN(COM1);
<COM1>"*/" BEGIN(0);
"//" BEGIN(COM2);
<COM2>"\n" BEGIN(0);
<COM1,COM2>. ;

\n                	 {printf("\n") ;}n_lineas++;

int         {printf("INT");}

float       {printf("FLOAT");}

return      {printf("RETURN");}

for        {printf("FOR");}

if         {printf("IF");}

else        {printf("ELSE");}

{id1}{id2}*           {analizar(a,yytext,n_lineas);printf("ID"); }



{digito}+               {printf("ENTERO");}

({digito}+[.]{digito}*|{digito}*[.]{digito}*){expo}?   {printf("REAL");}

["][^"]*["]                         {printf("CAD");}
  




%%
int main(){
  //inicialización de los contadores
	n_lineas = 1;
	
	iniciar(a);
  	
	yylex();    //llamada al analizador léxico

	escribir(a, n_lineas);
	
  	return 0;  
}
