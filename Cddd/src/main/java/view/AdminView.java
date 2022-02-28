package view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminView extends HomeView implements Show {
    @Override
    public Scene execute(Stage primaryStage) {
        welcome.setText("You are logged in as Admin");

        logOut.setOnAction(e ->{
            primaryStage.setScene(new LoginView().execute(primaryStage));
        });

        btHome.setOnAction(e -> {
            paneData.setVisible(false);
            logedIn.setVisible(true);
            addpane.setVisible(false);
            paneUserData.setVisible(false);
            addUserpane.setVisible(false);
        });

        btData.setOnAction(e -> {
            paneData.setVisible(true);
            logedIn.setVisible(false);
            addpane.setVisible(false);
            paneUserData.setVisible(false);
            addUserpane.setVisible(false);
        });

        btAdd.setOnAction(e ->{
            paneData.setVisible(false);
            logedIn.setVisible(false);
            addpane.setVisible(true);
            paneUserData.setVisible(false);
            addUserpane.setVisible(false);
        });

        btUserData.setOnAction( e ->{
            paneUserData.setVisible(true);
            paneData.setVisible(false);
            logedIn.setVisible(false);
            addpane.setVisible(false);
            addUserpane.setVisible(false);
        });

        btAddUser.setOnAction( e ->{
            paneUserData.setVisible(false);
            paneData.setVisible(false);
            logedIn.setVisible(false);
            addpane.setVisible(false);
            addUserpane.setVisible(true);
        });

        Scene scene = new Scene(pane, 963, 563);
        primaryStage.setTitle("Home");
        return scene;
    }
}
