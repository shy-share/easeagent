package com.megaease.plugin.rocketmq.advice;

import com.megaease.easeagent.plugin.Points;
import com.megaease.easeagent.plugin.matcher.ClassMatcher;
import com.megaease.easeagent.plugin.matcher.IClassMatcher;
import com.megaease.easeagent.plugin.matcher.IMethodMatcher;
import com.megaease.easeagent.plugin.matcher.MethodMatcher;
import java.util.Set;

public class RocketMqConsumerAdvice implements Points {

    @Override
    public IClassMatcher getClassMatcher() {
        return ClassMatcher.builder()
            .hasSuperClass("com.rocketmq.client.Consumer")
            .notAbstract()
            .notInterface()
            .build();
    }

    @Override
    public Set<IMethodMatcher> getMethodMatcher() {
        return MethodMatcher.builder().named("handleDelivery")
            .build()
            .toSet();
    }

    @Override
    public boolean isAddDynamicField() {
        return true;
    }
}
