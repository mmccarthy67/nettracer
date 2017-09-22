package aero.nettracer.kitems.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class FileUtils {
    public static Properties getApplicationProperties() {
        System.out.println("Loading application.properties file.");
        Properties props = new Properties();
        Resource resource = new ClassPathResource("application.properties");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            props.load(reader);
            props.forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (IOException e) {
            System.out.println("IOException closing input Stream Reader on application.properties.");
        }
        return props;
    }

    public static List<Integer> getArrayFileFromResources() {
        System.out.println("Loading array.txt file.");
        Scanner arrayFile = null;
        List<Integer> arrayList = new ArrayList<Integer>();
        Resource resource = new ClassPathResource("array.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            arrayFile = new Scanner(reader).useDelimiter(",\\s*");

            while (arrayFile.hasNext()) {
                int token = arrayFile.nextInt();
                arrayList.add(token);
            }
        } catch (IOException e) {
            System.out.println("IOException closing input Stream Reader on array.txt.");
        } finally {
            if (arrayFile != null) {
                arrayFile.close();
            }
        }
        return arrayList;
    }
}