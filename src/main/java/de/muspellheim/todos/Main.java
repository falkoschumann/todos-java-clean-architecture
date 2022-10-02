package de.muspellheim.todos;

import de.muspellheim.todos.application.*;
import de.muspellheim.todos.domain.*;
import de.muspellheim.todos.infrastructure.*;
import java.nio.file.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home"), "todos.json");
    var todos = new JsonTodos(file);
    var model = new TodosServiceImpl(todos);
    SwingUtilities.invokeLater(
        () -> {
          var view = new TodosView(model);
          view.run();
        });
  }
}
