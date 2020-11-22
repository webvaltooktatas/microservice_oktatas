package hu.webvalto.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogolasAspect {

    Logger logger = LoggerFactory.getLogger(LogolasAspect.class);

    @Around("execution(public * hu.webvalto.controller.AdobevallasController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("Meghivasra kerult: " + joinPoint.getSignature()+", params=" + Arrays.asList(joinPoint.getArgs()));

        Object proceed = joinPoint.proceed();

        logger.debug("Befejezodott : " + joinPoint.getSignature());
        return proceed;
    }
}
