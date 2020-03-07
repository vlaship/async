package vlaship.async;

import java.util.concurrent.CompletableFuture;

public interface AsyncClient {
    CompletableFuture<Long> doSmt1() throws InterruptedException;

    CompletableFuture<Long> doSmt2() throws InterruptedException;
}
