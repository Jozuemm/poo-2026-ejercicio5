# Ejercicio #5

## Integrantes

Josué Morales - 26588
Raul Robles - 26919

## Analisis

### Descripción del problema

La misión del satélite Quetzal-2 necesita administrar componentes que tienen características comunes, pero realizan tareas diferentes. Todos los módulos poseen un identificador, un nombre, un estado de salud y un costo de construcción

Hay tres tipos de modulos, de energia, de vuelo y de tierra para los cuales se necesita un sistema que permita consultar estos componentes y ejecutar su comportamiento mediante un menú de terminal. En esta primera versión no se incluirán interfaz gráfica, enemigos ni un mapa.

### Requisitos funcionales

- Cargar inicialmente al menos 10 módulos de los tres tipos en una única
- Mostrar un menú de consola que se repita hasta que el usuario seleccione salir
- Listar todos los módulos con sus características comunes y específicas
- Buscar un módulo por su ID y mostrar su información
- Buscar módulos por nombre y mostrar las coincidencias
- Informar cuando una búsqueda no encuentre resultados
- Mostrar los módulos ordenados de menor a mayor costo mediante Comparable<Modulo> y Collections.sort()
- Permitir que el usuario procese un ciclo de la simulación
- Ejecutar el comportamiento de cada módulo mediante el método polimórfico procesarCiclo()
- Registrar la energía disponible, los datos pendientes, los datos descargados y el número de ciclos realizados
- Mostrar el estado actual de la misión
- Validar las entradas y permitir corregir opciones o datos inválidos sin finalizar inesperadamente el programa

### Reglas de funcionamiento

- Cada módulo tendrá un ID numérico, único e inmutable
El nombre no podrá estar vacío; el costo y los recursos no podrán ser negativos
- La salud se representará con un valor entre 0 y 100. Un módulo con salud cero no ejecutará su comportamiento
- Cada ciclo avanzará únicamente cuando el operador seleccione la opción correspondiente
- Los módulos actuarán en el orden establecido por la carga inicial
- Los módulos de energía incrementarán la energía disponible
- Los módulos de vuelo consumirán energía y agregarán datos pendientes. Si no existe energía suficiente, no recolectarán datos ni descontarán recursos
- Los módulos de tierra descargarán como máximo su capacidad por ciclo y nunca más datos de los disponibles. Solo consumirán energía si pueden realizar una descarga
- Descargar información reducirá los datos pendientes e incrementará los datos descargados en la misma cantidad
- Ordenar para mostrar el catálogo no modificará el orden de ejecución: se ordenará una copia de la colección
- La búsqueda por ID devolverá como máximo un módulo; la búsqueda por nombre permitirá varias coincidencias parciales, sin distinguir mayúsculas y minúsculas

### Clases

- Mision : Administrar la colección de módulos, los recursos, las búsquedas, el ordenamiento y los ciclos
- Modulo : Definir los atributos y comportamientos comunes de los módulos. Será abstracta
- ModuloEnergia : Implementar la generación de energía
- ModuloVuelo : Implementar la recolección de datos mediante consumo de energía
- ModuloTierra : Implementar la descarga de datos mediante consumo de energía
- VistaConsola : Mostrar el menú, presentar resultados y leer las entradas del operador
- ControladorMision : Interpretar las opciones y coordinar las operaciones entre la vista y el modelo
- Main : Crear los objetos principales, conectarlos e iniciar el programa

### Aplicación de POO y MVC

La herencia permitirá que las tres clases de módulos reutilicen los atributos definidos en Modulo. Esta clase será abstracta porque no se necesita construir un módulo genérico, sino módulos con funciones concretas

El polimorfismo permitirá almacenar las tres subclases en una única ArrayList<Modulo>. Al recorrerla y llamar a procesarCiclo(), cada objeto ejecutará su propia implementación. Asimismo, agregarModulo(Modulo modulo) podrá recibir cualquiera de los tres tipos mediante el tipo de la clase base

La sobrecarga estará presente en las búsquedas: buscarModulo(int id) buscará por identificador y buscarModulo(String nombre) buscará por nombre

La encapsulación protegerá los atributos mediante visibilidad privada y métodos controlados. No se expondrá la lista interna para que otras clases puedan modificarla directamente

En MVC, el modelo contendrá los datos y las reglas; la vista manejará la interacción por terminal; y el controlador conectará ambas partes. Por ejemplo, la vista podrá leer una solicitud de avanzar un ciclo, pero será el modelo quien determine cuánta energía se genera o consume.