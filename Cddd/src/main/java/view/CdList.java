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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.*;

import java.util.ArrayList;
import java.util.Date;

public class CdList {
    private User currentUser;
    private int i=1;
    AnchorPane pane = new AnchorPane();


    CdList(User currentUser){
        this.currentUser=currentUser;
    }


    public AnchorPane show() {

        pane.setPrefWidth(711);
        pane.setPrefHeight(511);
        AccessCd cdFile = new AccessCd();
        ObservableList<Cd> CdList = FXCollections.observableArrayList(cdFile.getCds());

        TableView cdTable = new TableView();

        cdTable.setLayoutX(20);
        cdTable.setLayoutY(100);


        cdTable.setEditable(true);

        TableColumn idC = new TableColumn("Id");
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn genreC = new TableColumn("Genre");
        genreC.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn nameC = new TableColumn("Name");
        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn singerC = new TableColumn("Singer");
        singerC.setCellValueFactory(new PropertyValueFactory<>("singer"));

        TableColumn PriceC = new TableColumn("Price");
        PriceC.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantityC = new TableColumn("Quantity");
        quantityC.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        cdTable.setItems(CdList);
        cdTable.getColumns().addAll(idC, genreC,nameC, singerC, PriceC, quantityC);
        pane.getChildren().add(cdTable);

        ArrayList<Cd> selectArr= new ArrayList<Cd>();

        Button addToBill = new Button("Add to Bill");
        addToBill.setStyle("-fx-background-color: #000000," +
                "        linear-gradient(#7ebcea, #2f4b8f)," +
                "        linear-gradient(#426ab7, #263e75)," +
                "        linear-gradient(#395cab, #223768);" +
                "    -fx-background-insets: 0,1,2,3;" +
                "    -fx-background-radius: 3,2,2,2;" +
                "    -fx-padding: 12 30 12 30;" +
                "    -fx-text-fill: white;" +
                "    -fx-font-size: 12px;" +
                "-fx-cursor: hand; ");
        Button edit = new Button("Edit Selected");
        edit.setStyle("-fx-background-color: #000000," +
                "        linear-gradient(#7ebcea, #2f4b8f)," +
                "        linear-gradient(#426ab7, #263e75)," +
                "        linear-gradient(#395cab, #223768);" +
                "    -fx-background-insets: 0,1,2,3;" +
                "    -fx-background-radius: 3,2,2,2;" +
                "    -fx-padding: 12 30 12 30;" +
                "    -fx-text-fill: white;" +
                "    -fx-font-size: 12px;" +
                "-fx-cursor: hand; ");

        addToBill.setOnAction(e -> {
            AccessCd ac = new AccessCd();
            Cd selectCd = (Cd) cdTable.getSelectionModel().getSelectedItem();
            selectCd.setQuantity(selectCd.getQuantity()-1);
            //ac.setQuantity(selectCd,selectCd.getQuantity());
            selectArr.add(selectCd);

        });

        Button done = new Button("Done");
        done.setStyle("-fx-background-color: #000000," +
                "        linear-gradient(#7ebcea, #2f4b8f)," +
                "        linear-gradient(#426ab7, #263e75)," +
                "        linear-gradient(#395cab, #223768);" +
                "    -fx-background-insets: 0,1,2,3;" +
                "    -fx-background-radius: 3,2,2,2;" +
                "    -fx-padding: 12 30 12 30;" +
                "    -fx-text-fill: white;" +
                "    -fx-font-size: 12px;" +
                "-fx-cursor: hand; ");
        //ArrayList<String> fname = new ArrayList<>();

        BorderPane bp = new BorderPane();
        HBox hb = new HBox();
        pane.getChildren().addAll(bp,hb);

        hb.getChildren().addAll(addToBill,done,edit);
        hb.setMargin(addToBill, new Insets(0, 10, 0, 0));;
        hb.setAlignment(Pos.CENTER);


        bp.setCenter(cdTable);
        bp.setBottom(hb);


        done.setOnAction(e -> {
            Date currentDate = new Date();
            String fname = "Bill_" + currentDate.toString().replaceAll("[\\s:]","-") + ".txt";
            Bill b = new Bill(selectArr,fname);
            b.writeToBill();
            Date now = new Date();
            b.setDateBill(now);
            i++;
            selectArr.clear();

        });

        edit.setOnAction(e -> {
            Cd selectCd1 = (Cd) cdTable.getSelectionModel().getSelectedItem();
            cdTable.setVisible(false);
            bp.setVisible(false);
            hb.setVisible(false);
            EditCd editC = new EditCd(currentUser,selectCd1);
            pane.getChildren().add(editC.show());
        });


        return pane;
    }
}
