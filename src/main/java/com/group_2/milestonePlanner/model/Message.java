package com.group_2.milestonePlanner.model;


public class Message {
    String text;

    public Message(String text){
        this.text = text;
    }

    public String displayMessage(){
        System.out.println(text);
        return text;
    }
}
