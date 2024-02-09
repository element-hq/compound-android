package io.element.android.compound.screenshot

import app.cash.paparazzi.Paparazzi
import app.cash.paparazzi.detectEnvironment
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.android.ide.common.rendering.api.SessionParams
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import io.element.android.compound.previews.CompoundIconListPreviewProvider
import io.element.android.compound.previews.IconChunk
import io.element.android.compound.previews.IconsCompoundPreviewLight
import io.element.android.compound.showkase.getMetadata
import io.element.android.compound.theme.AvatarColorsDarkPreview
import io.element.android.compound.theme.AvatarColorsLightPreview
import io.element.android.compound.tokens.generated.CompoundIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class CompoundIconTests {
    internal data class ComponentTestPreview(
        val name: String,
        val component: () -> Unit
    )
    private object PreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<IconChunk> {
            return CompoundIconListPreviewProvider().values.toList()
        }
    }

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
    fun Light(@TestParameter(valuesProvider = PreviewProvider::class) chunk: IconChunk) {
        paparazzi.snapshot {
            IconsCompoundPreviewLight(chunk)
        }
    }

    @Test
    fun Dark(@TestParameter(valuesProvider = PreviewProvider::class) chunk: IconChunk) {
        paparazzi.snapshot {
            IconsCompoundPreviewLight(chunk)
        }
    }
}