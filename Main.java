package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        //here is you rplace to put code
        //let's create some UI elements
        Button addButton = new Button();
        addButton.setText("Add Item");

        //create a label
        Label mylabel = new Label("hello");

        //another way of writing it (works exactly the same!!!)
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //here we put our code - actions or things that should happen when the button has been pressed
                Item myitem = new Item();
                myitem.setValue(678.0);
                //print value of item on the console
                System.out.println(myitem.getValue());

            }
        });



        HBox HBox1 = new HBox(10);
        HBox1.getChildren().addAll(addButton, mylabel);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(HBox1, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class Item {


    //field variables
    private long propertyID;
    private double value;

    //getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(long propertyID) {
        this.propertyID = propertyID;
    }

    //method to calculate value loss
    public double looseValue() {
        double result = 0.0;
        result = this.getValue() * 0.8;
        return result;
    }


}

class Server extends Item {

}

class Rack extends Item {

    public double looseValue() {
        double result = 0.0;
        result = this.getValue() * 0;
        return result;
    }

}

class Desktop extends Item {

    //overriding the loosValue method
    public double looseValue() {
        double result = 0.0;
        result = this.getValue() * 0.6;
        return result;
    }
}
