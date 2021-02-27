/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentpizza;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AssignmentPizza extends Application {

    public static Customer cus = new Customer();
    public static Topping pizza[] = new Topping[10];
    public static String address[] = new String[6];
    static int pizzanum = 0;
    static int adresss = 2;
    static int size, topping1, topping2, topping3;
    static String namefield, numberfield, adrressfield;

    BorderPane root = new BorderPane();
    Scene scene;
    Button order = new Button("Order"), exit = new Button("Exit"), continuebtn = new Button("Continue"), yesT = new Button("Yes"), noT = new Button("No"), yesbtnP = new Button("Yes"), nobtnP = new Button("No"), yesbtnS = new Button("Yes"), nobtnS = new Button("No"), yesbtnM = new Button("Yes"), nobtnM = new Button("No"), yesPizza = new Button("Yes"), noPizza = new Button("No"),
            Confirm_Order = new Button("Confirm"), Cancel_Order = new Button("Cancel"), Leave = new Button("Leave"), addAdress = new Button("Add"), confirmAdress = new Button("Confirm"), addNewAdress = new Button("Add"), cancelAdress = new Button("Cancel");
    RadioButton small = new RadioButton("Small \nRM8"), medium = new RadioButton("Medium \nRM10"), big = new RadioButton("Big \nRM12");
    Image MainImage, BigPic, MediumPic, SmallPic;
    VBox title;
    TextField nameT, phoneNumberT, selectAdress;
    TextArea adrressT, NewAddress, receiptArea;

    @Override
    public void start(Stage primaryStage) {
        Menu();
        scene = new Scene(root);
        primaryStage.getIcons().add(new Image(AssignmentPizza.class.getResourceAsStream("image/pizza.png")));
        primaryStage.setTitle("Pizza Deliver System");
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(600);
        primaryStage.show();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        exit.setOnAction(a -> {
            Exit();
        });
        order.setOnAction(b -> {
            Information();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        continuebtn.setOnAction(d -> {
            ImageIcon icon = new ImageIcon(AssignmentPizza.class.getResource("image/bye.png"));
            int i = 0;
            if (small.isSelected()) {
                int confirm = JOptionPane.showConfirmDialog(null, "Conform Your Select ?", "Pizza Deliver System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                if (confirm == 0) {
                    size = 1;
                    ThirdPage();
                } else {
                    SecondPage();
                }
            } else if (medium.isSelected()) {
                int confirm = JOptionPane.showConfirmDialog(null, "Conform Your Select ?", "Pizza Deliver System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                if (confirm == 0) {
                    size = 2;
                    ThirdPage();
                } else {
                    SecondPage();
                }
            } else if (big.isSelected()) {
                int confirm = JOptionPane.showConfirmDialog(null, "Conform Your Select ?", "Pizza Deliver System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                if (confirm == 0) {
                    size = 3;
                    ThirdPage();
                } else {
                    SecondPage();
                }
            } else {
                JOptionPane.showMessageDialog(null, "   Please Select The Pizza Size !", "WARNING", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        yesT.setOnAction(e -> {
            ForthPage();
        });
        noT.setOnAction(e -> {
            CreateNoTop();
            SeventhPage();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        yesbtnP.setOnAction(e -> {
            topping1 = 1;
            FifthPage();
        });
        nobtnP.setOnAction(e -> {
            topping1 = 0;
            FifthPage();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        yesbtnS.setOnAction(f -> {
            topping2 = 2;
            SixthPage();
        });
        nobtnS.setOnAction(f -> {
            topping2 = 0;
            SixthPage();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        yesbtnM.setOnAction(g -> {
            if (pizzanum == 9) {
                JOptionPane.showMessageDialog(null, "Maximum can choose 10 pizza", "Warning", JOptionPane.INFORMATION_MESSAGE);
                topping3 = 3;
                Create();
                ChangeAdress();
            } else {
                topping3 = 3;
                Create();
                SeventhPage();
            }

        });
        nobtnM.setOnAction(g -> {
            if (pizzanum == 9) {
                JOptionPane.showMessageDialog(null, "Maximum can choose 10 pizza", "Warning", JOptionPane.INFORMATION_MESSAGE);
                topping3 = 0;
                Create();
                ChangeAdress();
            } else {
                topping3 = 0;
                Create();
                SeventhPage();
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        yesPizza.setOnAction(g -> {
            pizzanum++;
            SecondPage();
        });
        noPizza.setOnAction(g -> {
            ChangeAdress();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Confirm_Order.setOnAction(g -> {
            namefield = nameT.getText();
            numberfield = phoneNumberT.getText();
            adrressfield = adrressT.getText();
            if (namefield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field should not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!validName(namefield)) {
                JOptionPane.showMessageDialog(null, "The Field cannot have number or spacing", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (numberfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field should not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!validPhoneNumber(numberfield)) {
                JOptionPane.showMessageDialog(null, "The Phone Number Format is wrong \n              ex. 000-0000000", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (adrressfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field should not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                ImageIcon icon = new ImageIcon(AssignmentPizza.class.getResource("image/bye.png"));
                int confirm = JOptionPane.showConfirmDialog(null, "Confirm your Information ?", "Pizza Deliver System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                if (confirm == 0) {
                    cus = new Customer(namefield, numberfield, adrressfield);
                    SecondPage();
                } else {
                    Information();
                }
            }
        });
        Cancel_Order.setOnAction(g -> {
            Menu();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Leave.setOnAction(g -> {
            ImageIcon icon = new ImageIcon(AssignmentPizza.class.getResource("image/bye.png"));
            JOptionPane.showMessageDialog(null, "Goodbye Please wait for your Pizza", "Pizza Deliver System", JOptionPane.INFORMATION_MESSAGE, icon);
            reset();
            Menu();
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        addAdress.setOnAction(g -> {
            if (adresss == 6) {
                JOptionPane.showMessageDialog(null, "Maximum is about 5 Address", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                addAdress();
            }
        });
        confirmAdress.setOnAction(g -> {
            String selectAd = selectAdress.getText();
            try {
                if (selectAd.equals("")) {
                    JOptionPane.showMessageDialog(null, "Text Field should not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (selectAd.equals("1")) {
                    NinehtPage();
                } else {
                    int selNum = Integer.parseInt(selectAd);
                    address[selNum].toString();
                    String newSelectAdress = address[selNum].toString();
                    cus = new Customer(namefield, numberfield, newSelectAdress);
                    JOptionPane.showMessageDialog(null, "Select sucessful", "Warning", JOptionPane.WARNING_MESSAGE);
                    NinehtPage();
                }
            } catch (NumberFormatException z) {
                JOptionPane.showMessageDialog(null, "Cannot be Alphabet !\nPlease Check again!", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException y) {
                JOptionPane.showMessageDialog(null, "No this Selection !\nPlease Check again!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        addNewAdress.setOnAction(g -> {
            String newAdre = NewAddress.getText();
            if (newAdre.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field should not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Added sucessful", "Warning", JOptionPane.WARNING_MESSAGE);
                address[adresss] = new String(newAdre);
                adresss++;
                ChangeAdress();
            }
        });
        cancelAdress.setOnAction(g -> {
            ChangeAdress();
        });
    }

    public void NinehtPage() {
        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=RECIEPT=-  ");
        a.setFont(Font.font("Bowlby One SC", 50));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        Leave.setMinSize(300, 60);
        button.getChildren().add(Leave);

        VBox Receipt = new VBox();
        HBox line1 = new HBox();
        Text name = new Text("Name                  : ");
        name.setFont(Font.font("Bowlby One SC", 15));
        Text name2 = new Text(cus.getName());

        name2.setFont(Font.font("Bowlby One SC", 15));
        line1.getChildren().addAll(name, name2);

        HBox line2 = new HBox();
        Text phoneNumber = new Text("Phone Number : ");
        phoneNumber.setFont(Font.font("Bowlby One SC", 15));
        Text phoneNumber2 = new Text(cus.getPhoneNumber());
        phoneNumber2.setFont(Font.font("Bowlby One SC", 15));
        line2.getChildren().addAll(phoneNumber, phoneNumber2);

        HBox line3 = new HBox();
        Text adrress = new Text("Adrress             : ");
        adrress.setFont(Font.font("Bowlby One SC", 15));
        Text adrress2 = new Text(cus.getAddress());
        adrress2.setFont(Font.font("Bowlby One SC", 15));
        line3.getChildren().addAll(adrress, adrress2);

        VBox line4 = new VBox();
        Text Total = new Text("Total Price : " + price());
        Total.setFont(Font.font("Bowlby One SC", 15));
        line4.getChildren().add(Total);

        HBox line5 = new HBox();

        Text Detail = new Text(detail());
        Detail.setFont(Font.font("Bowlby One SC", 15));
        receiptArea = new TextArea();
        receiptArea.setEditable(false);
        receiptArea.setPrefSize(250, 150);
        receiptArea.setText(detail());
        receiptArea.setStyle("-fx-background-color:black;-fx-control-inner-background:#F7F7F7;");
        receiptArea.setWrapText(true);
        line5.getChildren().addAll(receiptArea);
        ;

        Receipt.getChildren().addAll(line1, line2, line3, line4, line5);
        Receipt.setAlignment(Pos.TOP_CENTER);
        line1.setAlignment(Pos.TOP_LEFT);
        line2.setAlignment(Pos.TOP_LEFT);
        line3.setAlignment(Pos.TOP_LEFT);
        line4.setAlignment(Pos.TOP_CENTER);
        line5.setAlignment(Pos.TOP_CENTER);

        bottom.getChildren().addAll(Receipt, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
    }

    public void addAdress() {
        title = new VBox();
        VBox text = new VBox();
        Text a = new Text("    -=New Address=-  ");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        text.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);

        VBox textbox = new VBox();
        VBox line1 = new VBox();
        Text address = new Text("Adress");
        address.setFont(Font.font("Bowlby One SC", 15));
        NewAddress = new TextArea();
        NewAddress.setPrefHeight(100);
        NewAddress.setPrefWidth(100);
        line1.getChildren().addAll(address, NewAddress);
        textbox.getChildren().addAll(line1);
        textbox.setAlignment(Pos.CENTER_LEFT);
        textbox.setSpacing(30);
        line1.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        addNewAdress.setMinSize(150, 60);
        cancelAdress.setMinSize(150, 60);
        button.getChildren().addAll(addNewAdress, cancelAdress);

        bottom.getChildren().addAll(textbox, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

    }

    public void ChangeAdress() {
        title = new VBox();
        VBox text = new VBox();
        Text a = new Text("  -=Want to change Address=-  ");
        a.setFont(Font.font("Bowlby One SC", 25));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        text.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);

        VBox textbox = new VBox();
        VBox line1 = new VBox();
        Text adress = new Text("~Address~" + "\n1 )" + cus.getAddress() + "\n" + New());
        adress.setFont(Font.font("Bowlby One SC", 15));
        line1.getChildren().add(adress);
        line1.setSpacing(20);
        HBox line3 = new HBox();
        Text select = new Text("You can select the Address : \nfrom top side");
        select.setFont(Font.font("Bowlby One SC", 15));
        selectAdress = new TextField();
        selectAdress.setPrefHeight(40);
        selectAdress.setPrefWidth(30);
        line3.getChildren().addAll(select, selectAdress);
        textbox.getChildren().addAll(line1, line3);
        line1.setAlignment(Pos.CENTER);
        line3.setAlignment(Pos.CENTER);
        textbox.setAlignment(Pos.CENTER);
        textbox.setSpacing(10);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        addAdress.setMinSize(150, 60);
        confirmAdress.setMinSize(150, 60);
        button.getChildren().addAll(addAdress, confirmAdress);

        bottom.getChildren().addAll(textbox, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

    }

    public void Information() {
        title = new VBox();
        VBox text = new VBox();
        Text a = new Text("  -=Give The Information=-  ");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        text.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);

        VBox textbox = new VBox();
        HBox line1 = new HBox();
        Text name = new Text("Name                  : ");
        name.setFont(Font.font("Bowlby One SC", 15));
        nameT = new TextField();
        line1.getChildren().addAll(name, nameT);

        HBox line2 = new HBox();
        Text phoneNumber = new Text("Phone Number : ");
        phoneNumber.setFont(Font.font("Bowlby One SC", 15));
        phoneNumberT = new TextField();
        phoneNumberT.setPromptText("ex. 000-0000000");
        line2.getChildren().addAll(phoneNumber, phoneNumberT);

        HBox line3 = new HBox();
        Text adrress = new Text("Adrress             : ");
        adrress.setFont(Font.font("Bowlby One SC", 15));
        adrressT = new TextArea();
        adrressT.setPrefHeight(100);
        adrressT.setPrefWidth(300);
        line3.getChildren().addAll(adrress, adrressT);
        textbox.getChildren().addAll(line1, line2, line3);
        textbox.setAlignment(Pos.CENTER);
        textbox.setSpacing(30);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        Confirm_Order.setMinSize(150, 60);
        Cancel_Order.setMinSize(150, 60);
        button.getChildren().addAll(Confirm_Order, Cancel_Order);

        bottom.getChildren().addAll(textbox, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

    }

    public void SeventhPage() {
        title = new VBox();
        VBox text = new VBox();
        Text a = new Text("  -=Did you want to add more Pizza?=-  ");
        a.setFont(Font.font("Bowlby One SC", 20));
        Text b = new Text("             RM" + price() + "             ");
        b.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().addAll(a, b);
        title.getChildren().add(text);
        root.setTop(title);
        text.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        yesPizza.setMinSize(150, 60);
        noPizza.setMinSize(150, 60);
        button.getChildren().addAll(yesPizza, noPizza);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/main.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(150);
        pizza1.setFitWidth(220);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(58);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

    }

    public void SixthPage() {
        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=Did you want add Mushroom  ?=-  \n                              RM2");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        yesbtnM.setMinSize(150, 60);
        nobtnM.setMinSize(150, 60);
        button.getChildren().addAll(yesbtnM, nobtnM);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/mushroom.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(200);
        pizza1.setFitWidth(220);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
    }

    public void FifthPage() {
        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=Did you want add Sausage ?=-  \n                            RM2");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        yesbtnS.setMinSize(150, 60);
        nobtnS.setMinSize(150, 60);
        button.getChildren().addAll(yesbtnS, nobtnS);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/sausage.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(220);
        pizza1.setFitWidth(220);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(20);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
    }

    public void ForthPage() {
        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=Did you want add Pepperoni ?=-  \n                             RM2");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        yesbtnP.setMinSize(150, 60);
        nobtnP.setMinSize(150, 60);
        button.getChildren().addAll(yesbtnP, nobtnP);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/pepperoni.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(200);
        pizza1.setFitWidth(200);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
    }

    public void ThirdPage() {
        title = new VBox();
        VBox text = new VBox();
        Text a = new Text("  -=Did you want add Some Topping ?=-  ");
        a.setFont(Font.font("Bowlby One SC", 20));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        text.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        yesT.setMinSize(150, 60);
        noT.setMinSize(150, 60);
        button.getChildren().addAll(yesT, noT);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/main.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(170);
        pizza1.setFitWidth(240);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(101);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
    }

    public void SecondPage() {
        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=Select Your Pizza Size=-  ");
        a.setFont(Font.font("Bowlby One SC", 30));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox center = new VBox();
        HBox sizePic = new HBox();
        StackPane img = new StackPane();
        StackPane img2 = new StackPane();
        StackPane img3 = new StackPane();
        sizePic.setSpacing(50);
        BigPic = new Image(AssignmentPizza.class.getResourceAsStream("image/big.png"));
        ImageView Bigpic = new ImageView(BigPic);
        Bigpic.setFitHeight(100);
        Bigpic.setFitWidth(100);
        MediumPic = new Image(AssignmentPizza.class.getResourceAsStream("image/medium.png"));
        ImageView mediumpic = new ImageView(MediumPic);
        mediumpic.setFitHeight(100);
        mediumpic.setFitWidth(100);
        SmallPic = new Image(AssignmentPizza.class.getResourceAsStream("image/small.png"));
        ImageView smallpic = new ImageView(SmallPic);
        smallpic.setFitHeight(100);
        smallpic.setFitWidth(100);
        img.getChildren().add(Bigpic);
        img2.getChildren().add(mediumpic);
        img3.getChildren().add(smallpic);
        sizePic.getChildren().addAll(img, img2, img3);

        HBox button1 = new HBox();
        button1.setSpacing(50);
        continuebtn.setMinSize(150, 60);
        button1.getChildren().add(continuebtn);

        HBox radioSize = new HBox();
        ToggleGroup pizza = new ToggleGroup();
        small.setToggleGroup(pizza);
        medium.setToggleGroup(pizza);
        big.setToggleGroup(pizza);
        radioSize.setSpacing(80);

        radioSize.getChildren().addAll(small, medium, big);
        center.getChildren().addAll(sizePic, radioSize, button1);
        center.setSpacing(55);
        root.setCenter(center);
        radioSize.setAlignment(Pos.CENTER);
        button1.setAlignment(Pos.CENTER);
        sizePic.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);

    }

    public void Menu() {

        title = new VBox();
        StackPane text = new StackPane();
        Text a = new Text("  -=Pizza=-  ");
        a.setFont(Font.font("Bowlby One SC", 70));
        text.getChildren().add(a);
        title.getChildren().add(text);
        root.setTop(title);
        title.setAlignment(Pos.CENTER);

        VBox bottom = new VBox();
        HBox button = new HBox();
        button.setSpacing(50);
        order.setMinSize(150, 60);
        exit.setMinSize(150, 60);
        button.getChildren().addAll(order, exit);

        StackPane img = new StackPane();
        MainImage = new Image(AssignmentPizza.class.getResourceAsStream("image/main.png"));
        ImageView pizza1 = new ImageView(MainImage);
        pizza1.setFitHeight(150);
        pizza1.setFitWidth(220);
        img.getChildren().add(pizza1);

        bottom.getChildren().addAll(img, button);
        bottom.setSpacing(40);
        root.setCenter(bottom);
        button.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

    }

    public void Exit() {
        ImageIcon icon = new ImageIcon(AssignmentPizza.class.getResource("image/bye.png"));
        int bye = JOptionPane.showConfirmDialog(null, "Conform Exit?", "Pizza Deliver System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (bye == 0) {
            System.exit(0);
        }
    }

    public String New() {
        String msg = "";
        for (int i = 2; i < address.length; i++) {
            if (address[i] != null) {
                msg += i + ")" + address[i].toString() + "\n";
            } else {
                break;
            }
        }
        return msg;
    }

    public static void reset() {
        Arrays.fill(address, null);
        Arrays.fill(pizza, null);
        pizzanum = 0;
        adresss = 2;
    }

    public static void Create() {
        pizza[pizzanum] = new Topping(size, topping1, topping2, topping3);
        pizza[pizzanum].getPrice();
        pizza[pizzanum].getToppingPrice();
    }

    public static void CreateNoTop() {
        pizza[pizzanum] = new Topping(size, 0, 0, 0);
        pizza[pizzanum].getPrice();
    }

    public String detail() {
        String msg = "";
        for (int i = 0; i < pizza.length; i++) {
            if (pizza[i] != null) {
                msg += (i + 1) + ")" + pizza[i].toString();
            } else {
                break;
            }
        }
        return msg;
    }

    public int price() {
        int price = 0;
        for (int i = 0; i < pizza.length; i++) {
            if (pizza[i] != null) {
                price += pizza[i].getTotal();
            } else {
                break;
            }
        }
        return price;
    }

    public static boolean validPhoneNumber(String input) {
        return input.length() > 10 || input.length() < 12 && input.matches("[0-9]+") && input.matches("-");
    }

    public static boolean validName(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
