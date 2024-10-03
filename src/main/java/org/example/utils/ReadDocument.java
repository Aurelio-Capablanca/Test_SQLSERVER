package org.example.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ReadDocument {

  public final StringBuilder builder = new StringBuilder();

  public String readFile() {
    builder.setLength(0);
    FileDialog fileDialog = new FileDialog((Frame) null, "Select a File", FileDialog.LOAD);
    fileDialog.setVisible(true);
    String filePath = fileDialog.getDirectory() + fileDialog.getFile();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        builder.append(line).append(System.lineSeparator());
      }
      return builder.toString();
    } catch (IOException ex) {
      System.err.println("Error reading file: " + ex.getMessage());
    }
    return null;
  }

}
