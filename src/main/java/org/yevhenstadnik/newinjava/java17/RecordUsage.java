package org.yevhenstadnik.newinjava.java17;

import java.util.List;

public class RecordUsage {
    public static void main(String[] args) {
        RecordJava16 record = new RecordJava16("John Doe", 12345);
        RecordJava16 record2 = new RecordJava16("John Doe", 12345);
        System.out.println("Name: " + record.name());
        System.out.println("ID No: " + record.idNo());
        // record.setName("Jane Doe"); // This line will cause a compilation error
        // record.getName(); // This line will also cause a compilation error
        System.out.println("String representation of record: " + record.toString());
        System.out.println("The hash of record: " + record.hashCode());
        System.out.println("Two records are equal: " + record.equals(record2));
        List<RecordJava16> records = List.of(record, record2); // Using records as a generic type
    }
}
