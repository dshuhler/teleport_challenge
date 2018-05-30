- City names will never contain dashes. The current input format won't allow it - since you can't know how to parse
something like `Dallas - Ft. Worth - Austin`. It would be better to use a divider char that won't occur in a real name,
like `+`.
- Badly formed queries are ignored
