package model;

public class Item {
    private String id;
    private String name;
    private Integer qty;
    private String desc;

    private Double price;

    public Item(String id, String name, Integer qty,  Double price,String desc) {
        this.id = id;
        this.name = name;
        this.qty=qty;
        this.desc=desc;
        this.price=price;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc=desc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty=qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Qty='" + qty + '\'' +
                ", Price='" + price + '\'' +
                ", Description='" + desc + '\'' +

                '}';
    }

}
