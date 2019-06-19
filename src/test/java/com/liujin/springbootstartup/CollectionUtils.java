package com.liujin.springbootstartup;

import org.junit.Test;

import java.util.Spliterator;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zonghuixu
 */

public class CollectionUtils {
	@Test
	public void test() {
		ThreadPoolExecutor executorService = new ThreadPoolExecutor(4, 4,
			0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());
		executorService.prestartAllCoreThreads();
		Spliterator<Integer> spliterator = Stream.generate(() -> 41).limit(10).collect(Collectors.toList()).spliterator();
		Spliterator<Integer> spliterator_1 = Stream.generate(() -> 41).limit(10).collect(Collectors.toList()).spliterator();
		Spliterator<Integer> spliterator_2 = spliterator_1.trySplit();
		Spliterator<Integer> spliterator_3 = spliterator_2.trySplit();
		Spliterator<Integer> spliterator_4 = spliterator_1.trySplit();

		long singelThreadStart = System.currentTimeMillis();
		spliterator.forEachRemaining(Math::log1p);
		long singelThreadStop = System.currentTimeMillis();
		System.out.println("single cost " + (singelThreadStop - singelThreadStart));
		long multyThreadStart = System.currentTimeMillis();
		Future<Integer> t1 = executorService.submit(new SqrTask(spliterator_1));
		Future<Integer> t2 = executorService.submit(new SqrTask(spliterator_2));
		Future<Integer> t3 = executorService.submit(new SqrTask(spliterator_3));
		Future<Integer> t4 = executorService.submit(new SqrTask(spliterator_4));
		try {
			t1.get();
			t2.get();
			t3.get();
			t4.get();
		} catch (Exception e) {

		}
		long multyThreadStop = System.currentTimeMillis();

		System.out.println("multiple cost " + (multyThreadStop - multyThreadStart));

	}

	private static class SqrTask implements Callable<Integer> {
		Spliterator<Integer> data;

		public SqrTask(Spliterator<Integer> data) {
			this.data = data;
		}

		@Override
		public Integer call() throws Exception {
			data.forEachRemaining(Math::log1p);
			return 1;
		}
	}
}
