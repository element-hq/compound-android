<p align="center"><img src="https://compound.element.io/logo-readme.png" width="300" alt="" /></p>

# Compound Android

[![](https://img.shields.io/github/license/vector-im/compound)](https://github.com/vector-im/compound/blob/main/LICENSE)

This module contains the theme tokens for the application, including those auto-generated from [Compound](https://github.com/vector-im/compound-design-tokens) and its mappings.

## Usage

The module contains public tokens and color schemes that are later used in `MaterialTheme` and added to `ElementTheme` for use in the application.

All tokens can be accessed through the `ElementTheme` object, which contains the following properties:

* `ElementTheme.materialColors`: contains all Material color tokens. In Figma, they're prefixed with `M3/`. It's an alias to `MaterialTheme.colorScheme`. This should not be used, prefer using `ElementTheme.colors` instead.
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

## Copyright and License

Copyright (c) 2023 - 2025 New Vector Ltd

This software is dual licensed by New Vector Ltd (Element). It can be used either:

(1) for free under the terms of the GNU Affero General Public License (as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version); OR

(2) under the terms of a paid-for Element Commercial License agreement between you and Element (the terms of which may vary depending on what you and Element have agreed to).

Unless required by applicable law or agreed to in writing, software distributed under the Licenses is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the Licenses for the specific language governing permissions and limitations under the Licenses.