package io.github.govindtank.linkedtext

import androidx.compose.ui.graphics.Color

expect fun platformOpenUrl(url: String)
expect fun platformSendEmail(email: String)
expect fun platformDialPhone(phone: String)

data class LinkStyle(
    val linkColor: Color = Color(0xFF007AFF),
    val normalColor: Color = Color.Unspecified,
    val underline: Boolean = true
)
