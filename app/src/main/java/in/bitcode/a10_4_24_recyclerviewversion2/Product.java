package in.bitcode.a10_4_24_recyclerviewversion2;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String txtTitle;
    private int price;
    private int imageId;

    public Product(int id , String txtTitle, int price, int imageId){
        this.id = id;
        this.txtTitle = txtTitle;
        this.price = price;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
