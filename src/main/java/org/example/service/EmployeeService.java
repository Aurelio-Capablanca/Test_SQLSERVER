package org.example.service;

import org.example.model.Employee;
import org.example.model.EmployeeDTO;
import org.example.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

  private final EmployeeRepository repository = new EmployeeRepository();

  public void saveEmployees(Employee employee) {
    repository.save(employee);
  }

  public void saveAllEmployees(List<Employee> employees) {
    repository.saveAll(employees);
  }

  public List<Employee> getAll(){
    return repository.findAll();
  }

  public List<EmployeeDTO> getDataSet(){
    return repository.getEmployees().stream().map(object ->{
      return EmployeeDTO.builder()
              .nameEmployee((String)object[0])
              .lastNameEmployee((String) object[1])
              .codeEmployee((String) object[2])
              .internalPhoneEmployee((String) object[3])
              .emailEmployee((String) object[4])
              .dateCreated((String) object[5])
              .department((String) object[6])
              .role((String) object[7])
              .build();
    }).collect(Collectors.toList());
  }
}
