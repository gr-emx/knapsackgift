package com.gaurav.raje.knapsackgift.registry;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;


public abstract class AbstractFileBasedGiftItemRegistry implements GiftItemRegistry {
    @Value("${arg0}")
    String fileName;

    @Value("${lineSeparator}")
    protected String lineSeparator;

    @Value("${fieldSeparator}")
    protected String fieldSeparator;

    @PostConstruct
    public void init() throws IOException {
        doInit();
    }

    public void doInit() throws IOException {

    }
}
