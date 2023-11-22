%{
#include <iostream>
 

using namespace std;

//elementos externos al analizador sintácticos por haber sido declarados en el analizador léxico      			
extern int n_lineas;
extern int yylex();

//definición de procedimientos auxiliares
void yyerror(const char* s){         /*    llamada por cada error sintactico de yacc */
	cout << "Error sintáctico en la instrucción "<< n_lineas<<endl;	
} 

void prompt(){
  	cout << "LISTO> ";
}

bool errorSemantico = false;

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
%token NUMERO SALIR IDENTIFICADOR ENTERO REAL ASIG CIERTO FALSO  MAYORI MENORI IGUAL DISTINTO Y O NO
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
entrada: 		{prompt();}
      |entrada linea
      ;
linea: SALIR 	'\n'			{cout<<"Vuelta a la terminal"<<endl;return(0);	} 


        |error  '\n'                    {yyerrok;prompt();}
        | IDENTIFICADOR ASIG expr '\n'    {if (!errorSemantico) {
                                    		 cout <<"Instruccíon "<< n_lineas<<":La variable "  << $1<<", "; 
					if($3.esReal){
					cout<<"de tipo real,";				
					}
					else cout<<"de tipo entero,";	
					cout<< " toma el valor " << $3.valor << endl;
                                   	 }
                                   	 else {
                                          cout << "Error semántico en la instrucción "<<n_lineas<< endl;
                                    }
					prompt();
					errorSemantico=false;}
        | IDENTIFICADOR ASIG exprBool '\n'    {if (!errorSemantico) {
                                    		 cout <<"Instruccíon "<< n_lineas<<":La variable " << $1 << ", de tipo lógico, toma el valor ";
							if($3==1){
							cout<<"cierto"<<endl;							
							}else cout<<"falso"<<endl;
                                   	 }
                                   	 else {
                                          cout << "Error semántico en la instrucción "<<n_lineas<< endl;
                                    }
					prompt();
					errorSemantico=false;}
                                          
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

       | expr '+' expr 		{$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor+$3.valor;}  
                   
       | expr '-' expr    	{$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor-$3.valor;}            
       | expr '*' expr          {$$.esReal=$1.esReal||$3.esReal;$$.valor=$1.valor*$3.valor;} 
       | expr '/' expr          {$$.esReal=$1.esReal||$3.esReal;
                                    if ($3.valor == 0) {
                                          errorSemantico = true;
                                    }
                                    else if ($$.esReal) {
                                          $$.valor = $1.valor / $3.valor;
                                    }
                                    else {
                                          $$.valor = int ($1.valor) / int ($3.valor);}
                                    }
       | expr '%' expr          {$$.esReal=$1.esReal||$3.esReal;
 				
				if ($3.esReal == true) {
				
					errorSemantico = true;
				}else{
					if($3.valor==0){
					errorSemantico = true;
}
				else $$.valor=int($1.valor)%int($3.valor);}
				}  
                        
       | '(' expr ')'           {$$.esReal=($2.esReal);$$.valor=($2.valor);}

       |'-' expr %prec menos    {$$.esReal=$2.esReal;$$.valor=-$2.valor;}
	
	
       ;
%%

int main(){
     
     n_lineas = 0;
     
     cout <<endl<<"******************************************************"<<endl;
     cout <<"*      Calculadora de expresiones aritméticas        *"<<endl;
     cout <<"*                                                    *"<<endl;
     cout <<"*      1)con el prompt LISTO>                        *"<<endl;
     cout <<"*        teclea una expresión, por ej. 1+2<ENTER>    *"<<endl;
     cout <<"*        Este programa indicará                      *"<<endl;
     cout <<"*        si es gramaticalmente correcto              *"<<endl;
     cout <<"*      2)para terminar el programa                   *"<<endl;
     cout <<"*        teclear SALIR<ENTER>                        *"<<endl;
     cout <<"*      3)si se comete algun error en la expresión    *"<<endl;
     cout <<"*        se mostrará un mensaje y la ejecución       *"<<endl;
     cout <<"*        del programa finaliza                       *"<<endl;
     cout <<"******************************************************"<<endl<<endl<<endl;
     yyparse();
     cout <<"****************************************************"<<endl;
     cout <<"*                                                  *"<<endl;
     cout <<"*                 ADIOS!!!!                        *"<<endl;
     cout <<"****************************************************"<<endl;
     return 0;
}
