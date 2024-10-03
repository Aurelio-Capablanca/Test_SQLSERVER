package org.example.domain;

import org.example.application.EmployeeApplication;

import java.util.Objects;
import java.util.Scanner;

public class MenuManger {

  private final Scanner scan = new Scanner(System.in);
  private final EmployeeApplication application = new EmployeeApplication();

  public void mainMenu() {
    System.out.println("Welcome to the console app, choose an action :");
    String responseContinue = "y";
    while (Objects.equals(responseContinue, "y") || Objects.equals(responseContinue, "Y")) {
      System.out.println("1. Upload document and save all" +
              "\n2. Retrieve CSV with all the Employees");
      int option = scan.nextInt();
      scan.nextLine();
      switch (option) {
        case 1:
          application.saveEmployees();
          break;
        case 2:
          application.getCSV();
          break;
        default:
          System.out.println("Option no available");
          break;
      }
      System.out.println("Do you want to continue ? y/n");
      responseContinue = scan.next();
    }
  }

}
