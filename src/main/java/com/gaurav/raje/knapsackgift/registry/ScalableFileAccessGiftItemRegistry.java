package com.gaurav.raje.knapsackgift.registry;

import com.gaurav.raje.knapsackgift.domain.GiftItem;
import com.gaurav.raje.knapsackgift.registry.AbstractFileBasedGiftItemRegistry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is the extreme case where the input file is trillions of rows and cannot fit in the memory.
 * We therefore scan the file everytime we find a query. Unfortunately, the input data is variable.
 * Hence a "RandomAccessFile" from Java NIO is not helpful here since it uses the bytes to seek the pointer
 * in a random access file. Our delimiter in this casse is a linebreak which can be variable. So we have no alternative
 * but to scan the file. In the real world, such a situation should use the database instead of reinventing the wheel.
 * But for the sake of brevity, I will use a file scan approach.
 */
@Repository
@Profile("fileBased")
public class ScalableFileAccessGiftItemRegistry extends AbstractFileBasedGiftItemRegistry {

    private int size;

    /**
     * We do not parse the file. We assume the file is too big to fit in the memory. trillions of rows :-)
     * Everytime we do a lookup, we scan the file. This also means, it is an IO operation.
     *
     * @throws IOException
     */
    @Override
    public void doInit() throws IOException {
        int cnt = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {

            while ((br.readLine()) != null) {
                cnt++;
            }

        }
        this.size = cnt;

    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Some code duplication here. TODO clean this up if there is time
     *
     * @param index
     * @return
     */
    @Override
    public GiftItem getItemAtIndex(int index) {
        int cnt = 0;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
                String line = null;
                do {
                    line = ((br.readLine()));
                    if (cnt == index) {
                        String[] columns = line.split(fieldSeparator);
                        return new GiftItem(Integer.parseInt(columns[1]), columns[0]);
                    }
                    cnt++;
                }
                while (line != null);

            }
        } catch (Exception e) {
            // The following exception must be thrown. We should never come here or escape out if we have checks in place
        }

        throw new RuntimeException("Error accessing file");
    }
}
