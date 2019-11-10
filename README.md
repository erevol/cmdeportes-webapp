# CM Deportes

This is a simple **JSP Servlet Web Application** using a **SQL Server** database that I did in my last year at the University, in **Lab IV** class.

## How do I run the project?
* Run the **script.sql** to create the database (you need to modify the path inside)
* Change the dataabse path in ```src > java > controlador > Gestor.java```

        private final String conexion = "jdbc:sqlserver://DESKTOP-C7M3HAG\\SQLEXPRESS:1433;databaseName=cm_database";
* Open the project in Netbeans and add the sql server driver
* Run the project

## Demo

### Inicio de Sesión
![Inicio de sesión](https://media.giphy.com/media/WRKtPIMchu7Yz1yIrd/giphy.gif)
### ABMC Pacientes
![](https://media.giphy.com/media/gdqvdOPsnrgJ2f5WDA/giphy.gif)
### ABMC Profesionales
![](https://media.giphy.com/media/H7CQPbx2V2VcbwvX5X/giphy.gif)
### ABMC Disciplinas
![](https://media.giphy.com/media/JmDtfWQfkcAmIxb9RY/giphy.gif)
### Inscripción de un paciente a Disciplina
![](https://media.giphy.com/media/cPOC6BSZtqXah6lIZV/giphy.gif)
### Reportes Varios
![](https://media.giphy.com/media/fT1eY8MdKxRWlep3ee/giphy.gif)