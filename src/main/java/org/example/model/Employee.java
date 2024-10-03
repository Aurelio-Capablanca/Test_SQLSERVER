package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_employee")
  private Integer id;

  @Column(name = "name_employee")
  private String nameEmployee;

  @Column(name = "lastname_employee")
  private String lastNameEmployee;

  @Column(name = "code_employee")
  private String codeEmployee;

  @Column(name = "internal_phone")
  private String internalPhoneEmployee;

  @Column(name = "email_employee")
  private String emailEmployee;

  @Column(name = "id_creator")
  private Integer creatorEmployee;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "id_department")
  private Integer departmentEmployee;

  @Column(name = "id_role")
  private Integer roleEmployee;

}
