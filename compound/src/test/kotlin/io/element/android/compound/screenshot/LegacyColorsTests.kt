package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.previews.ColorPreview
import io.element.android.compound.theme.AvatarColorsDarkPreview
import io.element.android.compound.theme.AvatarColorsLightPreview
import io.element.android.compound.theme.ElementTheme
import io.element.android.compound.theme.LinkColor
import io.element.android.compound.theme.SnackBarLabelColorDark
import io.element.android.compound.theme.SnackBarLabelColorLight
import org.junit.Rule
import org.junit.Test

class LegacyColorsTests {
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
    fun `List`() {
        paparazzi.snapshot {
            ElementTheme {
                Surface {
                    Column {
                        LegacyColorPreview(
                            color = LinkColor,
                            name = "Link"
                        )
                        LegacyColorPreview(
                            color = SnackBarLabelColorLight,
                            name = "SnackBar Label - Light"
                        )
                        LegacyColorPreview(
                            color = SnackBarLabelColorDark,
                            name = "SnackBar Label - Dark"
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun LegacyColorPreview(color: Color, name: String) {
        ColorPreview(
            backgroundColor = Color.White,
            foregroundColor = Color.Black,
            name = name,
            color = color
        )
    }
}