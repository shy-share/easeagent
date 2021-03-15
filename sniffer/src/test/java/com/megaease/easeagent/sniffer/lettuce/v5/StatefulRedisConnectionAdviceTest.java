package com.megaease.easeagent.sniffer.lettuce.v5;

import com.megaease.easeagent.core.Classes;
import com.megaease.easeagent.core.Definition;
import com.megaease.easeagent.core.DynamicFieldAccessor;
import com.megaease.easeagent.sniffer.lettuce.v5.advice.GenStatefulRedisConnectionAdvice;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;
import io.lettuce.core.resource.ClientResources;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class StatefulRedisConnectionAdviceTest {

    @SuppressWarnings("unchecked")
    @Test
    public void success() {
        Definition.Default def = new GenStatefulRedisConnectionAdvice().define(Definition.Default.EMPTY);
        ClassLoader loader = this.getClass().getClassLoader();
        List<Class<?>> classList = Classes.transform(this.getClass().getName() + "$MyStatefulRedisConnection")
                .with(def)
                .load(loader);
        Class<MyStatefulRedisConnection> conClass = (Class<MyStatefulRedisConnection>) classList.get(0);
        Assert.assertTrue(DynamicFieldAccessor.class.isAssignableFrom(conClass));
    }

    static class MyStatefulRedisConnection implements StatefulRedisConnection<String, String> {

        @Override
        public boolean isMulti() {
            return false;
        }

        @Override
        public RedisCommands<String, String> sync() {
            return null;
        }

        @Override
        public RedisAsyncCommands<String, String> async() {
            return null;
        }

        @Override
        public RedisReactiveCommands<String, String> reactive() {
            return null;
        }

        @Override
        public void setTimeout(Duration timeout) {

        }

        @Override
        public void setTimeout(long timeout, TimeUnit unit) {

        }

        @Override
        public Duration getTimeout() {
            return null;
        }

        @Override
        public <T> RedisCommand<String, String, T> dispatch(RedisCommand<String, String, T> command) {
            return null;
        }

        @Override
        public Collection<RedisCommand<String, String, ?>> dispatch(Collection<? extends RedisCommand<String, String, ?>> redisCommands) {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public CompletableFuture<Void> closeAsync() {
            return null;
        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public ClientOptions getOptions() {
            return null;
        }

        @Override
        public ClientResources getResources() {
            return null;
        }

        @Override
        public void reset() {

        }

        @Override
        public void setAutoFlushCommands(boolean autoFlush) {

        }

        @Override
        public void flushCommands() {

        }
    }
}
