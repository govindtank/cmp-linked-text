package io.github.govindtank.linkedtext

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit

private val URL_REGEX = Regex(
    """(https?://[^\s<]+)""",
    RegexOption.IGNORE_CASE
)

private val EMAIL_REGEX = Regex(
    """([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})""",
    RegexOption.IGNORE_CASE
)

private val PHONE_REGEX = Regex(
    """(\+?[\d\-().\s]{7,})""",
    RegexOption.IGNORE_CASE
)

/**
 * Composable that auto-detects URLs, emails, and phone numbers in text
 * and renders them as clickable links.
 *
 * Opens platform browser/mail/dialer on tap.
 */
@Composable
fun LinkedText(
    text: String,
    style: LinkStyle = LinkStyle(),
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null
) {
    val annotatedString = remember(text, style) {
        buildAnnotatedString {
            append(text)

            // URLs
            URL_REGEX.findAll(text).forEach { match ->
                val range = match.range
                addStyle(
                    SpanStyle(
                        color = style.linkColor,
                        textDecoration = if (style.underline) TextDecoration.Underline else null
                    ),
                    range.first,
                    range.last + 1
                )
                addStringAnnotation(
                    tag = "link",
                    annotation = "url:${match.value}",
                    start = range.first,
                    end = range.last + 1
                )
            }

            // Emails
            EMAIL_REGEX.findAll(text).forEach { match ->
                val range = match.range
                addStyle(
                    SpanStyle(
                        color = style.linkColor,
                        textDecoration = if (style.underline) TextDecoration.Underline else null
                    ),
                    range.first,
                    range.last + 1
                )
                addStringAnnotation(
                    tag = "link",
                    annotation = "email:${match.value}",
                    start = range.first,
                    end = range.last + 1
                )
            }

            // Phones
            PHONE_REGEX.findAll(text).forEach { match ->
                val range = match.range
                addStyle(
                    SpanStyle(
                        color = style.linkColor,
                        textDecoration = if (style.underline) TextDecoration.Underline else null
                    ),
                    range.first,
                    range.last + 1
                )
                addStringAnnotation(
                    tag = "link",
                    annotation = "phone:${match.value.trim()}",
                    start = range.first,
                    end = range.last + 1
                )
            }
        }
    }

    ClickableText(
        text = annotatedString,
        modifier = modifier,
        style = TextStyle(
            color = style.normalColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontStyle = fontStyle
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations("link", offset, offset)
                .firstOrNull()
                ?.let { annotation ->
                    val (type, target) = annotation.item.split(":", limit = 2)
                    when (type) {
                        "url" -> platformOpenUrl(target)
                        "email" -> platformSendEmail(target)
                        "phone" -> platformDialPhone(target)
                    }
                }
        }
    )
}
