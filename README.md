# CM Deportes

This is a simple **JSP Servlet Web Application** using a **SQL Server** database that I did in my last year at the University, in **Lab IV** class.

## How do I run the project?
* Run the **script.sql** to create the database (you need to modify the path inside)
* Change the dataabse path in ```src > java > controlador > Gestor.java```

        private final String conexion = "jdbc:sqlserver://DESKTOP-C7M3HAG\\SQLEXPRESS:1433;databaseName=cm_database";
* Open the project in Netbeans and add the sql server driver
* Run the project