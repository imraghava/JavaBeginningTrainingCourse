package com.tyshchenko.java.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alexander Tyshchenko.
 */
@State(Scope.Benchmark)
@OutputTimeUnit(value = TimeUnit.MICROSECONDS)
public class AtomicVsSynchronizedCounterBenchmark {

    private final int NUM = 10000;
    private int notAtomic = 0;
    private AtomicInteger atomic;

    public synchronized int incrementNotAtomic() {
        return notAtomic++;
    }

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    public void notAtomic() {
        for (int i = 0 ; i < NUM ; i++) {
            incrementNotAtomic();
        }
    }

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    public void atomic() {
        for (int i = 0 ; i < NUM ; i++) {
            incrementNotAtomic();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AtomicVsSynchronizedCounterBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

}
