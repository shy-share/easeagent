package com.megaease.plugin.rocketmq.advice;

import com.megaease.easeagent.plugin.Points;
import com.megaease.easeagent.plugin.matcher.ClassMatcher;
import com.megaease.easeagent.plugin.matcher.IClassMatcher;
import com.megaease.easeagent.plugin.matcher.IMethodMatcher;
import com.megaease.easeagent.plugin.matcher.MethodMatcher;
import java.util.Set;

public class RocketMqChannelAdvice implements Points {
    public IClassMatcher getClassMatcher() {
        return ClassMatcher.builder().hasInterface("com.rocketmq.client.Channel")
            .notAbstract()
            .notInterface()
            .build();
    }

    public Set<IMethodMatcher> getMethodMatcher() {
        return MethodMatcher.multiBuilder()
            .match(MethodMatcher.builder().named("basicPublish")
                .isPublic()
                .argsLength(6)
                .returnType("void")
                .qualifier("basicPublish")
                .build())
            .match(MethodMatcher.builder().named("basicConsume")
                .isPublic()
                .argsLength(7)
                .qualifier("basicConsume")
                .build())
            .build();
    }

    public boolean isAddDynamicField() {
        return false;
    }
}
