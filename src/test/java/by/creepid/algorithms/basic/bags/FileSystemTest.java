/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import by.creepid.algorithms.basic.bags.FileSystem.FileNode;
import by.creepid.algorithms.basic.bags.FileSystem.FolderNode;
import java.io.File;
import java.io.PrintStream;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class FileSystemTest {

    private static final String PATH = "src/";

    private FileSystem fs;

    public FileSystemTest() {
    }

    //@BeforeClass
    public static void init() {
        try {
            System.setOut(new PrintStream(
                    new File("output.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of getRootNode method, of class FileSystem.
     */
    @Test
    public void testGetRootNode() {
        fs = new FileSystem(PATH);
        assertNotNull(fs);

        FolderNode root = (FolderNode) fs.getRootNode();
        assertNotNull(root);

        this.print(root, "");
    }

    private void print(FileNode node, String prefix) {
        if (node instanceof FolderNode) {
            System.out.println(prefix + node.item.getName());

            FolderNode folder = (FolderNode) node;
            java.util.Queue<FileSystem.FileNode> files = folder.getFiles();

            for (FileSystem.FileNode fileNode : files) {
                this.print(fileNode, prefix + "\t");
            }

        } else {
            System.out.println(prefix + node.item.getName());
        }
    }

        }
