package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.nektodev.abcouses.model.UsefulLink;

import java.util.List;

/**
 * @author nektodev
 * @date 28/09/2016
 */
@JsonRpcService("/service")
public interface ServiceFacade {
    List<UsefulLink> listUsefulLinks();
    List<UsefulLink> saveUsefulLinks(List<UsefulLink> links);
}
