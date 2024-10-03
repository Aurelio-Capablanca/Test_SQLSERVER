package org.example;

import org.example.domain.MenuManger;

public class Main {
  //mvn exce:exec -Dexec.executable="java" -Dexec.args="-jar target/ DBA-DevelopmentTest-1.0-SNAPSHOT.jar"
  public static void main(String[] args) {
    MenuManger menu = new MenuManger();
    menu.mainMenu();
  }
}