package pl.projectE.sec;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FinalsCheckingAspect {
    @Before("set(@pl.projectE.sec.Final * *.*) && !cflowbelow(execution(*.new(..)))")
    public void preventFromChangingFinalReference(JoinPoint thisJoinPoint){
        System.out.println(thisJoinPoint.getSignature().getClass());
        throw new FinalFieldSettingException();
    }
    @Before("set(@pl.projectE.inject.FinalAfterInject * *.*) && !cflow(within(pl.projectE.inject.Injector))")
    public void check(JoinPoint thisJoinPoint){
        throw new FinalFieldSettingException();
    }
}
