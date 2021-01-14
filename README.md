Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.



Implementación
-------

Este proyecto está construido sobre programación orientada a objetos y un diseño Modelo-Vista-Controlador.
Se tiene una clase abstracta de Weapon y AbstractPlayerCharacter que contienen las funcionalidades básicas de cada tipo de arma o personaje implementado en el juego.

La funcionalidad es que en el modelo se tiene todos los objetos del juego, 
la vista (no implementada) en mostrar la info relevante al jugador y el 
controlador es el que se encargara de interactuar con el usuario y gestionar entre el modelo y la vista.

El Controlador contiene los turnos, el equipo aliado y el enemigo, junto a todos
los métodos básicos que un usuario podría necesitar.

Instrucciones para ejecutar
-------

Hay que hacer "Run" a "FinalReality" dentro de "gui".

1. Parte con una ventana con un botón start para comenzar.

2. Selecciona 3 personajes.

3. Selecciona 3 enemigos.

4. Decide si quieres customizar los personajes (vida,defensa,etc) o iniciar 
con lo default.

Batalla:

Los enemigos atacan random a tu party

El usuario puede decidir en su turno si quiere cambiar arma, ver información
de aliados o enemigos o ver inventario sin perder el turno. También puede decidir 
atacar a un enemigo y perder el turno.

Esto continua hasta que uno de los dos bandos se queda sin miembros con vida.