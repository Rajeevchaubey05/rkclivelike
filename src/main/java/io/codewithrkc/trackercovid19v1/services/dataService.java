package io.codewithrkc.trackercovid19v1.services;

import io.codewithrkc.trackercovid19v1.models.CovidDataLocationWise;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class dataService {
    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<CovidDataLocationWise> allCovidData = new ArrayList<>();

    public  List<CovidDataLocationWise> getAllCovidData() {
        return allCovidData;
    }

    @PostConstruct
    @Scheduled(cron = "* * * * * *")
    public void fetchVirusData () throws IOException {
        List<CovidDataLocationWise> newCovidData = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(VIRUS_DATA_URL, String.class);
        StringReader csvBodyReader = new StringReader(result);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            CovidDataLocationWise covidData = new CovidDataLocationWise();
            covidData.setState(record.get("Province/State"));
            covidData.setCountry(record.get("Country/Region"));
            int latestCount = Integer.parseInt(record.get(record.size()-1));
            int prevCount = Integer.parseInt(record.get(record.size()-2));
            covidData.setCurrentTotalCase(latestCount);
            covidData.setDiffFromPrevDay(latestCount - prevCount);
            newCovidData.add(covidData);
        }
        this.allCovidData = newCovidData;
    }
}
