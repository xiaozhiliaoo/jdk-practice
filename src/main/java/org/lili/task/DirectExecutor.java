package org.lili.task;

import java.util.concurrent.Executor;

/**
 * @author lili
 * @date 2020/2/2 13:12
 * @description
 * @notes
 */

public class DirectExecutor implements Executor {
    public void execute(Runnable command) {
        command.run();
    }
}
