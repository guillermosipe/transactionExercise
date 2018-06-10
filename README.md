# transactionExercise

## Execute options
### Add
java -jar application.jar <id> <transaction_json>

transaction_json format: { “amount”: 1.23, “description”: “Joes Tacos”, “date”:”2018-12-30”, “user_id”: 345 }

Request:
  ```console
  $ java -jar application.jar 100 add { \"amount\":30.23 , \"description\":\"Tacos\" , \"date\":\"2019-04-30\" , \"user_id\":1 }
   ```
Response:
  ```json
  {"transaction_id":"0f3b133b-0596-39f2-77e8-e60949622685","amount":30.23,"description":"Tacos","date":"2019-04-30","user_id":1}
  ```
### Show

java -jar application.jar <id> <transaction_id>

Request:
```console
 $ java -jar application.jar 100 06502864-2384-1de1-6a5a-056456e1d5f6
 ```
Response:
 if exist:
  ```json
  {"transaction_id":"06502864-2384-1de1-6a5a-056456e1d5f6","amount":30.23,"description":"Tacos","date":"2019-04-30","user_id":1}
  ```
 else:
  ```json
  Transaction not found
  ```
### Sum
java -jar application.jar <id> sum

Request:
  ```console
  $ java -jar application.jar 100 sum
  ```
Response:
  ```json
  {"user_id":100,"sum":241.62}
  ```
### List

java -jar application.jar <id> list

Request:
  ```console
  $ java -jar application.jar 100 list
  ```
Response:
  ```json
  [{"transaction_id":"e2271aa9-02e6-1b56-6088-28c6bb1264d1","amount":50.01,"description":"Pizza","date":"2019-12-30","user_id":345},{"transaction_id":"168543c7-ee89-d904-03dd-bc79d9ef4326","amount":10.23,"description":"Tacos","date":"2018-12-30","user_id":345},{"transaction_id":"b9d4b4dd-f097-53c9-3b41-b43e224ca699","amount":20.23,"description":"Hamburguesas","date":"2018-02-28","user_id":345},{"transaction_id":"c1dcbfef-63e4-a4c9-25fe-361f9702b58c","amount":40.23,"description":"Empanadas","date":"2018-01-30","user_id":345},{"transaction_id":"5d47793a-9ea9-2334-01e5-5156d87be013","amount":30.23,"description":"Tamales","date":"2017-12-30","user_id":345}]
  ```
