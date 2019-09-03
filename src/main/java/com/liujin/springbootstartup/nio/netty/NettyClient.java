package com.liujin.springbootstartup.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author zonghuixu
 */
public class NettyClient {
	public static void main(String[] args) throws Exception {
//		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//		Bootstrap bootstrap = new Bootstrap();
//		bootstrap
//			.group(eventLoopGroup)
//			.channel(NioSocketChannel.class)
//			.remoteAddress(new InetSocketAddress("127.0.0.1", 8888))
//			.handler(new ChannelInitializer<SocketChannel>() {
//				@Override
//				protected void initChannel(SocketChannel ch) throws Exception {
//					ch.pipeline().addLast(new EchoClientHandler());
//				}
//			});
//		ChannelFuture future = bootstrap.connect().sync();
//		future.channel().closeFuture().sync();

		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
				.channel(NioSocketChannel.class)
				.remoteAddress(new InetSocketAddress("127.0.0.1", 8888))
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch)
						throws Exception {
						ch.pipeline().addLast(
							new EchoClientHandler());
					} });
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
