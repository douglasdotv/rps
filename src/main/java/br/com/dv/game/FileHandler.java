package br.com.dv.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class FileHandler {

    private final String fileName;
    private final HashMap<String, Integer> players;

    public FileHandler(String fileName) {
        this.fileName = fileName;
        this.players = new HashMap<>();
    }

    public HashMap<String, Integer> readFile() {
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                players.put(lineWords[0], Integer.parseInt(lineWords[1]));
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return players;
    }

}
