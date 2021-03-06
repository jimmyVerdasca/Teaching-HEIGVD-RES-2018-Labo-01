package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
     vistor.visit(rootDirectory);
      if(rootDirectory != null) {
         
         //find all the files and directory in the current root directory
         File[] list = rootDirectory.listFiles(); 
         if(list != null) {
            for(File f : list) { 
               //go deeper if f is a directory (recusif call)
                if(f.isDirectory()) { 
                    explore(f, vistor); 
                } // apply the visitor if f is a file
                else {
                  vistor.visit(f);
                }
            } 
         }
      }
  }

}
