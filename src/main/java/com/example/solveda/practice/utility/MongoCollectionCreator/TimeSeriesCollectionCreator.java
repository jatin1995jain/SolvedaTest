package com.example.solveda.practice.utility.MongoCollectionCreator;


import com.mongodb.client.model.TimeSeriesGranularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.mongodb.client.model.TimeSeriesOptions;


@Component
public class TimeSeriesCollectionCreator implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        String collectionName = "Thermostat_timeseries_data_1";

        if (!mongoTemplate.collectionExists(collectionName)) {
            // Create time-series options
            TimeSeriesOptions timeSeriesOptions = new TimeSeriesOptions("timestamp")
                    .metaField("meta")
                    .granularity(TimeSeriesGranularity.MINUTES);

            mongoTemplate.createCollection(collectionName);

            System.out.println("Time-series collection created: " + collectionName);
        }
    }
}
