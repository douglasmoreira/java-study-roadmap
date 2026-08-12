# Week 7 — Naming, Functions & Code Readability

## Concept

Giving code a good name is an important part of ensuring it is easy to maintain and understand. In this exercise, the original code had several problems: methods, parameters, and variables with unclear names, a bug hidden by that lack of clarity, and a method with too many parameters — a sign that it was doing more than one thing.

## What was fixed

- **Renamed** all unclear identifiers (methods, parameters, variables) to intention-revealing names. Once renamed, the underlying problems in the code became much easier to see.
- **Removed unnecessary parameters.** The `shouldLog` flag was removed — logging happens on every call regardless, since it's not something that should depend on the caller's choice.
- **Replaced a magic-number-driven dispatch** (an `int` with `if`/`switch` branches deciding the notification channel) with a `NotificationType` enum, making the valid values explicit and compiler-checked instead of relying on unclear integer parameters.
- **Fixed a bug** where, under a specific and non-obvious scenario (priority + SMS), the code sent an email in addition to the SMS — with no clear rule describing when that should happen. The priority-email behavior was extracted into its own explicit method (`sendPriorityEmail`) instead of being controlled by a hidden boolean flag, which removes the bug and makes the behavior intentional and visible at the call site.

## Key takeaway

A flag argument doesn't just make a method harder to read — it can actively hide bugs, since it lets a function silently do two different things depending on a boolean that's invisible at the point of use.