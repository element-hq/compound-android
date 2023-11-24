package io.element.android.compound.theme

import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.tokens.generated.internal.DarkColorTokens
import io.element.android.compound.tokens.generated.internal.LightColorTokens

/**
 * Avatar colors are not yet part of SemanticColors, so create list here.
 * LightColorTokens is internal to the module.
 */

@OptIn(CoreColorToken::class)
val avatarColorsLight = listOf(
    LightColorTokens.colorBlue300 to LightColorTokens.colorBlue1200,
    LightColorTokens.colorFuchsia300 to LightColorTokens.colorFuchsia1200,
    LightColorTokens.colorGreen300 to LightColorTokens.colorGreen1200,
    LightColorTokens.colorPink300 to LightColorTokens.colorPink1200,
    LightColorTokens.colorOrange300 to LightColorTokens.colorOrange1200,
    LightColorTokens.colorCyan300 to LightColorTokens.colorCyan1200,
    LightColorTokens.colorPurple300 to LightColorTokens.colorPurple1200,
    LightColorTokens.colorLime300 to LightColorTokens.colorLime1200,
)

/**
 * Avatar colors are not yet part of SemanticColors, so create list here.
 * DarkColorTokens is internal to the module.
 */

@OptIn(CoreColorToken::class)
val avatarColorsDark = listOf(
    DarkColorTokens.colorBlue300 to DarkColorTokens.colorBlue1200,
    DarkColorTokens.colorFuchsia300 to DarkColorTokens.colorFuchsia1200,
    DarkColorTokens.colorGreen300 to DarkColorTokens.colorGreen1200,
    DarkColorTokens.colorPink300 to DarkColorTokens.colorPink1200,
    DarkColorTokens.colorOrange300 to DarkColorTokens.colorOrange1200,
    DarkColorTokens.colorCyan300 to DarkColorTokens.colorCyan1200,
    DarkColorTokens.colorPurple300 to DarkColorTokens.colorPurple1200,
    DarkColorTokens.colorLime300 to DarkColorTokens.colorLime1200,
)
