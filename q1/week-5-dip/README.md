# Dependency Inversion Principle

DIP states that high-level modules should depend only on abstractions, never on concrete details.

In this exercise, `PaymentProcessingService` directly instantiated `StripePaymentGateway` and `MySqlPaymentRepository` inside its constructor, coupling the business logic to infrastructure and making the class impossible to test in isolation.

To fix this, I extracted the interfaces `PaymentGateway` and `PaymentRepository`, applied constructor injection, and made the service depend on these abstractions instead of their concrete implementations. This decouples the domain from infrastructure and enables unit testing with mocks — which was impossible before the refactor.