package ucad.sn.asrservice.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface IaAgent {
    @AliasFor(annotation = Component.class)
    public String value() default "";
}
