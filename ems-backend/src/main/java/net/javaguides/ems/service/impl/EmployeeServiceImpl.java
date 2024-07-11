package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entitiy.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // object of EmployeeRepository Class created
    private final EmployeeRepository employeeRepository; // Injecting EmployeeRepository instance

    // override the EmployeeService method to create / save employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); // Pass the EmployeeDto and convert it to Employee
        Employee savedEmployee = employeeRepository.save(employee); // Calling save() on the injected instance to save employee and return a list of employee that saved
        return  EmployeeMapper.mapToEmployeeDto(savedEmployee); // return that employee to EmployeeDTo
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {

        Employee emp = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found : "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeebyId(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<EmployeeDto> deleteAllEmployee() {
        employeeRepository.deleteAll();
        return null;
    }

    @Override
    public void updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found : "+employeeId));
        emp.setFirstName(employeeDto.getFirstName());
        emp.setLastName(employeeDto.getLastName());
        emp.setEmail(employeeDto.getEmail());
        employeeRepository.save(emp);
    }
}
