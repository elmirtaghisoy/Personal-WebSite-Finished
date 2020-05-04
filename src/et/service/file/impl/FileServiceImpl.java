package et.service.file.impl;

import et.dao.file.dao.FileDao;
import et.dao.info.dao.InfoDao;
import et.model.MFiles;
import et.service.file.service.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {

    private FileDao fileDao;

    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public List<MFiles> getGeneralFiles() throws Exception {
        return fileDao.getGeneralFiles();
    }

    @Override
    public MFiles getFileById(Integer fileId) throws Exception {
        return fileDao.getFileById(fileId);
    }

    @Override
    public boolean deleteFile(Integer fileId) throws Exception {
        return fileDao.deleteFile(fileId);
    }

    @Override
    public boolean updateFile(String filePath, Integer fileId) throws Exception {
        return fileDao.updateFile(filePath,fileId);
    }

    @Override
    public boolean addFile(List<MFiles> filesList, Integer postId) throws Exception {
        return fileDao.isAddedFiles(filesList,postId);
    }

}
