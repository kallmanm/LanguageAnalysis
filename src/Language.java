import java.util.*;

public class Language {

    //---- Variables -----//
    String content;
    String languageLabel;
    Map<String,Double> charDistribution = new HashMap<>();
    String test = "kalle";

    //---- Constructor ----//
    public Language(String content, String languageLabel){
        setContent(content);
        setLanguageLabel(languageLabel);
    }

    public void setLanguageLabel(String languageLabel) {
        this.languageLabel = languageLabel;
    }

    public void setContent(String content) {
        this.content = content;
    }

     public void calculateCharDistribution(String content){
        //Counts total amount of chars used
        double totalChars = 0;

        //sets all chars used
        for(int i=0;i<content.length();i++){
             charDistribution.put(String.valueOf(content.charAt(i)), 0.00);
        }
        //Adds chars & amounts to HashMap
        for(int i=0;i<content.length();i++){
             double val = charDistribution.get(String.valueOf(content.charAt(i)));
             val ++;
             charDistribution.replace(String.valueOf(content.charAt(i)), val);
             totalChars ++;
        }
        for(Map.Entry<String, Double> entry : charDistribution.entrySet()){
            Double finalize = entry.getValue();
            finalize /= totalChars;
            entry.setValue(finalize);
         }
    }
}
