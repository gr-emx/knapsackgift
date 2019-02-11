package com.gaurav.raje.knapsackgift.registry;

import com.gaurav.raje.knapsackgift.domain.GiftItem;
import com.gaurav.raje.knapsackgift.registry.AbstractFileBasedGiftItemRegistry;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("!fileBased")
public class ArrayFileBasedGiftItemRegistry extends AbstractFileBasedGiftItemRegistry {


    /**
     * After watching https://www.youtube.com/watch?v=Y4XkWSAm2XU&app=desktop
     * I have started using arraylists instead of linkedlists in such a situation
     */
    protected List<GiftItem> giftItems = new ArrayList<>();

    @Override
    public void doInit() throws IOException {
        parseInputFile();
    }

    public void parseInputFile() throws IOException {
        String fileContent = FileUtils.readFileToString(new File(fileName), Charset.defaultCharset());
        String[] rows = fileContent.split(lineSeparator);
        for (String row : rows) {
            String[] columns = row.split(fieldSeparator);
            giftItems.add(new GiftItem(Integer.parseInt(columns[1]), columns[0]));

        }
    }

    @Override
    public GiftItem getItemAtIndex(int index) {
        return giftItems.get(index);
    }

    @Override
    public int getSize() {
        return giftItems.size();
    }

}
