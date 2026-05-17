# Open/Closed Principle (OCP)

OCP is a principle that states that your code should be open for
extension, but closed for modification. This means it is possible
to add new features without changing existing code, ensuring
long-term maintainability.

In this exercise, I started with a flawed implementation that
violates OCP: the class OrderNotificationServiceBefore used a
chain of if/else statements to determine which channels to notify.
The class had to be modified every time a new channel was added.

To fix this, I extracted a NotificationChannel interface and created
a concrete class for each channel (Email, SMS, Push). The
OrderNotificationService now only orchestrates which channel to
invoke. No existing class needs to be modified when a new channel
is introduced — you simply implement the interface and wire it in.

One important consideration when applying OCP: avoid overengineering.
Introducing abstractions adds complexity, so this principle should
only be applied where extensibility is genuinely needed — not every
class needs to be designed for extension from the start.