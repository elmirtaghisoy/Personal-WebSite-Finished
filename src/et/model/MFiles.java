package et.model;

public class MFiles extends AbstarctClass {
    private String filePath;
    private int fileType;
    private int role;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MFiles{" +
                "filePath='" + filePath + '\'' +
                ", fileType=" + fileType +
                ", role=" + role +
                '}';
    }
}
