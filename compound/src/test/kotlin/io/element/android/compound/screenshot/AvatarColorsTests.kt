package io.element.android.compound.screenshot

import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.theme.AvatarColorsDarkPreview
import io.element.android.compound.theme.AvatarColorsLightPreview
import org.junit.Rule
import org.junit.Test

class AvatarColorsTests {
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
    fun `Avatar colors - Light`() {
        paparazzi.snapshot {
            AvatarColorsLightPreview()
        }
    }

    @Test
    fun `Avatar colors - Dark`() {
        paparazzi.snapshot {
            AvatarColorsDarkPreview()
        }
    }
}