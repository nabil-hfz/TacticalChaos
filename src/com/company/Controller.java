package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    public ListView<String> l1;
    @FXML
    public Label lb1, lb2, lb3;
    @FXML
    public TextField tf1;
    @FXML
    public TextField tf2;
    @FXML
    public Text t1;
    @FXML
    public Text t2;
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3, btn4, btn5;
    @FXML
    public TextArea tr1;
    @FXML
    public TextArea tr2;
    @FXML
    public TextArea tr3, tr4, tr5, tr6, tr7;
    @FXML
    public GridPane gr;

    public Label getLb2() {
        return lb2;
    }

    public void setLb2(Label lb2) {
        this.lb2 = lb2;
    }

    public Label getLb3() {
        return lb3;
    }

    public void setLb3(Label lb3) {
        this.lb3 = lb3;
    }

    public Button getBtn4() {
        return btn4;
    }

    public void setBtn4(Button btn4) {
        this.btn4 = btn4;
    }

    public Button getBtn5() {
        return btn5;
    }

    public void setBtn5(Button btn5) {
        this.btn5 = btn5;
    }

    public GridPane getGr() {
        return gr;
    }

    public void setGr(GridPane gr) {
        this.gr = gr;
    }

    public Button getBtn3() {
        return btn3;
    }

    public void setBtn3(Button btn3) {
        this.btn3 = btn3;
    }

    public Label getLb1() {
        return lb1;
    }

    public void setLb1(Label lb1) {
        this.lb1 = lb1;
    }

    public TextArea getTr3() {
        return tr3;
    }

    public void setTr3(TextArea tr3) {
        this.tr3 = tr3;
    }

    public TextArea getTr4() {
        return tr4;
    }

    public void setTr4(TextArea tr4) {
        this.tr4 = tr4;
    }

    public TextArea getTr5() {
        return tr5;
    }

    public void setTr5(TextArea tr5) {
        this.tr5 = tr5;
    }

    public TextArea getTr6() {
        return tr6;
    }

    public void setTr6(TextArea tr6) {
        this.tr6 = tr6;
    }

    public TextArea getTr7() {
        return tr7;
    }

    public void setTr7(TextArea tr7) {
        this.tr7 = tr7;
    }

    public void setTr1(TextArea tr1) {
        this.tr1 = tr1;
    }

    public TextArea getTr1() {
        return tr1;
    }

    public void setTr2(TextArea tr2) {
        this.tr2 = tr2;
    }

    public TextArea getTr2() {
        return tr2;
    }

    public Button getBtn2() {
        return btn2;
    }

    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    public Button getBtn1() {
        return btn1;
    }

    public TextField getTf1() {
        return tf1;
    }

    public TextField getTf2() {
        return tf2;
    }

    public void setT1(Text t1) {
        this.t1 = t1;
    }

    public Text getT1() {
        return t1;
    }

    public void setT2(Text t2) {
        this.t2 = t2;
    }

    public Text getT2() {
        return t2;
    }

    public ListView<String> getL1() {
        return l1;
    }

    public void setL1(ListView<String> l1) {
        this.l1 = l1;
    }


    public void MyNum() {
        lb2.setText(tf1.getText());
    }

    public void ShowItem() { // add the item of list view on bench
        //     ObservableList<String>items =FXCollections.observableArrayList("Ch1","Ch2","Ch3","Ch4","Ch5","Ch6","Ch7","Ch8","Ch9");
        //   l1.getItems().addAll(items);
        l1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (l1.getSelectionModel().getSelectedIndex() == 0) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 1) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));

                } else if (l1.getSelectionModel().getSelectedIndex() == 2) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 3) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 4) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 5) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 6) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 7) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                } else if (l1.getSelectionModel().getSelectedIndex() == 8) {
                    lb3.setText("Selected Champion is :" + String.valueOf(l1.getSelectionModel().getSelectedItems()));
                }
            }
        });
    }

    public void addItem() { // Buy the Champion
        btn1.setOnAction((ActionEvent e) -> {
            if (!tr3.getText().equals("")) {
                l1.getItems().add(tr3.getText());
                l1.getSelectionModel().selectLast();
                tr3.setText("");
            } else if (!tr4.getText().equals("")) {
                l1.getItems().add(tr4.getText());
                l1.getSelectionModel().selectLast();
                tr4.setText("");
            } else if (!tr5.getText().equals("")) {
                l1.getItems().add(tr5.getText());
                l1.getSelectionModel().selectLast();
                tr5.setText("");
            } else if (!tr6.getText().equals("")) {
                l1.getItems().add(tr6.getText());
                l1.getSelectionModel().selectLast();
                tr6.setText("");
            } else if (!tr7.getText().equals("")) {
                l1.getItems().add(tr7.getText());
                l1.getSelectionModel().selectLast();
                tr7.setText("");
            }
        });
    }

    public void SellItem() { // sell the champion
        btn2.setOnAction((ActionEvent e) -> {
            if (l1.getSelectionModel().getSelectedIndex() == 0) {
                tr3.setText(String.valueOf(l1.getSelectionModel().getSelectedItems()));
            } else if (l1.getSelectionModel().getSelectedIndex() == 1) {
                tr4.setText(String.valueOf(l1.getSelectionModel().getSelectedItems()));
            } else if (l1.getSelectionModel().getSelectedIndex() == 2) {
                tr5.setText(String.valueOf(l1.getSelectionModel().getSelectedItems()));
            } else if (l1.getSelectionModel().getSelectedIndex() == 3) {
                tr6.setText(String.valueOf(l1.getSelectionModel().getSelectedItems()));
            } else if (l1.getSelectionModel().getSelectedIndex() == 4) {
                tr7.setText(String.valueOf(l1.getSelectionModel().getSelectedItems()));
            }
        });
    }

    public void addGrid() { // button ok to add the grid
        btn3.setOnAction((ActionEvent e) -> {
            if (l1.getSelectionModel().isSelected(0)) {
                gr.add(l1, 1, 1);
                l1.getItems();
            } else if (l1.getSelectionModel().isSelected(1)) {
                gr.add(l1, 2, 2);
            } else if (l1.getSelectionModel().isSelected(2)) {
                gr.add(l1, 3, 3);
            } else if (l1.getSelectionModel().isSelected(3)) {
                gr.add(l1, 4, 4);
            } else if (l1.getSelectionModel().isSelected(4)) {
                gr.add(l1, 5, 5);
            } else if (l1.getSelectionModel().isSelected(5)) {
                gr.addRow(1, l1);
            }
        });
    }
}