/*
 * Copyright 2023, 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.compound.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableMap

@Composable
fun ColorListPreview(
    backgroundColor: Color,
    foregroundColor: Color,
    colors: ImmutableMap<String, Color>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = backgroundColor)
            .fillMaxWidth()
    ) {
        colors.keys.forEach { name ->
            val color = colors[name]!!
            ColorPreview(backgroundColor = backgroundColor, foregroundColor = foregroundColor, name = name, color = color)
        }
        Spacer(modifier = Modifier.height(2.dp))
    }
}
