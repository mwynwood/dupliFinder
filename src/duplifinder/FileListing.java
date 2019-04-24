/**
* This has been modified by Marcus Wynwood
* but is based on:
*
* @author javapractices.com
* @author Alex Wong
* http://www.javapractices.com/Topic68.cjp
*
* Creative Commons Licence
* http://creativecommons.org/
*/

package duplifinder;

import java.util.*;
import java.io.*;

public final class FileListing {
    
    public FileListing() {
        // just because
    }

    public Vector returnVector(String startingPoint) {
        File tempDir = new File(startingPoint);
        Vector fileListVector = new Vector(); // Stores files
        try {
            List files = FileListing.getFileListing(tempDir);
            //print out all file names, and display the order of File.compareTo
            Iterator filesIter = files.iterator();
            while( filesIter.hasNext() ){
                //System.out.println(filesIter.next());
                fileListVector.addElement(filesIter.next());
            }            
        } catch (FileNotFoundException e) {
            //System.out.println(e);
        } catch (Exception e) {
            //System.out.println(e);
        }
        return fileListVector;
    }

/*
  // Demonstrate use.
  public static void main(String[] aArguments) throws FileNotFoundException {
    File tempDir = new File(aArguments[0]);
    List files = FileListing.getFileListing( tempDir );

    //print out all file names, and display the order of File.compareTo
    Iterator filesIter = files.iterator();
    while( filesIter.hasNext() ){
      System.out.println( filesIter.next() );
    }
  }
*/
  
  /**
  * Recursively walk a directory tree and return a List of all
  * Files found; the List is sorted using File.compareTo.
  *
  * @param aStartingDir is a valid directory, which can be read.
  */
  static public List getFileListing( File aStartingDir ) throws FileNotFoundException{
    validateDirectory(aStartingDir);
    List result = new ArrayList();

    File[] filesAndDirs = aStartingDir.listFiles();
    List filesDirs = Arrays.asList(filesAndDirs);
    Iterator filesIter = filesDirs.iterator();
    File file = null;
    while ( filesIter.hasNext() ) {
      file = (File)filesIter.next();
      result.add(file); //always add, even if directory
      if (!file.isFile()) {
        //must be a directory
        //recursive call!
        List deeperList = getFileListing(file);
        result.addAll(deeperList);
      }

    }
    Collections.sort(result);
    return result;
  }

  /**
  * Directory is valid if it exists, does not represent a file, and can be read.
  */
  static private void validateDirectory (File aDirectory) throws FileNotFoundException {
    if (aDirectory == null) {
      throw new IllegalArgumentException("Directory should not be null.");
    }
    if (!aDirectory.exists()) {
      throw new FileNotFoundException("Directory does not exist: " + aDirectory);
    }
    if (!aDirectory.isDirectory()) {
      throw new IllegalArgumentException("Is not a directory: " + aDirectory);
    }
    if (!aDirectory.canRead()) {
      throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
    }
  }
}