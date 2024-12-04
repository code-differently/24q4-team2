package com.codedifferently.q4.team2;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently.q4.team2")
public class Main {
  public static void main(String[] args) {
    var application = new SpringApplication(Main.class);
    application.run(args);
  }
}
