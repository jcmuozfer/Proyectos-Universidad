#Jesús Manuel Vega Benítez y Juan Carlos Muñoz Fernández

ejecutar: ejecucion
	./ejecucion < entrada.txt >salida.txt

ejecucion: analizador.o analizadorTexto.o
	g++ -oejecucion analizador.o analizadorTexto.o

analizador.o: analizador.cpp
	g++ -c analizador.cpp

analizadorTexto.o: lex.yy.c
	g++ -c -oanalizadorTexto.o lex.yy.c

lex.yy.c : analizadorTexto.l
	flex  analizadorTexto.l

clean:
	rm -f *.o 


