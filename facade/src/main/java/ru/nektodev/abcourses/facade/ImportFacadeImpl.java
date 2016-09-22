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
    public void doImport() {
        importService.doImport();
    }

    @Override
    public void doImport(String student) {
        importService.doImport(student);
    }
}
