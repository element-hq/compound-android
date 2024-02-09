package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.android.ide.common.rendering.api.SessionParams
import io.element.android.compound.theme.ColorsSchemeDarkPreview
import io.element.android.compound.theme.ColorsSchemeLightPreview
import org.junit.Rule
import org.junit.Test

class MaterialColorSchemeTests {
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
    fun `Material 3 light colors`() {
        paparazzi.snapshot {
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "M3 Light colors",
                    style = TextStyle.Default.copy(fontSize = 18.sp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                ColorsSchemeLightPreview()
            }
        }
    }

    @Test
    fun `Material 3 dark colors`() {
        paparazzi.snapshot {
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "M3 Dark colors",
                    style = TextStyle.Default.copy(fontSize = 18.sp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                ColorsSchemeDarkPreview()
            }
        }
    }
}