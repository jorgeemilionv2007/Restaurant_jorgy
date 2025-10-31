package co.edu.umanizales.restaurant_jorgy.controller;

import co.edu.umanizales.restaurant_jorgy.model.*;
import co.edu.umanizales.restaurant_jorgy.service.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    // CLIENT ENDPOINTS
    @PostMapping("/clients")
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        repository.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client added successfully");
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(repository.getAllClients());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        Client client = repository.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<String> updateClient(@PathVariable String id, @RequestBody Client client) {
        Client existing = repository.getClientById(id);
        if (existing != null) {
            client.setId(id);
            repository.updateClient(client);
            return ResponseEntity.ok("Client updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id) {
        Client existing = repository.getClientById(id);
        if (existing != null) {
            repository.deleteClient(id);
            return ResponseEntity.ok("Client deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // EMPLOYEE ENDPOINTS
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        repository.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(repository.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = repository.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Employee existing = repository.getEmployeeById(id);
        if (existing != null) {
            employee.setId(id);
            repository.updateEmployee(employee);
            return ResponseEntity.ok("Employee updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        Employee existing = repository.getEmployeeById(id);
        if (existing != null) {
            repository.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // DISH ENDPOINTS
    @PostMapping("/dishes")
    public ResponseEntity<String> addDish(@RequestBody Dish dish) {
        repository.addDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dish added successfully");
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(repository.getAllDishes());
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable String id) {
        Dish dish = repository.getDishById(id);
        if (dish != null) {
            return ResponseEntity.ok(dish);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/dishes/{id}")
    public ResponseEntity<String> updateDish(@PathVariable String id, @RequestBody Dish dish) {
        Dish existing = repository.getDishById(id);
        if (existing != null) {
            dish.setId(id);
            repository.updateDish(dish);
            return ResponseEntity.ok("Dish updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable String id) {
        Dish existing = repository.getDishById(id);
        if (existing != null) {
            repository.deleteDish(id);
            return ResponseEntity.ok("Dish deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // ORDER ENDPOINTS
    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        repository.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order added successfully");
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(repository.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Order order = repository.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable String id, @RequestBody Order order) {
        Order existing = repository.getOrderById(id);
        if (existing != null) {
            order.setId(id);
            repository.updateOrder(order);
            return ResponseEntity.ok("Order updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id) {
        Order existing = repository.getOrderById(id);
        if (existing != null) {
            repository.deleteOrder(id);
            return ResponseEntity.ok("Order deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // TABLE ENDPOINTS
    @PostMapping("/tables")
    public ResponseEntity<String> addTable(@RequestBody Table table) {
        repository.addTable(table);
        return ResponseEntity.status(HttpStatus.CREATED).body("Table added successfully");
    }

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> getAllTables() {
        return ResponseEntity.ok(repository.getAllTables());
    }

    @GetMapping("/tables/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable String id) {
        Table table = repository.getTableById(id);
        if (table != null) {
            return ResponseEntity.ok(table);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/tables/{id}")
    public ResponseEntity<String> updateTable(@PathVariable String id, @RequestBody Table table) {
        Table existing = repository.getTableById(id);
        if (existing != null) {
            table.setId(id);
            repository.updateTable(table);
            return ResponseEntity.ok("Table updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // RESERVATION ENDPOINTS
    @PostMapping("/reservations")
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation) {
        repository.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reservation added successfully");
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(repository.getAllReservations());
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Reservation reservation = repository.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable String id, @RequestBody Reservation reservation) {
        Reservation existing = repository.getReservationById(id);
        if (existing != null) {
            reservation.setId(id);
            repository.updateReservation(reservation);
            return ResponseEntity.ok("Reservation updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable String id) {
        Reservation existing = repository.getReservationById(id);
        if (existing != null) {
            repository.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // INVOICE ENDPOINTS
    @PostMapping("/invoices")
    public ResponseEntity<String> addInvoice(@RequestBody Invoice invoice) {
        repository.addInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body("Invoice added successfully");
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(repository.getAllInvoices());
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable String id) {
        Invoice invoice = repository.getInvoiceById(id);
        if (invoice != null) {
            return ResponseEntity.ok(invoice);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/invoices/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable String id, @RequestBody Invoice invoice) {
        Invoice existing = repository.getInvoiceById(id);
        if (existing != null) {
            invoice.setId(id);
            repository.updateInvoice(invoice);
            return ResponseEntity.ok("Invoice updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // INGREDIENT ENDPOINTS
    @PostMapping("/ingredients")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        repository.addIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingredient added successfully");
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(repository.getAllIngredients());
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable String id) {
        Ingredient ingredient = repository.getIngredientById(id);
        if (ingredient != null) {
            return ResponseEntity.ok(ingredient);
        }
        return ResponseEntity.notFound().build();
    }

    // SUPPLIER ENDPOINTS
    @PostMapping("/suppliers")
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        repository.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body("Supplier added successfully");
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(repository.getAllSuppliers());
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable String id) {
        Supplier supplier = repository.getSupplierById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        }
        return ResponseEntity.notFound().build();
    }

    // MENU ENDPOINTS
    @PostMapping("/menus")
    public ResponseEntity<String> addMenu(@RequestBody Menu menu) {
        repository.addMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body("Menu added successfully");
    }

    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(repository.getAllMenus());
    }

    @GetMapping("/menus/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable String id) {
        Menu menu = repository.getMenuById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        }
        return ResponseEntity.notFound().build();
    }
}
