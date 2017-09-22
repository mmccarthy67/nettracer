package aero.nettracer.kitems.delegate;

import aero.nettracer.kitems.utils.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class KItemsApplicationDelegate {
    private static final int DEFAULT_RANDOM_INIT = 50;

    public void processCommandLineArgs(String[] args) {
        System.out.println("Processing command line args = [" + args.toString() + "]");
        try {
            if (args.length == 1) {
                processOneArgument(args[0]);
            } else if (args.length == 2) {
                processTwoArguments(args[0], args[1]);
            } else {
                System.out.println("Incorrect number of args = [" + args.toString() + "]");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception parsing: " + e.getMessage());
            System.exit(1);
        }
        System.exit(1);
    }

    public void processApplicationProperties() {
        System.out.println("Processing application properties.");
        Properties props = FileUtils.getApplicationProperties();

        if (props == null) {
            System.out.println("Missing application properties.  Restart with k argument, or update property file.");
        } else {
            String randomFlag = props.get("random.flag").toString();

            if (randomFlag.isEmpty()) {
                System.out.println("Missing random.flag in application properties.  Restart with k argument, or update property file.");
            } else {
                processRandomFlag(randomFlag, props);
            }
        }
    }

    private void processOneArgument(String argZero) {
        int k = Integer.parseInt(argZero);
        List<Integer> list = FileUtils.getArrayFileFromResources();

        if (list != null && list.size() > 0) {
            getSmallestKItems(list, k);
            getSmallestKthItem(list, k);
        } else {
            System.out.println("Unable to continue processing.  Array file missing or empty.");
            System.exit(1);
        }
    }

    private void processTwoArguments(String argZero, String argOne) {
        int k = Integer.parseInt(argZero);
        int kth = Integer.parseInt(argOne);
        List<Integer> list = FileUtils.getArrayFileFromResources();

        if (list != null && list.size() > 0) {
            getSmallestKItems(list, k);
            getSmallestKthItem(list, kth);
        } else {
            System.out.println("Unable to continue processing.  Array file missing or empty.");
            System.exit(1);
        }
    }

    private void processRandomFlag(String randomFlag, Properties props) {
        if (randomFlag.equalsIgnoreCase("n")) {
            processArrayTextFile(props);
        } else {
            processRandomIntegerArrayList(props);
        }
    }

    private void processArrayTextFile(Properties props) {
        try {
            int k = Integer.parseInt(props.get("int.k").toString());
            int kth = Integer.parseInt(props.get("int.kth").toString());
            List<Integer> list = FileUtils.getArrayFileFromResources();

            if (list != null && list.size() > 0) {
                getSmallestKItems(list, k);
                getSmallestKthItem(list, kth);
            } else {
                System.out.println("Unable to continue processing.  Array file missing or empty.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception parsing " + props.get("int.k").toString() + ", " + e.getMessage());
        }
    }

    private void processRandomIntegerArrayList(Properties props) {
        int init;

        try {
            init = Integer.parseInt(props.get("random.init").toString());
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception parsing " + props.get("random.init").toString() + ", " + e.getMessage());
            System.out.println("Using default init: " + DEFAULT_RANDOM_INIT);
            init = DEFAULT_RANDOM_INIT;
        }

        try {
            int k = Integer.parseInt(props.get("int.k").toString());
            int kth = Integer.parseInt(props.get("int.kth").toString());
            int [] array = new Random().ints(init, 0, 100).toArray();
            System.out.println(Arrays.toString(array));
            List<Integer> list =  Arrays.stream(array).boxed().collect(Collectors.toList());

            if (list != null && list.size() > 0) {
                getSmallestKItems(list, k);
                getSmallestKthItem(list, kth);
            } else {
                System.out.println("Unable to continue processing.  Array file missing or empty.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception parsing " + props.get("int.k").toString() + ", " + e.getMessage());
        }
    }

    private void getSmallestKItems(List<Integer> list, int k) {
        SmallestKItemsDelegate delegate = new SmallestKItemsDelegate();
        Queue<Integer> pq = delegate.processArrayFile(list, k);
        System.out.println(pq);
    }

    private void getSmallestKthItem(List<Integer> list, int k) {
        SmallestKthItemDelegate delegate = new SmallestKthItemDelegate();
        int i = delegate.processArrayFile(list, k);
        System.out.println(i);
    }
}