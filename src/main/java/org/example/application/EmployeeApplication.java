package org.example.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Employee;
import org.example.model.EmployeeDTO;
import org.example.service.EmployeeService;
import org.example.utils.CSVIssuer;
import org.example.utils.ReadDocument;

import java.util.*;

public class EmployeeApplication {

  private final EmployeeService service = new EmployeeService();


  public void saveEmployees() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    List<Employee> employeeList;
    ReadDocument reader = new ReadDocument();
    try {
      employeeList = mapper.readValue(reader.readFile(), new TypeReference<List<Employee>>() {});
      for(Employee employeeS : employeeList){
        System.out.println(employeeS.toString());
      }
      service.saveAllEmployees(employeeList);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private List<List<String>> processDataSets(){
    //List<Employee> employees = service.getAll();
    List<EmployeeDTO> dto = service.getDataSet();
    List<List<String>> rows = new ArrayList<>();
    for(EmployeeDTO employee : dto){
      rows.add(Arrays.asList(employee.getNameEmployee(),employee.getLastNameEmployee(),employee.getCodeEmployee(),employee.getInternalPhoneEmployee(), employee.getEmailEmployee(), employee.getDateCreated(), employee.getDepartment(), employee.getRole()));
    }
    return rows;
  }

  public void getCSV(){
    final Scanner scan = new Scanner(System.in);
    List<String> tableHeader = Arrays.asList("Name","Last Name","Code","Phone","Email","Creation Date","Department", "Role");
    System.out.print("Insert the name of the file: ");
    String fileName = scan.nextLine();
    CSVIssuer.createDocument(fileName, processDataSets(), tableHeader);
  }


}
