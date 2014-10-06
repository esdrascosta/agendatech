package utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FromNowValidator.class)
@play.data.Form.Display(name="constraint.fromNow")
public @interface FromNow {

	String message() default "error.frowNow";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
