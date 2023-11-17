## Time spent (around 18h)


## Getting Started
To get started with the project, follow these steps:

1. Clone the repository to your local machine:
    ```shell
    git clone https://github.com/andrecastrosousa/quotesChallenge
2. Navigate to the project directory:
    ```shell
    cd quotesChallenge
3. Start the MongoDB, ensuring that are up. using the following command:
    ```shell
   docker-compose up -d

4. Run script to import data to MongoDB.<br>
   <i>You can find data in /mongo-seed/quotes.json 
   as 50.000 quotes from following URL: https://pprathameshmore.github.io/QuoteGarden/#get-quotes </i>
   ```shell
   cd mongo-seed && sh import-data.sh

5. Run the application:
    ```shell
   ./gradlew run 

6. Test the application:
    ```shell
   ./gradlew test

Results of 3 stress test using 50 requests per second for `api/quotes/5eb17aaeb69dc744b4e7262f`, tool used JMeter:
![image](https://github.com/andrecastrosousa/quotesChallenge/assets/23742537/fe2175fa-98a9-4492-bb39-ad0a54830397)

Result of 1 stress test using 50 request per second for `api/quotes/search?author=Bill%20Gates`, tool used JMeter
![image](https://github.com/andrecastrosousa/quotesChallenge/assets/23742537/12065d5c-76cf-431a-b452-54c8530ed4bc)
