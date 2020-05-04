package et.dao.file.dao;

import et.model.MFiles;

import java.io.File;
import java.util.List;

public interface FileDao {
    List<MFiles> getGeneralFiles() throws Exception;

    List<MFiles> getFilesByPostId(Integer postId) throws Exception;

    boolean isAddedFiles(List<MFiles> files, Integer postId) throws Exception;

    MFiles getFileById(Integer fileId) throws Exception;

    boolean deleteFile(Integer fileId) throws Exception;

    boolean updateFile(String filePath, Integer fileId) throws Exception;

}
