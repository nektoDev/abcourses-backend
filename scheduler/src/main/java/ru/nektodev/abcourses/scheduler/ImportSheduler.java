package ru.nektodev.abcourses.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.nektodev.abcourses.service.ImportService;

/**
 * @author nektodev
 * @date 27/09/2016
 */
@Component
public class ImportSheduler {
    public static final Logger LOG = Logger.getLogger(ImportSheduler.class);
    @Autowired
    private ImportService importService;

    @Scheduled(cron="${scheduler.import.cron}")
    public void importAllStudents() {
        LOG.info("Start scheduled import.");
        importService.doImport();
        importService.doImportProgress();
        LOG.info("Scheduled import completed");
    }
}
