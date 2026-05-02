# Single Responsibility Principle SRP

* SRP is a principle that helps create classes with only one reason to change, that is important because when you follow this principle is easier to maintain the code fewer places need to change when code is updated or increase more features.

* In my study I worked with a class named "UserService" with some problems about SRP (Single Responsibility Principle), like, validate the inputs, hash the password, save to the database, and send message. 

* Analyzing this class I solved it by extracting each responsibility into separate classes and keeping the class "UserService" just orchestrating the flow. Now each class has only one reason to be changed by one actor that ensure it is independently without affecting other parts of code.

* In this study I can see an interesting thing about SRP, when you apply this principle, the understanding about what is the context of the class can be changed by different people, and it turns difficult in some case to define what keep in the class or extract to another, you need to first define the exact context and responsibility of the class, then decide where each piece of code belongs.