# cmp-linked-text

<p align="center">
  <a href="https://jitpack.io/#govindtank/cmp-linked-text"><img src="https://jitpack.io/v/govindtank/cmp-linked-text.svg?style=flat-square" alt="JitPack"></a>
  <a href="https://github.com/govindtank/cmp-linked-text/actions"><img src="https://img.shields.io/github/actions/workflow/status/govindtank/cmp-linked-text/build.yml?branch=main&style=flat-square&label=build" alt="Build Status"></a>
  <img src="https://img.shields.io/badge/Platform-Android%20%7C%20iOS%20%7C%20CMP-blue?style=flat-square" alt="Platform">
  <img src="https://img.shields.io/badge/Kotlin-2.0.0-purple?style=flat-square" alt="Kotlin">
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-Apache%202.0-green.svg?style=flat-square" alt="License"></a>
</p>

<p align="center">
  <b>Compose Multiplatform auto-linking text component with URL, email, and phone detection.</b>
</p>

<p align="center">
  <img src="./screenshot.svg" width="340" alt="cmp-linked-text demo" style="border-radius: 14px;" />
</p>

---

## ⚡ Features

- 🔗 **Automatic Link Detection**: Detects HTTP/HTTPS URLs, emails, phone numbers, and @mentions.
- 📱 **Cross-Platform Intent Launching**: Opens system browser, mail client, or dialer on tap.
- 🎨 **Fully Customizable Styling**: Configure regular text style, link color, underlined states, and click callbacks.
- 🚀 **Compose Multiplatform**: Native integration for Android and iOS.

---

## 📦 Installation

Add the JitPack repository and dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.govindtank:cmp-linked-text:1.0.0")
}
```

---

## 🚀 Usage

```kotlin
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import io.github.govindtank.linkedtext.LinkedText
import io.github.govindtank.linkedtext.LinkStyle

@Composable
fun ProfileBioScreen() {
    LinkedText(
        text = "Visit https://govindtank.github.io or reach out at contact@govindtank.dev! Call +1234567890.",
        style = LinkStyle(
            linkColor = Color(0xFF1976D2),
            underline = true
        )
    )
}
```

---

## 💖 Support the Project

If you find this project useful, consider supporting its active maintenance and future development:

<p align="left">
  <a href="https://buymeacoffee.com/govindtanko"><img src="https://img.shields.io/badge/Buy%20Me%20A%20Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black" alt="Buy Me A Coffee" /></a>
  <a href="https://github.com/sponsors/govindtank"><img src="https://img.shields.io/badge/GitHub%20Sponsors-EA4AAA?style=for-the-badge&logo=github&logoColor=white" alt="GitHub Sponsors" /></a>
  <a href="https://www.patreon.com/govindtank"><img src="https://img.shields.io/badge/Patreon-F96854?style=for-the-badge&logo=patreon&logoColor=white" alt="Patreon" /></a>
</p>

---

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

*Maintained with ❤️ by [Govind Tank](https://github.com/govindtank).*
