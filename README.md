# cmp-linked-text

[![JitPack](https://jitpack.io/v/govindtank/cmp-linked-text.svg)](https://jitpack.io/#govindtank/cmp-linked-text)

<p align="center">
  <img src="screenshot.svg" width="280" alt="cmp-linked-text demo">
</p>

Compose Multiplatform library that auto-detects URLs, emails, and phone numbers in text and renders them as clickable links. Tapping a link opens the platform browser, mail client, or dialer.

## Installation

Add the JitPack repository and dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.govindtank:cmp-linked-text:1.0.0")
}
```

> [!IMPORTANT]
> After tagging a release on GitHub (`git tag v1.0.0 && git push --tags`), JitPack automatically builds and publishes the artifacts. Replace `1.0.0` with your actual tag.

## Usage

```kotlin
import io.github.govindtank.linkedtext.LinkedText
import io.github.govindtank.linkedtext.LinkStyle
import androidx.compose.ui.graphics.Color

@Composable
fun BioScreen() {
    LinkedText(
        text = "Check out https://example.com or email us at hello@test.com",
        style = LinkStyle(
            linkColor = Color(0xFF1976D2),
            underline = true
        )
    )
}
```

### Android setup

On Android set `appContext` before using `LinkedText`:

```kotlin
import io.github.govindtank.linkedtext.appContext

appContext = context
```

## API Reference

### `LinkedText`

| Parameter    | Type        | Default              | Description                               |
|-------------|-------------|----------------------|-------------------------------------------|
| `text`      | `String`    | (required)           | Input text with URLs, emails, or phones   |
| `style`     | `LinkStyle` | `LinkStyle()`        | Link appearance configuration             |
| `modifier`  | `Modifier`  | `Modifier`           | Compose modifier                          |
| `fontSize`  | `TextUnit`  | `TextUnit.Unspecified` | Base font size                          |
| `fontWeight`| `FontWeight?`| `null`              | Base font weight                          |
| `fontStyle` | `FontStyle?`| `null`              | Base font style                           |

### `LinkStyle`

| Parameter    | Type    | Default              | Description                     |
|-------------|---------|----------------------|---------------------------------|
| `linkColor` | `Color` | `Color(0xFF007AFF)`  | Color for detected links        |
| `normalColor`| `Color` | `Color.Unspecified`  | Color for non-link text         |
| `underline` | `Boolean`| `true`              | Show underline on links         |

### Detection Patterns

- **URLs**: `http://` or `https://` followed by non-whitespace characters
- **Emails**: Standard email format (`user@domain.tld`)
- **Phones**: Digits, `+`, `-`, `.`, `(`, `)`, and spaces (7+ characters)

## Platform Support

| Platform | Status | Notes                         |
|----------|--------|-------------------------------|
| Android  | ✅     | Opens browser/mail/dialer via `Intent` |
| iOS      | ✅     | Opens via `UIApplication.shared`       |
| Desktop  | ❌     | Not supported yet             |
| Web      | ❌     | Not supported yet             |

### Requirements

- **Android**: API 21+ (Android 5.0)
- **iOS**: iOS 13+
- **Kotlin**: 1.9+
- **Compose Multiplatform**: 1.5+

## Features

- URL detection (http/https)
- Email detection
- Phone number detection
- Custom link color and underline style
- Platform browser/mail/dialer on click
- Kotlin Multiplatform (Android + iOS)
