package com.rafikiroast.util;

import com.rafikiroast.models.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        File folder = new File("receipts");
        if (!folder.exists()) folder.mkdir();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);

        String fileName = "receipts/Order" + order.getOrderNumber() + "-" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.toString());
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
