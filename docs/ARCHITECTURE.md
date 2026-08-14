# ShadeKZ Architecture

## 1. High-level architecture

ShadeKZ consists of two major parts:

1. Android client
2. Geospatial data infrastructure

The client should perform privacy-sensitive operations locally whenever practical.

```text
                 ┌────────────────────┐
                 │ Geospatial backend  │
                 ├────────────────────┤
                 │ OSM data            │
                 │ Building data       │
                 │ Shadow tiles        │
                 │ Weather             │
                 │ Map tiles           │
                 └─────────┬──────────┘
                           │
                           ▼
┌────────────────────────────────────────────┐
│                 Android                    │
│                                            │
│  Location                                  │
│      │                                     │
│      ▼                                     │
│  Solar Engine                              │
│      │                                     │
│      ▼                                     │
│  Shadow Engine                              │
│      │                                     │
│      ▼                                     │
│  Routing Engine                             │
│      │                                     │
│      ▼                                     │
│  Route ranking                              │
│                                            │
└────────────────────────────────────────────┘