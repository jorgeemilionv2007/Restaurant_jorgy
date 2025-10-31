# Documentación del Modelo - Restaurant Management System

## Descripción General
Sistema de gestión de restaurante desarrollado en Java con Spring Boot y Lombok. Implementa principios de POO como herencia, polimorfismo, interfaces y composición. Los datos se persisten en archivos CSV.

## Estructura del Proyecto

### 1. Clases Base y Herencia

#### `Person` (Clase Abstracta)
- **Propósito**: Clase base para modelar personas en el sistema
- **Atributos**: id, name, email, phone, address
- **Métodos Abstractos**: `getRole()`
- **Métodos Concretos**: `getPersonInfo()`

#### `Employee` (Hereda de Person)
- **Propósito**: Representa empleados del restaurante
- **Atributos Adicionales**: position, salary, hireDate
- **Polimorfismo**: Sobrescribe `getRole()` retornando "EMPLOYEE"
- **Métodos**: `getEmployeeDetails()`, `getPersonInfo()`

#### `Client` (Hereda de Person)
- **Propósito**: Representa clientes del restaurante
- **Atributos Adicionales**: loyaltyLevel, totalSpent, visitCount
- **Polimorfismo**: Sobrescribe `getRole()` retornando "CLIENT"
- **Métodos**: `addVisit()`, `getClientStatus()`, `getPersonInfo()`

### 2. Interfaces (Contratos)

#### `Preparable`
- **Métodos**: 
  - `prepare()`: Retorna información de preparación
  - `getPreparationTime()`: Retorna tiempo en minutos
  - `isAvailable()`: Verifica disponibilidad
- **Implementada por**: Dish

#### `Billable`
- **Métodos**:
  - `calculateTotal()`: Calcula total con descuentos
  - `generateBill()`: Genera factura en texto
  - `applyDiscount()`: Aplica descuento porcentual
- **Implementada por**: Order, Invoice

#### `Reservable`
- **Métodos**:
  - `reserve()`: Confirma una reserva
  - `cancel()`: Cancela una reserva
  - `getReservationStatus()`: Obtiene estado
- **Implementada por**: Reservation

### 3. Clases de Dominio

#### `Dish` (Implementa Preparable)
- **Propósito**: Representa platos del menú
- **Atributos**: id, name, description, price, preparationTime, available, category, ingredients
- **Métodos**: `prepare()`, `addIngredient()`, `calculateCost()`, `getDishInfo()`
- **Composición**: Contiene lista de `Ingredient`

#### `Ingredient`
- **Propósito**: Representa ingredientes de los platos
- **Atributos**: id, name, unit, quantity, unitPrice
- **Métodos**: `getTotalCost()`, `getIngredientInfo()`

#### `Order` (Implementa Billable)
- **Propósito**: Representa pedidos de clientes
- **Atributos**: id, clientId, orderDate, status, dishes, discount, notes
- **Métodos**: `addDish()`, `removeDish()`, `calculateTotal()`, `generateBill()`, `applyDiscount()`
- **Composición**: Contiene lista de `Dish`

#### `Table`
- **Propósito**: Representa mesas del restaurante
- **Atributos**: id, capacity, location, available, currentClientId
- **Métodos**: `occupyTable()`, `releaseTable()`, `getTableStatus()`

#### `Reservation` (Implementa Reservable)
- **Propósito**: Representa reservas de mesas
- **Atributos**: id, clientId, tableId, reservationDate, reservationTime, guestCount, status, notes
- **Métodos**: `reserve()`, `cancel()`, `getReservationStatus()`, `getReservationInfo()`

#### `Invoice` (Implementa Billable)
- **Propósito**: Representa facturas de pedidos
- **Atributos**: id, orderId, clientId, invoiceDate, subtotal, tax, discount, paymentMethod, status
- **Métodos**: `calculateTotal()`, `generateBill()`, `applyDiscount()`, `markAsPaid()`, `getInvoiceInfo()`

#### `Supplier`
- **Propósito**: Representa proveedores de ingredientes
- **Atributos**: id, name, contactPerson, email, phone, address, productType, averageDeliveryDays
- **Métodos**: `getSupplierInfo()`, `getSupplierDetails()`

#### `Menu`
- **Propósito**: Representa menús del restaurante
- **Atributos**: id, name, description, season, dishes, active
- **Métodos**: `addDish()`, `removeDish()`, `getDishCount()`, `getAveragePrice()`, `getMenuInfo()`
- **Composición**: Contiene lista de `Dish`

## Principios de POO Implementados

### 1. Encapsulamiento
- Todos los atributos son privados
- Acceso controlado mediante getters/setters (Lombok @Data)
- Métodos públicos para operaciones controladas

### 2. Herencia
```
Person (Abstracta)
├── Employee
└── Client
```

### 3. Polimorfismo
- Métodos abstractos en `Person` implementados en `Employee` y `Client`
- Métodos de interfaces implementados en `Dish`, `Order`, `Invoice`, `Reservation`
- Sobrescritura de `getPersonInfo()` en clases derivadas

### 4. Interfaces
- `Preparable`: Define contrato para platos preparables
- `Billable`: Define contrato para elementos facturables
- `Reservable`: Define contrato para reservas

### 5. Composición y Agregación
- `Order` contiene múltiples `Dish`
- `Menu` contiene múltiples `Dish`
- `Dish` contiene múltiples `Ingredient`

## Persistencia en CSV

### Servicio CsvService
- **Métodos**:
  - `writeToCSV()`: Escribe datos a archivo CSV
  - `readFromCSV()`: Lee datos desde archivo CSV
  - `appendToCSV()`: Añade fila a archivo existente
  - `fileExists()`: Verifica existencia de archivo

### Archivos CSV Generados
- `clients.csv`: Datos de clientes
- `employees.csv`: Datos de empleados
- `dishes.csv`: Datos de platos
- `orders.csv`: Datos de pedidos
- `tables.csv`: Datos de mesas
- `reservations.csv`: Datos de reservas
- `invoices.csv`: Datos de facturas
- `ingredients.csv`: Datos de ingredientes
- `suppliers.csv`: Datos de proveedores
- `menus.csv`: Datos de menús

## API REST

### Endpoints Disponibles

#### Clientes
- `POST /api/restaurant/clients` - Crear cliente
- `GET /api/restaurant/clients` - Obtener todos los clientes
- `GET /api/restaurant/clients/{id}` - Obtener cliente por ID
- `PUT /api/restaurant/clients/{id}` - Actualizar cliente
- `DELETE /api/restaurant/clients/{id}` - Eliminar cliente

#### Empleados
- `POST /api/restaurant/employees` - Crear empleado
- `GET /api/restaurant/employees` - Obtener todos los empleados
- `GET /api/restaurant/employees/{id}` - Obtener empleado por ID
- `PUT /api/restaurant/employees/{id}` - Actualizar empleado
- `DELETE /api/restaurant/employees/{id}` - Eliminar empleado

#### Platos
- `POST /api/restaurant/dishes` - Crear plato
- `GET /api/restaurant/dishes` - Obtener todos los platos
- `GET /api/restaurant/dishes/{id}` - Obtener plato por ID
- `PUT /api/restaurant/dishes/{id}` - Actualizar plato
- `DELETE /api/restaurant/dishes/{id}` - Eliminar plato

#### Pedidos
- `POST /api/restaurant/orders` - Crear pedido
- `GET /api/restaurant/orders` - Obtener todos los pedidos
- `GET /api/restaurant/orders/{id}` - Obtener pedido por ID
- `PUT /api/restaurant/orders/{id}` - Actualizar pedido
- `DELETE /api/restaurant/orders/{id}` - Eliminar pedido

#### Mesas
- `POST /api/restaurant/tables` - Crear mesa
- `GET /api/restaurant/tables` - Obtener todas las mesas
- `GET /api/restaurant/tables/{id}` - Obtener mesa por ID
- `PUT /api/restaurant/tables/{id}` - Actualizar mesa

#### Reservas
- `POST /api/restaurant/reservations` - Crear reserva
- `GET /api/restaurant/reservations` - Obtener todas las reservas
- `GET /api/restaurant/reservations/{id}` - Obtener reserva por ID
- `PUT /api/restaurant/reservations/{id}` - Actualizar reserva
- `DELETE /api/restaurant/reservations/{id}` - Eliminar reserva

#### Facturas
- `POST /api/restaurant/invoices` - Crear factura
- `GET /api/restaurant/invoices` - Obtener todas las facturas
- `GET /api/restaurant/invoices/{id}` - Obtener factura por ID
- `PUT /api/restaurant/invoices/{id}` - Actualizar factura

#### Ingredientes
- `POST /api/restaurant/ingredients` - Crear ingrediente
- `GET /api/restaurant/ingredients` - Obtener todos los ingredientes
- `GET /api/restaurant/ingredients/{id}` - Obtener ingrediente por ID

#### Proveedores
- `POST /api/restaurant/suppliers` - Crear proveedor
- `GET /api/restaurant/suppliers` - Obtener todos los proveedores
- `GET /api/restaurant/suppliers/{id}` - Obtener proveedor por ID

#### Menús
- `POST /api/restaurant/menus` - Crear menú
- `GET /api/restaurant/menus` - Obtener todos los menús
- `GET /api/restaurant/menus/{id}` - Obtener menú por ID

## Tecnologías Utilizadas

- **Java 23+**: Lenguaje de programación
- **Spring Boot**: Framework web
- **Lombok**: Generación automática de getters/setters
- **CSV**: Persistencia de datos
- **Maven**: Gestor de dependencias

## Ejemplo de Uso

```java
// Crear un cliente
Client client = new Client(
    "C001", 
    "Juan Pérez", 
    "juan@email.com", 
    "123456789", 
    "Calle Principal 123",
    "GOLD",
    0.0,
    0
);
repository.addClient(client);

// Crear un plato
Dish dish = new Dish(
    "D001",
    "Pasta Carbonara",
    "Pasta con salsa de huevo y tocino",
    15.99,
    20,
    true,
    "PASTA"
);
repository.addDish(dish);

// Crear un pedido
Order order = new Order("O001", "C001", "2024-10-30");
order.addDish(dish);
order.applyDiscount(10.0);
repository.addOrder(order);

// Generar factura
System.out.println(order.generateBill());
```

## Notas Importantes

1. **Lombok**: Utiliza anotaciones como `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` para reducir código boilerplate
2. **Herencia**: La clase `Person` es abstracta y no puede instanciarse directamente
3. **Polimorfismo**: Los métodos de interfaces permiten diferentes implementaciones
4. **CSV**: Los archivos se guardan en el directorio `data/csv/`
5. **Spring Boot**: El proyecto está configurado para ejecutarse como aplicación web
