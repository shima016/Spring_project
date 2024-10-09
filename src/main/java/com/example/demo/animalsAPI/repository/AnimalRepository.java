package com.example.demo.animalsAPI.repository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.animalsAPI.data.AnimalData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {

    public List<AnimalData> getAnimalById(int id) throws IOException {
        String urlString = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id=" + id;
        return fetchAnimalsFromApi(urlString);
    }

    public List<AnimalData> getAllAnimals() throws IOException {
        String urlString = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI"; // 全ての動物を取得
        return fetchAnimalsFromApi(urlString);
    }

    private List<AnimalData> fetchAnimalsFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        ObjectMapper objectMapper = new ObjectMapper();
        List<AnimalData> animalList = objectMapper.readValue(connection.getInputStream(), new TypeReference<List<AnimalData>>() {});
        connection.disconnect();
        return animalList;
    }
}