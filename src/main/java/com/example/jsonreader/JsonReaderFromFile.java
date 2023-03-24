package com.example.jsonreader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
class JsonReaderFromFile implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonReaderFromFile.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            LOGGER.info("Bitte geben Sie den Dateinamen als Startparameter an.");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            LOGGER.info("Die Datei {} konnte nicht gefunden werden.", fileName);
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
  //           List<JsonData> j = new ArrayList<>(Arrays.asList(objectMapper.readValue(fileInputStream, JsonData[].class)));
            List<JsonData> j = Arrays.asList(objectMapper.readValue(fileInputStream, JsonData[].class));
            LOGGER.info("Daten aus " + fileName + ": " + j);
            for (JsonData jsonData : j) {
                LOGGER.info("in Schleife");
                personRepository.save(new Person(jsonData.getName(), jsonData.getAge()));
            }
            // Ausgabe der Personen aus der Datenbank
            List<Person> savedPersons = personRepository.findAll();

            LOGGER.info ("Personen aus der Datenbank:");
            for (Person savedPerson : savedPersons) {
                LOGGER.info (savedPerson.getName() + " " + savedPerson.getAge());
            }

        } catch (IOException e) {
            LOGGER.info("Fehler beim Schreiben der Datei " + fileName + ": " + e.getMessage());
        }
     }
}
