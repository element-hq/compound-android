package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.previews.ColorListPreview
import io.element.android.compound.theme.ElementTheme
import kotlinx.collections.immutable.toImmutableMap
import org.junit.Rule
import org.junit.Test

class SemanticColorsTests {
    companion object {
        private const val TOTAL_CHUNKS = 5
    }

    @get:Rule
    val paparazzi = Paparazzi(
        environment = detectEnvironment().run {
            // Workaround to work with API 34 (https://github.com/cashapp/paparazzi/issues/1025)
            copy(compileSdkVersion = 33, platformDir = platformDir.replace("34", "33"))
        },
        maxPercentDifference = 0.01,
        renderingMode = SessionParams.RenderingMode.SHRINK,
    )

    @Test
    fun `Compound light colors - 1`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = false, index = 0)
        }
    }

    @Test
    fun `Compound light colors - 2`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = false, index = 1)
        }
    }

    @Test
    fun `Compound light colors - 3`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = false, index = 2)
        }
    }

    @Test
    fun `Compound light colors - 4`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = false, index = 3)
        }
    }

    @Test
    fun `Compound light colors - 5`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = false, index = 4)
        }
    }

    @Test
    fun `Compound dark colors - 1`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = true, index = 0)
        }
    }

    @Test
    fun `Compound dark colors - 2`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = true, index = 1)
        }
    }

    @Test
    fun `Compound dark colors - 3`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = true, index = 2)
        }
    }

    @Test
    fun `Compound dark colors - 4`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = true, index = 3)
        }
    }

    @Test
    fun `Compound dark colors - 5`() {
        paparazzi.snapshot {
            SemanticColorPreview(darkTheme = true, index = 4)
        }
    }

    @Composable
    private fun getSemanticColors(): List<Pair<String, Color>> {
        return with(ElementTheme.colors) {
            listOf(
                "bgActionPrimaryDisabled" to bgActionPrimaryDisabled,
                "bgActionPrimaryHovered" to bgActionPrimaryHovered,
                "bgActionPrimaryPressed" to bgActionPrimaryPressed,
                "bgActionPrimaryRest" to bgActionPrimaryRest,
                "bgActionSecondaryHovered" to bgActionSecondaryHovered,
                "bgActionSecondaryPressed" to bgActionSecondaryPressed,
                "bgActionSecondaryRest" to bgActionSecondaryRest,
                "bgCanvasDefault" to bgCanvasDefault,
                "bgCanvasDisabled" to bgCanvasDisabled,
                "bgCriticalHovered" to bgCriticalHovered,
                "bgCriticalPrimary" to bgCriticalPrimary,
                "bgCriticalSubtle" to bgCriticalSubtle,
                "bgCriticalSubtleHovered" to bgCriticalSubtleHovered,
                "bgInfoSubtle" to bgInfoSubtle,
                "bgSubtlePrimary" to bgSubtlePrimary,
                "bgSubtleSecondary" to bgSubtleSecondary,
                "bgSuccessSubtle" to bgSuccessSubtle,
                "borderCriticalHovered" to borderCriticalHovered,
                "borderCriticalPrimary" to borderCriticalPrimary,
                "borderCriticalSubtle" to borderCriticalSubtle,
                "borderDisabled" to borderDisabled,
                "borderFocused" to borderFocused,
                "borderInfoSubtle" to borderInfoSubtle,
                "borderInteractiveHovered" to borderInteractiveHovered,
                "borderInteractivePrimary" to borderInteractivePrimary,
                "borderInteractiveSecondary" to borderInteractiveSecondary,
                "borderSuccessSubtle" to borderSuccessSubtle,
                "iconAccentTertiary" to iconAccentTertiary,
                "iconCriticalPrimary" to iconCriticalPrimary,
                "iconDisabled" to iconDisabled,
                "iconInfoPrimary" to iconInfoPrimary,
                "iconOnSolidPrimary" to iconOnSolidPrimary,
                "iconPrimary" to iconPrimary,
                "iconPrimaryAlpha" to iconPrimaryAlpha,
                "iconQuaternary" to iconQuaternary,
                "iconQuaternaryAlpha" to iconQuaternaryAlpha,
                "iconSecondary" to iconSecondary,
                "iconSecondaryAlpha" to iconSecondaryAlpha,
                "iconSuccessPrimary" to iconSuccessPrimary,
                "iconTertiary" to iconTertiary,
                "iconTertiaryAlpha" to iconTertiaryAlpha,
                "textActionAccent" to textActionAccent,
                "textActionPrimary" to textActionPrimary,
                "textCriticalPrimary" to textCriticalPrimary,
                "textDisabled" to textDisabled,
                "textInfoPrimary" to textInfoPrimary,
                "textLinkExternal" to textLinkExternal,
                "textOnSolidPrimary" to textOnSolidPrimary,
                "textPlaceholder" to textPlaceholder,
                "textPrimary" to textPrimary,
                "textSecondary" to textSecondary,
                "textSuccessPrimary" to textSuccessPrimary,
            )
        }
    }

    @Composable
    private fun SemanticColorPreview(darkTheme: Boolean, index: Int) {
        val colorList = getSemanticColors().chunked(12)[index]
        ElementTheme(darkTheme = darkTheme) {
            Surface {
                Column(modifier = Modifier.width(300.dp).padding(10.dp)) {
                    val theme = if (darkTheme) "Dark" else "Light"
                    Text(
                        text = "Compound $theme colors (${index + 1}/$TOTAL_CHUNKS)",
                        style = TextStyle.Default.copy(fontSize = 18.sp),
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    ColorListPreview(
                        backgroundColor = Color.White,
                        foregroundColor = Color.Black,
                        colors = colorList.toMap().toImmutableMap()
                    )
                }
            }
        }
    }
}
