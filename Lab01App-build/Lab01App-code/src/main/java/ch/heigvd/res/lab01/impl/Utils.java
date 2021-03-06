package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 * utilitary class who allow to find the first line from a string 
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
     int separatorSize = 1;
     int index = lines.indexOf("\r");
     int index2 = lines.indexOf("\n");
     
     //there is only one line left
     if(index == -1 && index2 == -1) {
        return new String[]{"", lines};
     } // we found the \r\n line separator
     else if (index != -1 && index2 != -1){
        separatorSize = 2;
        index = Math.min(index, index2);
     } // we found \r or \n line separator
     else {
        index = Math.max(index, index2);
     }
     
     // we build the result with the calculated first line separator type found
     String[] result = new String[2];
     result[0] = lines.substring(0, index + separatorSize);
     result[1] = lines.substring(index + separatorSize);
     return result;
  }

}
