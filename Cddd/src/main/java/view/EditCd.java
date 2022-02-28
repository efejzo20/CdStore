package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.AccessCd;
import model.Cd;
import model.User;

public class EditCd {

    private User currentUser;
    private Cd cd;
    private boolean isEdit;

/*
    */
/**
     * Call This constructor to add a new user
     *//*

    public EditCd(User currentUser)
    {
        this.currentUser = currentUser;
        this.cd = null;
        this.isEdit = false;
    }
*/

    /**
     * Call this constructor to edit users
     */
    public EditCd(User currentUser, Cd editCd)
    {
        this.currentUser = currentUser;
        this.cd = editCd;
        this.isEdit = true;
    }


    public AnchorPane show()
    {
        AnchorPane pane = new AnchorPane();
        String genre;
        String singer;
        String name;
        int price = 0;
        int quantity = 0;
        int id=0;


        if(isEdit)
        {
           genre = cd.getGenre();
           singer = cd.getSinger();
           name = cd.getName();
           price = (int)cd.getPrice();
           quantity = cd.getQuantity();
           id = cd.getId();
        }
        else
        {
            genre = "";
            singer = "";
            name = "";
        }

        //ObservableList<Department> departments = FXCollections.observableArrayList(Department.values());

        Label genreL = new Label("Genre: ");
        Label singerL = new Label("Singer: ");
        Label nameL = new Label("Name: ");
        Label priceL = new Label("Price: ");
        Label quantityL = new Label("Quantity: ");
        Label idL = new Label("Id: ");

        TextField genreField = new TextField(genre);
        TextField singerField = new TextField(singer);
        TextField nameField = new TextField(name);
        TextField priceField = new TextField(String.valueOf(price));
        TextField quantityField = new TextField(String.valueOf(quantity));
        TextField idField = new TextField(String.valueOf(id));

        Button create = new Button("Create");
        Button cancel = new Button("Cancel");

        HBox buttons = new HBox();
        //buttons.getChildren().addAll(create, cancel);
        buttons.setAlignment(Pos.CENTER);
        HBox.setMargin(create, new Insets(0, 10, 0, 0));

        Label succes = new Label("Cd edited");
        succes.setTextFill(Color.BLUE);
        succes.setVisible(false);


        GridPane fieldPane = new GridPane();
        fieldPane.addRow(0, nameL,nameField);
        fieldPane.addRow(1, quantityL, quantityField);
        fieldPane.addRow(2, singerL, singerField);
        fieldPane.addRow(3, genreL, genreField);
        fieldPane.addRow(4, priceL, priceField);
        fieldPane.addRow(5,create,cancel);
        fieldPane.addRow(6, succes);


        fieldPane.setAlignment(Pos.CENTER);
        fieldPane.setPadding(new Insets(10,10,10,10));
        fieldPane.setHgap(5);
        fieldPane.setVgap(5);

        BorderPane topPane = new BorderPane();
        topPane.setCenter(fieldPane);
        //topPane.setBottom(buttons);
        topPane.getStyleClass().add("bluebox");

        if (isEdit) {
            nameField.setText(cd.getName());
            singerField.setText(cd.getSinger());
            genreField.setText(cd.getGenre());
            priceField.setText(String.valueOf((int)cd.getPrice()));
            quantityField.setText(String.valueOf(cd.getQuantity()));
            create.setText("Edit");

        }

        cancel.setOnAction(e -> {
            CdList clist = new CdList(currentUser);
            pane.getChildren().add(clist.show());
            succes.setVisible(false);
           // primaryStage.close();
        });

        create.setOnAction(e -> {
            String nameData = nameField.getText();
            String quantityData = quantityField.getText();
            int quantityInt = Integer.parseInt(quantityData);
            String singerData = singerField.getText();
            String priceData = priceField.getText();
            int priceInt = Integer.parseInt(priceData);
            String genreData = genreField.getText();
            String idData = idField.getText();
            int idInt = Integer.parseInt(idData);

            AccessCd manager = new AccessCd();

            if (isEdit) {
                cd.setId(idInt);
                cd.setGenre(genreData);
                cd.setPrice(priceInt);
                cd.setQuantity(quantityInt);
                cd.setSinger(singerData);
                cd.setName(nameData);
                manager.editCd(cd);
                succes.setVisible(true);
            } else {
                Cd c = new Cd(idInt,nameData,genreData,singerData,priceInt,quantityInt);
                manager.addCd(c);
            }
            //primaryStage.setScene((new ListCDs(this.currentUser, selling)).exec(primaryStage));
        });


        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(topPane);
        pane.getChildren().addAll(topPane,mainPane, fieldPane,buttons);

        //Scene scene = new Scene(mainPane);
        //scene.getStylesheets().addAll(this.getClass().getResource("../resources/css/style.css").toString());
        //primaryStage.setTitle("Bill");
        return pane;
    }

/*    public void showSuccessful(Stage primaryStage)
    {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox vb = new VBox();

        String message = "Successfully Inserted!";

        if(isEdit)
        {
            message = "Successfully Edited!";
        }

        Label msg = new Label(message);
        Button ok = new Button("OK");

        vb.getChildren().addAll(msg, ok);
        Scene scene = new Scene(vb);
        scene.getStylesheets().addAll(this.getClass().getResource("../resources/css/style.css").toString());

        stage.setTitle("Information");
        stage.setScene(scene);
        stage.show();

        ok.setOnAction(e -> {
            stage.close();

        });
    }*/
}
