# Liskov Substitution Principle

LSP is a principle that states that subtypes are fully substitutable for their base types, without breaking the program's behavior.

In this exercise, PushNotificationSender violated LSP by throwing an
IllegalArgumentException when the message exceeded 100 characters — a
behaviour the base class contract explicitly did not allow.

The fix was to handle the failure internally: log a warning with the
recipient and message length, and skip the send silently. This keeps the
contract intact — no exceptions reach the caller, regardless of which
sender implementation is injected.