package hu.webvalto.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogolasAspect {

    Logger logger = LoggerFactory.getLogger(LogolasAspect.class);

    @Pointcut("execution(public * hu.webvalto.controller.AdobevallasController.*(..))")
    public void method(){}

    @After("method()")
    public void log(){
        logger.debug("Meghivasra kerultem");
    }
}
