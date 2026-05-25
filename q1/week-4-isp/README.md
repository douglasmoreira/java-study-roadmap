# Interface Segregation Principle

ISP states that a class should never be forced to implement methods it does not use.

In this exercise, the class CardPaymentAdapterBefore violates the ISP by implementing a methods it does not use.

To fix this violation, I split the interface PaymentProcessorBefore into three focused interfaces: CardProcessor, BoletoProcessor, and PixProcessor, so that each adapter implements only the methods it actually needs.