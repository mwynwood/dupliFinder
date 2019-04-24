/*
 * findDuplicates.java
 *
 * Created on 14 January 2005, 00:21
 */

package duplifinder;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

/**
 *
 * @author  Marcus Wynwood
 */
public class findDuplicates {
    
    /** Creates a new instance of findDuplicates */
    public findDuplicates() {
        //System.out.println("findDuplicates Class");
    }
    
    public Vector createFileListVector(String path) {
        FileListing FileListing = new FileListing();
        return FileListing.returnVector(path);
    }
    
    public Vector calcMD5FromVector(Vector inputVector) {
        Vector hashedVector = new Vector();
        Md5 myMd5 = new Md5("");
        for (int i=0; i<inputVector.size(); i++) {
            try {
                hashedVector.addElement(myMd5.hashThis(inputVector.get(i).toString())+inputVector.get(i).toString());
            } catch (IOException e) {
                //System.out.println(e);
            }
        }
        return hashedVector;
    }
}
