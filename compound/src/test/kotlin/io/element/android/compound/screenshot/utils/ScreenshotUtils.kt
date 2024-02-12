package io.element.android.compound.screenshot.utils

import java.io.File

/**
 * Returns a [File] object for a screenshot with the given [filename].
 * This is to ensure we have a consistent location for all screenshots.
 */
fun screenshotFile(filename: String): File {
    return File("screenshots", filename)
}