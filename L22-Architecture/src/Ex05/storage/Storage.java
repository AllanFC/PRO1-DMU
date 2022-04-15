package Ex05.storage;

import Ex05.model.Company;
import Ex05.model.Customer;
import Ex05.model.Employee;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Company> companies = new ArrayList<>();
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final ArrayList<Customer> customers = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Company> getCompanies() {
        return new ArrayList<>(companies);
    }

    public static void storeCompany(Company company) {
        companies.add(company);
    }

    public static void deleteCompany(Company company) {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public static void storeEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public static void storeCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }
}
