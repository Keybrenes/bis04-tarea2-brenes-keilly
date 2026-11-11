En la clase Asociado se representa un asociado de la cooperativa, con el nombre, cedula y saldo de aportes, pero no lee ni muestra ventanas.
En Asociado cada vez que se registra una persona, se crea un objeto Asociado con sus propios datos
En la clase AsociadoArchivo DAO guarda a un asociado en el archivo, lee los que ya estan guardados y convierte la informacion en objetos
Todas las clases piden a DAO que guarde o devuelva informacion.
La clase AsociadoServicio funciona para la lógica del programa, esta clase busca, suma, devuelve los datos, la ventana no es la que calcula los datos, es esta clase.
La clase AsociadoServicio registra asociados, hace listado de ellos, evita problemas de duplicacion, cuenta el numero de asociados, calcula el total de aportes.
En la clase de VentanaPrincipal está la interfaz con el usuario parece como una app para que el usuario agregue información, agregamos botones como registrar, listar, resumen y buscar
La VentanaPrincipal no hace cálculos, solo funciona para la comunicación con el usuario.
