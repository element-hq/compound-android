package io.element.android.compound.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.element.android.compound.annotations.CoreColorToken
import io.element.android.compound.tokens.generated.internal.DarkColorTokens
import io.element.android.compound.tokens.generated.internal.LightColorTokens

/**
 * Data class to hold avatar colors.
 */
data class AvatarColors(
    /** Background color for the avatar. */
    val background: Color,
    /** Foreground color for the avatar. */
    val foreground: Color,
)

/**
 * Avatar colors are not yet part of SemanticColors, so create list here.
 * LightColorTokens is internal to the module.
 */
@OptIn(CoreColorToken::class)
val avatarColorsLight = listOf(
    AvatarColors(background = LightColorTokens.colorBlue300, foreground = LightColorTokens.colorBlue1200),
    AvatarColors(background = LightColorTokens.colorFuchsia300, foreground = LightColorTokens.colorFuchsia1200),
    AvatarColors(background = LightColorTokens.colorGreen300, foreground = LightColorTokens.colorGreen1200),
    AvatarColors(background = LightColorTokens.colorPink300, foreground = LightColorTokens.colorPink1200),
    AvatarColors(background = LightColorTokens.colorOrange300, foreground = LightColorTokens.colorOrange1200),
    AvatarColors(background = LightColorTokens.colorCyan300, foreground = LightColorTokens.colorCyan1200),
    AvatarColors(background = LightColorTokens.colorPurple300, foreground = LightColorTokens.colorPurple1200),
    AvatarColors(background = LightColorTokens.colorLime300, foreground = LightColorTokens.colorLime1200),
)

/**
 * Avatar colors are not yet part of SemanticColors, so create list here.
 * DarkColorTokens is internal to the module.
 */
@OptIn(CoreColorToken::class)
val avatarColorsDark = listOf(
    AvatarColors(background = DarkColorTokens.colorBlue300, foreground = DarkColorTokens.colorBlue1200),
    AvatarColors(background = DarkColorTokens.colorFuchsia300, foreground = DarkColorTokens.colorFuchsia1200),
    AvatarColors(background = DarkColorTokens.colorGreen300, foreground = DarkColorTokens.colorGreen1200),
    AvatarColors(background = DarkColorTokens.colorPink300, foreground = DarkColorTokens.colorPink1200),
    AvatarColors(background = DarkColorTokens.colorOrange300, foreground = DarkColorTokens.colorOrange1200),
    AvatarColors(background = DarkColorTokens.colorCyan300, foreground = DarkColorTokens.colorCyan1200),
    AvatarColors(background = DarkColorTokens.colorPurple300, foreground = DarkColorTokens.colorPurple1200),
    AvatarColors(background = DarkColorTokens.colorLime300, foreground = DarkColorTokens.colorLime1200),
)

@Preview
@Composable
internal fun AvatarColorsLightPreview() {
    val chunks = avatarColorsLight.chunked(4)
    ElementTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            for (chunk in chunks) {
                AvatarColorRow(chunk)
            }
        }
    }
}

@Preview
@Composable
internal fun AvatarColorsDarkPreview() {
    val chunks = avatarColorsDark.chunked(4)
    ElementTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            for (chunk in chunks) {
                AvatarColorRow(chunk)
            }
        }
    }
}

@Composable
private fun AvatarColorRow(colors: List<AvatarColors>) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        colors.forEach { color ->
            Box(
                modifier = Modifier.size(48.dp)
                    .background(color.background),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "A",
                    color = color.foreground,
                )
            }
        }
    }
}