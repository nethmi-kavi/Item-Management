package database;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class dbConnection {




    private static dbConnection instance;
    private List <Item> itemList;
    private dbConnection(){
        itemList = new ArrayList<>();
    }
    public List<Item> getDBList(){
        return itemList;
    }
    public static dbConnection getInstance(){
        return instance==null?instance=new dbConnection():instance;

    }
}
