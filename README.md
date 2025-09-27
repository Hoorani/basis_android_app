# Simple Android App

A simple Android application with automated APK building using GitHub Actions.

## Features

- Simple UI with a welcome message, click button, and counter
- Material Design 3 theme
- Automated APK building with GitHub Actions
- Support for both debug and release builds
- Signed APK generation for releases

## Project Structure

```
├── app/
│   ├── build.gradle                 # App-level build configuration
│   ├── src/main/
│   │   ├── AndroidManifest.xml      # App manifest
│   │   ├── java/com/example/simpleandroidapp/
│   │   │   └── MainActivity.kt      # Main activity
│   │   └── res/                     # Resources (layouts, strings, etc.)
├── .github/workflows/
│   ├── build-apk.yml               # Build APK on push/PR
│   └── build-signed-apk.yml        # Build signed APK on tags
├── build.gradle                    # Project-level build configuration
├── settings.gradle                 # Project settings
└── gradle.properties              # Gradle properties
```

## Setup Instructions

### Prerequisites

1. **Android Studio** (recommended) or command line tools
2. **Java Development Kit (JDK) 17** or higher
3. **Android SDK** with API level 34

### Local Development

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd workflow-tut
   ```

2. **Open in Android Studio:**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the project directory and select it

3. **Sync the project:**
   - Android Studio will automatically sync the Gradle files
   - Wait for the sync to complete

4. **Run the app:**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`

### Command Line Building

1. **Make gradlew executable (Linux/macOS):**
   ```bash
   chmod +x gradlew
   ```

2. **Build debug APK:**
   ```bash
   ./gradlew assembleDebug
   ```

3. **Build release APK:**
   ```bash
   ./gradlew assembleRelease
   ```

4. **Find the APK files:**
   - Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
   - Release APK: `app/build/outputs/apk/release/app-release-unsigned.apk`

## GitHub Actions Workflows

### 1. Build APK Workflow (`.github/workflows/build-apk.yml`)

**Triggers:**
- Push to `main` or `master` branch
- Pull requests to `main` or `master` branch
- Manual trigger via GitHub Actions UI

**What it does:**
- Sets up Java 17 and Android SDK
- Caches Gradle dependencies for faster builds
- Builds both debug and release APKs
- Uploads APK artifacts to GitHub Actions
- Uploads build reports for debugging

**Artifacts:**
- `app-debug-apk`: Debug APK file
- `app-release-apk`: Release APK file
- `build-reports`: Build reports and logs

### 2. Build Signed APK Workflow (`.github/workflows/build-signed-apk.yml`)

**Triggers:**
- Push of version tags (e.g., `v1.0.0`)
- Manual trigger via GitHub Actions UI

**What it does:**
- Creates a debug keystore for signing
- Builds and signs the release APK
- Creates a GitHub release with the signed APK
- Generates release notes automatically

**Artifacts:**
- `app-release-signed-apk`: Signed release APK
- GitHub release with downloadable APK

## How to Use GitHub Actions

### 1. Enable GitHub Actions

1. Push your code to a GitHub repository
2. Go to the "Actions" tab in your GitHub repository
3. GitHub Actions will be automatically enabled

### 2. Build APKs Automatically

**For every push/PR:**
- The `build-apk.yml` workflow will run automatically
- Check the "Actions" tab to see build status
- Download APK artifacts from the workflow run page

**For releases:**
1. Create and push a version tag:
   ```bash
   git tag v1.0.0
   git push origin v1.0.0
   ```
2. The `build-signed-apk.yml` workflow will run
3. A GitHub release will be created with the signed APK

### 3. Download APKs

1. Go to the "Actions" tab in your repository
2. Click on a workflow run
3. Scroll down to the "Artifacts" section
4. Download the APK files you need

## Customization

### Changing App Details

1. **App Name:** Edit `app/src/main/res/values/strings.xml`
2. **Package Name:** Edit `app/build.gradle` (applicationId)
3. **Version:** Edit `app/build.gradle` (versionCode, versionName)

### Adding Dependencies

Add dependencies in `app/build.gradle`:
```gradle
dependencies {
    implementation 'your.dependency:name:version'
}
```

### Modifying the UI

Edit `app/src/main/res/layout/activity_main.xml` to change the layout.

### Customizing Workflows

Edit the workflow files in `.github/workflows/` to:
- Change build triggers
- Add additional build steps
- Modify artifact names
- Add custom signing configurations

## Troubleshooting

### Common Issues

1. **Build fails with "SDK not found":**
   - Make sure Android SDK is installed
   - Set `ANDROID_HOME` environment variable

2. **Gradle sync fails:**
   - Check internet connection
   - Clear Gradle cache: `./gradlew clean`

3. **APK not installing:**
   - Enable "Unknown sources" in device settings
   - Check if device architecture matches APK

4. **GitHub Actions fails:**
   - Check the workflow logs in the Actions tab
   - Ensure all required files are committed

### Getting Help

- Check the [Android Developer Documentation](https://developer.android.com/)
- Review [GitHub Actions Documentation](https://docs.github.com/en/actions)
- Look at workflow logs for specific error messages

## License

This project is open source and available under the [MIT License](LICENSE).
