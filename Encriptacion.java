
package encriptacion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Base64;


public class Encriptacion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Scene scene = new Scene(grid,400,200);
        
        Label etiqueta = new Label("Palabra :");
        grid.add(etiqueta, 0, 0);
        
        TextField palabra1 = new TextField();
        grid.add(palabra1, 1, 0);
        
        Button btn = new Button();
        btn.setText("Encriptar");
        grid.add(btn, 1, 1);
        
        Button btn2 = new Button();
        btn2.setText("Desencriptar");
        grid.add(btn2, 1, 2);
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                byte[] palabra = palabra1.getText().getBytes();
                String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
                palabra1.setText(palabraEncriptada);
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String palabra = palabra1.getText();
                byte[] palabraDesencriptada = Base64.getDecoder().decode(palabra);
                String palabraLista = new String(palabraDesencriptada);
                palabra1.setText(palabraLista);
            }
        });
        
        
      
        
        primaryStage.setTitle("Encriptar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
