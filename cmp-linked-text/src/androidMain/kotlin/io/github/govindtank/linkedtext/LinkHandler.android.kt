package io.github.govindtank.linkedtext

import android.content.Intent
import android.net.Uri

actual fun platformOpenUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    appContext?.startActivity(intent)
}

actual fun platformSendEmail(email: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$email")
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    appContext?.startActivity(intent)
}

actual fun platformDialPhone(phone: String) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    appContext?.startActivity(intent)
}

var appContext: android.content.Context? = null
