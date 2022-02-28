package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SingUpView implements Show {

    private Button back1;

    public SingUpView(){

        back1 = new Button();
        back1.setLayoutX(34);
        back1.setLayoutY(29);
        back1.setPrefHeight(30);
        back1.setPrefWidth(34);
        back1.setStyle("-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                " -fx-background-color: blue;" +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: #cccccc;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 1px;" +
                "    -fx-text-fill: whitesmoke;");
        back1.setText("Back");
        back1.setTextFill(Color.WHITE);
    }


    public Scene execute(Stage primaryStage) {

        AnchorPane pane = new AnchorPane();
        pane.setPrefHeight(440);
        pane.setPrefWidth(653);
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        AnchorPane pane1 = new AnchorPane();
        pane1.setPrefWidth(267);
        pane1.setPrefHeight(440);
        pane.getChildren().add(pane1);

        ImageView imgView = new ImageView();
        imgView.setFitHeight(440);
        imgView.setFitWidth(267);
        Image photo = new Image("wallpaper.jpg");
        imgView.setImage(photo);

        ImageView img2 = new ImageView();
        img2.setFitHeight(120.0);
        img2.setFitWidth(135);
        img2.setX(71);
        img2.setY(29);
        img2.setPickOnBounds(true);
        Image logo = new Image("logo11.jpg");
        img2.setImage(logo);
        pane1.getChildren().add(imgView);
        pane1.getChildren().add(img2);

        AnchorPane pane2 = new AnchorPane();
        pane2.setPrefHeight(441);
        pane2.setPrefWidth(383);
        pane2.setLayoutX(278);
        pane2.setLayoutY(-1);
        pane.getChildren().add(pane2);

        ImageView img3 = new ImageView();
        img3.setFitHeight(460);
        img3.setFitWidth(390);
        Image back = new Image("backpic.jpg");
        img3.setImage(back);
        //img3.setEffect(new Glow(0.3));
        pane2.getChildren().add(img3);

        Label Title = new Label("Access Denied");
        Title.setLayoutX(100);
        Title.setLayoutY(105);
        Title.setFont(new Font("Arial", 26));
        Title.setTextFill(Color.WHITE);
        pane2.getChildren().add((Title));


        Label txt = new Label("Please contact the administrator to register");
        txt.setFont(new Font("Arial", 13));
        txt.setLayoutY(130);
        txt.setLayoutX(75);
        txt.setPrefHeight(80);
        txt.setPrefWidth(250);
        txt.setTextFill(Color.GRAY);
        pane2.getChildren().add(txt);


        Button back1 = new Button();
        back1.setLayoutX(34);
        back1.setLayoutY(29);
        back1.setPrefHeight(30);
        back1.setPrefWidth(63);
        back1.setStyle("-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                " -fx-background-color: transparent;" +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: #cccccc;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 1px;" +
                "    -fx-text-fill: whitesmoke;");
        back1.setText("Back");
        back1.setTextFill(Color.WHITE);
        pane2.getChildren().add(back1);




        back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene((new LoginView()).execute(primaryStage));
                primaryStage.show();

            }
        });
        Scene scene = new Scene(pane, 653, 440);

        return scene;
    }


}
