# Lab5UTN
proyectos para LAB 5 UTN


Respuestas:
Se necesitan "n" numero de Threads para aplicar la logica deseada,
 puede ser 1 hilo que ejecute 10 veces el metodo run como también se pueden instanciar varios hilos y ocurra que necesite 2 para terminar
 la tarea

Los bloques synchronized son utilizados para que entre un hilo a la vez,
 sirven para ser multiaccedidos por los hilos de ejecución, a su vez estos bloques permiten la interacción con la acción especifica y su 
interaccion al objeto compartido,
 en caso de no querer que accedan se setea una variable que hace al thread en un ciclo de wait() hasta que se notifique
 y la variable previamente mencionada este liberada.

El recurso compartido es la Cerveceria, es el punto en comun donde todos los hilos van a ejercutarse y entraran en orden de llegada a los metodos syncronized.

Formas de instanciar un Thread: 
-Extender de Thread,realizar un override del metodo .run(),instanciar nuestra clase 
y ejecutar metodo .start().
-Implementar Runnable,tambien realizar override de .run(),instanciar un Thread mediante 
new Thread(NuestraClase) e iniciar el metodo .start() en la instancia del Thread. 
-Implementar Callable, es similar al uso
 de Runnable solo que esta interfaz permite el retorno de datos y emitir una Exception
 en caso de no poder retornar datos.