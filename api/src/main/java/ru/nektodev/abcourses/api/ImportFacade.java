package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author nektodev
 * @date 22/09/2016
 */

@JsonRpcService("/import")
public interface ImportFacade {
    void doImportHomework();
    void doImportHomework(String student);

    void doImportProgress();
    void doImportProgress(String student);
}
