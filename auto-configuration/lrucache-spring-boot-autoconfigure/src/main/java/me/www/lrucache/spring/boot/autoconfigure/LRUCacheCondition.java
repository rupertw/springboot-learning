package me.www.lrucache.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: www
 * @date: 2018/5/12 19:35
 * @description: TODO
 */
class LRUCacheCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String annotatedClassName = ((AnnotationMetadata) metadata).getClassName();


        ConditionMessage.Builder message = ConditionMessage.forCondition("LRUCacheCondition", null);
        Environment environment = context.getEnvironment();

        BindResult<LRUCacheType> specified = Binder.get(environment).bind("lrucache.type", LRUCacheType.class);
        if (!specified.isBound()) {
            return ConditionOutcome.match(message.because("do not specify LRUCache type"));
        }

        LRUCacheType required = LRUCacheConfigurations.getType(annotatedClassName);
        if (specified.get() == required) {
            return ConditionOutcome.match(message.because("specify LRUCache type: matched"));
        } else {
            return ConditionOutcome.noMatch(message.because("specify LRUCache type: not matched"));
        }

    }

}
