# ShadeKZ

Privacy-first shade-aware and thermal walking navigation for Kazakhstan.

ShadeKZ is a navigation application designed to find walking routes that reduce direct sun exposure and thermal discomfort.

## Core idea

Instead of optimizing only for distance or travel time, ShadeKZ considers:

- Sun position
- Building geometry and height
- Building shadows
- Tree and vegetation shadows where data is available
- Weather conditions
- Temperature
- Humidity
- Wind
- Solar radiation
- UV conditions
- Walking time
- Route length
- Data confidence

The route is calculated according to the estimated conditions at the time the user reaches each part of the route.

## Privacy

Privacy is a fundamental architectural requirement.

The application is designed so that:

- Precise user location remains on the device whenever possible.
- Location history is not collected by default.
- Routes are not publicly associated with users.
- No user location map is maintained.
- Analytics must not contain precise location data.
- Only the minimum required Android permissions are requested.
- Sensitive local data is protected.
- Third-party services must not receive precise location unless explicitly required and consented to.

## Architecture

```text
Android
   │
   ├── Location
   ├── MapLibre
   ├── Solar Engine
   ├── Shadow Engine
   ├── Routing
   └── Privacy Layer
          │
          ▼
       Local data
          │
          ▼
      Minimal API
          │
   ┌──────┼────────┐
   ▼      ▼        ▼
 Maps   Shadows  Weather