package com.mayoo.Exceptions;

public class FlatIdPictogramsNotFound extends CustomException {
    private FlatIdPictogramsNotFound(String message) {
        super(message);
    }
    
    public FlatIdPictogramsNotFound(long id) {
        this(String.format("l'id %d n'existe pas"));
    }
}
