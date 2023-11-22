#fichero Makefile
#Autores:Juan Carlos Muñoz Férnandez y Jesús Manuel Vega Benítez

OBJ = expresiones.o lexico.o analizador.o

calculadora : $(OBJ)     				#segunda fase de la traducción. Generación del código ejecutable 
	g++ -ocalculadora $(OBJ)

expresiones.o : expresiones.c        	#primera fase de la traducción del analizador sintáctico
	g++ -c -oexpresiones.o  expresiones.c 
	
lexico.o : lex.yy.c						#primera fase de la traducción del analizador léxico
	g++ -c -olexico.o  lex.yy.c 	

analizador.o: analizador.cpp
	g++ -c -oanalizador.o analizador.cpp

expresiones.c : expresiones.y       	#obtenemos el analizador sintáctico en C
	bison -d -v -oexpresiones.c expresiones.y

lex.yy.c: lexico.l						#obtenemos el analizador léxico en C
	flex lexico.l

clean : 
	rm  -f  *.c *.o 
