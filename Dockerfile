FROM mongo

CMD mongoimport --uri "mongodb://localhost:27017/quotes" --type json --file ./quotes.json --jsonArray