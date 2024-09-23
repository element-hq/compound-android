package io.element.android.compound.screenshot

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import io.element.android.compound.screenshot.utils.screenshotFile
import io.element.android.compound.theme.AvatarColorsPreviewDark
import io.element.android.compound.theme.AvatarColorsPreviewLight
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AvatarColorsTests {
    @Test
    @Config(sdk = [34], qualifiers = "xxhdpi")
    fun screenshots() {
        captureRoboImage(file = screenshotFile("Avatar Colors - Light.png")) {
            AvatarColorsPreviewLight()
        }
        captureRoboImage(file = screenshotFile("Avatar Colors - Dark.png")) {
            AvatarColorsPreviewDark()
        }
    }
}