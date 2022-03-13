package com.megaease.plugin.rocketmq.advice;

import com.megaease.easeagent.plugin.Points;
import com.megaease.easeagent.plugin.matcher.ClassMatcher;
import com.megaease.easeagent.plugin.matcher.IClassMatcher;
import com.megaease.easeagent.plugin.matcher.IMethodMatcher;
import com.megaease.easeagent.plugin.matcher.MethodMatcher;
import java.util.Set;

public class RocketMqPropertyAdvice implements Points {
    @Override
    public IClassMatcher getClassMatcher() {
        return ClassMatcher.builder()
            .hasClassName("org.springframework.boot.autoconfigure.amqp.RabbitProperties")
            .build();
    }

    @Override
    public Set<IMethodMatcher> getMethodMatcher() {
        return MethodMatcher.builder()
            .nameStartWith("set").build().toSet();
    }
}
