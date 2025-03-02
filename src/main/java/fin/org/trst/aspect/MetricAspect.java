package fin.org.trst.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {

    private final MeterRegistry meterRegistry;

    public MetricAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(fin.org.trst.annotation.TrackMetric)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            Object result = joinPoint.proceed();
            sample.stop(Timer.builder("client_account_service")
                    .tag("method", methodName)
                    .tag("status", "success")
                    .register(meterRegistry));
            return result;
        } catch (Throwable throwable) {
            sample.stop(Timer.builder("client_account_service")
                    .tag("method", methodName)
                    .tag("status", "error")
                    .register(meterRegistry));
            throw throwable;
        }
    }
}