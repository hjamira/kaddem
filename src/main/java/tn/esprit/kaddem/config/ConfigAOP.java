package tn.esprit.kaddem.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ConfigAOP {


    @Before("execution(* tn.esprit.kaddem.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("In Method AOP " + joinPoint.getSignature().getName());
    }

    @After("execution(* tn.esprit.kaddem.service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        log.info("Out of Method AOP " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* tn.esprit.kaddem.service.*.*(..))")
    public void logMethodExitSucess(JoinPoint joinPoint) {
        log.info("Out of Method without Errors AOP " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* tn.esprit.kaddem.service.*.*(..))")
    public void logMethodExitErorr(JoinPoint joinPoint) {
        log.info("Out of Method with Errors AOP " + joinPoint.getSignature().getName());
    }

    @Around("execution(* tn.esprit.kaddem.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Methodexecutiontime AOP: " + elapsedTime + " milliseconds.");
        return obj;
    }

}
