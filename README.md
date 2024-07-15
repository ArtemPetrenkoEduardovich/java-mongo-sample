# java-mongo-sample (JMS/jms)

I want to try to create a project using Java + mongoDB in order to refresh java in my mind after 3 years of break and learn how to work with mongoDB in Java.

Subject area is going to be:
Client
Contract
Payment

"Client": {
  "id": "string",
  "firstName": "string",
  "lastName": "string",
  "contactInfo": {
    "email": "string",
    "phone": "string"
  }
}

"Contract": {
  "id": "string",
  "contractNumber": "string",
  "startDate": "string",  // ISO 8601
  "endDate": "string",
  "amount": "number",
  "clientId": "string"
}

"Payment": {
  "id": "string",
  "paymentDate": "string",  // ISO 8601
  "amount": "number",
  "paymentMethod": ["credit_card", "bank_transfer", "cash", "paypal"],
  "contractId": "string"
}
