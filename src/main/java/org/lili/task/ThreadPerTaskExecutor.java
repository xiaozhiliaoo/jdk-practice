package org.lili.task;

import java.util.concurrent.Executor;

/**
 * @author lili
 * @date 2020/2/2 13:13
 * @description
 * @notes
 */

public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
