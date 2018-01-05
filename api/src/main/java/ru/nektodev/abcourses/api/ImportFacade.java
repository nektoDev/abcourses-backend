package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author nektodev
 * @date 22/09/2016
 */

@JsonRpcService("/import")
public interface ImportFacade {
    void doImportHomework();

    void doImportHomework(Boolean force);

    void doImportHomework(String student);

    void doImportHomework(String student, Boolean force);

    void doImportProgress();
    void doImportProgress(String student);
}
