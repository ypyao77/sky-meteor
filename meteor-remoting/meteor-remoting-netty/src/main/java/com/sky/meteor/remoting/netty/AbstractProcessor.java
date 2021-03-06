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
package com.sky.meteor.remoting.netty;

import com.sky.meteor.common.config.ConfigManager;
import com.sky.meteor.common.threadpool.ThreadPoolHelper;
import com.sky.meteor.common.threadpool.ThreadPoolProperties;
import com.sky.meteor.remoting.Request;
import com.sky.meteor.remoting.Response;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author
 */
public abstract class AbstractProcessor implements Processor {

    /**
     * request handler
     *
     * @param ctx
     * @param request
     */
    @Override
    public void handler(ChannelHandlerContext ctx, Request request) {
    }

    /**
     * response handler
     *
     * @param ctx
     * @param response
     */
    @Override
    public void handler(ChannelHandlerContext ctx, Response response) {
    }

    /**
     * 创建业务线程池
     */
    public void executors() {
        ThreadPoolProperties properties = new ThreadPoolProperties();
        properties.setCorePoolSize(ConfigManager.tpCorePoolSize());
        properties.setMaximumPoolSize(ConfigManager.tpMaximumPoolSize());
        properties.setInitialCapacity(ConfigManager.TpInitialCapacity());
        properties.setKeepAliveTime(ConfigManager.tpKeepAliveTime());
        properties.setDiscard(ConfigManager.tpDiscardSwitch());
        ThreadPoolHelper.newExtendThreadPool(properties);
    }
}
