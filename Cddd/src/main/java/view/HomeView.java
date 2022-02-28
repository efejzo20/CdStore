package view;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.User;

public class HomeView {

    ImageView add1 = new ImageView();
    ImageView userDataimg = new ImageView();
    ImageView addUserImg = new ImageView();
    public ImageView addUser = new ImageView();
    AnchorPane pane = new AnchorPane();
    Label welcome = new Label();
    Button logOut = new Button("Log Out");
    Button btHome = new Button("Home");
    Button btData = new Button("CD Data");
    Button btAdd = new Button("Add Cd");
    AnchorPane logedIn = new AnchorPane();
    AnchorPane paneData = new AnchorPane();
    AnchorPane paneUserData = new AnchorPane();
    AnchorPane addpane = new AnchorPane();
    AnchorPane addUserpane = new AnchorPane();
    Button btUserData = new Button("Employee Data");
    Button btAddUser = new Button("Add Employee");
    private User user;

    public HomeView(User u) {
        user = u;
    }


    public HomeView() {

        pane.setPrefHeight(563);
        pane.setPrefWidth(963);
        pane.setStyle("-fx-background-color: #e6e6e6;");

        AnchorPane menubar = new AnchorPane();
        pane.getChildren().add(menubar);
        menubar.setPrefHeight(54);
        menubar.setPrefWidth(963);
        menubar.setStyle("-fx-background-color: #3333ff;");


        CdList c = new CdList(user);
        paneData = c.show();
        paneData.setLayoutX(320);
        paneData.setLayoutY(70);
        paneData.setVisible(false);
        pane.getChildren().add(paneData);

        EmployeeList emp = new EmployeeList(user);
        paneUserData = emp.show();
        paneUserData.setLayoutX(230);
        paneUserData.setLayoutY(70);
        paneUserData.setVisible(false);
        pane.getChildren().add(paneUserData);


        logOut.setLayoutY(14);
        logOut.setLayoutX(870);
        logOut.setPrefWidth(60);
        logOut.setPrefHeight(27);
        logOut.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);" +
                "-fx-background-radius: 30;" +
                "-fx-background-insets: 0;" +
                "-fx-text-fill: white;" + "-fx-cursor: hand; ");
        menubar.getChildren().add(logOut);


        AnchorPane pane1 = new AnchorPane();
        pane.getChildren().add(pane1);
        pane1.setLayoutY(54);
        pane1.setPrefWidth(72);
        pane1.setPrefHeight(511);
        pane1.setStyle("-fx-background-color: white;");

        VBox v1 = new VBox();
        pane1.getChildren().add(v1);
        v1.setAlignment(Pos.TOP_CENTER);
        v1.setLayoutY(23);
        v1.setPrefWidth(72);
        v1.setPrefHeight(438);
        v1.setSpacing(15);

        ImageView homeimg = new ImageView();
        Image h = new Image("home.png");
        homeimg.setImage(h);
        homeimg.setFitHeight(40);
        homeimg.setFitWidth(40);
        homeimg.setPickOnBounds(true);
        homeimg.setPreserveRatio(true);
        v1.getChildren().add(homeimg);


        ImageView data = new ImageView();
        v1.getChildren().add(data);
        data.setImage(new Image("data.png"));
        data.setFitHeight(40);
        data.setFitWidth(40);
        data.setPickOnBounds(true);
        data.setPreserveRatio(true);




        addUser.setImage(new Image("add.png"));
        addUser.setFitHeight(40);
        addUser.setFitWidth(40);
        addUser.setPickOnBounds(true);
        addUser.setPreserveRatio(true);
        v1.getChildren().add(addUser);

        ImageView burger = new ImageView();
        Image b = new Image("burger.png");
        burger.setStyle("-fx-cursor: hand;");
        burger.setImage(b);
        burger.setFitHeight(38);
        burger.setFitWidth(42);
        burger.setLayoutX(14);
        burger.setLayoutY(8);
        burger.setPickOnBounds(true);
        menubar.getChildren().add(burger);

        AnchorPane black = new AnchorPane();
        black.setPrefHeight(563);
        black.setPrefWidth(941);
        black.setStyle("fx-background-color: black;");
        pane.getChildren().add(black);


        AnchorPane pane2 = new AnchorPane();

        pane.getChildren().add(pane2);
        pane2.setLayoutY(54);
        pane2.setPrefWidth(72);
        pane2.setPrefHeight(520);
        pane2.setStyle("-fx-background-color: white;");

        VBox v2 = new VBox();
        pane2.getChildren().add(v2);
        v2.setAlignment(Pos.TOP_CENTER);
        v2.setLayoutY(23);
        v2.setPrefWidth(72);
        v2.setPrefHeight(438);
        v2.setSpacing(15);

        ImageView homeimg1 = new ImageView();
        v2.getChildren().add(homeimg1);
        homeimg1.setImage(new Image("home.png"));
        homeimg1.setFitHeight(40);
        homeimg1.setFitWidth(40);
        homeimg1.setPickOnBounds(true);
        homeimg1.setPreserveRatio(true);

        ImageView data1 = new ImageView();
        v2.getChildren().add(data1);
        data1.setImage(new Image("data.png"));
        data1.setFitHeight(40);
        data1.setFitWidth(40);
        data1.setPickOnBounds(true);
        data1.setPreserveRatio(true);


        v2.getChildren().add(add1);
        add1.setImage(new Image("add.png"));
        add1.setFitHeight(40);
        add1.setFitWidth(40);
        add1.setPickOnBounds(true);
        add1.setPreserveRatio(true);


        AnchorPane pane22 = new AnchorPane();
        pane22.setLayoutX(72);
        pane22.setLayoutY(54);
        pane22.setPrefWidth(150);
        pane22.setPrefHeight(511);
        pane22.setStyle("-fx-background-color: white;");
        pane.getChildren().add(pane22);


        VBox v22 = new VBox();
        pane22.getChildren().add(v22);
        v22.setLayoutY(23);
        v22.setPrefWidth(150);
        v22.setPrefHeight(438);
        v22.setSpacing(15);


        btHome.setAlignment(Pos.BASELINE_LEFT);
        btHome.setPrefHeight(40);
        btHome.setPrefWidth(175);
        btHome.setFont(new Font(16));
        btHome.setStyle(
                "-fx-cursor: hand;" +
                        " -fx-background-color: transparent;" +
                        "    -fx-text-fill: Black;");
        v22.getChildren().add(btHome);

        btData.setAlignment(Pos.BASELINE_LEFT);
        btData.setPrefHeight(40);
        btData.setPrefWidth(175);
        btData.setFont(new Font(16));
        btData.setStyle(
                "-fx-cursor: hand; " +
                        " -fx-background-color: transparent;" +
                        "    -fx-text-fill: Black;");
        v22.getChildren().add(btData);

        btAdd.setAlignment(Pos.BASELINE_LEFT);
        btAdd.setPrefHeight(40);
        btAdd.setPrefWidth(220);
        btAdd.setFont(new Font(16));
        btAdd.setStyle(
                "-fx-cursor: hand; " +
                        " -fx-background-color: transparent;" +
                        "    -fx-text-fill: Black;");
        v22.getChildren().add(btAdd);


        v2.getChildren().add(userDataimg);
        userDataimg.setImage(new Image("user.png"));
        userDataimg.setFitHeight(40);
        userDataimg.setFitWidth(40);
        userDataimg.setPickOnBounds(true);
        userDataimg.setPreserveRatio(true);

        v2.getChildren().add(addUserImg);
        addUserImg.setImage(new Image("add.png"));
        addUserImg.setFitHeight(40);
        addUserImg.setFitWidth(40);
        addUserImg.setPickOnBounds(true);
        addUserImg.setPreserveRatio(true);

        btUserData.setAlignment(Pos.BASELINE_LEFT);
        btUserData.setPrefHeight(40);
        btUserData.setPrefWidth(220);
        btUserData.setFont(new Font(16));
        btUserData.setStyle(
                "-fx-cursor: hand; " +
                        " -fx-background-color: transparent;" +
                        "    -fx-text-fill: Black;");
        v22.getChildren().add(btUserData);

        btAddUser.setAlignment(Pos.BASELINE_LEFT);
        btAddUser.setPrefHeight(40);
        btAddUser.setPrefWidth(220);
        btAddUser.setFont(new Font(16));
        btAddUser.setStyle(
                "-fx-cursor: hand; " +
                        " -fx-background-color: transparent;" +
                        "    -fx-text-fill: Black;");
        v22.getChildren().add(btAddUser);

        black.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), pane22);
        translateTransition.setByX(-600);
        translateTransition.play();

        final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
        final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color; -fx-cursor: hand;";

        btHome.setStyle(IDLE_BUTTON_STYLE);
        btHome.setOnMouseEntered(e -> btHome.setStyle(HOVERED_BUTTON_STYLE));
        btHome.setOnMouseExited(e -> btHome.setStyle(IDLE_BUTTON_STYLE));

        btData.setStyle(IDLE_BUTTON_STYLE);
        btData.setOnMouseEntered(e -> btData.setStyle(HOVERED_BUTTON_STYLE));
        btData.setOnMouseExited(e -> btData.setStyle(IDLE_BUTTON_STYLE));

        btAdd.setStyle(IDLE_BUTTON_STYLE);
        btAdd.setOnMouseEntered(e -> btAdd.setStyle(HOVERED_BUTTON_STYLE));
        btAdd.setOnMouseExited(e -> btAdd.setStyle(IDLE_BUTTON_STYLE));

        btUserData.setStyle(IDLE_BUTTON_STYLE);
        btUserData.setOnMouseEntered(e -> btUserData.setStyle(HOVERED_BUTTON_STYLE));
        btUserData.setOnMouseExited(e -> btUserData.setStyle(IDLE_BUTTON_STYLE));

        btAddUser.setStyle(IDLE_BUTTON_STYLE);
        btAddUser.setOnMouseEntered(e -> btAddUser.setStyle(HOVERED_BUTTON_STYLE));
        btAddUser.setOnMouseExited(e -> btAddUser.setStyle(IDLE_BUTTON_STYLE));

        burger.setOnMouseClicked(event -> {


            black.setVisible(true);

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), black);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane22);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });


        black.setOnMouseClicked(event -> {

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), black);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                black.setVisible(false);
            });


            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane22);
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });


        logedIn.setPrefHeight(332);
        logedIn.setPrefWidth(528);
        logedIn.setLayoutX(314);
        logedIn.setLayoutY(116);
        pane.getChildren().add(logedIn);

        ImageView logedinPic = new ImageView();
        logedinPic.setImage(new Image("Logedin.png"));
        logedinPic.setLayoutY(16);
        logedinPic.setLayoutX(175);
        logedinPic.setFitHeight(200);
        logedinPic.setFitWidth(200);
        logedIn.getChildren().add(logedinPic);

        Label hi = new Label("WELCOME");
        hi.setLayoutX(234);
        hi.setLayoutY(206);
        hi.setPrefHeight(80);
        hi.setPrefWidth(100);
        hi.setFont(new Font(22));
        logedIn.getChildren().add(hi);


        AddCd cE = new AddCd();
        addpane = cE.show();
        addpane.setLayoutX(230);
        addpane.setLayoutY(70);
        addpane.setVisible(false);
        pane.getChildren().add(addpane);

        AddEmployee addE = new AddEmployee();
        addUserpane = addE.show();
        addUserpane.setLayoutX(230);
        addUserpane.setLayoutY(70);
        addUserpane.setVisible(false);
        pane.getChildren().add(addUserpane);

        welcome.setLayoutX(196);
        welcome.setLayoutY(262);
        welcome.setPrefHeight(20);
        welcome.setPrefWidth(230);
        hi.setFont(new Font(18));
        logedIn.getChildren().add(welcome);
    }

}