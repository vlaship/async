package vlaship.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppServerImpl implements AppService {

    private final AsyncClient client;

    @Override
    public long doSmt() {

        try {
            final var s1 = client.doSmt1();
            final var s2 = client.doSmt2();

            CompletableFuture.allOf(s1, s2).join();
            long duration = s1.get() + s2.get();
            log.info("{}", duration);

            return duration;
        } catch (InterruptedException | ExecutionException e) {
            log.error("{}", e.getMessage(), e);
            throw new IllegalStateException();
        }

    }

}
