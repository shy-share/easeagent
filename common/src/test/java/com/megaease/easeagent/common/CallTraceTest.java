package com.megaease.easeagent.common;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import org.junit.Test;

import static com.google.common.collect.Iterables.size;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CallTraceTest {

    @Test
    public void should_trace_call_tree() throws Exception {
        final String root = "root";
        final String child = "child";
        final String boy = "boy";
        final Supplier<String> rootSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return root;
            }
        };
        final Supplier<String> childSupplier = new Supplier<String>() {

            @Override
            public String get() {
                return child;
            }
        };

        final CallTrace trace = new CallTrace();
        assertFalse(trace.fork(childSupplier));

        assertTrue(trace.pushIfRoot(rootSupplier));
        assertFalse(trace.pushIfRoot(rootSupplier));

        assertTrue(trace.fork(childSupplier));
        trace.join(new Function<CallTrace.Frame, String>() {
            @Override
            public String apply(CallTrace.Frame input) {
                assertThat(input.<String>context(), is(child));
                return boy;
            }
        });

        final CallTrace.Frame frame = trace.pop();
        assertThat(frame.<String>context(), is(root));
        final Iterable<String> contexts = Iterables.transform(frame.children(), new Function<CallTrace.Frame, String>() {
            @Override
            public String apply(CallTrace.Frame input) {
                return input.context();
            }
        });

        assertThat(size(contexts), is(1));
        assertThat(contexts, hasItem(boy));
    }
}