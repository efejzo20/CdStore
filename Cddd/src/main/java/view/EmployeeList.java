package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.User;
import model.UserAccess;

public class EmployeeList{
    private User currentUser;
    private int i=1;


    EmployeeList(User currentUser){
        this.currentUser=currentUser;
    }


    public AnchorPane show() {
        AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(711);
        pane.setPrefHeight(511);
        UserAccess ufile = new UserAccess();
        ObservableList<User> UserList = FXCollections.observableArrayList(ufile.getUsers());

        TableView UserTable = new TableView();

        UserTable.setLayoutX(25);
        UserTable.setLayoutY(50);


        UserTable.setEditable(true);

        TableColumn idC = new TableColumn("Id");
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn usernameC = new TableColumn("Username");
        usernameC.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn passC = new TableColumn("Password");
        passC.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn surname = new TableColumn("Surname");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn number = new TableColumn("Number");
        number.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn email = new TableColumn("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn salary = new TableColumn("Salary");
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn positionC = new TableColumn("Position");
        positionC.setCellValueFactory(new PropertyValueFactory<>("positon"));

        UserTable.setItems(UserList);
        UserTable.getColumns().addAll(idC,usernameC,passC, name,surname, number, email, salary, positionC);
        pane.getChildren().add(UserTable);

        Button deleteUser = new Button("Delete User");
        deleteUser.setStyle("-fx-background-color: #000000," +
                "        linear-gradient(#7ebcea, #2f4b8f)," +
                "        linear-gradient(#426ab7, #263e75)," +
                "        linear-gradient(#395cab, #223768);" +
                "    -fx-background-insets: 0,1,2,3;" +
                "    -fx-background-radius: 3,2,2,2;" +
                "    -fx-padding: 12 30 12 30;" +
                "    -fx-text-fill: white;" +
                "    -fx-font-size: 12px;" +
                "-fx-cursor: hand; ");

        Label deleted = new Label("Deleted successfully");
        deleted.setTextFill(Color.RED);
        deleted.setVisible(false);


        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        pane.getChildren().addAll(bp,vb);
        vb.getChildren().addAll(deleteUser,deleted);
        vb.setMargin(deleteUser, new Insets(0, 10, 0, 0));;
        vb.setAlignment(Pos.CENTER);
        bp.setCenter(UserTable);
        bp.setBottom(vb);


        deleteUser.setOnAction(e -> {
            UserAccess u = new UserAccess();
            User selectUser = (User) UserTable.getSelectionModel().getSelectedItem();
            u.remove(selectUser);
            deleted.setVisible(true);
        });


        return pane;
    }
}


