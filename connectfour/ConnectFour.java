/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Kionari
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author narayan
 */
public class ConnectFour extends Application {
    
    @Override
    public void start(final Stage stage) throws Exception {
        int rows = 6;
        int columns = 6;
        BorderPane border = new BorderPane();
     
        
        stage.setTitle("Enjoy your game");

        GridPane grid = new GridPane();
        grid.getStyleClass().add("game-grid");

        for(int i = 0; i < columns; i++) {

            ColumnConstraints column = new ColumnConstraints(70);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(70);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane();

                pane.setOnMouseReleased(e -> {
                    MouseButton button = e.getButton();
                    if(button == MouseButton.PRIMARY)
                       pane.getChildren().add(Anims.getAtoms(1));
                    if(button == MouseButton.SECONDARY)
                        pane.getChildren().add(Anims.getAtoms1(1));
                    
                });
                
                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }
       
              
        VBox vb = new VBox();
        ToolBar toolbar = new ToolBar();
        vb.getChildren().add(toolbar);
         border.setTop(vb);
        border.setCenter(grid);
        Scene scene = new Scene(border,(columns * 100)+20, (rows * 100)+20);
        scene.getStylesheets().add(ConnectFour.class.getResource("resources/game.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
    }

    public static class Anims {

        public static Node getAtoms(final int number) {
            
            //TODO: Add code to create a colored 
            Rectangle rect = new Rectangle (69,69,Color.RED);
            return rect;

        }
        
        public static Node getAtoms1(final int number) {
            
            //TODO: Add code to create a colored 
            Rectangle rect = new Rectangle (69,69,Color.BLUE);
            return rect;

        }
        
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
    
}
