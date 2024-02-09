package io.element.android.compound.previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import io.element.android.compound.theme.ElementTheme
import io.element.android.compound.tokens.generated.CompoundIcons
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

internal class CompoundIconListPreviewProvider : PreviewParameterProvider<IconChunk> {
    override val values: Sequence<IconChunk>
        get() {
            val chunks = CompoundIcons.allResIds.chunked(36)
            return chunks.mapIndexed { index, chunk ->
                IconChunk(index = index + 1, total = chunks.size, icons = chunk.toPersistentList())
            }
                .asSequence()
        }
}
data class IconChunk(
    val index: Int,
    val total: Int,
    val icons: ImmutableList<Int>,
) {
    override fun toString(): String {
        return index.toString()
    }
}

@Preview
@Composable
internal fun IconsCompoundPreviewLight(@PreviewParameter(CompoundIconListPreviewProvider::class) chunk: IconChunk) =
    ElementTheme {
        IconsPreview(
            title = "R.drawable.ic_compound_* ${chunk.index}/${chunk.total}",
            iconsList = chunk.icons,
            iconNameTransform = { name ->
                name.removePrefix("ic_compound_")
                    .replace("_", " ")
            }
        )
    }

@Preview
@Composable
internal fun IconsCompoundPreviewDark(@PreviewParameter(CompoundIconListPreviewProvider::class) chunk: IconChunk) =
    ElementTheme(darkTheme = true) {
        IconsPreview(
            title = "R.drawable.ic_compound_* ${chunk.index}/${chunk.total}",
            iconsList = chunk.icons,
            iconNameTransform = { name ->
                name.removePrefix("ic_compound_")
                    .replace("_", " ")
            }
        )
    }

@Composable
private fun IconsPreview(
    title: String,
    iconsList: ImmutableList<Int>,
    iconNameTransform: (String) -> String,
) = Surface {
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = ElementTheme.typography.fontHeadingSmMedium,
            text = title,
            textAlign = TextAlign.Center,
        )
        iconsList.chunked(6).forEach { iconsRow ->
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                iconsRow.forEach { icon ->
                    Column(
                        modifier = Modifier.width(48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            modifier = Modifier.padding(2.dp),
                            imageVector = ImageVector.vectorResource(icon),
                            contentDescription = null,
                        )
                        Text(
                            text = iconNameTransform(
                                context.resources.getResourceEntryName(icon)
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = ElementTheme.typography.fontBodyXsMedium,
                            color = ElementTheme.colors.textSecondary,
                        )
                    }
                }
            }
        }
    }
}