package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

  private String nameEmployee;
  private String lastNameEmployee;
  private String codeEmployee;
  private String internalPhoneEmployee;
  private String emailEmployee;
  private String dateCreated;
  private String department;
  private String role;

}
