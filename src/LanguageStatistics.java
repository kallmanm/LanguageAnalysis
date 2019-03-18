import java.util.*;

public class LanguageStatistics {

    Map<String, Language > languages = new HashMap<>();

    public void addLanguage(Language l){
        languages.put(l.languageLabel,l);
    }

    public void guessLanguage(){
        //todo:fix
    }
}
