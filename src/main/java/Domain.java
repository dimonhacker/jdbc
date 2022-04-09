import bl.Util;
import entity.Address;
import entity.Employee;
import service.AddressService;
import service.EmployeeService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {
        AddressService addressService;
        EmployeeService employeeService;
        /* Address address = new Address();
        address.setId(3);
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Levicheva");
        address.setPostCode("160000");
        */
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setAddressId(1);
        try {
            //addressService = new AddressService();
            //addressService.add(address);
//            employeeService = new EmployeeService();
//            employeeService.add(employee);
            employeeService = new EmployeeService();
            List<Employee> employeeList = employeeService.getAll();
            System.out.println(employeeList);
            addressService = new AddressService();
            List<Address> addressList= addressService.getAll();
            System.out.println(addressList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
