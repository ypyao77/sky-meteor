/*
 * The MIT License (MIT)
 * Copyright © 2019-2020 <sky>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sky.meteor.cluster;


import com.sky.meteor.common.spi.SpiMetadata;
import com.sky.meteor.rpc.Invocation;
import com.sky.meteor.rpc.Invoker;
import com.sky.meteor.rpc.future.InvokeFuture;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 */
@Slf4j
@SpiMetadata(name = "failsafe")
public class FailsafeClusterInvoker extends AbstractClusterInvoker {


    @Override
    public <T> T invoke(Invoker invoker, Invocation invocation) {
        Object result = null;
        InvokeFuture future = invoker.invoke(invocation);
        try {
            result = future.getResult();
            if (future.getCause() != null) {
                throw future.getCause();
            }
        } catch (Throwable throwable) {
            log.warn("failsafeClusterInvoker invoke exception:{}", throwable);
        }
        return (T) result;
    }
}
