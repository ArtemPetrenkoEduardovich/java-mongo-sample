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
  "startDate": "string",  // LocalDate
  "endDate": "string",    // LocalDate
  "amount": "double",
  "clientId": "string"
  "status": ["ACTIVE", "CANCELED", "COMPLETED", "DRAFT", "PENDING_PAYMENT"]
}

"Payment": {
  "id": "string",
  "paymentDate": "string",  // ISO 8601
  "amount": "double",
  "paymentMethod": ["CREDIT_CARD", "BANK_TRANSFER", "CASH", "PAYPAL"],
  "contractId": "string"
}

Implement different operations with the contract
- create a DRAFT
- publish and wait for payment (PENDING_PAYMENT)
- cancel contract
- complete if the endDate is over
- ACTIVE if the contract has been fully paid (Let's think that the contract can be activated when the full price is paid and at that moment startDate is set)

Implement payment generator on POST: api/payment/generate/:size generate a list of payment + their contract + their clients

Implement payment process:
When there's an unpaid contract and the payment is come.

Cover by tests