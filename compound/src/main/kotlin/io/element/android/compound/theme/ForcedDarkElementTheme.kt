/*
 * Copyright (c) 2023 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.element.android.compound.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

/**
 * Can be used to force a composable in dark theme.
 * It will automatically change the system ui colors back to normal when leaving the composition.
 */
@Composable
fun ForcedDarkElementTheme(
    lightStatusBar: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = MaterialTheme.colorScheme
    val wasDarkTheme = !ElementTheme.colors.isLight
    val activity = LocalContext.current as? ComponentActivity
    DisposableEffect(Unit) {
        onDispose {
            activity?.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.auto(
                    lightScrim = colorScheme.background.toArgb(),
                    darkScrim = colorScheme.background.toArgb(),
                ),
                navigationBarStyle = if (wasDarkTheme) {
                    SystemBarStyle.dark(Color.Transparent.toArgb())
                } else {
                    SystemBarStyle.light(
                        scrim = Color.Transparent.toArgb(),
                        darkScrim = Color.Transparent.toArgb()
                    )
                }
            )
        }
    }
    ElementTheme(darkTheme = true, lightStatusBar = lightStatusBar, content = content)
}
