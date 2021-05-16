package com.company.design.observer;

public class Button {

    private String name;
    private IButtonListner buttonListner;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        buttonListner.clickEvent(message);
    }

    public void addListener(IButtonListner buttonListner){
        this.buttonListner = buttonListner;
    }
}
