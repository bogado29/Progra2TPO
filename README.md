# Progra2TPO
TPO de Progra 2 - 2021

Hola chicos, aca Alejandro

Agreguen las modificaciones que crean necesarias, si no estan muy cancheros usando github pueden hacer un drag and drop
sobre los archivos que quieran modificar.

Cuando suban las modificacines pongan un comentario. 

Para configurar el repo en eclipse pueden usar este video: 

https://www.youtube.com/watch?v=LPT7v69guVY

Cualquier cosa me comentan por WhatsUp.
Slds!.

# Trabajo Práctico Obligatorio de Programación II

Definir el TDA “Lista”, con la correspondiente interface, implementación y análisis de costos.

1. El TDA “Lista” permite funcionalidades similares a la lista vista en Python.

2. Posee las siguientes características:

a. Las elementos se van agregando a la lista, desde el primero al último, siendo el que ocupa la posición 0 el primero, el que ocupa la posición 1 el segundo, etc… .

b. Los elementos son del tipo int y pueden estar duplicados.

3. El estudiante debe decidir que implementación utilizará (estática o dinámica)

4. Posee el siguiente comportamiento:

a. inicializar(): Permite inicializar las propiedades de la lista. Es precondición para el resto de los métodos del comportamiento de la lista

b. append(int x): Permite agregar un entero que recibe como parámetro.

c. int get(int x): Retorna el elemento que se encuentra en la posición x de la lista. (z=Lista[x]). Precondición que no se encuentre vacía la lista y que exista el elemento x.

d. void set(int x, int valor): Asigna al elemento que se encuentra en la posición x un valor. En el caso que no exista x, no se asigna valor.

e. void insert (x, int valor): Inserta el valor en la posición x, haciendo un corrimiento a la derecha de los restantes elementos.

Precondición: x es un valor positivo y debe existir el elemento en posición x o debe ser el inmediato siguiente (len de la lista)

f. int pop(). Permite eliminar el último elemento de la lista, que será retornado por el método. Precondición que no se encuentre vacía la lista.

g. int pop(int x). Permite eliminar el elemento x de la lista, que será retornado por el método. Precondición que no se encuentre vacía la lista, y que exista el elemento x.

h. print(): Permite imprimir los elementos separados por comas entre corchetes. Por ejemplo: [3,5,1]

i. int len(): Retorna la cantidad de elementos de la lista.

j. sort(int orden): Permite ordenar la lista, en el caso de recibir 1, de menor a mayor, en el caso de recibir 2 como parámetro, de mayor a menor.

k. extend (lista x): Permite agregar la lista x a la lista.

l. remove(int x) : Permite eliminar el elemento x de la lista. En el caso de que el elemento estuviera repetido, elimina el primero de ellos. Precondición que no se encuentre vacía la lista y que el elemento x exista.

m. reverse(): Permite invertir el orden en que esta almacenada la list
