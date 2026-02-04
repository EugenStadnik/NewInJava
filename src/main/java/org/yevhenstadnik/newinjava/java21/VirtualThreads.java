package org.yevhenstadnik.newinjava.java21;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        executeWithThreads(() -> Executors.newFixedThreadPool(100));
        executeWithThreads(Executors::newVirtualThreadPerTaskExecutor);
        Thread.ofVirtual().name("VirtualThread").start(() -> System.out.println("Hello from virtual thread!"));
        Thread.startVirtualThread(() -> System.out.println("Hello from other virtual thread!"));
        Thread.ofPlatform().name("PlatformThread").start(() -> System.out.println("Hello from platform thread!"));

    }

    private static void executeWithThreads(Supplier<ExecutorService> threadsSupplier) throws InterruptedException {
        try (ExecutorService executor = threadsSupplier.get()) {
            List<Task> tasks = IntStream.range(0, 1000).mapToObj(Task::new).toList();
            long start = System.currentTimeMillis();
            List<Future<Integer>> futures = executor.invokeAll(tasks);
            long sum = futures.stream().map(VirtualThreads::getFutureValue).collect(Collectors.summarizingInt(Integer::intValue)).getSum();
            long end = System.currentTimeMillis();
            System.out.printf("%d ms time elapsed to count %d sum with %s threads.%n", end - start, sum,
                    executor.getClass().getSimpleName());
        }
    }

    private static Integer getFutureValue(final Future<Integer> future){
        try {
            return future.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Failed to get value from future:" + e.getMessage());
            return 0;
        }
    }

    public static class Task implements Callable<Integer> {

        private final int number;

        public Task(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            String threadName = Thread.currentThread().isVirtual()
                    ? "virtual-thread-for-task-" + number
                    : Thread.currentThread().getName();
            System.out.printf("Thread %s, Task %d waiting...%n", threadName, number);
            Thread.sleep(1000);
            System.out.printf("Thread %s, Task %d done!%n", threadName, number);
            return ThreadLocalRandom.current().nextInt(100);
        }
    }

}
