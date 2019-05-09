package com.liujin.springbootstartup.concurrent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zonghuixu
 *
 * DestroyJavaVm线程将在所有非守护结束后销毁虚拟机
 */

@Slf4j
public class ConcurrentKit {
	CountDownLatch latch = new CountDownLatch(5);

	@SneakyThrows
	public void joinAndResume() {
		ExecutorService tp = Executors.newFixedThreadPool(2);
		tp.submit(new Task());
		tp.submit(new ActualTask());
		Thread.sleep(2000);
		tp.submit(new Task());
		Thread.sleep(2000);
		tp.submit(new Task());
		Thread.sleep(2000);
		tp.submit(new Task());
		Thread.sleep(2000);
		tp.submit(new Task());

	}

	public static void main(String[] args) {
		ConcurrentKit concurrentKit = new ConcurrentKit();
		concurrentKit.joinAndResume();
	}

	private class Task implements Runnable {
		@Override
		public void run() {
			latch.countDown();
			log.info("thread {} started, now count is {}", Thread.currentThread().getName(), latch.getCount());
		}
	}

	private class ActualTask implements Runnable {
		@Override
		@SneakyThrows
		public void run() {
			log.info("now, job thread is waiting for signal");
			latch.await();
			log.info("all parent tasks are finished, we can start");
		}
	}
}
