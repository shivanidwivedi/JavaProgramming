package design_questions.online.book.reader.modules;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shivanidwivedi on 18/10/20
 * @project JavaProgramming
 */
@Slf4j
public class LoggingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info(String.format("Before: ", methodInvocation.getMethod().getName()));
        Object result = methodInvocation.proceed();
        log.info(String.format("After: ", methodInvocation.getMethod().getName()));
        return result;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CallTracker {}
