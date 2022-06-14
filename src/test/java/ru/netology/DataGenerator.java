package ru.netology;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    @Step("Генерируем дату")
    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Step("Получаем название города")
    public static String generateCity(String locale) {
        String[] listOfCities = new String[]{"Вологда", "Уфа", "Новосибирск", "Адлер"};
        int city = (int) Math.floor(Math.random() * listOfCities.length);
        return listOfCities[city];
    }
    @Step("Генерируем имя при помощи faker")
    public static String generateName(String locale) {
        return faker.name().fullName();
    }
    @Step("Генерируем телефонный номер {generatePhone}")
    public static String generatePhone(String locale) {
        return faker.phoneNumber().phoneNumber();
    }
}
