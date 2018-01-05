package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.ImportFacade;
import ru.nektodev.abcourses.service.ImportService;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
@AutoJsonRpcServiceImpl
public class ImportFacadeImpl implements ImportFacade {

    @Autowired
    private ImportService importService;

    @Override
    public void doImportHomework() {
        this.doImportHomework(false);
    }

    @Override
    public void doImportHomework(Boolean force) {
        importService.doImport(force);
    }

    @Override
    public void doImportHomework(String student) {
        this.doImportHomework(student, false);
    }

    @Override
    public void doImportHomework(String student, Boolean force) {
        importService.doImport(student, force);
    }

    @Override
    public void doImportProgress() {
        importService.doImportProgress();
    }

    @Override
    public void doImportProgress(String student) {
        importService.doImportProgress(student);
    }
}
