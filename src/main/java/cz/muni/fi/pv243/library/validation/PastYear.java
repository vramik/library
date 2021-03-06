package cz.muni.fi.pv243.library.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The year must be a number whose value must be lower or equal to this year.
 * 
 * <code>null</code> elements are considered valid
 * 
 * @author <a href="mailto:vramik at redhat.com">Vlastislav Ramik</a>
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {PastYearValidator.class})
public @interface PastYear {
    String message() default "Year cannot be in future.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

    /**
	 * Defines several <code>@PastYear</code> annotations on the same element
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		PastYear[] value();
	}
}
