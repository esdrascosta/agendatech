package utils;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.FutureValidatorForCalendar;

public class FromNowValidator implements ConstraintValidator<FromNow, Calendar> {

	private FutureValidatorForCalendar futureValidator =
			new FutureValidatorForCalendar();
	
	@Override
	public void initialize(FromNow fromNow) {

	}

	@Override
	public boolean isValid(Calendar date,
			ConstraintValidatorContext constraintValidatorContext) {

		if (date == null)
			return true;

		Calendar hoje = Calendar.getInstance();
		
		return mesmoDia(hoje, date) || futureValidator.isValid(date
				, constraintValidatorContext); 
	}

	private boolean mesmoDia(Calendar hoje, Calendar data) {
		return hoje.get(Calendar.DAY_OF_MONTH) == data
				.get(Calendar.DAY_OF_MONTH)
				&& hoje.get(Calendar.MONTH) == data.get(Calendar.MONTH)
				&& hoje.get(Calendar.YEAR) == data.get(Calendar.YEAR);
	}
}
