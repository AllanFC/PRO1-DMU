package Ex02.gui;

import Ex02.controller.Controller;
import Ex02.model.Company;
import Ex02.model.Customer;
import Ex02.model.Employee;
import javafx.application.Application;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee bob = Controller.createEmployee("Bob Dole", 210, 2007);
        Controller.addEmployeeToCompany(bob, ibm);

        Employee alice = Controller.createEmployee("Alice Schmidt", 250, 2018);
        Controller.addEmployeeToCompany(alice, ibm);

        Employee george = Controller.createEmployee("George Down", 150, 2012);
        Controller.addEmployeeToCompany(george, amd);

        Employee rita = Controller.createEmployee("Rita Uphill", 300, 2009);
        Controller.addEmployeeToCompany(rita, sled);

        Controller.createEmployee("John Doe", 100, -1);

        Customer joe = Controller.createCustomer("Joe");
        Controller.addCustomerToCompany(joe, ibm);

        Customer james = Controller.createCustomer("James");
        Controller.addCustomerToCompany(james, ibm);

        Customer joel = Controller.createCustomer("Joel");
        Controller.addCustomerToCompany(joel, amd);

        Customer joey = Controller.createCustomer("Joey");
        Controller.addCustomerToCompany(joe, amd);

        Customer joseph = Controller.createCustomer("Joseph");
        Controller.addCustomerToCompany(joseph, sled);

        Customer eric = Controller.createCustomer("Eric");
        Controller.addCustomerToCompany(eric, sled);

    }
}
