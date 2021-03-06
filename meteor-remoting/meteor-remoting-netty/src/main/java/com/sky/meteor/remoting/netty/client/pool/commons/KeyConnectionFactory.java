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
//package com.sky.meteor.remoting.netty.client.pool;
//
//import com.sky.meteor.remoting.netty.client.NettyClient;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelFutureListener;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.pool.KeyedPoolableObjectFactory;
//
///**
// * @author
// */
//@Slf4j
//public class KeyConnectionFactory implements KeyedPoolableObjectFactory<String, Channel> {
//
//    private NettyClient client;
//
//    public KeyConnectionFactory(NettyClient client) {
//        this.client = client;
//    }
//
//    @Override
//    public Channel makeObject(String key) throws Exception {
//        return client.getChannel(key);
//    }
//
//    @Override
//    public void destroyObject(String key, Channel channel) throws Exception {
//        channel.close().addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                log.info("KeyConnectionFactory close channel complete !");
//            }
//        });
//    }
//
//    @Override
//    public boolean validateObject(String key, Channel channel) {
//        return channel.isActive();
//    }
//
//    @Override
//    public void activateObject(String key, Channel obj) throws Exception {
//    }
//
//    /**
//     * 挂起
//     *
//     * @param key
//     * @param obj
//     * @throws Exception
//     */
//    @Override
//    public void passivateObject(String key, Channel obj) throws Exception {
//    }
//}
