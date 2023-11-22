%{
#include <iostream>
#include "analizador.h"
#include <cstring>

 

using namespace std;
extern FILE* yyin;
extern FILE* yyout;

//elementos externos al analizador sintácticos por haber sido declarados en el analizador léxico      			
extern int n_lineas;
extern int yylex();
bool errorSemantico = false;
 analizadorAux a;
string error;

//definición de procedimientos auxiliares
void yyerror(const char* s){         /*    llamada por cada error sintactico de yacc */
	cout << "Error sintáctico en la instrucción "<< n_lineas<<endl;	
	errorSemantico=false;
} 


void mostrarErrorSemantico(string error){         /*    llamada por cada error sintactico de yacc */
	cout << "Error semántico en la instrucción "<< n_lineas <<error <<endl;	
	errorSemantico=false;

}


%}

%union{
	int c_entero;
	float c_real;
	char c_cadena[20];
	bool c_bool;
struct {
	float valor;	
	bool esReal;
} c_expresion;
}
%start entrada
%token IDENTIFICADOR ENTERO REAL ASIG CIERTO FALSO  MAYORI MENORI IGUAL DISTINTO Y O NO 
%left O
%left Y
%left IGUAL DISTINTO
%left '<' '>' MENORI MAYORI  
%left '+' '-'   /* asociativo por la izquierda, misma prioridad */
%left '*' '/' '%'   /* asociativo por la izquierda, prioridad alta */
%left menos
%left NO
 

%type <c_real> REAL
%type <c_cadena> IDENTIFICADOR
%type <c_entero> ENTERO
%type <c_expresion> expr
%type <c_bool> exprBool




%%
entrada: 		
      |entrada linea
      ;
linea: error  '\n'                    {yyerrok;errorSemantico=false;}
        | IDENTIFICADOR ASIG expr '\n'    {if (!errorSemantico) {

					analizador b;
					strcpy(b.id,$1);
					b.linea=n_lineas;
					
					if($3.esReal){
			
					b.tipo=1;
					b.valor.c_real=$3.valor;
					}
					
					else{ 
					b.tipo=0;
					b.valor.c_entero=$3.valor;
					}
						
					if(!insertar(a,b)) {
					string error = ": la variable ";
					error += $1;
					error +=" es de tipo un tipo distinto del que se le quiere asignar";
					mostrarErrorSemantico(error);
					
					}}else mostrarErrorSemantico(error);} 
					
					
					
					
        | IDENTIFICADOR ASIG exprBool '\n'    {if (!errorSemantico) {

						
						analizador b;
						strcpy(b.id,$1);
						b.linea=n_lineas;
						b.tipo = 2;
							
							if($3==1){

							b.valor.c_bool=true;
														
							}else{
							b.valor.c_bool=false;
							}
					if(!insertar(a,b)) {
					string error = ": la variable ";
					error += $1;
					error +=" es de tipo un tipo distinto del que se le quiere asignar";
					mostrarErrorSemantico(error);
                                   	 }}else mostrarErrorSemantico(error);}    
                                   	 
                                   	 
                                   	                            
	;




exprBool: CIERTO			 {$$=true;}
	| FALSO				 {$$=false;}
	| exprBool IGUAL exprBool        {
					if($1==$3)
						$$=true;
					else $$=false;}
	| exprBool DISTINTO exprBool        {
					if($1!=$3)
						$$=true;
					else $$=false;}
	| exprBool Y exprBool        {$$=($1&&$3);}
	| exprBool O exprBool        {$$=($1||$3);}
	| NO exprBool			{$$=!$2;}
	
	| expr IGUAL expr        {
					if($1.valor==$3.valor)
						$$=true;
					else $$=false;}
	| expr DISTINTO expr        {
					if($1.valor!=$3.valor)
						$$=true;
					else $$=false;}

	| expr '<' expr        {
					if($1.valor < $3.valor)
						$$=true;
					else $$=false;}
	| expr '>' expr        {
					if($1.valor > $3.valor)
						$$=true;
					else $$=false;}
	| expr MENORI expr        {
					if($1.valor<=$3.valor)
						$$=true;
					else $$=false;}
	| expr MAYORI expr        {
					if($1.valor>=$3.valor)
						$$=true;
					else $$=false;}
	| '(' exprBool ')'        {
					if($2==true)
						$$=true;
					else $$=false;}
	


	;

expr:  ENTERO                  {$$.esReal = false;
				 $$.valor=$1;}
       | REAL			{$$.esReal = true;
				 $$.valor=$1;}
	| IDENTIFICADOR        {analizador b;
	 			if(buscar(a, $1, b)){
	 			 
	 				if(b.tipo == 0){
	 					
	 					$$.esReal = false;
	 					$$.valor=b.valor.c_entero;
	 				}else {
	 				if(b.tipo == 1){
	 				
	 					$$.esReal = true;
	 					$$.valor=b.valor.c_real;
	 				}else {  	
	 		errorSemantico=true;				
			error = ": la variable ";
			error += $1;
			error +=" no es de tipo numérico";

	 		}
	 				}
	 				
				}else{ 
				
				errorSemantico=true;
				error = ": la variable ";
				error += $1;
				error +=" no está definida";

				}
	 			}   

       | expr '+' expr 		{$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor+$3.valor;}  
                   
       | expr '-' expr    	{$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor-$3.valor;}            
       | expr '*' expr          {$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor*$3.valor;} 
       | expr '/' expr          {$$.esReal=$1.esReal||$3.esReal;
                                    if ($3.valor == 0) {
                                          errorSemantico = true;
                                         error =": división por cero";
                                    }
                                    else if ($$.esReal) {
                                          $$.valor = $1.valor / $3.valor;
                                    }
                                    else {
                                          $$.valor = int ($1.valor) / int ($3.valor);}
                                    }
       | expr '%' expr          {$$.esReal=$1.esReal||$3.esReal;
 				
				if ($1.esReal ==true || $3.esReal == true) {
				
					errorSemantico = true;
					error =": se usa la operación % con operandos reales";

				
				}else{
					if($3.valor==0){
					errorSemantico = true;
					error =": se usa la operación % con un 0";
}
				else $$.valor=int($1.valor)%int($3.valor);}
				}  
                        
       | '(' expr ')'           {$$.esReal=($2.esReal);$$.valor=($2.valor);}

       |'-' expr %prec menos    {$$.esReal=$2.esReal;$$.valor=-$2.valor;}
	
	
       ;

%%

int main(int argc, char *argv[]){
     
     if(argc>=2){
     
     n_lineas = 0;
     iniciar(a);
      
     yyin = fopen(argv[1], "rt");     
     yyparse();

     crearFichero( a, argv[2]);
    
     }else cout << "No se han introducido los parametros de entrada"<<endl;
     
     return 0;
}
