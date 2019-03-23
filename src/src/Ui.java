import java.util.*;

public class Ui {

    public static void menu() {

        //----- Variables -----//
        String choice = "0";
        String guess;
        Scanner input = new Scanner(System.in);

        LanguageStatistics reference = new LanguageStatistics();

        //Texts to be used for analyses
        //English
        String textEng = "src/languages/English.txt";
        String treatedTextEng = FileHandler.fileReader(textEng);
        Language eng = new Language(treatedTextEng, "English");
        reference.addLanguage(eng);

        //German
        String textGer = "src/languages/Deutch.txt";
        String treatedTextGer = FileHandler.fileReader(textGer);
        Language ger = new Language(treatedTextGer, "German");
        reference.addLanguage(ger);

        //Estonian
        String textEesti = "src/languages/Eesti.txt";
        String treatedTextEesti = FileHandler.fileReader(textEesti);
        Language est = new Language(treatedTextEesti, "Estonian");
        reference.addLanguage(est);

        //French
        String textFra = "src/languages/Francais.txt";
        String treatedTextFra = FileHandler.fileReader(textFra);
        Language fra = new Language(treatedTextFra, "French");
        reference.addLanguage(fra);

        //Italian
        String textIt = "src/languages/Italiano.txt";
        String treatedTextIt = FileHandler.fileReader(textIt);
        Language it = new Language(treatedTextIt, "Italian");
        reference.addLanguage(it);

        //Norwegian
        String textNor = "src/languages/Norsk.txt";
        String treatedTextNor = FileHandler.fileReader(textNor);
        Language nor = new Language(treatedTextNor, "Norwegian");
        reference.addLanguage(nor);

        //Finnish
        String textFin = "src/languages/Suomi.txt";
        String treatedTextFin = FileHandler.fileReader(textFin);
        Language fin = new Language(treatedTextFin, "Finnish");
        reference.addLanguage(fin);

        //Swedish
        String textSwe = "src/languages/Svenska.txt";
        String treatedTextSwe = FileHandler.fileReader(textSwe);
        Language swe = new Language(treatedTextSwe, "Swedish");
        reference.addLanguage(swe);

        while (!choice.equals("3")) {

            System.out.println(" --------------------------------");
            System.out.println("|1. Show all reference languages |");
            System.out.println("|2. Analyse input text           |");
            System.out.println("|3. Exit                         |");
            System.out.println(" --------------------------------");

            choice = input.nextLine();

            switch (choice) {

                case "1":
                    reference.printAllLanguages();
                    break;

                case "2":
                    System.out.println("Please type a sentence so I can guess what language it is.");
                    guess = input.nextLine();
                    Language unknown = new Language(guess, "Unknown");
                    reference.guessLanguage(unknown);
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Input, try again...");
                    break;

            }
        }
    }
}
