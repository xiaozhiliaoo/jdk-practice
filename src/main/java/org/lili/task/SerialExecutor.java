package org.lili.task;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * @author lili
 * @date 2020/2/2 13:19
 * @description
 * @notes
 */

public class SerialExecutor implements Executor {

    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final Executor executor;
    Runnable active;

    public SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    public synchronized void execute(Runnable command) {
        tasks.offer(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                } finally {
                    scheduleNext();
                }
            }
        });
        if(active == null) {
            scheduleNext();
        }
    }


    protected synchronized void scheduleNext() {
        if ((active = tasks.poll()) != null) {
            executor.execute(active);
        }
    }
}
