import java.io.*;

public class FileHandler {

    //todo: add all methods needed for handeling all data management & regex management


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
}
