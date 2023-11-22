%{
#include <iostream>
#include <cstring>
#include <fstream>
#include "analizador.h"
#include<math.h>



 

using namespace std;
extern FILE* yyin;
extern FILE* yyout;

//elementos externos al analizador sintácticos por haber sido declarados en el analizador léxico                  
extern int n_lineas;
extern int yylex();

 listas l;
 variables v;
 bool condicional = true ;
 
 
fstream f;
bool ejecutar = false;

bool asignarLista  =true;
string error;

//definición de procedimientos auxiliares
void yyerror(const char* s){         /*    llamada por cada error sintactico de yacc */
    cout << "Error sintáctico en la instrucción "<< n_lineas<<endl;    
	condicional = true;
} 

void mostrarErrorSemantico(string error){         /*    llamada por cada error sintactico de yacc */
    cout << "Error semántico en la instrucción "<< n_lineas <<error <<endl;    
	condicional = true;
}


%}

%union{
    int c_entero;
    float c_real;
    char c_cadena[100];
    bool c_bool;
    

union c_valor{
    int c_entero;
    float c_real;
    char c_cadena[100];
    bool c_bool;
};


struct {
int tipo;
c_valor valor;

}c_valores;



}
%start inicio
%token LISTAS ESCRIBIR  ASIGLISTA ENTERO REAL IDENTIFICADOR IDENTIFICADOR2 CIERTO FALSO DOBLEPUNTO NOMENTERO NOMREAL LOGICO VARIABLES INICIO FIN ASIG TEXTO MAYORI MENORI IGUAL DISTINTO Y O NO NUEVALINEA PRIMERO ULTIMO ENESIMO SI SI_NO 
 
%left O
%left Y
%left IGUAL DISTINTO
%left '<' '>' MENORI MAYORI  
%left '+' '-'   /* asociativo por la izquierda, misma prioridad */
%left '*' '/' '%'   
%left menos
%left NO


%type <c_cadena> IDENTIFICADOR
%type <c_cadena> IDENTIFICADOR2
%type <c_entero> ENTERO
%type <c_valores> tipo
%type <c_real> REAL
%type <c_bool> CIERTO
%type <c_bool> FALSO
%type <c_cadena>TEXTO
%type <c_valores> expr
%type <c_bool> exprBool
%type <c_valores> secValores
%type <c_valores> valores
%type <c_valores>escribir

%nonassoc si_simple

%%

inicio:  blista bVariable bCodigo {;}
				

;

bCodigo: INICIO saltoLinea secCodigo   FIN saltoLinea    {;}

;



secCodigo:     			{;}
    | secCodigo codigo			{;}
    | secCodigo condicional      	{;}
;



codigo: error '\n'							{yyerrok;}
	|ESCRIBIR '(' secEscribir ')'';' saltoLinea  			{;} 
    	| IDENTIFICADOR2 ASIG expr ';' saltoLinea    			{if(condicional){ 
									analizador nuevoValor;
    									
									switch($3.tipo){
				    	
								    	case 0:
								    	nuevoValor.valor.c_entero =  round($3.valor.c_real);
								    	break;
								    	
								    	
								    	case 1:
								    	nuevoValor.valor.c_real =  $3.valor.c_real;
								    	break;

								    	case 3:
								    	strcpy(nuevoValor.valor.c_cadena, $3.valor.c_cadena );
								    	break; 	
									
								    	}
									nuevoValor.tipo = $3.tipo;
									
    									char c_cadena[100];
    									strcpy(c_cadena,$1 );
    									 if(!asignarValor (l,v, nuevoValor,  c_cadena)){ 
error = ": no se ha encontrado la variable para asignar valor o el tipo de la variable es incompatible con el valor a introducir ";
    									 mostrarErrorSemantico(error);
    									 }
    									 } }    
    									         
    | IDENTIFICADOR2 ASIG exprBool ';' saltoLinea   			{if(condicional){
    									analizador nuevoValor;
    									nuevoValor.valor.c_bool = $3;
    									nuevoValor.tipo = 2;
    									char c_cadena[100];
    									strcpy(c_cadena,$1 );
    									  if(!asignarValor (l,v, nuevoValor,  c_cadena)){ 
    									 error = ": no pueden aparecer variables de tipo lógico en la parte derecha de una asignación";
    									 mostrarErrorSemantico(error);
    									 }}}  

	| IDENTIFICADOR2 ASIG PRIMERO'(' IDENTIFICADOR ')'';'   saltoLinea	{if(condicional){
									analizador valorCompleto;
									char c_cadena[100];
									if(primero (l,$5,valorCompleto)){
									strcpy(c_cadena,$1 );
									strcpy(valorCompleto.nombreTipo,$5 );
    									if(!asignarValor (l,v, valorCompleto,  c_cadena)){ 
error = ": no se ha encontrado la variable para asignar valor o el tipo de la variable es incompatible con el valor a introducir ";
    									 mostrarErrorSemantico(error);}
    									 }else {
									 error = ": no se ha encontrado la lista indicada en primero";
    									 mostrarErrorSemantico(error);    									 
    									 }}} 
									
| IDENTIFICADOR2 ASIG ULTIMO '(' IDENTIFICADOR ')'';' saltoLinea	{ if(condicional){
									analizador valorCompleto;
									char c_cadena[100];
									if(ultimo (l,$5,valorCompleto)){
									strcpy(c_cadena,$1 );
									strcpy(valorCompleto.nombreTipo,$5 );
									
    									 if(!asignarValor (l,v, valorCompleto,  c_cadena)){ 
error = ": no se ha encontrado la variable para asignar valor o el tipo de la variable es incompatible con el valor a introducir ";
    									 mostrarErrorSemantico(error);}}
    									 
    									 else {
									 error = ": no se ha encontrado la lista indicada en ultimo";
    									 }} }
    									 
    									 
    									 
    									  									 
| IDENTIFICADOR2 ASIG ENESIMO '(' IDENTIFICADOR ','  expr ')'';' saltoLinea	{if(condicional){analizador valorCompleto;
										char c_cadena[100];
										
										if(!enesimo (l,$5,(int)$7.valor.c_real,valorCompleto)){
								error = ": imposible obtener el enesimo ";
    									 	mostrarErrorSemantico(error);
										}else{
									strcpy(c_cadena,$1 );
									strcpy(valorCompleto.nombreTipo,$5 );
										 if(!asignarValor (l,v, valorCompleto,  c_cadena)){ 
error = ": no se ha encontrado la variable para asignar valor, el tipo de la variable es incompatible con el valor a introducir o se exceden el límite de la lista ";
    									 mostrarErrorSemantico(error);}}}} 										 
    | NUEVALINEA ';' saltoLinea                     			{ if(condicional){ saltoLinea(f);}}
    	

;



condicional: parteSi parteSiNo {condicional=true;}
;



parteSi: SI exprBool { condicional=$2; } saltoLinea '['saltoLinea secCodigo  ']' saltoLinea 			{;}
									
	;




parteSiNo: %prec si_simple					{;}
	| SI_NO { condicional = !condicional;}  '['saltoLinea secCodigo  ']' saltoLinea  {;}

;



secEscribir: escribir    				{analizador a;
							if(condicional){


							switch($1.tipo){
	
		    					case 0:
		    					a.valor.c_entero =  $1.valor.c_entero;
		    					break;
						    	
						    	case 1:
						    	a.valor.c_real =  $1.valor.c_real;
						    	break;
						    	
						    	case 2:
						    	a.valor.c_bool =  $1.valor.c_bool;
						    	break; 
						    	
						    	case 3:
						    	strcpy(a.valor.c_cadena, $1.valor.c_cadena );
						    	break; 	
							
						    	}
						    	a.tipo = $1.tipo;
							escribir(a,f);}}
									
	| secEscribir ',' escribir 			{analizador a;
							if(condicional){			
			
							switch($3.tipo){
		    					case 0:
		    					a.valor.c_entero =  $3.valor.c_entero;
		    					break;
						    	
						    	case 1:
						    	a.valor.c_real =  $3.valor.c_real;
						    	break;
						    	
						    	case 2:
						    	a.valor.c_bool =  $3.valor.c_bool;
						    	break; 
						    	
						    	case 3:
						    	strcpy(a.valor.c_cadena, $3.valor.c_cadena );
						    	break; 	
							
						    	}
						    	a.tipo = $3.tipo;
							escribir(a,f);}}
							

;



escribir:  expr                 					{
									$$=$1;
									if($1.tipo == 0)
									$$.valor.c_entero = int($1.valor.c_real);
									else $$.valor.c_real = $1.valor.c_real;} 
	| exprBool							{
									if($1){
									$$.tipo=2;
									$$.valor.c_bool=true;
									}else{
									$$.tipo=2;
									$$.valor.c_bool=false;}}
	| TEXTO								{strcpy($$.valor.c_cadena, $1);
									$$.tipo=3;}
									
	| PRIMERO '(' IDENTIFICADOR ')' saltoLinea			{analizador a;
									primero (l,$3,a);
					
									switch(a.tipo){
    	
				    					case 0:
				    					$$.valor.c_entero =  a.valor.c_entero;
				    					break;
								    	
								    	case 1:
								    	$$.valor.c_real =  a.valor.c_real;
								    	break;
								    	
								    	case 2:
								    	$$.valor.c_bool =  a.valor.c_bool;
								    	break; 
								    	
								    	case 3:
								    	strcpy($$.valor.c_cadena, a.valor.c_cadena );
								    	break; 	
								    	}
								    	$$.tipo = a.tipo;}
									
	| ULTIMO '(' IDENTIFICADOR ')' saltoLinea			{analizador a;
									ultimo (l,$3,a);
									
									switch(a.tipo){
				    					case 0:
				    					$$.valor.c_entero =  a.valor.c_entero;
				    					break;
								    	
								    	case 1:
								    	$$.valor.c_real =  a.valor.c_real;
								    	break;
								    	
								    	case 2:
								    	$$.valor.c_bool =  a.valor.c_bool;
								    	break; 
								    	
								    	case 3:
								    	strcpy($$.valor.c_cadena, a.valor.c_cadena );
								    	break; 	
								    	}
								    	$$.tipo = a.tipo;}
									
	| ENESIMO '(' IDENTIFICADOR ',' expr ')'saltoLinea		{analizador a;
									if(enesimo (l,$3,(int)$5.valor.c_real,a)){
									
									switch(a.tipo){
				    					case 0:
				    					$$.valor.c_entero =  a.valor.c_entero;
				    					break;
								    	
								    	case 1:
								    	$$.valor.c_real =  a.valor.c_real;
								    	break;
								    	
								    	case 2:
								    	$$.valor.c_bool =  a.valor.c_bool;
								    	break; 
								    	
								    	case 3:
								    	strcpy($$.valor.c_cadena, a.valor.c_cadena );
								    	break; 	
								    	}
								    	$$.tipo = a.tipo;}
								    	else {
								    	error = ": imposible obtener el enesimo ";
    									mostrarErrorSemantico(error);
								    	}}
;

bVariable: VARIABLES saltoLinea secVariable {;}
;
secVariable:
	|secVariable variable{;}
;

variable: error '\n'					{yyerrok;}
	|tipo secIdentificador ';' saltoLinea    	{analizador a;
							a.tipo = $1.tipo;
							strcpy(a.valor.c_cadena,$1.valor.c_cadena  );
							if(!asignarTipo(l,v, a )){
							error = ": no se ha encontrado el tipo que se le quiere asignar a la variable";
    							mostrarErrorSemantico(error);}}
;



secIdentificador:      IDENTIFICADOR2        {if (!crearVariable(v,$1)){
    						error = ": ya se ha creado una variable con el nombre indicado";
    						mostrarErrorSemantico(error);}}
    						
    						
    						
    						
    |    secIdentificador ',' IDENTIFICADOR2    {crearVariable(v,$3);}
;

tipo:      NOMENTERO        	{$$.tipo=0;}    
    |  NOMREAL          	{$$.tipo=1;}             
    |   LOGICO               	{$$.tipo=2;}  
    |   IDENTIFICADOR    	{$$.tipo=3;
    				strcpy($$.valor.c_cadena,$1  );}
            
;        

blista: saltoLinea LISTAS saltoLinea secLista {asignarLista  =false;}

;



secLista: listas			{;}
	|secLista  listas		{;}


;


listas:  error '\n'					{yyerrok;}
	|IDENTIFICADOR ASIGLISTA secValores '}' saltoLinea 		{char nombreID[100];  
									strcpy(nombreID,$1  );
									if(!asignarNombreLista(l,nombreID)){
    									error = ": ya se ha creado una lsita con el nombre indicado";
    									mostrarErrorSemantico(error);}}   

                         

;

secValores: valores			{
					crearLista(l);
					analizador a;
					
					switch($1.tipo){
    	
				    	case 0:
				    	a.valor.c_entero =  $1.valor.c_entero;
				    	break;
				    	
				    	
				    	case 1:
				    	a.valor.c_real =  $1.valor.c_real;
				    	break;
				    	
				    	case 2:
				    	a.valor.c_bool =  $1.valor.c_bool;
				    	break; 
				    	
				    	case 3:
				    	strcpy(a.valor.c_cadena, $1.valor.c_cadena );
				    	break; 	
					
				    	}
					a.tipo = $1.tipo;
					
					
					if(!insertarDatoListas(l, a)){
					
    					error = ": los valores introducidos en la lista no tienen el mismo tipo";
    					mostrarErrorSemantico(error);}}   					
					
	| secValores ',' valores  	{
					analizador a;
					
					switch($3.tipo){
    	
				    	case 0:
				    	a.valor.c_entero =  $3.valor.c_entero;
				    	break;
				    	
				    	
				    	case 1:
				    	a.valor.c_real =  $3.valor.c_real;
				    	break;
				    	
				    	case 2:
				    	a.valor.c_bool =  $3.valor.c_bool;
				    	break; 
				    	
				    	case 3:
				    	strcpy(a.valor.c_cadena, $3.valor.c_cadena );
				    	break; 	
					
				    	}
					a.tipo = $3.tipo;
					
					if(!insertarDatoListas(l, a)){
					
    					error = ": los valores introducidos en la lista no tienen el mismo tipo";
    					mostrarErrorSemantico(error);}}   

	| expr DOBLEPUNTO expr   	{crearLista(l);
					if(!insertarDatosSecuencia(l,(int)$1.valor.c_real,(int)$3.valor.c_real)){
					error = ": en la secuencia, el valor de inicio es superior del de fin ";
    					mostrarErrorSemantico(error);}
					}  

	
;

valores: expr				{
					$$=$1;
					if($1.tipo == 0)
					$$.valor.c_entero = int($1.valor.c_real);} 
					
	| exprBool			{
					if($1){
					$$.tipo=2;
					$$.valor.c_bool=true;
					}else{
					$$.tipo=2;
					$$.valor.c_bool=false;}}
					
;


    

exprBool: CIERTO             {$$=true;}
    | FALSO                 {$$=false;}
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
    | NO exprBool            {$$=!$2;}
    
    | expr IGUAL expr        {
                    if($1.valor.c_real==$3.valor.c_real)
                        $$=true;
                    else $$=false;}
    | expr DISTINTO expr        {
                    if($1.valor.c_real!=$3.valor.c_real)
                        $$=true;
                    else $$=false;}

    | expr '<' expr        {
                    if($1.valor.c_real < $3.valor.c_real)
                        $$=true;
                    else $$=false;}
    | expr '>' expr        {
                    if($1.valor.c_real > $3.valor.c_real)
                        $$=true;
                    else $$=false;}
    | expr MENORI expr        {
                    if($1.valor.c_real<=$3.valor.c_real)
                        $$=true;
                    else $$=false;}
    | expr MAYORI expr        {
                    if($1.valor.c_real>=$3.valor.c_real)
                        $$=true;
                    else $$=false;}
    | '(' exprBool ')'        {
                    if($2==true)
                        $$=true;
                    else $$=false;}
    


    ;



expr:  ENTERO                  {$$.tipo = 0;
                 		$$.valor.c_real=$1;}
       | REAL            	{$$.tipo = 1;
                		 $$.valor.c_real=$1;}
       | IDENTIFICADOR2         {analizador a; 
	 				if(buscar(v, a,$1)){
	 			 
	 				if(a.tipo == 0){
	 					
	 					$$.tipo = 0;
	 					$$.valor.c_real=(int)a.valor.c_entero;
	 					
	 				}
	 				if(a.tipo == 1){
	 					$$.tipo = 1;
	 					$$.valor.c_real=(float)a.valor.c_real;
	 				}
					if(a.tipo == 3){
	 				
	 					$$.tipo = 3;
						strcpy($$.valor.c_cadena,a.valor.c_cadena  );
	 				}
				}else {  
				if(asignarLista){
				$$.tipo = 3;
				strcpy($$.valor.c_cadena,$1);
				}else{
	 			error = ": no se ha encontrado valores para la variable indicada";
    				mostrarErrorSemantico(error);
	 			}
				
	 		}}

       | expr '+' expr 		{$$.tipo=$1.tipo||$3.tipo;
				$$.valor.c_real=$1.valor.c_real+$3.valor.c_real;  }  
                   
       | expr '-' expr        {$$.tipo=$1.tipo||$3.tipo;$$.valor.c_real=$1.valor.c_real-$3.valor.c_real;}            
       | expr '*' expr          {$$.tipo=$1.tipo||$3.tipo;$$.valor.c_real=$1.valor.c_real*$3.valor.c_real;} 
     
     
     
       | expr '/' expr          {$$.tipo=$1.tipo||$3.tipo;
                                    if ($3.valor.c_real == 0) {
                                    
	 			error = ": división entre 0";
    				mostrarErrorSemantico(error);                                    
                                    }
                                    else  $$.valor.c_real = $1.valor.c_real / $3.valor.c_real;
                                    }
                                    
       | expr '%' expr          {$$.tipo=$1.tipo||$3.tipo;
                 
                if ($1.tipo ==1 || $3.tipo == 1) {
	 			error = ": se usa la operación % con un 0";
    				mostrarErrorSemantico(error);                     
                }else{
                    if($3.valor.c_real==0){
                    	 	error = ": se usa la operación % con operandos reales";
    				mostrarErrorSemantico(error);    
}
                else $$.valor.c_real=int($1.valor.c_real)%int($3.valor.c_real);}
                }  
                        
       | '(' expr ')'           {$$.tipo=($2.tipo);$$.valor.c_real=($2.valor.c_real);}

       |'-' expr %prec menos    {$$.tipo=$2.tipo;$$.valor.c_real=-$2.valor.c_real;}
    
    
       ;                 



saltoLinea:         {;}
    |     saltoLinea '\n'   {;}

;
            
   
                
%%

int main(int argc, char *argv[]){
     
	if(argc==2){

		n_lineas = 1;


		iniciarListas(l);
		iniciarVariables(v);

		yyin = fopen(argv[1], "rt");    
		
		char entrada[100];
		strcpy(entrada, argv[1]);
		char salida[100];
		memset(salida, 0, 100); 
		int i = 0;
		bool enc = false;
		char punto = '.';
		for ( i = 0; i< strlen(entrada) && !enc; i++)
		if(entrada[i] !=punto)
		salida[i] = entrada[i];
		else{
		enc = true;
		salida[i] = '.';
		salida[i+1] = 'c';
		salida[i+2] = 'p';
		salida[i+3] = 'p';
		} 	
		
		f.open(salida,ios_base::out);
		 iniciarCPP(f);
		yyparse();
		 finalizarCPP(f);
		
		fclose(yyin);
		
		f.close();


         


    }else cout << "No se han introducido el número de parametros de entrada correcto"<<endl;
        //valoresLista(l);
       //valoresVariables(v);

     return 0;
}
