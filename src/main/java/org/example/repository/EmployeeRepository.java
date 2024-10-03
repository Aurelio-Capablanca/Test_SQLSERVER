package org.example.repository;

import org.example.model.Employee;
import org.example.repository.genericRepository.GenericRepository;
import org.example.utils.ConnectionApplication;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.management.Query;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository extends GenericRepository<Employee, Integer> {

  public EmployeeRepository(){
    super(Employee.class);
  }

  public List<Object[]> getEmployees(){
    try(Session session = ConnectionApplication.getSessionFactory().openSession()) {
      String querySQL = "select " +
              "name_employee, " +//0
              "lastname_employee, " +//1
              "code_employee , " +//2
              "internal_phone, " +//3
              "email_employee, " +//4
              "FORMAT(date_created , 'dd/MM/yyyy, hh:mm:ss') as date, " +//5
              "d.department_name, " +//6
              "re.role_employee " +//7
              "from Employee e " +
              "inner join Departments d on d.id_department = e.id_department " +
              "inner join Role_Employee re on re.id_role = e.id_role";
      NativeQuery<Object[]> query =  session.createNativeQuery(querySQL);
      return query.getResultList();
    } catch (Exception ex){
      ex.printStackTrace();
      return Collections.emptyList();
    }
  }
}
