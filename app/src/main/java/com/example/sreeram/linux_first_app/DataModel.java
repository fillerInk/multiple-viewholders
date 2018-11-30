package com.example.sreeram.linux_first_app;

public class DataModel  {

    String heading;
    String description;

    public DataModel(String heading, String description){
        this.heading = heading;
        this.description = description;
    }

    public String getHeading(){
        return this.heading;
    }

    public String getDescription(){
        return this.description;
    }

}
