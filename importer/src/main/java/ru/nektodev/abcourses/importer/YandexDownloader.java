package ru.nektodev.abcourses.importer;

import com.yandex.disk.rest.Credentials;
import com.yandex.disk.rest.RestClient;
import com.yandex.disk.rest.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
public class YandexDownloader {
    private static final Credentials CREDENTIALS = new Credentials("", "");

    @Value("${importer.temp.directory}")
    private String tempDirPath;

    private File tempDir;
    private RestClient client;

    @PostConstruct
    public void init() {
        tempDir = new File(tempDirPath);

        if (!tempDir.exists())
            tempDir.mkdirs();

        if (!tempDir.isDirectory() || !tempDir.canWrite()) {
            //throw exception
        }

        client = new RestClient(CREDENTIALS);
    }

    public File downloadFile(String publicKey, String path) throws IOException, ServerException {
        File saveTo = new File(tempDir, "temp_"+ new Date().getTime()+ getExtension(path));

        client.downloadPublicResource(publicKey,
                path,
                saveTo,
                null);
        return saveTo;
    }

    private String getExtension(String path) {
        if (path.contains("."))
            return path.substring(path.lastIndexOf('.'));
        else
            return ".zip";
    }
}
