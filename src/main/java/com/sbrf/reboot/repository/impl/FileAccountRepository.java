package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class FileAccountRepository implements AccountRepository {
    public String filePath;


    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) throws IOException {
        ArrayList<String> list = parse(filePath);
        Set<Long> result = new HashSet<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).contains("clientId") && list.get(i - 1).contains(String.valueOf(clientId))) {
                result.add(Long.parseLong(list.get(i).substring(14, 17)));
            }
        }
        return result;
    }

    public void updateAccountNumber(long clientId, long oldAccountNumber, long newAccountNumber) throws IOException {
        ArrayList<String> list = parse(filePath);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).contains("clientId") && list.get(i - 1).contains(String.valueOf(clientId))) {
                list.add(i, list.get(i).replace(String.valueOf(oldAccountNumber), String.valueOf(newAccountNumber)));
                list.remove(i + 1);
            }
        }
        File file = new File(filePath);
        PrintWriter writer = new PrintWriter(file);
        for (String line : list) {
            writer.println(line);
        }
        writer.close();
    }

    public ArrayList<String> parse(String filePath) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

            while (reader.ready()) {
                result.add(reader.readLine());
            }
        }
        return result;
    }

    @Override
    public String getClientEmailByClientId(long clientId) {
        return null;
    }
}
