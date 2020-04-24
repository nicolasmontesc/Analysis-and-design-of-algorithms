"""Algoritmos de ordenamiento para ordenar un vector 
de manera ascendente y de manera descendente
Autores: Juan Nicolás Montes Cetina & Jimmy Alejandro Rios Piñeros""" 


import math #Se importa la clase math para poder realizar operaciones matematicas

#Metodo para ingresar los datos
def ingresar_datos(): 
	
	n = int(input('¿Cuantos valores desea ordenar? \n> ')) #Lee los datos de entrada de tipo entero y los guarda en la variable n
	vector = []
	for i in range(n): #Para i hasta el rango que tome la variable n
		vector.append(int(input(f"Ingrese el valor {i+1} que desea ordenar: "))) #Agrega los valores de tipo entero a la variable vector

	return vector

#Metodo Burbuja de menor a mayor.
def burbuja_ascendente(vector):

	for i in range(0,len(vector)-1): #Se recorre el vector desde la posicion 0 hasta el tamaño del vector menos una posicion
		for j in range(i+1,len(vector)): #Se recorre el vector desde la desde la posicion de i + una posicion hasta el tamaño del vector
			if vector[i]>vector[j]: #Si el vector del elemento i es mayor al elemento j
				aux = vector[i] #El elemento i del vector se asigna a la variable auxiliar
				vector[i] = vector[j] #El elemento j del vector se asigna al vector de elemento i
				vector[j] = aux #El elemento de la variable auxiliar se asigna al vector de elemento j

	print('Burbuja Ascendente >', vector[:]) #Imprime todo lo que contiene el vector

#Metodo Burbuja de mayor a menor
def burbuja_descendente(vector): 

	for i in range(0,len(vector)-1): #Se recorre el vector desde la posicion 0 hasta el tamaño del vector menos una posicion
		for j in range(i+1,len(vector)): #Se recorre el vector desde la desde la posicion de i + una posicion hasta el tamaño del vector
			if vector[i]<vector[j]:#Si el vector del elemento i es menor al elemento j
				aux = vector[i] #El elemento i del vector se asigna a la variable auxiliar
				vector[i] = vector[j] #El elemento j del vector se asigna al vector de elemento i
				vector[j] = aux #El elemento de la variable auxiliar se asigna al vector de elemento j

	print('Burbuja Descendente >', vector[:]) #Imprime todo lo que contiene el vector



#Metodo Burbuja Bidireccional de menor a mayor
def burbujaBidireccional_ascendente(vector):

	for j in range(1,len(vector)): #Recorre el arreglo desde 1 hasta el tamaño del vector
		for i in range(0,len(vector)-j):# 
			if vector[i] > vector[i+1]:
				temp = vector[i]
				vector[i] = vector[i+1]
				vector[i+1] = temp
		for k in range(len(vector)-j,j,-1):
			if vector[k]<vector[k-1]:
				temp = vector[k]
				vector[k] = vector[k-1]
				vector[k-1] = temp
	print('Burbuja Bidireccional Ascendente >',vector[:])


#Burbuja Bidireccional de mayor a menor
def burbujaBidireccional_descendente(vector):

	for j in range(1,len(vector)):
		for i in range(0,len(vector)-j):
			if vector[i] < vector[i+1]:
				temp = vector[i]
				vector[i] = vector[i+1]
				vector[i+1] = temp
		for k in range(len(vector)-j,j,-1):
			if vector[k]>vector[k-1]:
				temp = vector[k]
				vector[k] = vector[k-1]
				vector[k-1] = temp
	print('Burbuja Bidireccional Descendente >',vector[:])


#Metodo de Seleccion de menor a mayor			
def seleccion_ascendente(vector):
	for i in range(0,len(vector)):
		menor = vector[i]
		pos = i
		for j in range(i+1,len(vector)):
			if vector[j] < menor:
				menor = vector[j]
				pos = j
		if(pos != i):
			temp = vector[i]
			vector[i] = vector[pos]
			vector[pos] = temp

	print('Seleccion Ascendente >',vector[:])

#Metodo de Seleccion de mayor a menor
def seleccion_descendente(vector):
	for i in range(0,len(vector)):
		menor = vector[i]
		pos = i
		for j in range(i+1,len(vector)):
			if vector[j] > menor:
				menor = vector[j]
				pos = j
		if(pos != i):
			temp = vector[i]
			vector[i] = vector[pos]
			vector[pos] = temp

	print('Seleccion Descendente >',vector[:])

#Metodo Inserción de menor a mayor
def insercion_ascendente(vector):
	for p in range(1,len(vector)):
		aux = vector[p]
		j = p - 1
		while (j >= 0) and (aux < vector[j]):
			vector[j+1] = vector[j]
			j = j - 1
		vector[j+1] = aux
	print('Inserción Ascendente >',vector[:])

#Metodo Inserción de mayor a menor
def insercion_descendente(vector):
	for p in range(1,len(vector)):
		aux = vector[p]
		j = p - 1
		while (j >= 0) and (aux > vector[j]):
			vector[j+1] = vector[j]
			j = j - 1
		vector[j+1] = aux
	print('Inserción Descendente >',vector[:])

#Metodo Quicksort de menor a mayor
def quicksort_ascendente(vector):
	
	if len(vector) > 1:
		inicio = []
		ultimo = []
		pivote = vector.pop()
		for i in vector:
			if i < pivote:
				ultimo.append(i)
			elif i > pivote:
				inicio.append(i)
		return quicksort_ascendente(ultimo)+[pivote]+quicksort_ascendente(inicio)
	else:
		return vector


#Metodo Quicksort de mayor a menor
def quicksort_descendente(vector):
	
	if len(vector) > 1:
		inicio = []
		ultimo = []
		pivote = vector[0]
		secuencia = vector[1:]
		for i in vector:
			if i < pivote:
				ultimo.append(i)
			elif i > pivote:
				inicio.append(i)
		return quicksort_descendente(inicio)+[pivote]+quicksort_descendente(ultimo)
	else:
		return vector
#Metodo Shell de menor a mayor
def shell_ascendente(vector):
	inicio = 1
	for inicio in range(1,len(vector),inicio*3+1):
		while inicio>0:
			for i in range(inicio,len(vector)):
				j = i
				aux = vector[i]
				while j >= inicio and vector[j-inicio] > aux:
					vector[j]=vector[j-inicio]
					j = j - inicio
				vector[j] = aux
			inicio = inicio//2
	print('Shell Ascendente >',vector[:])

#Metodo Shell de mayor a menor
def shell_descendente(vector):
	inicio = 1
	for inicio in range(1,len(vector),inicio*3+1):
		while inicio>0:
			for i in range(inicio,len(vector)):
				j = i
				aux = vector[i]
				while j >= inicio and vector[j-inicio] < aux:
					vector[j]=vector[j-inicio]
					j = j - inicio
				vector[j] = aux
			inicio = inicio//2
	print('Shell Descendente >',vector[:])

#Metodo Gnome de menor a mayor
def gnome_ascendente(vector):
	i = 1
	while i < len(vector):
		if vector[i] >= vector[i - 1]:
			i = i + 1 
		else:
			aux = vector[i - 1]
			vector[i - 1] = vector[i]
			vector[i] = aux
			if i > 1 :
				i = i - 1
	print('Gnome Ascendente >',vector[:])

#Metodo Gnome de mayor a menor
def gnome_descendente(vector):
	i = 1
	while i < len(vector):
		if vector[i] <= vector[i - 1]:
			i = i + 1 
		else:
			aux = vector[i - 1]
			vector[i - 1] = vector[i]
			vector[i] = aux
			if i > 1 :
				i = i - 1
	print('Gnome Descendente >',vector[:])

#Metodo Peine de menor a mayor
def peine_ascendente(vector):
	permutacion = True
	gap = len(vector)
	while (permutacion == True) or (gap>1):
		permutacion = False
		gap = math.floor(gap / 1.3)
		if gap < 1: 
			gap = 1
		for actual in range(0,len(vector)-gap):
			if vector[actual] > vector[actual + gap]:
				permutacion = True
				aux = vector[actual]
				vector[actual] = vector[actual + gap] 
				vector[actual + gap] = aux
	print('Peine Ascendente >',vector[:])

#Metodo Peine de mayor a menor
def peine_descendente(vector):
	permutacion = True
	gap = len(vector)
	while (permutacion == True) or (gap>1):
		permutacion = False
		gap = math.floor(gap / 1.3)
		if gap < 1: 
			gap = 1
		for actual in range(0,len(vector)-gap):
			if vector[actual] < vector[actual + gap]:
				permutacion = True
				aux = vector[actual]
				vector[actual] = vector[actual + gap] 
				vector[actual + gap] = aux
	print('Peine Descendente >',vector[:])


#Ejecucion de Metodos (8)
def main():
	#Metodo Ingresar varios datos 
	vector = ingresar_datos()
	
	#1. Metodo Burbuja
	#burbuja_ascendente(vector)
	#burbuja_descendente(vector)
	
	#2. Metodo Burbuja Bidireccional
	#burbujaBidireccional_ascendente(vector)
	#burbujaBidireccional_descendente(vector)
	
	#3. Metodo Seleccion
	#seleccion_ascendente(vector)
	#seleccion_descendente(vector)
	
	#4. Metodo Inserción
	#insercion_ascendente(vector)
	#insercion_descendente(vector)
	
	#5. Metodo Quicksort
	#print('Quicksort Ascendente >',quicksort_ascendente(vector))
	#print('Quicksort Descendente >',quicksort_descendente(vector))

	#6. Metodo Shell
	#shell_ascendente(vector)
	#shell_descendente(vector)

	#7. Metodo Gnome
	#gnome_ascendente(vector)
	#gnome_descendente(vector)

	#8. Metodo Peine
	peine_ascendente(vector)
	peine_descendente(vector)

if __name__ == "__main__" :
	main()