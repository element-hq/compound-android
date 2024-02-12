package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import io.element.android.compound.screenshot.utils.screenshotFile
import io.element.android.compound.theme.ElementTheme
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MaterialTypographyTests {
    @Test
    @Config(sdk = [34], qualifiers = "h2048dp-xxhdpi")
    fun screenshots() {
        captureRoboImage(file = screenshotFile("Material Typography.png")) {
            ElementTheme {
                Surface {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        with(ElementTheme.materialTypography) {
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
