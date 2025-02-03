package io.element.android.compound.screenshot

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import io.element.android.compound.previews.TypographyPreview
import io.element.android.compound.screenshot.utils.screenshotFile
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MaterialTypographyTests {
    @Test
    @Config(sdk = [35], qualifiers = "h2048dp-xxhdpi")
    fun screenshots() {
        captureRoboImage(file = screenshotFile("Material Typography.png")) {
            TypographyPreview()
        }
    }
}
