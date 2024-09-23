# Changelog

# v0.1.0:
- Import Semantics color and typography from compound tokens.
- Replace avatar colors with updated values.
- Update Compose to `BOM 2024.09.02` and Material 3 to `v1.3.0`. 

# v0.0.7:

- Import Semantics color from compound token, and new color: `iconAccentPrimary`, and make them public so that they can be copied to override colors.
- New icons: `ExtensionsSolid`, `MarkAsRead`, `MarkAsUnread`, `Minus`
- Add more screenshot tests.

# v0.0.6:

- Remove Accompanist SystemUiController library.
- Bump dependencies: Kotlin `1.9.23`, Compose BOM `2024.04.00`, Material3 `1.3.1`, AGP `8.3.1`, Robolectric `4.12.1`.
- Update Compound tokens (new decorative colors, photo solid icon).

# v0.0.5:

- Update icons from Compound, also change how the `CompoundIcons` helper works. **This is a breaking change.**
- Add regression tests, coverage support and a publishing flow.

# v0.0.4:

- Add `applySystemBarsUpdate` to `ElementTheme` to control whether using nested theming should affect the system bars tinting.
- Improve how the Material3 color schemes are provided to the theming.

# v0.0.3:

- Disable vector icons rasterization to PNGs.

## v0.0.2:

- Prevent minification of the library.

## v0.0.1:

- Initial version.
