package controller;

import database.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Item;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.List;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;




public class AddItem {

    @FXML
    public Label lbl1;
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtQty;
    public TextField txtDesc;
    public TextField deleteId;
    public TableColumn colId;
    public  TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public  TableColumn colDesc;


    public TableView table1;



    public void initialize() {
        generateItemId();

    }

    public void generateItemId() {
        if (dbConnection.getInstance().getDBList().isEmpty()) {
            lbl1.setText("I001");
        } else {
            List<Item> itemList = dbConnection.getInstance().getDBList();
            String lastId = itemList.get(itemList.size() - 1).getId();
            int lastIdNum = Integer.parseInt(lastId.substring(1));
            lbl1.setText(String.format("I%03d", lastIdNum + 1));
        }
    }
    public void btnAddItemOnAction(ActionEvent actionEvent) {
        String id = lbl1.getText();
        String name = txtName.getText();
        Integer qty = Integer.valueOf(txtQty.getText());
        String desc= txtDesc.getText();
        Double price = Double.parseDouble(txtPrice.getText());


        Item item = new Item(id, name, qty, price, desc);
        dbConnection.getInstance().getDBList().add(item);
        loadTable();
        generateItemId();

        txtName.clear();
        txtQty.clear();
        txtPrice.clear();
        txtDesc.clear();
    }
    public void btnDeleteItem(ActionEvent actionEvent) {
        List<Item> itemList = dbConnection.getInstance().getDBList();
        String id=deleteId.getText();
        Item toRemove=null;

        for (Item item : itemList) {
            if (item.getId().equalsIgnoreCase(id)) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            itemList.remove(toRemove);
            loadTable(); // Refresh table view
            deleteId.clear();
        }



    }

    private void loadTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));


        ObservableList<Item> ItemObservableList = FXCollections.observableArrayList();

        dbConnection.getInstance().getDBList().forEach(item -> {
            ItemObservableList.add(item);
        });

        table1.setItems(ItemObservableList);
    }

    public void btnViewAll(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/viewAll.fxml"))));
        stage.show();
    }

   }