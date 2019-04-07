package main.com.group2.messageBoard.model;


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
