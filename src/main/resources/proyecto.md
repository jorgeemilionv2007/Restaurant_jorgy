Desarrollar una API REST en Java (versión superior a Java 23) utilizando Spring Boot y Lombok, para la gestión operativa de un restaurante. El sistema deberá permitir registrar, consultar, actualizar y eliminar información relacionada con las operaciones internas del restaurante, incluyendo clientes, empleados, platos, pedidos, mesas, facturas, ingredientes, proveedores, reservas y menús.

Toda la información se almacenará en un archivo CSV (valores separados por comas) en lugar de una base de datos relacional.

El diseño del proyecto debe evidenciar los principios de la Programación Orientada a Objetos (POO), implementando:
      •     Encapsulamiento para proteger los atributos y controlar su acceso.
      •     Herencia para modelar jerarquías (por ejemplo, una clase abstracta Persona heredada por Empleado y Cliente).
      •     Polimorfismo para redefinir o sobrecargar métodos en clases derivadas.
      •     Interfaces para establecer contratos comunes (como Preparable, Facturable o Reservable).
      •     Composición y agregación en las relaciones entre objetos (por ejemplo, un Pedido contiene varios Platos y pertenece a un Cliente).

El sistema deberá incluir al menos 10 clases dentro de su modelo, pudiendo incorporar records, enumeraciones y clases abstractas según sea necesario para representar comportamientos o estructuras propias del dominio del restaurante.