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
import io.element.android.compound.theme.ElementTheme
import io.element.android.compound.tokens.compoundTypography
import io.element.android.compound.tokens.generated.TypographyTokens
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class CompoundTypographyTests {
    @Test
    @Config(sdk = [34], qualifiers = "h2048dp-xxhdpi")
    fun screenshots() {
        captureRoboImage(filePath = "screenshots/Compound Typography.png") {
            ElementTheme {
                Surface {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        with(TypographyTokens) {
                            TypographyTokenPreview(fontHeadingXlBold, "Heading XL Bold")
                            TypographyTokenPreview(fontHeadingXlRegular, "Heading XL Regular")
                            TypographyTokenPreview(fontHeadingLgBold, "Heading LG Bold")
                            TypographyTokenPreview(fontHeadingLgRegular, "Heading LG Regular")
                            TypographyTokenPreview(fontHeadingMdBold, "Heading MD Bold")
                            TypographyTokenPreview(fontHeadingMdRegular, "Heading MD Regular")
                            TypographyTokenPreview(fontHeadingSmMedium, "Heading SM Medium")
                            TypographyTokenPreview(fontHeadingSmRegular, "Heading SM Regular")
                            TypographyTokenPreview(fontBodyLgMedium, "Body LG Medium")
                            TypographyTokenPreview(fontBodyLgRegular, "Body LG Regular")
                            TypographyTokenPreview(fontBodyMdMedium, "Body MD Medium")
                            TypographyTokenPreview(fontBodyMdRegular, "Body MD Regular")
                            TypographyTokenPreview(fontBodySmMedium, "Body SM Medium")
                            TypographyTokenPreview(fontBodySmRegular, "Body SM Regular")
                            TypographyTokenPreview(fontBodyXsMedium, "Body XS Medium")
                            TypographyTokenPreview(fontBodyXsRegular, "Body XS Regular")
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
