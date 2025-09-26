I have deleted the mongo curl from properties because I was using my companies qa cluster as Mongo atlas was having issues
on their website
Sorry but please add one mongo db at your end to make this working

Curl that shows transactions working

curl --location 'http://localhost:8080/order/with-payments' \
--header 'Content-Type: application/json' \
--data '{
    "order": {
        "customerName": "John Doe",
        "amount": 1200.50,
        "status": "PENDING",
        "totalAmount" : 1200.50
    },
    "paymentList": [
        {
            "paymentMethod": "CREDIT_CARD",
            "amount": 600.25,
            "status": "PENDING"
        },
        {
            "paymentMethod": "UPI",
            "amount": 600.25

        }
    ]
}'

In this curl i have removed status from 2nd payment which is saved post first payment and order but
since the save call for 2nd payment fails it returns error showing that saved calls are only committed if
all the save or update calls are working

Below will save the data

curl --location 'http://localhost:8080/order/with-payments' \
--header 'Content-Type: application/json' \
--data '{
    "order": {
        "customerName": "John Doe",
        "amount": 1200.50,
        "status": "PENDING",
        "totalAmount" : 1200.50
    },
    "paymentList": [
        {
            "paymentMethod": "CREDIT_CARD",
            "amount": 600.25,
            "status": "PENDING"
        },
        {
            "paymentMethod": "UPI",
            "amount": 600.25,
            "status": "PENDING"

        }
    ]
}'



For mongo Project

I have created a collection name Thermostat_timeseries_data
to create timeseries collection I have created a Collection creater in Util which will create my timeSeries collection

Also a simulator which is using threading to insert data into Thermostat collection

Below is the curl to fetch data from Thermostat collection

curl --location 'http://localhost:8080/thermostats?deviceId=thermo1&startTime=2025-09-24T00%3A00%3A00Z&endTime=2025-09-28T00%3A00%3A00Z'



