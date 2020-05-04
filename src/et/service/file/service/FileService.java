package et.service.file.service;

import et.model.MFiles;

import java.util.List;

public interface FileService {
    List<MFiles> getGeneralFiles() throws Exception;

    MFiles getFileById(Integer fileId) throws Exception;

    boolean deleteFile(Integer fileId) throws Exception;

    boolean updateFile(String filePath, Integer fileId) throws Exception;

    boolean addFile(List<MFiles> filesList, Integer postId) throws Exception;
}
