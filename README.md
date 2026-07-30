# cmp-linked-text

Compose Multiplatform library that auto-detects URLs, emails, and phone numbers in text and renders them as clickable links.

```
implementation("io.github.govindtank:cmp-linked-text:1.0.0")
```

## Usage

```kotlin
import io.github.govindtank.linkedtext.LinkedText
import io.github.govindtank.linkedtext.LinkStyle

@Composable
fun MyScreen() {
    LinkedText(
        text = "Visit https://example.com or email me@example.com or call +1234567890",
        style = LinkStyle(
            linkColor = Color(0xFF007AFF),
            underline = true
        )
    )
}
```

On Android set `appContext` before use:

```kotlin
import io.github.govindtank.linkedtext.appContext

appContext = context
```

## Features

- URL detection (http/https)
- Email detection
- Phone number detection
- Custom link color and underline style
- Platform browser/mail/dialer on click
- Kotlin Multiplatform (Android + iOS)
