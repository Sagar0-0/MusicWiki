# MusicWiki
> An unofficial Last.fm app that contains information about different music genres, the albums, artists and tracks listed under the genre.


## Specs for MusicWiki
- Display the list of genres available.
- Clicking on the genre it take the user to a page called ```GenreDetails``` which contains information regarding it.
- ```GenreDetails``` contains a BottomBar with three different fragment screens.
  - Albums: Display the cover image, title and the artist information. Clicking on the album it display the details about the album.
  - Artists: Display the image, title ,play count and followers, description, a list of top tracks and top albums and the genres.
  - Tracks: Show all tracks related to particular Genre.

## UI
HomeScreen | Albums Tab | Artists Tab | Tracks Tab
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------: 
![Screenshot_20230202_214824](https://user-images.githubusercontent.com/85388413/216382388-8ca4f68d-71f7-4c3a-b4b2-0d20e52ce659.png)|![Screenshot_20230202_223611](https://user-images.githubusercontent.com/85388413/216393224-1b73c730-0287-4c0c-803d-05c7d6adbd98.png)|![Screenshot_20230202_223611](https://user-images.githubusercontent.com/85388413/216393224-1b73c730-0287-4c0c-803d-05c7d6adbd98.png)|![Screenshot_20230202_223611](https://user-images.githubusercontent.com/85388413/216393224-1b73c730-0287-4c0c-803d-05c7d6adbd98.png)



## Libraries/Principles used: 
- [Kotlin](https://kotlinlang.org/) as the Primary Language.
- [Fragments](https://developer.android.com/guide/fragments) to display reflixible UI.
- [Coroutines](https://developer.android.com/kotlin/coroutines?gclsrc=ds&gclsrc=ds) for writing asynchronous non-blocking code.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?gclsrc=ds&gclsrc=ds) as a single source of truth.
- [Single Activity Pattern](https://www.youtube.com/watch?v=2k8x8V77CrU) for best practices.
- [MVVM](https://developer.android.com/topic/architecture?gclsrc=ds&gclsrc=ds) for the clean and recommended architecture of app.
- [Retrofit](https://square.github.io/retrofit/) to fetch data from Last.fm API.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
- [Glide](https://github.com/bumptech/glide) to load images in UI.
- [Jetpack Navigation component](https://developer.android.com/guide/navigation?gclsrc=ds&gclsrc=ds) to navigate easily from one Screen to another.
- [Timber](https://github.com/JakeWharton/timber) for logging.
- Truth, JUnit, Robolectric for Testing.(Still pending)
