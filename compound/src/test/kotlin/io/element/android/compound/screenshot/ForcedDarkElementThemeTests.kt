package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.theme.ForcedDarkElementTheme
import org.junit.Rule
import org.junit.Test

class ForcedDarkElementThemeTests {
    @get:Rule
    val paparazzi = Paparazzi(
        environment = detectEnvironment().run {
            // Workaround to work with API 34 (https://github.com/cashapp/paparazzi/issues/1025)
            copy(compileSdkVersion = 33, platformDir = platformDir.replace("34", "33"))
        },
        theme = "android:Theme.Material.NoActionBar",
        showSystemUi = true,
        maxPercentDifference = 0.01,
        renderingMode = SessionParams.RenderingMode.NORMAL,
    )

    @Test
    fun `Forces dark tokens`() {
        paparazzi.snapshot {
            ForcedDarkElementTheme {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(text = "Testing", modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}