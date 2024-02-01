package hello.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class LogTestController {

    @GetMapping("/log/test")
    public String logTest(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        log.trace("remoteAddr = {}", remoteAddr);
        log.debug("remoteAddr = {}", remoteAddr);
        log.info("remoteAddr = {}", remoteAddr);
        log.warn("remoteAddr = {}", remoteAddr);
        log.error("remoteAddr = {}", remoteAddr);

        return "ok";
    }
}
