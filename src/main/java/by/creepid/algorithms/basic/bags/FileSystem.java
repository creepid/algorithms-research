/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author rusakovich
 */
public class FileSystem {

    private final FileNode fsNode;

    public FileSystem(String path) {
        File rootFile = new File(path);
        if (rootFile.exists()) {
            fsNode = createFSTree(rootFile);
        } else {
            throw new IllegalArgumentException("No such file: [" + path + "]");
        }
    }

    public class FileNode extends Node<File> {

        private FileNode parent;

        public FileNode getParent() {
            return parent;
        }

    }

    public class FolderNode extends FileNode {

        private final java.util.Queue<FileNode> files = new LinkedList<>();

        public Queue<FileNode> getFiles() {
            return files;
        }

    }

    private FileNode createFSTree(File rootFile) {
        FileNode rootNode;

        if (rootFile.isFile()) {
            rootNode = new FileNode();

        } else {
            rootNode = new FolderNode();

            File[] contentFiles = rootFile.listFiles();
            
            if (contentFiles != null) {
                FileNode prev = null;
                for (File currentFile : contentFiles) {

                    FileNode currentFileNode;
                    if (currentFile.isFile()) {
                        currentFileNode = new FileNode();
                    } else {
                        currentFileNode = createFSTree(currentFile);
                    }

                    currentFileNode.parent = rootNode;
                    currentFileNode.item = currentFile;

                    if (prev != null) {
                        prev.next = currentFileNode;
                    }
                    prev = currentFileNode;

                    FolderNode rootFolderNode = (FolderNode) rootNode;
                    rootFolderNode.files.add(currentFileNode);
                }
            }
            
        }

        rootNode.item = rootFile;
        return rootNode;
    }

    public FileNode getRootNode() {
        return fsNode;
    }

}
