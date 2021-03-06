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
package com.sky.meteor.filter;

import com.sky.meteor.common.constant.CommonConstants;
import com.sky.meteor.common.exception.RpcException;
import com.sky.meteor.common.spi.SpiMetadata;
import com.sky.meteor.rpc.Invocation;
import com.sky.meteor.rpc.Invoker;
import com.sky.meteor.rpc.RpcContext;
import com.sky.meteor.rpc.filter.Filter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 */
@Slf4j
@SpiMetadata(name = "traceFilter")
public class TraceFilter implements Filter {


    @Override
    public <T> T invoke(Invoker invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext().get().getAttachment() == null ? RpcContext.getServerContext().get() : RpcContext.getContext().get();
        log.info("trace filter side :{}", context.getAttachment(CommonConstants.SIDE));
        return invoker.invoke(invocation);
    }
}
