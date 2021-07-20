# Popular Movie Viewer
<a href="https://github.com/Vova-SH/Samsung-Bootcamp-2021/actions/workflows/android.yml"><img src="https://github.com/Vova-SH/Samsung-Bootcamp-2021/actions/workflows/android.yml/badge.svg" align="left" alt="Android CI"></a>
<p align="right">
  <a href="./README.en-US.md">English</a>
  |
  <a href="./README.md">Русский</a>
</p>

## About app
<img src="https://github.com/Vova-SH/Samsung-Bootcamp-2021/blob/main/screenshots/app.en-US.gif" width = "260" align="right">

The application was developed as part of the [Samsung Innovation Campus Bootcamp: Kotlin for Android (RU)] training intensive (https://youtube.com/playlist?list=PLa2T1zmZ6w5KzKoh9M91vk1LBqpc-WtoS). Master class "[Using MVVM pattern in application development. ViewModel and LiveData classes (RU)](https://youtu.be/8MmeLVi-7yU)".

The functionality provides a simple list of popular movies and information about each movie. The movie information is accessed via the [The Movie DB](https://www.themoviedb.org) service using the corresponding [API](https://www.themoviedb.org/documentation/api/).

Find presentation and other supplementary materials [here](https://github.com/Vova-SH/Samsung-Bootcamp-2021/tree/main/docs).

**The project template is in the template branch or can be downloaded** [here](https://github.com/Vova-SH/Samsung-Bootcamp-2021/archive/refs/heads/template.zip).

## Development Environment
The app is written entirely in Kotlin and uses the Gradle build system.

To build the app, use the `gradlew build` command or use "Import Project" in
Android Studio. A stable version of Android Studio 4.2.1 or newer is
required and may be downloaded [here](https://developer.android.com/studio/).

## Architecture
The architecture is built around [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/).

We followed the recommendations laid out in the [Guide to App Architecture](https://developer.android.com/jetpack/docs/guide) when deciding on the architecture for the app. We kept logic away from Activities and Fragments and moved it to [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).

We observed data using [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) and use [Room](https://developer.android.com/jetpack/androidx/releases/room)  for storage and manage movies cache.

We used [Koin](https://github.com/InsertKoinIO/koin) for inject ViewModels into Fragments.

## The Movie Database API
This API is used to demonstrate the client-server architecture. The data and images are licensed under [CC BY-NC 4.0](https://creativecommons.org/licenses/by-nc/4.0/). The full API usage rules are available [here](https://www.themoviedb.org/documentation/api/terms-of-use).

The following steps are required for operability:
1. Obtain the key by [following instructions](https://developers.themoviedb.org/3/getting-started/introduction).
2. Add the key in the file `Constants.kt` to the constant `API_KEY`.

The following queries are used in the application:
- `GET` [/movie/{movie_id}](https://developers.themoviedb.org/3/movies/get-movie-details) - to get information about the movie.
- `GET` [/movie/{movie_id}/credits](https://developers.themoviedb.org/3/movies/get-movie-credits) - to get information about the actors and crew of the movie.
- `GET` [/movie/popular](https://developers.themoviedb.org/3/movies/get-popular-movies) - to get a page-by-page list of popular movies.