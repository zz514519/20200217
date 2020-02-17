package com.bitedu.osm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTreeNode {
    private String fileName;  // 文件名
    private long totalLength; //文件的总长度
    private File file;//记录系统文件对象
    private List<FileTreeNode> children = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }

    public List<FileTreeNode> getChildrens() {
        return children;
    }

    public void addChildNode(FileTreeNode node) {
        this.children.add(node);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

