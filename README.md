# QueMePongo

5ta iteracion

1er Requerimiento
- Como usuarie de QuéMePongo, quiero poder manejar varios guardarropas para separar mis prendas según diversos criterios (ropa de viaje, ropa de entrecasa, etc). 

Propuesta:
Se considera una clase Usuario que cuenta con una lista de guardarropas.

2do Requerimiento:
- Como usuarie de QuéMePongo, quiero poder crear guardarropas compartidos con otros usuaries (ej, ropa que comparto con mi hermane). 

Propuesta:
En la clase guadarropas se agrega una lista de usuarios que lo estan usando. Al agregar un  usuario un guardarropas, este ultimo se agrega automaticamente.

3er y 4to Requerimiento:
- Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente agregar una prenda al guardarropas.
- Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente quitar una prenda del guardarropas.

Propuesta:
Se considera una nueva clase propuesta que va a contar como parametros la prenda que se propone y su estado. No se considera la accion de la propuesta (agregar, quitar), eso se implementara en otra capa, pero si me interesa manejar el estado.  

5to Requerimiento:
- Como usuarie de QuéMePongo, necesito ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas y poder aceptarlas o rechazarlas.

Propuesta:
Las propuestas se implementan en una lista en la clase usuario, estas propuestas tendran un estado neutro sin decidir. Las propuestas sobre las que se tomo accion, pasaran a ser parte de una lista de decisiones concretadas. La decision es una interfaz dado que se intenta emular un patron command a la hora de como actuara cada decision. A su vez, puedo tomar otras decisiones no sugeridas, como ignorar propuesta.

6to Requerimiento:
- Como usuarie de QuéMePongo, quiero poder deshacer las propuestas de modificación que haya aceptado.

Propuesta:
La posibilidad de deshacer se implementa mediante la interfaz de cada decision para que impacte solamente a la propuesta y sea facilmente accedible. No se dan detalles de si deshacer implica devolver la propuesta a la lista de propuestas o cambiar a un estado intermedio.