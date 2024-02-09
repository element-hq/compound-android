/*
 * Copyright (c) 2023 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.element.android.compound.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.previews.ColorsSchemePreview
import io.element.android.compound.tokens.generated.internal.DarkColorTokens
import io.element.android.compound.tokens.generated.internal.LightColorTokens

@OptIn(CoreColorToken::class)
internal val materialColorSchemeLight = lightColorScheme(
    primary = LightColorTokens.colorGray1400,
    onPrimary = LightColorTokens.colorThemeBg,
    primaryContainer = LightColorTokens.colorThemeBg,
    onPrimaryContainer = LightColorTokens.colorGray1400,
    inversePrimary = LightColorTokens.colorThemeBg,
    secondary = LightColorTokens.colorGray900,
    onSecondary = LightColorTokens.colorThemeBg,
    secondaryContainer = LightColorTokens.colorGray400,
    onSecondaryContainer = LightColorTokens.colorGray1400,
    tertiary = LightColorTokens.colorGray900,
    onTertiary = LightColorTokens.colorThemeBg,
    tertiaryContainer = LightColorTokens.colorGray1400,
    onTertiaryContainer = LightColorTokens.colorThemeBg,
    background = LightColorTokens.colorThemeBg,
    onBackground = LightColorTokens.colorGray1400,
    surface = LightColorTokens.colorThemeBg,
    onSurface = LightColorTokens.colorGray1400,
    surfaceVariant = LightColorTokens.colorGray300,
    onSurfaceVariant = LightColorTokens.colorGray900,
    surfaceTint = LightColorTokens.colorGray1000,
    inverseSurface = LightColorTokens.colorGray1300,
    inverseOnSurface = LightColorTokens.colorThemeBg,
    error = LightColorTokens.colorRed900,
    onError = LightColorTokens.colorThemeBg,
    errorContainer = LightColorTokens.colorRed400,
    onErrorContainer = LightColorTokens.colorRed900,
    outline = LightColorTokens.colorGray800,
    outlineVariant = LightColorTokens.colorAlphaGray400,
    scrim = LightColorTokens.colorGray1400,
)

@OptIn(CoreColorToken::class)
internal val materialColorSchemeDark = darkColorScheme(
    primary = DarkColorTokens.colorGray1400,
    onPrimary = DarkColorTokens.colorThemeBg,
    primaryContainer = DarkColorTokens.colorThemeBg,
    onPrimaryContainer = DarkColorTokens.colorGray1400,
    inversePrimary = DarkColorTokens.colorThemeBg,
    secondary = DarkColorTokens.colorGray900,
    onSecondary = DarkColorTokens.colorThemeBg,
    secondaryContainer = DarkColorTokens.colorGray400,
    onSecondaryContainer = DarkColorTokens.colorGray1400,
    tertiary = DarkColorTokens.colorGray900,
    onTertiary = DarkColorTokens.colorThemeBg,
    tertiaryContainer = DarkColorTokens.colorGray1400,
    onTertiaryContainer = DarkColorTokens.colorThemeBg,
    background = DarkColorTokens.colorThemeBg,
    onBackground = DarkColorTokens.colorGray1400,
    surface = DarkColorTokens.colorThemeBg,
    onSurface = DarkColorTokens.colorGray1400,
    surfaceVariant = DarkColorTokens.colorGray300,
    onSurfaceVariant = DarkColorTokens.colorGray900,
    surfaceTint = DarkColorTokens.colorGray1000,
    inverseSurface = DarkColorTokens.colorGray1300,
    inverseOnSurface = DarkColorTokens.colorThemeBg,
    error = DarkColorTokens.colorRed900,
    onError = DarkColorTokens.colorThemeBg,
    errorContainer = DarkColorTokens.colorRed400,
    onErrorContainer = DarkColorTokens.colorRed900,
    outline = DarkColorTokens.colorGray800,
    outlineVariant = DarkColorTokens.colorAlphaGray400,
    scrim = DarkColorTokens.colorGray300,
)

@Preview
@Composable
internal fun ColorsSchemeLightPreview() = ElementTheme {
    ColorsSchemePreview(
        Color.Black,
        Color.White,
        ElementTheme.materialColors,
    )
}

@Preview
@Composable
internal fun ColorsSchemeDarkPreview() = ElementTheme(darkTheme = true) {
    ColorsSchemePreview(
        Color.White,
        Color.Black,
        materialColorSchemeDark,
    )
}
