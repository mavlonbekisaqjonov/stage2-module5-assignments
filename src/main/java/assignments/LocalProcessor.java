package assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private Integer valueofCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(StringBuilder processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
        // Default constructor
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        stringArrayList.forEach(s -> System.out.println(s.hashCode())); // Use method reference for clarity
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorGenerator(List<String> stringList) {
        stringList.forEach(s -> processorName.append(s)); // Using method reference for readability
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(processorVersion::append); // Efficiently reading the file line-by-line
        }
    }
}
