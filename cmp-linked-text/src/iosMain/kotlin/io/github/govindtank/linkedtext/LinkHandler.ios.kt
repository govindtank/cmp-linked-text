package io.github.govindtank.linkedtext

import platform.UIKit.UIApplication
import platform.Foundation.NSURL

actual fun platformOpenUrl(url: String) {
    NSURL.URLWithString(url)?.let { nsUrl ->
        UIApplication.sharedApplication.openURL(nsUrl)
    }
}

actual fun platformSendEmail(email: String) {
    NSURL.URLWithString("mailto:$email")?.let { nsUrl ->
        UIApplication.sharedApplication.openURL(nsUrl)
    }
}

actual fun platformDialPhone(phone: String) {
    NSURL.URLWithString("tel:$phone")?.let { nsUrl ->
        UIApplication.sharedApplication.openURL(nsUrl)
    }
}
