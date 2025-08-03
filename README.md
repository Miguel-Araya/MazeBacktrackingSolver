# Aplicación Solucionadora de Laberintos

## Descripción

La **Aplicación Solucionadora de Laberintos** es una herramienta interactiva desarrollada en **Java** que permite resolver laberintos utilizando el algoritmo de **backtracking**. La interfaz gráfica está construida con **Java Swing** y permite al usuario visualizar paso a paso cómo se encuentra la solución, gracias al uso de **hilos**.

## Características

* **Algoritmo de Backtracking**: Encuentra automáticamente un camino desde el inicio hasta la salida del laberinto.
* **Interfaz Gráfica Interactiva**: Desarrollada con Java Swing, facilita la creación y visualización del laberinto.
* **Selección Manual del Inicio y Fin**: El usuario puede establecer las posiciones de entrada y salida.
* **Tamaño Personalizable del Laberinto**: Es posible definir el tamaño del laberinto (por ejemplo: 5x5, 10x10, etc.).
* **Resolución Paso a Paso con Hilos**: Se utiliza un **hilo (Thread)** para mostrar en tiempo real cómo se explora el laberinto y se encuentra la solución.
* **Visualización del Camino Correcto**: Al finalizar, se resalta el camino encontrado desde el inicio hasta la salida.

## Estructuras de Datos Utilizadas

* **Listas Enlazadas (Linked Lists)**: Para gestionar los nodos del laberinto y registrar el recorrido.
* **ArrayList**: Para almacenar de forma dinámica las posiciones exploradas y los caminos posibles.

## Instalación y Uso

1. Clona o descarga este repositorio.
2. Asegúrate de tener instalada una versión compatible de Java (Java 8 o superior).
3. Abre el proyecto en tu IDE favorito (por ejemplo: IntelliJ IDEA, Eclipse o NetBeans).
4. Compila y ejecuta la aplicación.
5. Crea tu laberinto, selecciona los puntos de inicio y fin, y observa cómo el programa resuelve el laberinto paso a paso.
