package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.ServiceFacade;
import ru.nektodev.abcourses.service.UsefulLinksService;
import ru.nektodev.abcouses.model.UsefulLink;

import java.util.List;

/**
 * @author nektodev
 * @date 28/09/2016
 */
@Service
@AutoJsonRpcServiceImpl
public class ServiceFacadeImpl implements ServiceFacade{

    @Autowired
    private UsefulLinksService usefulLinksService;

    @Override
    public List<UsefulLink> listUsefulLinks() {
        return usefulLinksService.listUsefulLinks();
    }

    @Override
    public List<UsefulLink> saveUsefulLinks(List<UsefulLink> links) {
        return usefulLinksService.saveLinks(links);
    }
}
