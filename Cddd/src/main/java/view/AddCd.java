package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.AccessCd;
import model.Cd;

public class AddCd {

    private Cd AddC;

    private boolean isInt(TextField f, String msg)
    {
        try
        {
            Integer.parseInt(f.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            System.out.println(msg);
            return false;
        }
    }

    public AnchorPane show(){

        AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(700);
        pane.setPrefHeight(500);

        TextField Id = new TextField();
        Id.setLayoutX(300);
        Id.setLayoutY(50);
        Id.setPromptText("Id");
        Id.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(Id);

        TextField name = new TextField();
        name.setLayoutX(300);
        name.setLayoutY(100);
        name.setPromptText("Name");
        name.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(name);

        TextField genre = new TextField();
        genre.setLayoutX(300);
        genre.setLayoutY(150);
        genre.setPromptText("Genre");
        genre.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(genre);

        TextField singer = new TextField();
        singer.setLayoutX(300);
        singer.setLayoutY(200);
        singer.setPromptText("Singer");
        singer.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(singer);

        TextField price = new TextField();
        price.setLayoutX(300);
        price.setLayoutY(250);
        price.setPromptText("Price");
        price.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(price);

        TextField quantity = new TextField();
        quantity.setLayoutX(300);
        quantity.setLayoutY(300);
        quantity.setPromptText("Quantity");
        quantity.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(quantity);

        Button create = new Button();
        create.setLayoutX(300);
        create.setLayoutY(380);
        create.setPrefHeight(30);
        create.setPrefWidth(160);

        create.setText("Add Cd");
        create.setTextFill(Color.BLACK);
        pane.getChildren().add(create);

       /* final String IDLE_BUTTON_STYLE = "-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                " -fx-background-color: transparent;" +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: black;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 2px;" +
                "    -fx-text-fill: black;";
        final String HOVERED_BUTTON_STYLE = "-fx-background-color: #0000cc;" +
                "-fx-cursor: hand;    " +
                "    -fx-background-radius: 5px;" +
                "    -fx-border-color: black;" +
                "    -fx-border-radius: 5px;" +
                "    -fx-border-width: 2px;" +
                "    -fx-text-fill: black;" + "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color; -fx-cursor: hand;";
*/
        create.setStyle("-fx-background-color: #000000," +
                "        linear-gradient(#7ebcea, #2f4b8f)," +
                "        linear-gradient(#426ab7, #263e75)," +
                "        linear-gradient(#395cab, #223768);" +
                "    -fx-background-insets: 0,1,2,3;" +
                "    -fx-background-radius: 3,2,2,2;" +
                "    -fx-padding: 12 30 12 30;" +
                "    -fx-text-fill: white;" +
                "    -fx-font-size: 12px;" +
                "-fx-cursor: hand; ");
       /* create.setOnMouseEntered(e -> create.setStyle(HOVERED_BUTTON_STYLE));
        create.setOnMouseExited(e -> create.setStyle(IDLE_BUTTON_STYLE));*/

        Label alert = new Label("Hi");
        alert.setLayoutX(290);
        alert.setLayoutY(415);
        alert.setPrefHeight(30);
        alert.setPrefWidth(200);
        alert.setVisible(false);
        alert.setTextFill(Color.RED);
        pane.getChildren().add(alert);


        create.setOnAction(e -> {
            try {
                Integer IdTxt = Integer.parseInt(Id.getText());
                String nameTxt = name.getText();;
                String genreTxt = genre.getText();
                String SingerTxt = singer.getText();

                Integer priceTxt = Integer.parseInt(price.getText());
                Integer quantityTxt = Integer.parseInt(quantity.getText());

                AccessCd c = new AccessCd();

                Cd newCd = new Cd(IdTxt, nameTxt, genreTxt, SingerTxt,priceTxt, quantityTxt);
                if(c.sameId(IdTxt) == true){
                    alert.setText("        This Id is already used    ");
                    alert.setVisible(true);
                }
                else{
                    c.addCd(newCd);
                    alert.setText("     Cd added successfully"     );
                    alert.setTextFill(Color.BLUE);
                    alert.setVisible(true);
                }
            }catch (NumberFormatException error){
                error.getMessage();
                alert.setText(" Enter a number at certain text field");
                alert.setTextFill(Color.RED);
                alert.setVisible(true);
            }

        });

        return pane;
    }

}
