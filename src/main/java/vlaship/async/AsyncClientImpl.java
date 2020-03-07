package vlaship.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncClientImpl implements AsyncClient {

    @Async
    @Override
    public CompletableFuture<Long> doSmt1() throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("1 - start");
        Thread.sleep(1000);
        log.info("1 - end");
        return CompletableFuture.completedFuture(System.currentTimeMillis() - start);
    }

    @Async
    @Override
    public CompletableFuture<Long> doSmt2() throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("2 - start");
        Thread.sleep(5000);
        log.info("2 - end");
        return CompletableFuture.completedFuture(System.currentTimeMillis() - start);
    }

}
