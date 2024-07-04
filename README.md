<p align="center"><img src="https://compound.element.io/logo-readme.png" width="300" alt="" /></p>

# Compound Android

[![](https://img.shields.io/github/license/vector-im/compound)](https://github.com/vector-im/compound/blob/main/LICENSE)

This module contains the theme tokens for the application, including those auto-generated from [Compound](https://github.com/vector-im/compound-design-tokens) and its mappings.

## Usage

The module contains public tokens and color schemes that are later used in `MaterialTheme` and added to `ElementTheme` for use in the application.

All tokens can be accessed through the `ElementTheme` object, which contains the following properties:

* `ElementTheme.materialColors`: contains all Material color tokens. In Figma, they're prefixed with `M3/`. It's an alias to `MaterialTheme.colorScheme`.
* `ElementTheme.colors`: contains all Compound semantic color tokens. In Figma, they're prefixed with either `Light/` or `Dark/`.
* `ElementTheme.typography`: contains the Compound `TypographyTokens` values. In Figma, they're prefixed with `Android/font/`.

## Adding new tokens

All new tokens **should** come from Compound and added to the `compound.generated` package. Same thing for the value of `compoundColorsLight`, `compoundColorsDark`, `compoundColorsHcLight` and `compoundColorsHcDark`.

## Unit tests

To run Roborazzi test, run:

```bash
./gradlew :compound:verifyRoborazziDebug
```

To record the screenshot, run:

```bash
./gradlew :compound:recordRoborazziDebug
```

## Releasing

To release a new version of the module, you'll have to:

1. Update the version in `compound/build.gradle.kts`. 
2. Create a `version-x.y.z` branch and create a PR.
3. When the PR is merged, a new tag will be created and the module will automatically be published to Maven Central.
