package io.element.android.compound.screenshot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import io.element.android.compound.theme.ColorsSchemeDarkPreview
import io.element.android.compound.theme.ColorsSchemeLightPreview
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MaterialColorSchemeTests {
    @Test
    @Config(sdk = [34], qualifiers = "h2048dp-xhdpi")
    fun screenshots() {
        captureRoboImage(filePath = "screenshots/Material3 Colors - Light.png") {
            Column {
                Text(
                    text = "M3 Light colors",
                    style = TextStyle.Default.copy(fontSize = 18.sp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                ColorsSchemeLightPreview()
            }
        }
        captureRoboImage(filePath = "screenshots/Material3 Colors - Dark.png") {
            Column {
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
