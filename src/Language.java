import java.util.*;

public class Language {

    //---- Variables -----//
    String content;
    String languageLabel;
    String [] words;
    Map<String,Double> charDistribution = new HashMap<>();
    Map<String,Double> charDistributionThree = new HashMap<>();
    Map<String,Double> charDistributionFirstLetter = new HashMap<>();

    //---- Constructor ----//
    public Language(String content, String languageLabel){
        setContent(content);
        setLanguageLabel(languageLabel);
        setWords(content);
        calculateCharDistribution(content);
        calculateThreeCharDistribution(content);
        calculateFirstCharOfWordDistribution();
    }

    public void setLanguageLabel(String languageLabel) {
        this.languageLabel = languageLabel;
    }

    public void setContent(String content) {
        //textSanitizer removes non alphabetic chars
        this.content = content;
    }

    public void setWords(String content){
        String treatedContent = FileHandler.textSanitizerFirstWord(content);
        String[] words = treatedContent.split(" ");
        this.words =words;
    }

    public void calculateCharDistribution(String content){

        String treatedContent = FileHandler.textSanitizer(content);
        double totalChars = 0;

        //sets all chars used
        for(int i=0;i<treatedContent.length();i++){
             charDistribution.put(String.valueOf(treatedContent.charAt(i)), 0.00);
        }
        //Adds chars & amounts to HashMap
        for(int i=0;i<treatedContent.length();i++){
             double val = charDistribution.get(String.valueOf(treatedContent.charAt(i)));
             val ++;
             charDistribution.replace(String.valueOf(treatedContent.charAt(i)), val);
             totalChars ++;
        }
        //Counts total amount of chars used and converts entries to decimal value
        for(Map.Entry<String, Double> entry : charDistribution.entrySet()){
            Double finalize = entry.getValue();
            finalize /= totalChars;
            entry.setValue(finalize);
         }
    }
    public void calculateThreeCharDistribution(String content){

        String treatedContent = FileHandler.textSanitizer(content);
        double totalChars = 0;

        //sets all chars used
        for(int i=0;i<treatedContent.length()-2;i++){
            charDistributionThree.put(treatedContent.charAt(i) + String.valueOf(treatedContent.charAt(i+1)) + String.valueOf(treatedContent.charAt(i+2)), 0.00);
        }
        //Adds chars & amounts to HashMap
        for(int i=0;i<treatedContent.length()-2;i++){
            double val = charDistributionThree.get(treatedContent.charAt(i) + String.valueOf(treatedContent.charAt(i+1)) + String.valueOf(treatedContent.charAt(i+2)));
            val ++;
            charDistributionThree.replace(treatedContent.charAt(i) + String.valueOf(treatedContent.charAt(i+1)) + String.valueOf(treatedContent.charAt(i+2)), val);
            totalChars ++;
        }
        //Counts total amount of chars used
        for(Map.Entry<String, Double> entry : charDistributionThree.entrySet()){
            Double finalize = entry.getValue();
            finalize /= totalChars;
            entry.setValue(finalize);
        }
    }

    public void calculateFirstCharOfWordDistribution(){


        double totalChars = 0;

        //sets all chars used



        for(int i=0;i<words.length;i++){

            String input = String.valueOf(words[i].charAt(0));
            charDistributionFirstLetter.put(input, 0.00);

        }
        //Adds chars & amounts to HashMap
        for(int i=0;i<words.length;i++){

            String input = String.valueOf(words[i].charAt(0));
            double val = charDistributionFirstLetter.get(input);
            val++;
            charDistributionFirstLetter.replace(input, val);
            totalChars++;

        }
        //Counts total amount of chars used
        for(Map.Entry<String, Double> entry : charDistributionFirstLetter.entrySet()){
            Double finalize = entry.getValue();
            finalize /= totalChars;
            entry.setValue(finalize);
        }
    }
    public void combinedDistribution(){
        //todo:fix
    }
}
