package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.theme.ElementTheme
import io.element.android.compound.tokens.compoundTypography
import org.junit.Rule
import org.junit.Test

class MaterialTypographyTests {
    @get:Rule
    val paparazzi = Paparazzi(
        environment = detectEnvironment().run {
            // Workaround to work with API 34 (https://github.com/cashapp/paparazzi/issues/1025)
            copy(compileSdkVersion = 33, platformDir = platformDir.replace("34", "33"))
        },
        maxPercentDifference = 0.01,
        renderingMode = SessionParams.RenderingMode.FULL_EXPAND,
    )

    @Test
    fun `Compound Typography`() {
        paparazzi.snapshot {
            ElementTheme {
                Surface {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        with(compoundTypography) {
                            TypographyTokenPreview(displayLarge, "Display large")
                            TypographyTokenPreview(displayMedium, "Display medium")
                            TypographyTokenPreview(displaySmall, "Display small")
                            TypographyTokenPreview(headlineLarge, "Headline large")
                            TypographyTokenPreview(headlineMedium, "Headline medium")
                            TypographyTokenPreview(headlineSmall, "Headline small")
                            TypographyTokenPreview(titleLarge, "Title large")
                            TypographyTokenPreview(titleMedium, "Title medium")
                            TypographyTokenPreview(titleSmall, "Title small")
                            TypographyTokenPreview(bodyLarge, "Body large")
                            TypographyTokenPreview(bodyMedium, "Body medium")
                            TypographyTokenPreview(bodySmall, "Body small")
                            TypographyTokenPreview(labelLarge, "Label large")
                            TypographyTokenPreview(labelMedium, "Label medium")
                            TypographyTokenPreview(labelSmall, "Label small")
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun TypographyTokenPreview(style: TextStyle, text: String) {
        Text(text = text, style = style)
    }
}