import bl.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {
        AddressService addressService;
        EmployeeService employeeService;
        ProjectService projectService;
        EmplProjService emplProjService;

        Address address = new Address();
        address.setId(3);
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Levicheva");
        address.setPostCode("160000");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setBirthday(Date.valueOf("2000-01-01"));
        employee.setAddressId(1);

        Project project = new Project();
        project.setId(1);
        project.setTitle("FirstProject");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(1);
        emplProj.setProjectId(1);


        try {
            /*addressService = new AddressService();
            addressService.add(address);
            employeeService = new EmployeeService();
            employeeService.add(employee);
            projectService = new ProjectService();
            projectService.add(project);
            emplProjService= new EmplProjService();
            emplProjService.add(emplProj);*/
            projectService = new ProjectService();
            List<Project> projectList = projectService.getAll();
            System.out.println(projectList);

            emplProjService = new EmplProjService();
            List<EmplProj> emplProjList = emplProjService.getAll();
            System.out.println(emplProjList);

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
