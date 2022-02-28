package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.User;
import model.UserAccess;

import java.io.File;

public class LoginView implements Show {

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

        PasswordField pass = new PasswordField();
        pass.setLayoutY(196);
        pass.setLayoutX(113);
        //pass.setOpacity(0.5);
        pass.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #DEDEE4;" +
                "    -fx-border-width: 0px 0px 1px 0px;" +
                " -fx-text-fill: white");
        pass.setPromptText("Password");
        pane2.getChildren().add(pass);

        TextField user = new TextField();
        user.setLayoutX(113);
        user.setLayoutY(156);
        //user.setOpacity(0.5);
        user.setPromptText("Username");
        //user.setStyle("-fx-border-color: black;");
        user.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #DEDEE4;" +
                "    -fx-border-width: 0px 0px 1px 0px;" +
                " -fx-text-fill: white");
        //user.setStyle("-fx-background-color: transparent");
        pane2.getChildren().add(user);

        Button btLogin = new Button();
        btLogin.setLayoutY(238);
        btLogin.setLayoutX(130);
        btLogin.setPrefHeight(30);
        btLogin.setPrefWidth(117);
        btLogin.setStyle("-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                " -fx-background-color: blue;" +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: #cccccc;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 1px;" +
                "    -fx-text-fill: whitesmoke;");
        btLogin.setText("Login");
        btLogin.setTextFill(Color.WHITE);
        pane2.getChildren().add(btLogin);

        ImageView key = new ImageView();
        Image keyIc = new Image("keyIcon.png");
        key.setImage(keyIc);
        key.setFitWidth(27);
        key.setFitHeight(27);
        key.setLayoutX(63);
        key.setLayoutY(195);
        pane2.getChildren().add(key);

        ImageView us = new ImageView();
        Image usIc = new Image("userIcon.png");
        us.setImage(usIc);
        us.setFitWidth(27);
        us.setFitHeight(27);
        us.setLayoutX(63);
        us.setLayoutY(155);
        pane2.getChildren().add(us);

        Label Title = new Label("Sign In");
        Title.setLayoutX(149);
        Title.setLayoutY(44);
        Title.setFont(new Font("Arial", 26));
        Title.setTextFill(Color.WHITE);
        pane2.getChildren().add((Title));

        Label txt = new Label("Don't have an account? Sign up here");
        txt.setLayoutY(341);
        txt.setLayoutX(80);
        txt.setTextFill(Color.GRAY);
        pane2.getChildren().add(txt);

        Label alert = new Label("Username and password does not match");
        alert.setLayoutY(286);
        alert.setLayoutX(80);
        alert.setTextFill(Color.RED);
        alert.setVisible(false);
        pane2.getChildren().add(alert);

        Button btSign = new Button();
        btSign.setLayoutX(130);
        btSign.setLayoutY(371);
        btSign.setPrefHeight(30);
        btSign.setPrefWidth(117);
        //btSign.getStyleClass().add("btSign");
        btSign.setStyle("-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                " -fx-background-color: transparent;" +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: #cccccc;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 1px;" +
                "    -fx-text-fill: whitesmoke;");
        btSign.setText("Sign Up");
        btSign.setTextFill(Color.WHITE);
        pane2.getChildren().add(btSign);

        Scene scene = new Scene(pane, 653, 440);
        primaryStage.setTitle("Login");

        btSign.setOnAction(e -> {
            primaryStage.setScene((new SingUpView()).execute(primaryStage));
            primaryStage.show();
        });

        btLogin.setOnAction(e -> {
            
            String username = user.getText();
            String password = pass.getText();

            File file = new File(UserAccess.filename);
            boolean found = false;
            if(file.exists() && !file.isDirectory())
            {
                UserAccess fileUser = new UserAccess();
                User user1 = fileUser.checkUser(username, password);

            if(user1 != null)
            {
                if(user1.getPositon()==User.CASHIER){
                    alert.setVisible(false);
                    System.out.println("Logged in");
                    primaryStage.close();
                    primaryStage.setScene((new CashierView(user1).execute(primaryStage)));
                    primaryStage.show();
                }
                if(user1.getPositon()==User.MANAGER){
                    alert.setVisible(false);
                    System.out.println("Logged in");
                    primaryStage.close();
                    primaryStage.setScene((new ManagerView()).execute(primaryStage));
                    primaryStage.show();
                }
                if(user1.getPositon()==User.ADMIN){
                    alert.setVisible(false);
                    System.out.println("Logged in");
                    primaryStage.close();
                    primaryStage.setScene((new AdminView()).execute(primaryStage));
                    primaryStage.show();
                }

            }
            else{
                alert.setVisible(true);
            }
            }
                /*    if(username.equals("1") && password.equals("1"))
                    {
                        System.out.println("Logged in");
                        primaryStage.setScene((new AdminView()).execute(primaryStage));
                        //User UserAdmin = new User(0, "admin", "admin", User.ADMIN);}*/

        });

        return scene;
    }



}
