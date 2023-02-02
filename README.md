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

## Libraries/Principles used: 
- Kotlin as the Primary Language.
- Fragments to display reflixible UI.
- Coroutines for writing asynchronous non-blocking code.
- ViewModel as a single source of truth.
- Single Activity Pattern for best practices.
- MVVM for the clean and recommended architecture of app.
- Retrofit to fetch data from Last.fm API.
- Hilt for dependency injection.
- Glide to load images in UI.
- Jetpack Navigation component to navigate easily from one Screen to another.
- Truth, JUnit, Robolectric for Testing.(Still pending)
- Timber for logging.
