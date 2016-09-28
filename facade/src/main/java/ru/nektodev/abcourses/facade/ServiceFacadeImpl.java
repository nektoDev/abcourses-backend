package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.ServiceFacade;
import ru.nektodev.abcouses.model.UsefulLink;

import java.util.List;

/**
 * @author nektodev
 * @date 28/09/2016
 */
@Service
@AutoJsonRpcServiceImpl
public class ServiceFacadeImpl implements ServiceFacade{

    @Override
    public List<UsefulLink> listUsefulLinks() {
        return null;
    }

    @Override
    public List<UsefulLink> saveUsefulLinks(List<UsefulLink> links) {
        return null;
    }
}
