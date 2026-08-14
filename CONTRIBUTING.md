# Contributing to ShadeKZ

## Development principles

ShadeKZ is designed around privacy, correctness and reproducibility.

Before adding a feature, consider:

1. Does it need personal data?
2. Can it work entirely on the device?
3. Can the amount of collected data be reduced?
4. Does it introduce a third-party tracking mechanism?
5. Can the calculation be independently tested?

## Location privacy

Never add code that sends precise user coordinates to a server without an explicit architectural reason and documented consent flow.

Do not store:

- location history
- home location
- school/work location
- precise route history

unless a future feature explicitly requires it and the privacy architecture is redesigned accordingly.

## Geospatial data

OpenStreetMap-derived data must retain appropriate attribution and comply with its license.

## Code quality

Prefer:

- small components
- deterministic calculations
- unit tests for mathematical algorithms
- documented assumptions
- explicit uncertainty

Avoid:

- hidden network requests
- hard-coded API keys
- undocumented location collection
- silently enabled telemetry