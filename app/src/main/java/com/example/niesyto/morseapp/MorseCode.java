package com.example.niesyto.morseapp;


/**
 *
 * @author Niesyto
 * @version 4.0
 */
public class MorseCode {

    /**Table of letters*/
    char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?' };
    /**Table of letters in morse language*/
    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." };





    /**
     *This function translates sentence to Morse
     * @param toTranslate string to translate
     * @return translated string
     */
    public String translateToMorse(char[] toTranslate)
    {

        /** Translated sentence */
        String translated = "";
        try{
            for (int i = 0; i < toTranslate.length; i++){
                for(int j=0;j<letters.length;j++){
                    if (letters[j] == toTranslate[i]){
                        translated = translated + morse[j] + " ";
                    }
                }
            }

            if("".equals(translated))
            {
                throw new MorseCodeException("Empty input");
            }
            else
            {
                return translated;
            }
        }
        catch(MorseCodeException e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }

    }


    /**
     *This function translates sentence from Morse
     * @param toTranslate string to translate
     * @return translted string
     */
    public String translateFromMorse(char[] toTranslate){

        /**Translated sentence */
        String translated = "";
        /**Buffer, used becouse one letter is represented by more than one sign in morse*/
        String buffer="";

        try{
            for (int i = 0; i < toTranslate.length; i++){
                if(i==toTranslate.length-1)
                    if(toTranslate[i]!=' ')
                        buffer=buffer+toTranslate[i];
                if(toTranslate[i]==' '||i==toTranslate.length-1){

                    for (char j = 0; j < morse.length; j++){
                        if (morse[j].equals(buffer)){

                            translated = translated + letters[j] + " ";
                            buffer="";
                        }

                    }
                }
                else{
                    buffer=buffer+toTranslate[i];
                }
            }
            if(toTranslate.length==0)
            {
                throw new MorseCodeException("Empty input");
            }
            else
            {
                return translated;
            }
        }
        catch(MorseCodeException e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }

    }
}


