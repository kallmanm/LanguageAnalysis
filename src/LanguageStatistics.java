import java.util.*;

public class LanguageStatistics {

    Map<String, Language > languages = new HashMap<>();

    public void addLanguage(Language l){
        languages.put(l.languageLabel,l);
    }

    public void guessLanguage(){
        //todo: compare the input vs the source languages

    }

     void printAllLanguages(){
        for(Map.Entry<String,Language> entry : languages.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().content);
        }
    }
}
