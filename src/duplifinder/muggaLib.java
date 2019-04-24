package duplifinder;
/*****************************************************************************
 * muggaLib.java
 *
 * Created: 9 January 2005
 * Edited: 9 January 2005
 * @author  Marcus Wynwood
 *
 * This is a series of methods that I use all the time
 *
 * Usage:
 * muggaLib ml = new muggaLib();
 * ml.getDate();
 *
 *****************************************************************************/

import java.io.*;
import java.util.*;
import javax.swing.*;

public class muggaLib {
    
    String logFileName = new String();

/*****************************************************************************/

    // Creates a new instance of muggaLib
    public muggaLib() {
        // yeah
    }

/*****************************************************************************/

    // Plays a sound you pass it
    public void playSound(String soundFile) {
        java.applet.AudioClip clip = java.applet.Applet.newAudioClip(getClass().getResource(soundFile));
        clip.play();
    }

/*****************************************************************************/
    
    // output debug messages
    public String toLogFile(String text) {
        String logFileEntry = new String(text);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(logFileName,true));
            out.append(logFileEntry);
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return text;
    }
    
    public void setLogFileName(String newLogFileName) {
        logFileName = newLogFileName;
    }
    
    public String getLogFileName() {
        return logFileName;
    }
    
    public void deleteLogFile() {
        (new File(logFileName)).delete();
    }
/*****************************************************************************/
    
    // creates a dialogbox
    public String dialogBox(String text, String title) {
        javax.swing.JOptionPane.showMessageDialog(null, text, title, 2);
        return text;
    }

/*****************************************************************************/    

    // returns the date in a nice format
    public String getDate() {
        Calendar date = Calendar.getInstance();
        String minutes = new String();
        String seconds = new String();
        
        if (date.get(Calendar.MINUTE) < 10) {
            minutes = "0" + date.get(Calendar.MINUTE);
        } else {
            minutes = "" + date.get(Calendar.MINUTE);
        }

        if (date.get(Calendar.SECOND) < 10) {
            seconds = "0" + date.get(Calendar.SECOND);
        } else {
            seconds = "" + date.get(Calendar.SECOND);
        }
        return date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR) + " " + date.get(Calendar.HOUR_OF_DAY) + ":" + minutes + ":" + seconds;
    }

/*****************************************************************************/

    // Brings up the file chooser and puts the result a String
    public String browseForDir() {
        String result = new String("");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Select a directory...");
        int retval = fc.showOpenDialog(null);
        if (retval == fc.APPROVE_OPTION) {
            File mySelection = fc.getSelectedFile();
            result = mySelection.toString();
        }
        return result;
    }

/*****************************************************************************/
} // end of muggaLib class
