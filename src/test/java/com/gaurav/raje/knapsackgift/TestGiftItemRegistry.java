package com.gaurav.raje.knapsackgift;

import com.gaurav.raje.knapsackgift.domain.GiftItem;
import com.gaurav.raje.knapsackgift.registry.GiftItemRegistry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("Test")
public class TestGiftItemRegistry implements GiftItemRegistry {
    List<GiftItem> giftItems = new ArrayList<>();
    @PostConstruct
    public void init(){
        giftItems.add(new GiftItem(500,"Candy Bar"));
        giftItems.add(new GiftItem(700,"Paper Book"));
        giftItems.add(new GiftItem(1000,"Detergent"));
        giftItems.add(new GiftItem(1400,"Headphones"));
        giftItems.add(new GiftItem(2000,"Earmuffs"));
        giftItems.add(new GiftItem(6000,"Bluetooth Stereo"));
    }
    @Override
    public int getSize() {
        return giftItems.size();
    }

    @Override
    public GiftItem getItemAtIndex(int index) {
        return giftItems.get(index);
    }
}
