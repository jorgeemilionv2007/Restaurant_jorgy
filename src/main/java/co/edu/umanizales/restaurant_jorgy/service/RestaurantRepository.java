package co.edu.umanizales.restaurant_jorgy.service;

import co.edu.umanizales.restaurant_jorgy.model.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {
    private CsvService csvService;
    private List<Client> clients;
    private List<Employee> employees;
    private List<Dish> dishes;
    private List<Order> orders;
    private List<Table> tables;
    private List<Reservation> reservations;
    private List<Invoice> invoices;
    private List<Ingredient> ingredients;
    private List<Supplier> suppliers;
    private List<Menu> menus;

    public RestaurantRepository() {
        this.csvService = new CsvService();
        this.clients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.dishes = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.invoices = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    // CLIENT OPERATIONS
    public void addClient(Client client) {
        clients.add(client);
        saveClientsToCSV();
    }

    public Client getClientById(String id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    public void updateClient(Client client) {
        clients.replaceAll(c -> c.getId().equals(client.getId()) ? client : c);
        saveClientsToCSV();
    }

    public void deleteClient(String id) {
        clients.removeIf(c -> c.getId().equals(id));
        saveClientsToCSV();
    }

    // EMPLOYEE OPERATIONS
    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployeesToCSV();
    }

    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public void updateEmployee(Employee employee) {
        employees.replaceAll(e -> e.getId().equals(employee.getId()) ? employee : e);
        saveEmployeesToCSV();
    }

    public void deleteEmployee(String id) {
        employees.removeIf(e -> e.getId().equals(id));
        saveEmployeesToCSV();
    }

    // DISH OPERATIONS
    public void addDish(Dish dish) {
        dishes.add(dish);
        saveDishesToCSV();
    }

    public Dish getDishById(String id) {
        return dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    public void updateDish(Dish dish) {
        dishes.replaceAll(d -> d.getId().equals(dish.getId()) ? dish : d);
        saveDishesToCSV();
    }

    public void deleteDish(String id) {
        dishes.removeIf(d -> d.getId().equals(id));
        saveDishesToCSV();
    }

    // ORDER OPERATIONS
    public void addOrder(Order order) {
        orders.add(order);
        saveOrdersToCSV();
    }

    public Order getOrderById(String id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public void updateOrder(Order order) {
        orders.replaceAll(o -> o.getId().equals(order.getId()) ? order : o);
        saveOrdersToCSV();
    }

    public void deleteOrder(String id) {
        orders.removeIf(o -> o.getId().equals(id));
        saveOrdersToCSV();
    }

    // TABLE OPERATIONS
    public void addTable(Table table) {
        tables.add(table);
        saveTablesToCSV();
    }

    public Table getTableById(String id) {
        return tables.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Table> getAllTables() {
        return new ArrayList<>(tables);
    }

    public void updateTable(Table table) {
        tables.replaceAll(t -> t.getId().equals(table.getId()) ? table : t);
        saveTablesToCSV();
    }

    // RESERVATION OPERATIONS
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        saveReservationsToCSV();
    }

    public Reservation getReservationById(String id) {
        return reservations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public void updateReservation(Reservation reservation) {
        reservations.replaceAll(r -> r.getId().equals(reservation.getId()) ? reservation : r);
        saveReservationsToCSV();
    }

    public void deleteReservation(String id) {
        reservations.removeIf(r -> r.getId().equals(id));
        saveReservationsToCSV();
    }

    // INVOICE OPERATIONS
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        saveInvoicesToCSV();
    }

    public Invoice getInvoiceById(String id) {
        return invoices.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Invoice> getAllInvoices() {
        return new ArrayList<>(invoices);
    }

    public void updateInvoice(Invoice invoice) {
        invoices.replaceAll(i -> i.getId().equals(invoice.getId()) ? invoice : i);
        saveInvoicesToCSV();
    }

    // INGREDIENT OPERATIONS
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        saveIngredientsToCSV();
    }

    public Ingredient getIngredientById(String id) {
        return ingredients.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>(ingredients);
    }

    // SUPPLIER OPERATIONS
    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        cacheSuppliersToCSV();
    }

    public Supplier getSupplierById(String id) {
        return suppliers.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }

    // MENU OPERATIONS
    public void addMenu(Menu menu) {
        menus.add(menu);
        saveMenusToCSV();
    }

    public Menu getMenuById(String id) {
        return menus.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Menu> getAllMenus() {
        return new ArrayList<>(menus);
    }

    // CSV SAVE METHODS
    private void saveClientsToCSV() {
        List<String> headers = List.of("ID", "Name", "Email", "Phone", "Address", "LoyaltyLevel", "TotalSpent", "VisitCount");
        List<List<String>> data = new ArrayList<>();
        for (Client client : clients) {
            data.add(List.of(
                    client.getId(),
                    client.getName(),
                    client.getEmail(),
                    client.getPhone(),
                    client.getAddress(),
                    client.getLoyaltyLevel(),
                    String.valueOf(client.getTotalSpent()),
                    String.valueOf(client.getVisitCount())
            ));
        }
        csvService.writeToCSV("clients.csv", headers, data);
    }

    private void saveEmployeesToCSV() {
        List<String> headers = List.of("ID", "Name", "Email", "Phone", "Address", "Position", "Salary", "HireDate");
        List<List<String>> data = new ArrayList<>();
        for (Employee employee : employees) {
            data.add(List.of(
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getPhone(),
                    employee.getAddress(),
                    employee.getPosition(),
                    String.valueOf(employee.getSalary()),
                    employee.getHireDate()
            ));
        }
        csvService.writeToCSV("employees.csv", headers, data);
    }

    private void saveDishesToCSV() {
        List<String> headers = List.of("ID", "Name", "Description", "Price", "PreparationTime", "Available", "Category");
        List<List<String>> data = new ArrayList<>();
        for (Dish dish : dishes) {
            data.add(List.of(
                    dish.getId(),
                    dish.getName(),
                    dish.getDescription() != null ? dish.getDescription() : "",
                    String.valueOf(dish.getPrice()),
                    String.valueOf(dish.getPreparationTime()),
                    String.valueOf(dish.getAvailable()),
                    dish.getCategory() != null ? dish.getCategory() : ""
            ));
        }
        csvService.writeToCSV("dishes.csv", headers, data);
    }

    private void saveOrdersToCSV() {
        List<String> headers = List.of("ID", "ClientID", "OrderDate", "Status", "Discount", "Notes");
        List<List<String>> data = new ArrayList<>();
        for (Order order : orders) {
            data.add(List.of(
                    order.getId(),
                    order.getClientId(),
                    order.getOrderDate(),
                    order.getStatus(),
                    String.valueOf(order.getDiscount()),
                    order.getNotes() != null ? order.getNotes() : ""
            ));
        }
        csvService.writeToCSV("orders.csv", headers, data);
    }

    private void saveTablesToCSV() {
        List<String> headers = List.of("ID", "Capacity", "Location", "Available", "CurrentClientID");
        List<List<String>> data = new ArrayList<>();
        for (Table table : tables) {
            data.add(List.of(
                    table.getId(),
                    String.valueOf(table.getCapacity()),
                    table.getLocation(),
                    String.valueOf(table.getAvailable()),
                    table.getCurrentClientId() != null ? table.getCurrentClientId() : ""
            ));
        }
        csvService.writeToCSV("tables.csv", headers, data);
    }

    private void saveReservationsToCSV() {
        List<String> headers = List.of("ID", "ClientID", "TableID", "ReservationDate", "ReservationTime", "GuestCount", "Status", "Notes");
        List<List<String>> data = new ArrayList<>();
        for (Reservation reservation : reservations) {
            data.add(List.of(
                    reservation.getId(),
                    reservation.getClientId(),
                    reservation.getTableId(),
                    reservation.getReservationDate(),
                    reservation.getReservationTime(),
                    String.valueOf(reservation.getGuestCount()),
                    reservation.getStatus(),
                    reservation.getNotes() != null ? reservation.getNotes() : ""
            ));
        }
        csvService.writeToCSV("reservations.csv", headers, data);
    }

    private void saveInvoicesToCSV() {
        List<String> headers = List.of("ID", "OrderID", "ClientID", "InvoiceDate", "Subtotal", "Tax", "Discount", "PaymentMethod", "Status");
        List<List<String>> data = new ArrayList<>();
        for (Invoice invoice : invoices) {
            data.add(List.of(
                    invoice.getId(),
                    invoice.getOrderId(),
                    invoice.getClientId(),
                    invoice.getInvoiceDate(),
                    String.valueOf(invoice.getSubtotal()),
                    String.valueOf(invoice.getTax()),
                    String.valueOf(invoice.getDiscount()),
                    invoice.getPaymentMethod() != null ? invoice.getPaymentMethod() : "",
                    invoice.getStatus()
            ));
        }
        csvService.writeToCSV("invoices.csv", headers, data);
    }

    private void saveIngredientsToCSV() {
        List<String> headers = List.of("ID", "Name", "Unit", "Quantity", "UnitPrice");
        List<List<String>> data = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            data.add(List.of(
                    ingredient.getId(),
                    ingredient.getName(),
                    ingredient.getUnit(),
                    String.valueOf(ingredient.getQuantity()),
                    String.valueOf(ingredient.getUnitPrice())
            ));
        }
        csvService.writeToCSV("ingredients.csv", headers, data);
    }

    private void cacheSuppliersToCSV() {
        List<String> headers = List.of("ID", "Name", "ContactPerson", "Email", "Phone", "Address", "ProductType", "AverageDeliveryDays");
        List<List<String>> data = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            data.add(List.of(
                    supplier.getId(),
                    supplier.getName(),
                    supplier.getContactPerson(),
                    supplier.getEmail(),
                    supplier.getPhone(),
                    supplier.getAddress(),
                    supplier.getProductType(),
                    String.valueOf(supplier.getAverageDeliveryDays())
            ));
        }
        csvService.writeToCSV("suppliers.csv", headers, data);
    }

    private void saveMenusToCSV() {
        List<String> headers = List.of("ID", "Name", "Description", "Season", "DishCount", "Active");
        List<List<String>> data = new ArrayList<>();
        for (Menu menu : menus) {
            data.add(List.of(
                    menu.getId(),
                    menu.getName(),
                    menu.getDescription() != null ? menu.getDescription() : "",
                    menu.getSeason(),
                    String.valueOf(menu.getDishCount()),
                    String.valueOf(menu.getActive())
            ));
        }
        csvService.writeToCSV("menus.csv", headers, data);
    }
}
