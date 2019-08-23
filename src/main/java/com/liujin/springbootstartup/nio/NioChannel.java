package com.liujin.springbootstartup.nio;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author zonghuixu
 */
public class NioChannel {
	public static void main(String[] args) throws Exception {
		RandomAccessFile randomAccessFile = new RandomAccessFile(NioChannel.class.getClassLoader().getResource("test.txt").getPath(), "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();

		//分配40字节缓冲
		ByteBuffer buffer = ByteBuffer.allocate(100);
		System.out.println("now position is " + fileChannel.position());
		//将文件读到缓冲区中
		fileChannel.read(buffer);
		System.out.println("after read, position is " + fileChannel.position());
		//切换读模式
		buffer.flip();
		System.out.println("the file content is " + new java.lang.String(buffer.array()));

		ByteBuffer buffer2 = ByteBuffer.allocate(40);
		buffer2.put("content to be written".getBytes());
		buffer2.flip();

		fileChannel.write(buffer2);
		randomAccessFile.close();
	}
}
