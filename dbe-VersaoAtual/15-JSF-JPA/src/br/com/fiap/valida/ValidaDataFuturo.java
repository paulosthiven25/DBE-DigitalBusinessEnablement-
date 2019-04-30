package br.com.fiap.valida;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dataFuturo")
public class ValidaDataFuturo implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		Date data = (Date) arg2;

		if (data.after(new Date())) {
			throw new ValidatorException(new FacesMessage("Data inválida"));
		}

	}

}
