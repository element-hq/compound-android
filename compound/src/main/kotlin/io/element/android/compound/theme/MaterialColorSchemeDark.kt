/*
 * Copyright 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.compound.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.tokens.generated.SemanticColors
import io.element.android.compound.tokens.generated.internal.DarkColorTokens

@OptIn(CoreColorToken::class)
fun SemanticColors.toMaterialColorSchemeDark(): ColorScheme = darkColorScheme(
    primary = bgActionPrimaryRest,
    onPrimary = textOnSolidPrimary,
    primaryContainer = bgActionPrimaryRest,
    onPrimaryContainer = textOnSolidPrimary,
    inversePrimary = bgCanvasDefault,
    // Cannot use bgActionSecondaryRest, the value is not correct
    secondary = bgActionPrimaryRest,
    onSecondary = textOnSolidPrimary,
    // Cannot use bgActionSecondaryRest, the value is not correct
    secondaryContainer = bgActionPrimaryRest,
    onSecondaryContainer = textOnSolidPrimary,
    // Cannot use bgActionSecondaryRest, the value is not correct
    tertiary = bgActionPrimaryRest,
    onTertiary = textOnSolidPrimary,
    tertiaryContainer = bgActionPrimaryRest,
    onTertiaryContainer = textOnSolidPrimary,
    background = bgCanvasDefault,
    onBackground = textPrimary,
    surface = bgCanvasDefault,
    onSurface = textPrimary,
    surfaceVariant = bgSubtlePrimary,
    onSurfaceVariant = textPrimary,
    surfaceTint = DarkColorTokens.colorGray1000,
    inverseSurface = DarkColorTokens.colorGray1300,
    inverseOnSurface = textOnSolidPrimary,
    error = bgCriticalPrimary,
    onError = textOnSolidPrimary,
    errorContainer = bgCriticalPrimary,
    onErrorContainer = textOnSolidPrimary,
    outline = iconSecondary,
    outlineVariant = DarkColorTokens.colorAlphaGray400,
    scrim = bgSubtleSecondary,
)
