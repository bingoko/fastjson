package com.alibaba.json.bvt.parser;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;

import junit.framework.TestCase;

public class ReadOnlyAtomicLongTest extends TestCase {

    public void test_readOnly() throws Exception {
        Model model = new Model();
        model.value.set(1001);

        String text = JSON.toJSONString(model);
        Assert.assertEquals("{\"value\":1001}", text);
        Model model2 = JSON.parseObject(text, Model.class);
        Assert.assertEquals(model.value.get(), model2.value.get());
    }

    public static class Model {
        private final AtomicLong value = new AtomicLong();

        public AtomicLong getValue() {
            return value;
        }

    }
}
