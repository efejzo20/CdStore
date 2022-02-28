package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

public class CashierView extends HomeView implements Show {
    private User user;

    public CashierView() {
        super();
    }

    public CashierView(User u){
        user=u;
    }

    @Override
    public Scene execute(Stage primaryStage) {
        userDataimg.setVisible(false);
        btAdd.setVisible(false);
        addUser.setVisible(false);
        add1.setVisible(false);
        btUserData.setVisible(false);
        btAddUser.setVisible(false);
        addUserImg.setVisible(false);
        welcome.setText("You are logged in as Cashier");
        logOut.setOnAction(e ->{
            primaryStage.setScene(new LoginView().execute(primaryStage));
        });


        btHome.setOnAction(e -> {
            paneData.setVisible(false);
            logedIn.setVisible(true);
        });

        btData.setOnAction(e -> {
            paneData.setVisible(true);
            logedIn.setVisible(false);

            CdList c = new CdList(user);
            //data.setScene(new CdList(user).execute(primaryStage));
            //data.show();
        });



        Scene scene = new Scene(pane, 963, 563);
        primaryStage.setTitle("Home");
        return scene;
    }
}
