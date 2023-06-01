package com.mayoo.Exceptions;

public class EmailIsEmpty extends CustomException{
    public EmailIsEmpty() {
        super("L'email ne peux pas être vide");
    }
}
