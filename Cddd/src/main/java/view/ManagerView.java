package view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerView extends HomeView implements Show {
    @Override
    public Scene execute(Stage primaryStage) {
        welcome.setText("You are logged in as Manager");
        userDataimg.setVisible(false);
        btUserData.setVisible(false);
        btAddUser.setVisible(false);
        addUserImg.setVisible(false);

        logOut.setOnAction(e ->{
            primaryStage.setScene(new LoginView().execute(primaryStage));
        });

        btHome.setOnAction(e -> {
            paneData.setVisible(false);
            logedIn.setVisible(true);
            addpane.setVisible(false);
        });

        btData.setOnAction(e -> {
            paneData.setVisible(true);
            logedIn.setVisible(false);
            addpane.setVisible(false);
        });

        btAdd.setOnAction(e ->{
            paneData.setVisible(false);
            logedIn.setVisible(false);
            addpane.setVisible(true);
        });

        Scene scene = new Scene(pane, 963, 563);
        primaryStage.setTitle("Home");
        return scene;
    }
}
