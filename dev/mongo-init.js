print('Start #################################################################');

db = db.getSiblingDB('pet-clinic')

db.createUser({
    user: "petClinic",
    pwd: "petClinic",
    roles: [{
            role: "readWrite",
            db: "pet-clinic"
    }]
    }
);

db.createCollection('vets');

db.vets.insertMany([
    {firstName: 'James', lastName: 'Carter', speciality: 'radiology'},
    {firstName: 'Helen', lastName: 'Leary', speciality: 'surgery'},
    {firstName: 'Linda', lastName: 'Douglas', speciality: 'dentistry'},
])

db = db.getSiblingDB('vet-review')

db.createUser({
        user: "vetReview",
        pwd: "vetReview",
        roles: [{
            role: "readWrite",
            db: "vet-review"
        }]
    },
);

db.createCollection('vet_reviews');

db = db.getSiblingDB('pet-clinic')

db.vets.insertMany([
    {firstName: 'James', lastName: 'Carter', speciality: 'radiology'},
    {firstName: 'Helen', lastName: 'Leary', speciality: 'surgery'},
    {firstName: 'Linda', lastName: 'Douglas', speciality: 'dentistry'},
]);


db = db.getSiblingDB('vet-review')

db.vet_reviews.insertMany([
    {
        "publicId" : "0ee19b1c-ec8e-11ea-adc1-0242ac120002",
        "rating" : 4.0,
        "comment" : "Good vet in the area",
        "vetId" : "60e486b4-152f-4e15-ad5c-b7fefb1cdde7",
        "creationDate" : ISODate('2020-08-28T00:51:47')
    },
    {
        "rating" : 4.0,
        "comment" : "Very good vet",
        "vetId" : "63df3aa6-a0aa-41fa-9da5-97802ae4ad93",
        "creationDate": ISODate('2020-08-28T00:55:29'),
        "publicId" : "0ee19b1c-ec8e-11ea-adc1-0242ac120003"
    },
    {
        "rating" : 2.5,
        "comment" : "Bad experience with this vet",
        "vetId" : "60e486b4-152f-4e15-ad5c-b7fefb1cdde7",
        "creationDate" : ISODate("2020-08-31T20:31:11"),
        "publicId" : "0ee19b1c-ec8e-11ea-adc1-0242ac120004"
    },
    {
        "rating" : 2.5,
        "comment" : "Bad experience with this vet",
        "vetId" : "63df3aa6-a0aa-41fa-9da5-97802ae4ad93",
        "creationDate" : ISODate("2020-08-31T20:31:16"),
        "publicId" : "0ee19b1c-ec8e-11ea-adc1-0242ac120005"
    },
    {
        "rating": 2.5,
        "comment": "Bad experience with this vet",
        "vetId": "9fbf2ac6-9df9-444f-b831-669fae533fe3",
        "creationDate": ISODate("2020-08-31T20:31:20"),
        "publicId": "0ee19b1c-ec8e-11ea-adc1-0242ac120006"
    }
])