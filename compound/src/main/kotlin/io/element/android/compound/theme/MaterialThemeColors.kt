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

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.previews.ColorsSchemePreview
import io.element.android.compound.tokens.generated.SemanticColors
import io.element.android.compound.tokens.generated.compoundColorsHcDark
import io.element.android.compound.tokens.generated.compoundColorsHcLight
import io.element.android.compound.tokens.generated.internal.DarkColorTokens
import io.element.android.compound.tokens.generated.internal.LightColorTokens

@OptIn(CoreColorToken::class)
fun SemanticColors.toMaterialColorScheme(): ColorScheme {
    return if (isLight) {
        lightColorScheme(
            primary = textPrimary,
            onPrimary = textOnSolidPrimary,
            primaryContainer = textOnSolidPrimary,
            onPrimaryContainer = textPrimary,
            inversePrimary = textOnSolidPrimary,
            secondary = textSecondary,
            onSecondary = textOnSolidPrimary,
            secondaryContainer = bgSubtlePrimary,
            onSecondaryContainer = textPrimary,
            tertiary = textSecondary,
            onTertiary = textOnSolidPrimary,
            tertiaryContainer = textPrimary,
            onTertiaryContainer = textOnSolidPrimary,
            background = textOnSolidPrimary,
            onBackground = textPrimary,
            surface = textOnSolidPrimary,
            onSurface = textPrimary,
            surfaceVariant = LightColorTokens.colorGray300,
            onSurfaceVariant = iconSecondary,
            surfaceTint = LightColorTokens.colorGray1000,
            inverseSurface = LightColorTokens.colorGray1300,
            inverseOnSurface = textOnSolidPrimary,
            error = bgCriticalPrimary,
            onError = textOnSolidPrimary,
            errorContainer = LightColorTokens.colorRed400,
            onErrorContainer = textCriticalPrimary,
            outline = iconSecondary,
            outlineVariant = LightColorTokens.colorAlphaGray400,
            scrim = textPrimary,
        )
    } else {
        darkColorScheme(
            primary = textPrimary,
            onPrimary = textOnSolidPrimary,
            primaryContainer = textOnSolidPrimary,
            onPrimaryContainer = textPrimary,
            inversePrimary = textOnSolidPrimary,
            secondary = textSecondary,
            onSecondary = textOnSolidPrimary,
            secondaryContainer = bgSubtlePrimary,
            onSecondaryContainer = textPrimary,
            tertiary = textSecondary,
            onTertiary = textOnSolidPrimary,
            tertiaryContainer = textPrimary,
            onTertiaryContainer = textOnSolidPrimary,
            background = textOnSolidPrimary,
            onBackground = textPrimary,
            surface = textOnSolidPrimary,
            onSurface = textPrimary,
            surfaceVariant = DarkColorTokens.colorGray300,
            onSurfaceVariant = iconSecondary,
            surfaceTint = DarkColorTokens.colorGray1000,
            inverseSurface = DarkColorTokens.colorGray1300,
            inverseOnSurface = textOnSolidPrimary,
            error = bgCriticalPrimary,
            onError = textOnSolidPrimary,
            errorContainer = DarkColorTokens.colorRed400,
            onErrorContainer = textCriticalPrimary,
            outline = iconSecondary,
            outlineVariant = DarkColorTokens.colorAlphaGray400,
            scrim = bgSubtleSecondary,
        )
    }
}

@Preview(heightDp = 1200)
@Composable
internal fun ColorsSchemeLightPreview() = ElementTheme {
    ColorsSchemePreview(
        Color.Black,
        Color.White,
        ElementTheme.materialColors,
    )
}

@Preview(heightDp = 1200)
@Composable
internal fun ColorsSchemeLightHcPreview() = ElementTheme(
    compoundLight = compoundColorsHcLight,
) {
    ColorsSchemePreview(
        Color.Black,
        Color.White,
        ElementTheme.materialColors,
    )
}

@Preview(heightDp = 1200)
@Composable
internal fun ColorsSchemeDarkPreview() = ElementTheme(
    darkTheme = true,
) {
    ColorsSchemePreview(
        Color.White,
        Color.Black,
        ElementTheme.materialColors,
    )
}

@Preview(heightDp = 1200)
@Composable
internal fun ColorsSchemeDarkHcPreview() = ElementTheme(
    darkTheme = true,
    compoundDark = compoundColorsHcDark,
) {
    ColorsSchemePreview(
        Color.White,
        Color.Black,
        ElementTheme.materialColors,
    )
}
