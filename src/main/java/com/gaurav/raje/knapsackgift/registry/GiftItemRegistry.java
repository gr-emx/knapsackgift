package com.gaurav.raje.knapsackgift.registry;

import com.gaurav.raje.knapsackgift.domain.GiftItem;

/**
 * A scalable abstraction over how we retrieve the price. This way, we can swap out an in memory implementation
 * for a file system based implementation if the application goes out of scale.
 */
public interface GiftItemRegistry {
    int getSize();
    GiftItem getItemAtIndex(int index);
}
