package com.solvd.hospital.file;

import com.solvd.hospital.Main;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        File file = new File(FileUtil.class.getResource("resource/txt.txt").getFile());

        try{
            Map<String,Integer> count = new HashMap<>();
            String text = FileUtils.readFileToString(file, "utf-8").toLowerCase();
            for(String word : StringUtils.split(text)) {
                Object type = ((count.containsKey(word)) ? count.put(word, count.get(word)+1) : count.put(word,1));}
            FileUtils.writeStringToFile(new File("src/main/resources/WordCount.txt"), count.toString(), "UTF-8");
        } catch (IOException exception) {
            logger.error(exception);
        }

    }
}
