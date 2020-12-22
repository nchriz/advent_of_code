/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Helper {

    public static List<String> read(String file) {
        List<String> stringList = new ArrayList<String>();
        BufferedReader br = null;
        try {
            URL path = ClassLoader.getSystemResource(file);
            br = new BufferedReader(new FileReader(new File(path.toURI())));
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return stringList;
    }
}
