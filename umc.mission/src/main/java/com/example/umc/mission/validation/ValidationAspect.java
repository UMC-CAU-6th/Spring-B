package com.example.umc.mission.validation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    //@Around("execution(* com.example.umc.mission.web.controller.MemberRestController.*(..)) && args(..,@com.example.umc.mission.validation.annotation.CheckPage(*)))")
    /*public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //값 변경 로직 구현
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer num) {
                args[i] = num-1;
            }
        }

        return joinPoint.proceed(args);
    }*/
}
