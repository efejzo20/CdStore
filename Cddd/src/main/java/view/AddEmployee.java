package view;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.AccessCd;
import model.Cd;
import model.User;
import model.UserAccess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployee {

    public AnchorPane show(){

        AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(700);
        pane.setPrefHeight(500);

        TextField Id = new TextField();
        Id.setLayoutX(300);
        Id.setLayoutY(0);
        Id.setPromptText("Id");
        Id.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(Id);

        TextField username = new TextField();
        username.setLayoutX(300);
        username.setLayoutY(50);
        username.setPromptText("Username");
        username.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(username);

        TextField pass = new TextField();
        pass.setLayoutX(300);
        pass.setLayoutY(100);
        pass.setPromptText("Password");
        pass.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(pass);

        TextField Name = new TextField();
        Name.setLayoutX(300);
        Name.setLayoutY(150);
        Name.setPromptText("Name");
        Name.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(Name);

        TextField surname = new TextField();
        surname.setLayoutX(300);
        surname.setLayoutY(200);
        surname.setPromptText("Surname");
        surname.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(surname);

        TextField number = new TextField();
        number.setLayoutX(300);
        number.setLayoutY(250);
        number.setPromptText("Phone number");
        number.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(number);
        Tooltip tipNr = new Tooltip("XXXXXXXXXX");
        number.setTooltip(tipNr);

        TextField email = new TextField();
        email.setLayoutX(300);
        email.setLayoutY(300);
        email.setPromptText("E-mail");
        email.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(email);
        Tooltip tipEmail = new Tooltip("name@example.com");
        email.setTooltip(tipEmail);



        TextField salary = new TextField();
        salary.setLayoutX(300);
        salary.setLayoutY(350);
        salary.setPromptText("Salary");
        salary.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(salary);


        TextField position = new TextField();
        position.setLayoutX(300);
        position.setLayoutY(400);
        position.setPromptText("Position");
        position.setStyle(" -fx-background-color: transparent;" +
                "    -fx-border-color: #3333ff;" +
                "    -fx-border-width: 2px;" +
                " -fx-text-fill: black");
        pane.getChildren().add(position);

        Button create = new Button();
        create.setLayoutX(300);
        create.setLayoutY(450);
        create.setPrefHeight(30);
        create.setPrefWidth(160);

        create.setText("Add Employee");
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

        Label alert = new Label();
        alert.setLayoutX(450);
        alert.setLayoutY(450);
        alert.setPrefHeight(30);
        alert.setPrefWidth(250);
        alert.setVisible(false);
        alert.setTextFill(Color.RED);
        pane.getChildren().add(alert);


        create.setOnAction(e -> {
            try {
                Integer IdTxt = Integer.parseInt(Id.getText());
                String usrnameTxt = username.getText();;
                String passTxt = pass.getText();
                String nameTxt = Name.getText();
                String surnameTxt = surname.getText();
                String numberTxt = number.getText();
                String emailTxt = email.getText();
                Double salaryTxt = Double.parseDouble(salary.getText());
                Integer positionTxt = Integer.parseInt(position.getText());

                UserAccess u = new UserAccess();

                User newUser = new User(IdTxt,usrnameTxt,passTxt,nameTxt,surnameTxt,numberTxt,emailTxt,salaryTxt,positionTxt);

                Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
                Matcher matcher = pattern.matcher(numberTxt);

                Pattern pemail = Pattern.compile("^(.+)@(\\S+)$");
                Matcher memail = pemail.matcher(emailTxt);


                if(matcher.matches() == false){
                    alert.setText("        Number incorrect(enter 10 digits)    ");
                    alert.setTextFill(Color.RED);
                    alert.setVisible(true);

                }else if(memail.matches()==false){
                    alert.setText("        Email incorrect    ");
                    alert.setTextFill(Color.RED);
                    alert.setVisible(true);

                }else if(positionTxt > 2){
                    alert.setText("        Enter the right position(0 or 1 or 2)");
                    alert.setTextFill(Color.RED);
                    alert.setVisible(true);
                }
                else if(u.sameId(IdTxt) == true){
                    alert.setText("        This Id is already used    ");
                    alert.setTextFill(Color.RED);
                    alert.setVisible(true);
                }
                else{
                    u.addUser(newUser);
                    alert.setText("     User added successfully"     );
                    alert.setTextFill(Color.BLUE);
                    alert.setVisible(true);
                }
            }catch (NumberFormatException error){
                error.getMessage();
                alert.setTextFill(Color.RED);
                alert.setText(" Enter a number at certain text field");
                alert.setVisible(true);
            }

        });

        return pane;
    }
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

}
