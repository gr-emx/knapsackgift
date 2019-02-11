package com.gaurav.raje.knapsackgift;

import com.gaurav.raje.knapsackgift.antipatterns.InputSanitizer;
import com.gaurav.raje.knapsackgift.domain.GiftItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class KnapsackGiftApplication implements CommandLineRunner {

    @Autowired
    SolutionAlgorithm algorithm;
    @Value("${arg1}")
    int maxGiftCardValue;

    public static void main(String[] args) {

        InputSanitizer inputSanitizer = new InputSanitizer();
        args = inputSanitizer.sanitizeArguments(args);

        SpringApplication.run(KnapsackGiftApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        List<GiftItem> giftItemList = algorithm.findOptimalPair(maxGiftCardValue);
        giftItemList.forEach(System.out::println);
    }


}

