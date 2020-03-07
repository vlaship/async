package vlaship.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {


    private final AppService service;

    @Async
    @GetMapping("/")
    public CompletableFuture<ResponseEntity> root() {
        log.info("root - start");
        var res = ResponseEntity.ok(service.doSmt());
        log.info("root - end");
        return CompletableFuture.completedFuture(res);
    }

}
