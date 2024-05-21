pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

//        maven {
//            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
//            credentials {
//                // Do not change the username below.
//                // This should always be `mapbox` (not your username).
//                username = "mapbox"
//                // Use the secret token you stored in gradle.properties as the password
//                val MAPBOX_DOWNLOADS_TOKEN: String by settings
//                password = MAPBOX_DOWNLOADS_TOKEN
//            }
//        }

//        Use from the website of MAPBOX
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
// Do not change the username below. It should always be "mapbox" (not your username).
            credentials.username = "mapbox"
// Use the secret token stored in gradle.properties as the password
            credentials.password = providers.gradleProperty("MAPBOX_DOWNLOADS_TOKEN").get()
            authentication.create<BasicAuthentication>("basic")
        }

    }
}


rootProject.name = "OefenLocatie"
include(":app")
