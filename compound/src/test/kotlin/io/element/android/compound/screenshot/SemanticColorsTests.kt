package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import io.element.android.compound.previews.ColorListPreview
import io.element.android.compound.screenshot.utils.screenshotFile
import io.element.android.compound.theme.ElementTheme
import kotlinx.collections.immutable.toImmutableMap
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class SemanticColorsTests {
    @Config(sdk = [34], qualifiers = "h2048dp-xhdpi")
    @Test
    fun screenshots() {
        captureRoboImage(file = screenshotFile("Compound Semantic Colors - Light.png")) {
            ElementTheme {
                Surface {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text("Compound Semantic Colors - Light")
                        ColorListPreview(
                            backgroundColor = Color.White,
                            foregroundColor = Color.Black,
                            colors = getSemanticColors().toMap().toImmutableMap()
                        )
                    }
                }
            }
        }

        captureRoboImage(file = screenshotFile("Compound Semantic Colors - Dark.png")) {
            ElementTheme(darkTheme = true) {
                Surface {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text("Compound Semantic Colors - Dark")
                        ColorListPreview(
                            backgroundColor = Color.White,
                            foregroundColor = Color.Black,
                            colors = getSemanticColors().toMap().toImmutableMap()
                        )
                    }
                }
            }
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
}
