import java.io.*;
import java.util.regex.Pattern;

public class FileHandler {


    public static String fileReader(String URL){

        String text = new String();

        try {
            FileInputStream file = new FileInputStream(URL);

            int tempChar;

            while( (tempChar = file.read()) != -1 ) {

                text += String.valueOf((char)tempChar);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IOException occured: " + e.getMessage());
        }

        return text;
    }
    //Sanitizer for calculateCharDistribution & calculateThreeCharDistribution
    public static String textSanitizer(String str) {

        String newStr = str.replaceAll("\\s+", "").replaceAll("\\.", "")
                .replaceAll("\\,","")
                .replaceAll("\\.","")
                .replaceAll("\\[","")
                .replaceAll("\\]","")
                .replaceAll("\\¸","")
                .replaceAll("\\(","")
                .replaceAll("\\)","")
                .replaceAll("\\‰","")
                .replaceAll("\\ˆ","")
                .replaceAll("\\*","")
                .replaceAll("\\:","").toLowerCase();

        return newStr;
    }

    //Sanitizer for calculateFirstCharOfWordDistribution
    public static String textSanitizerFirstWord(String str) {

        String newStr = str.replaceAll("\\.","");

        return newStr;
    }

}
