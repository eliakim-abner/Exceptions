package br.com.eliakim.validator;

import br.com.eliakim.exception.ValidatorException;
import br.com.eliakim.model.UserModel;

public class UserValidator {

    private UserValidator(){

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (model.getName() == null || model.getName().isEmpty() )
            throw new ValidatorException("Informe um Nome Válido");
        if ( (!model.getEmail().contains("@")) && (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um e-mail válido");
    }
}

