CC = cc


# prueba1: monticulo.o prueba1.o 
# 	$(CC) -g prueba1.o monticulo.o  -o prueba1
	
prueba2: monticulo.o prueba2.o 
	$(CC) -g prueba2.o monticulo.o  -o prueba2
# prueba3: monticulo.o prueba3.o 
# 	$(CC) -g prueba3.o monticulo.o  -o prueba3

# prueba1.o: prueba1.c monticulo.h
# 	$(CC) -c prueba1.c -o prueba1.o
prueba2.o: prueba2.c monticulo.h
	$(CC) -c prueba2.c -o prueba2.o
prueba3.o: prueba3.c monticulo.h
	$(CC) -c prueba3.c -o prueba3.o
monticulo.o: monticulo.c monticulo.h
	$(CC) -c monticulo.c -o monticulo.o
limpiar:
	rm *.o prueba1 prueba2


