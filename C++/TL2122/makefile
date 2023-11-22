#fichero Makefile
#Autores:Juan Carlos Muñoz Férnandez y Jesús Manuel Vega Benítez

OBJ = listas.o lexico.o analizador.o 

listas : $(OBJ)     				#segunda fase de la traducción. Generación del código ejecutable 
	g++ -olistas -oanalizador  $(OBJ)

listas.o : listas.c        	#primera fase de la traducción del analizador sintáctico
	g++ -c -olistas.o  listas.c 
	
lexico.o : lex.yy.c						#primera fase de la traducción del analizador léxico
	g++ -c -olexico.o  lex.yy.c 	

analizador.o: analizador.cpp
	g++ -c -oanalizador.o analizador.cpp

listas.c : listas.y       	#obtenemos el analizador sintáctico en C
	bison -d -v -olistas.c listas.y

lex.yy.c: lexico.l						#obtenemos el analizador léxico en C
	flex lexico.l

clean : 
	rm  -f  *.c *.o
