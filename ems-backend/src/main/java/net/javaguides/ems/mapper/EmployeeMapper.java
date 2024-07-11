package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entitiy.Employee;

public class EmployeeMapper {

    // making Employee Database to Local DTO (Modal to View)
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto((int) employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    // View to modal (Convert the Employee Dto to Employee )
    public  static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
    }

}
