package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author nektodev
 * @date 22/09/2016
 */

@JsonRpcService("/import")
public interface ImportFacade {
    void doImport();
    void doImport(String student);
}
