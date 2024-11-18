/*
 * Copyright (c) 2024 New Vector Ltd
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

@file:Suppress("all")
package io.element.android.compound.tokens.generated

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


/**
 * !!! WARNING !!!
 * 
 * THIS IS AN AUTOGENERATED FILE.
 * DO NOT EDIT MANUALLY.
 */




/**
  * This class holds all the semantic tokens of the Compound theme.
  */
@Immutable
data class SemanticColors(
    /** Background colour for accent or brand actions. State: Hover */
    val bgAccentHovered: Color,
    /** Background colour for accent or brand actions. State: Pressed */
    val bgAccentPressed: Color,
    /** Background colour for accent or brand actions. State: Rest. */
    val bgAccentRest: Color,
    /** Background colour for primary actions. State: Disabled. */
    val bgActionPrimaryDisabled: Color,
    /** Background colour for primary actions. State: Hover. */
    val bgActionPrimaryHovered: Color,
    /** Background colour for primary actions. State: Pressed. */
    val bgActionPrimaryPressed: Color,
    /** Background colour for primary actions. State: Rest. */
    val bgActionPrimaryRest: Color,
    /** Background colour for secondary actions. State: Hover. */
    val bgActionSecondaryHovered: Color,
    /** Background colour for secondary actions. State: Pressed. */
    val bgActionSecondaryPressed: Color,
    /** Background colour for secondary actions. State: Rest. */
    val bgActionSecondaryRest: Color,
    /** Default global background for the user interface.
Elevation: Default (Level 0) */
    val bgCanvasDefault: Color,
    /** Default background for disabled elements. There's no minimum contrast requirement. */
    val bgCanvasDisabled: Color,
    /** High-contrast background color for critical state. State: Hover. */
    val bgCriticalHovered: Color,
    /** High-contrast background color for critical state. State: Rest. */
    val bgCriticalPrimary: Color,
    /** Default subtle critical surfaces. State: Rest. */
    val bgCriticalSubtle: Color,
    /** Default subtle critical surfaces. State: Hover. */
    val bgCriticalSubtleHovered: Color,
    /** Decorative background (1, Lime) for avatars and usernames. */
    val bgDecorative1: Color,
    /** Decorative background (2, Cyan) for avatars and usernames. */
    val bgDecorative2: Color,
    /** Decorative background (3, Fuchsia) for avatars and usernames. */
    val bgDecorative3: Color,
    /** Decorative background (4, Purple) for avatars and usernames. */
    val bgDecorative4: Color,
    /** Decorative background (5, Pink) for avatars and usernames. */
    val bgDecorative5: Color,
    /** Decorative background (6, Orange) for avatars and usernames. */
    val bgDecorative6: Color,
    /** Subtle background colour for informational elements. State: Rest. */
    val bgInfoSubtle: Color,
    /** Medium contrast surfaces.
Elevation: Default (Level 2). */
    val bgSubtlePrimary: Color,
    /** Low contrast surfaces.
Elevation: Default (Level 1). */
    val bgSubtleSecondary: Color,
    /** Subtle background colour for success state elements. State: Rest. */
    val bgSuccessSubtle: Color,
    /** High-contrast border for critical state. State: Hover. */
    val borderCriticalHovered: Color,
    /** High-contrast border for critical state. State: Rest. */
    val borderCriticalPrimary: Color,
    /** Subtle border colour for critical state elements. */
    val borderCriticalSubtle: Color,
    /** Used for borders of disabled elements. There's no minimum contrast requirement. */
    val borderDisabled: Color,
    /** Used for the focus state outline. */
    val borderFocused: Color,
    /** Subtle border colour for informational elements. */
    val borderInfoSubtle: Color,
    /** Default contrast for accessible interactive element borders. State: Hover. */
    val borderInteractiveHovered: Color,
    /** Default contrast for accessible interactive element borders. State: Rest. */
    val borderInteractivePrimary: Color,
    /** ⚠️ Lowest contrast for non-accessible interactive element borders, <3:1. Only use for non-essential borders. Do not rely exclusively on them. State: Rest. */
    val borderInteractiveSecondary: Color,
    /** Subtle border colour for success state elements. */
    val borderSuccessSubtle: Color,
    /** Highest contrast accessible accent icons. */
    val iconAccentPrimary: Color,
    /** Lowest contrast accessible accent icons. */
    val iconAccentTertiary: Color,
    /** High-contrast icon for critical state. State: Rest. */
    val iconCriticalPrimary: Color,
    /** Use for icons in disabled elements. There's no minimum contrast requirement. */
    val iconDisabled: Color,
    /** High-contrast icon for informational elements. */
    val iconInfoPrimary: Color,
    /** Highest contrast icon color on top of high-contrast solid backgrounds like primary, accent, or destructive actions. */
    val iconOnSolidPrimary: Color,
    /** Highest contrast icons. */
    val iconPrimary: Color,
    /** Translucent version of primary icon. Refer to it for intended use. */
    val iconPrimaryAlpha: Color,
    /** ⚠️ Lowest contrast non-accessible icons, <3:1. Only use for non-essential icons. Do not rely exclusively on them. */
    val iconQuaternary: Color,
    /** Translucent version of quaternary icon. Refer to it for intended use. */
    val iconQuaternaryAlpha: Color,
    /** Lower contrast icons. */
    val iconSecondary: Color,
    /** Translucent version of secondary icon. Refer to it for intended use. */
    val iconSecondaryAlpha: Color,
    /** High-contrast icon for success state elements. */
    val iconSuccessPrimary: Color,
    /** Lowest contrast accessible icons. */
    val iconTertiary: Color,
    /** Translucent version of tertiary icon. Refer to it for intended use. */
    val iconTertiaryAlpha: Color,
    /** Accent text colour for plain actions. */
    val textActionAccent: Color,
    /** Default text colour for plain actions. */
    val textActionPrimary: Color,
    /** Text colour for destructive plain actions. */
    val textCriticalPrimary: Color,
    /** Decorative text colour (1, Lime) for avatars and usernames. */
    val textDecorative1: Color,
    /** Decorative text colour (2, Cyan) for avatars and usernames. */
    val textDecorative2: Color,
    /** Decorative text colour (3, Fuchsia) for avatars and usernames. */
    val textDecorative3: Color,
    /** Decorative text colour (4, Purple) for avatars and usernames. */
    val textDecorative4: Color,
    /** Decorative text colour (5, Pink) for avatars and usernames. */
    val textDecorative5: Color,
    /** Decorative text colour (6, Orange) for avatars and usernames. */
    val textDecorative6: Color,
    /** Use for regular text in disabled elements. There's no minimum contrast requirement. */
    val textDisabled: Color,
    /** Accent text colour for informational elements. */
    val textInfoPrimary: Color,
    /** Text colour for external links. */
    val textLinkExternal: Color,
    /** For use as text color on top of high-contrast solid backgrounds like primary, accent, or destructive actions. */
    val textOnSolidPrimary: Color,
    /** Highest contrast text. */
    val textPrimary: Color,
    /** Lowest contrast text. */
    val textSecondary: Color,
    /** Accent text colour for success state elements. */
    val textSuccessPrimary: Color,
    /** True for light theme, false for dark theme. */
    val isLight: Boolean,
)
