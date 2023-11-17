DATABASE_URI="mongodb://localhost:27017/quotes"
COLLECTION_NAME="quotes"
JSON_FILE="./quotes.json"

mongoimport --uri ${DATABASE_URI} --collection $COLLECTION_NAME --drop --type json --file $JSON_FILE --jsonArray