package assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    public LocalProcessor(StringBuilder processorName,
                          Long period,
                          StringBuilder processorVersion,
                          Integer valueOfCheap,
                          Scanner informationScanner,
                          List<String> stringArrayList) {
        this.processorName = Objects.requireNonNull(processorName, "processorName must not be null");
        this.period = Objects.requireNonNull(period, "period must not be null");
        this.processorVersion = Objects.requireNonNull(processorVersion, "processorVersion must not be null");
        this.valueOfCheap = Objects.requireNonNull(valueOfCheap, "valueOfCheap must not be null");
        this.informationScanner = Objects.requireNonNull(informationScanner, "informationScanner must not be null");
        this.stringArrayList = new LinkedList<>(Objects.requireNonNull(stringArrayList, "stringArrayList must not be null"));
    }

    public LocalProcessor() {
        this.processorName = new StringBuilder();
        this.period = 10_000_000_000_000L;
        this.processorVersion = new StringBuilder();
        this.valueOfCheap = 0;
        this.informationScanner = new Scanner(System.in);
        this.stringArrayList = new LinkedList<>();
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        if (stringList == null) {
            throw new IllegalStateException("Provided list is null");
        }

        List<String> tempList = new LinkedList<>(stringList);
        this.stringArrayList = tempList;

        for (String s : tempList) {
            if (s != null) {
                System.out.println(s.hashCode());
            } else {
                System.out.println("Null element encountered in stringList");
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(List<String> stringList) {
        if (stringList == null || processorName == null) {
            throw new IllegalStateException("Input list or processorName is null");
        }

        for (String s : stringList) {
            if (s != null) {
                processorName.append(s);
            } else {
                processorName.append("null");
            }
        }
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws IOException {
        if (file == null || processorVersion == null) {
            throw new IllegalStateException("File or processorVersion is null");
        }

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processorVersion.append(line).append(System.lineSeparator());
            }
        }
    }
}