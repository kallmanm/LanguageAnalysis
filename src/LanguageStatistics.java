import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class LanguageStatistics {

    Double lowestValue= 10.00;
    HashMap<String, Language > languages = new HashMap<>();

    public void addLanguage(Language l){
        languages.put(l.languageLabel,l);
    }

    //----- Method that applies statistics and guesses the language-----//
    public void guessLanguage(Language input){
        HashMap<String,Double> result1 = guessLanguageCharDistribution(input);
        HashMap<String,Double> result2 = guessLanguageThreeCharDistribution(input);
        HashMap<String,Double> result3 = guessLanguageFirstCharOfWordDistribution(input);
        HashMap<String,Double> sumResults = new HashMap<>();

        for(Map.Entry<String, Double> entry : result1.entrySet()){
            if(result2.containsKey(entry.getKey())){
                Double sumValue = entry.getValue();
                sumValue += result2.get(entry.getKey());
                if(result3.containsKey(entry.getKey())){
                    sumValue += result3.get(entry.getKey());
                    sumResults.put(entry.getKey(),sumValue);
                    if(sumValue < lowestValue){
                        lowestValue=sumValue;
                    }
                }
            }
        }
        System.out.println("TOTAL RESULTS:");
        System.out.println(sumResults);

        for(Map.Entry entry: sumResults.entrySet()){
            if(lowestValue.equals(entry.getValue())){
                System.out.println("I think you are typing in: "+entry.getKey());
                break;
            }
        }
        //reseting variable for next input
        lowestValue= 10.00;
    }

    //----- Methods for guessing Language -----//
    public HashMap<String,Double> guessLanguageCharDistribution(Language input){

        HashMap<String,Double> comparedValues= new HashMap<>();

        for(Map.Entry<String, Language> entry : languages.entrySet()){
            String key = entry.getKey();
            Language value = entry.getValue();
            Double totalSum =0.00;

            for(Map.Entry<String, Double> entry2 : value.charDistribution.entrySet()){
                String key2 = entry2.getKey();

                if(input.charDistribution.containsKey(key2)){
                    Double x= entry2.getValue();
                    Double y =input.charDistribution.get(key2);
                    Double sum =(x-y)*(x-y);
                    totalSum +=sum;
                }
            }
            comparedValues.put(key,totalSum);
            //System.out.println(key);
            //System.out.println("total sum is: "+totalSum);
            //System.out.println("------------------------");
        }
        System.out.println("guessLanguageCharDistribution results:");
        System.out.println("*** ----------------------- ***");
        System.out.println(comparedValues);
        System.out.println("*** ----------------------- ***");
        return  comparedValues;
    }
    public HashMap<String,Double> guessLanguageThreeCharDistribution(Language input){

        HashMap<String,Double> comparedValues= new HashMap<>();

        for(Map.Entry<String, Language> entry : languages.entrySet()){
            String key = entry.getKey();
            Language value = entry.getValue();
            Double totalSum =0.00;

            for(Map.Entry<String, Double> entry2 : value.charDistributionThree.entrySet()){
                String key2 = entry2.getKey();

                if(input.charDistributionThree.containsKey(key2)){
                    Double x= entry2.getValue();
                    Double y =input.charDistributionThree.get(key2);
                    Double sum =(x-y)*(x-y);
                    totalSum +=sum;
                }
            }
            comparedValues.put(key,totalSum);
            //System.out.println(key);
            //System.out.println("total sum is: "+totalSum);
            //System.out.println("------------------------");
        }
        System.out.println("guessLanguageThreeCharDistribution results:");
        System.out.println("*** ----------------------- ***");
        System.out.println(comparedValues);
        System.out.println("*** ----------------------- ***");

        return comparedValues;
    }
    public HashMap<String,Double> guessLanguageFirstCharOfWordDistribution(Language input){

        HashMap<String,Double> comparedValues= new HashMap<>();

        for(Map.Entry<String, Language> entry : languages.entrySet()){
            String key = entry.getKey();
            Language value = entry.getValue();
            Double totalSum =0.00;

            for(Map.Entry<String, Double> entry2 : value.charDistributionFirstLetter.entrySet()){
                String key2 = entry2.getKey();

                if(input.charDistributionFirstLetter.containsKey(key2)){
                    Double x= entry2.getValue();
                    Double y =input.charDistributionFirstLetter.get(key2);
                    Double sum =(x-y)*(x-y);
                    totalSum +=sum;
                }
            }
            comparedValues.put(key,totalSum);
            //System.out.println(key);
            //System.out.println("total sum is: "+totalSum);
            //System.out.println("------------------------");
        }
        System.out.println("guessLanguageFirstCharOfWordDistribution results:");
        System.out.println("*** ----------------------- ***");
        System.out.println(comparedValues);
        System.out.println("*** ----------------------- ***");

        return comparedValues;
    }

    //Prints out all reference content from all Languages
    public void printAllLanguages(){
        for(Map.Entry<String,Language> entry : languages.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().content);
        }
    }
}
