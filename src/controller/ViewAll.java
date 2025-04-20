package controller;

import database.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;




import model.Item;

    public class ViewAll {

        public TableView table3;
        public TableColumn colId;
        public  TableColumn colName;
        public TableColumn colQty;
        public TableColumn colPrice;
        public  TableColumn colDesc;


        public void btnViewOnAction(ActionEvent actionEvent) {

            loadTable();
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


            table3.setItems(ItemObservableList);

    }

}
