package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.HelloFacade;

/**
 * @author nektodev
 * @date 21.09.16
 */
@AutoJsonRpcServiceImpl
@Service
public class HelloFacadeImpl implements HelloFacade {

    @Override
    public String hello() {
        return "Hello JSONRPC4J";
    }
}
