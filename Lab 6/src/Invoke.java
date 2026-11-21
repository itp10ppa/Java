import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Validate({String.class, Integer.class})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Invoke {
}
