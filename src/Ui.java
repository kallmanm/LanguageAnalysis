import java.util.*;

public class Ui {

    public static void menu() {

        String choice = "0";
        Scanner input = new Scanner(System.in);

        //Texts to be used for analyses
        //English
        String textEng = "src/languages/English.txt";
        String treatedTextEng = FileHandler.fileReader(textEng);
        Language eng = new Language(treatedTextEng, "English");

        //German
        String textGer = "src/languages/Deutch.txt";
        String treatedTextGer = FileHandler.fileReader(textGer);
        Language ger = new Language(treatedTextGer, "German");

        //Estonian
        String textEesti = "src/languages/Eesti.txt";
        String treatedTextEesti = FileHandler.fileReader(textEesti);
        Language est = new Language(treatedTextEesti, "Estonian");

        //French
        String textFra = "src/languages/Francais.txt";
        String treatedTextFra = FileHandler.fileReader(textFra);
        Language fra = new Language(treatedTextFra, "French");

        //Italian
        String textIt = "src/languages/Italiano.txt";
        String treatedTextIt = FileHandler.fileReader(textIt);
        Language it = new Language(treatedTextIt, "Italian");

        //Norwegian
        String textNor = "src/languages/Norsk.txt";
        String treatedTextNor = FileHandler.fileReader(textNor);
        Language nor = new Language(treatedTextNor, "Norwegian");

        //Finnish
        String textFin = "src/languages/Suomi.txt";
        String treatedTextFin = FileHandler.fileReader(textFin);
        Language fin = new Language(treatedTextFin, "Finnish");

        //Swedish
        String textSwe = "src/languages/Svenska.txt";
        String treatedTextSwe = FileHandler.fileReader(textSwe);
        Language swe = new Language(treatedTextSwe, "Swedish");

        while (!choice.equals("4")) {

            System.out.println(" -------------------------");
            System.out.println("|1. Calculate opt 1       |");
            System.out.println("|2. Calculate opt 2       |");
            System.out.println("|3. Calculate opt 3       |");
            System.out.println("|4. Exit                  |");
            System.out.println(" -------------------------");

            choice = input.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Case 1");
                    //String text = input.nextLine();
                    System.out.println(swe.languageLabel);
                    System.out.println(swe.content);
                    System.out.println("----");

                    break;

                case "2":
                    System.out.println("Case 2");
                    swe.calculateCharDistribution(swe.content);
                    System.out.println(swe.charDistribution);
                    break;

                case "3":
                    System.out.println("Case 3");
                    break;

                case "4":
                    System.out.println("Case 4, Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Input, try again...");
                    break;

            }
        }
    }
}
