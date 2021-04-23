package com.ashahova.gai_spring_boot.demo.service;


import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class NumberGenerationService {

    private File fileWriter;

    private  final Random randomizer = new Random();
    private  StringBuilder numbersCar = new StringBuilder();
    private  final char[] lettersNumbers = new char[] {'A', 'B','C', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'};

    private  final int LENGTH_LETTERS_NUMBERS = lettersNumbers.length - 1;
    private  final int MAX_NUMBER = 999;
    private  final String REGION = "116RUS";
    private  final String FIRST_POSSITION_DIGITS ="0";
    private  final String FIRST_AND_SECOND_POSITION_DIGITS ="00";

    private int firstLetterPos;
    private int secondLetterPos;
    private int thirdLetterPos;
    private int number;

    public  String addRandom() {

        boolean flag = true;
        while (flag) {
            numbersCar.setLength(0);

            numbersCar.append(lettersNumbers[randomizer.nextInt(LENGTH_LETTERS_NUMBERS)]);

            int randomNumber = randomizer.nextInt(MAX_NUMBER);

            if(randomNumber < 10)
                numbersCar.append(FIRST_AND_SECOND_POSITION_DIGITS);
            else if(randomNumber < 100)
                numbersCar.append(FIRST_POSSITION_DIGITS);

            numbersCar.append(randomNumber);
            numbersCar.append(lettersNumbers[randomizer.nextInt(LENGTH_LETTERS_NUMBERS)]);
            numbersCar.append(lettersNumbers[randomizer.nextInt(LENGTH_LETTERS_NUMBERS)]);
            numbersCar.append(REGION);

                if(!fileWriter.findStringFile(numbersCar.toString())) {
                    fileWriter.appendUsingFileWriter("GaiNumbers.txt", numbersCar);
                    flag = false;
                }
        }
        return numbersCar.toString();
    }

    public String addNext()  {
        boolean flag = true;

        while(flag){
            numbersCar.setLength(0);

            if (number > 999) {
                number = 0;
                thirdLetterPos++;
                if (thirdLetterPos > LENGTH_LETTERS_NUMBERS) {
                    thirdLetterPos = 0;
                    secondLetterPos++;
                }
                if (secondLetterPos > LENGTH_LETTERS_NUMBERS) {
                    secondLetterPos = 0;
                    firstLetterPos++;
                }
                if (firstLetterPos > LENGTH_LETTERS_NUMBERS) throw new RuntimeException("Номера закончились!");
            }

            numbersCar.append(lettersNumbers[firstLetterPos]);
            if(number < 10)
                numbersCar.append(FIRST_AND_SECOND_POSITION_DIGITS);
            else if(number < 100)
                numbersCar.append(FIRST_POSSITION_DIGITS);
            numbersCar.append(number++);
            numbersCar.append(lettersNumbers[secondLetterPos]);
            numbersCar.append(lettersNumbers[thirdLetterPos]);
            numbersCar.append(REGION);

                if(!fileWriter.findStringFile(numbersCar.toString())) {
                    fileWriter.appendUsingFileWriter("GaiNumbers.txt", numbersCar);
                    flag = false;
                }
        }
        return numbersCar.toString();
    }

}
