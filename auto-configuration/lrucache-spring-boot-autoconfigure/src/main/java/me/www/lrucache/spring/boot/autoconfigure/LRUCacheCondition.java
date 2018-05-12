package me.www.lrucache.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;

/**
 * @author: www
 * @date: 2018/5/12 19:35
 * @description: TODO
 */
class LRUCacheCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String sourceClass = "";
        if (metadata instanceof ClassMetadata) {
            sourceClass = ((ClassMetadata) metadata).getClassName();
        }
        ConditionMessage.Builder message = ConditionMessage.forCondition("LRUCache", sourceClass);
        Environment environment = context.getEnvironment();
        try {
            BindResult<LRUCacheType> specified = Binder.get(environment).bind("lrucache.type", LRUCacheType.class);
            if (!specified.isBound()) {
                return ConditionOutcome.match(message.because("automatic LRUCache type"));
            }
            LRUCacheType required = LRUCacheConfigurations.getType(((AnnotationMetadata) metadata).getClassName());
            if (specified.get() == required) {
                return ConditionOutcome.match(message.because(specified.get() + " LRUCache type"));
            }
        } catch (BindException ex) {
        }
        return ConditionOutcome.noMatch(message.because("unknown LRUCache type"));
    }

}
