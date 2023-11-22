
CREATE DATABASE BD1;

CREATE TABLE  Usuario (

Usuario PRIMARY KEY,


 Edad NUMERIC (30,3) 



,

 ¿Empleo? BOOLEAN 


,


 Nombre VARCHAR2(20) 

,



Sexo FOREIG KEY (numgest) 
REFERENCES Sexo (lista_Sexo)
ON DELETE SET NULL


);

CREATE TABLE lista_Sexo (

	Sexo PRIMARY KEY,
	Masculino VARCHAR2(20)
,	Femenino VARCHAR2(20)
	);


