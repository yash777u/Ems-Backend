package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    public  void deleteEmployeebyId(Long employeeId);
    List<EmployeeDto> deleteAllEmployee();
    void updateEmployee(Long employeeId, EmployeeDto employeeDto);
}
