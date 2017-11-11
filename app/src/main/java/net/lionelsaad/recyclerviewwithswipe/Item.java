package net.lionelsaad.recyclerviewwithswipe;

/**
 * Created by saadfauzi on 10/8/2017.
 */

public class Item {
    int id;
    String name;
    String description;
    double price;
    String thumbnail;

    public Item(){
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public String getThumbnail(){
        return thumbnail;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setThumbnail (String thumbnail){
        this.thumbnail = thumbnail;
    }
}
