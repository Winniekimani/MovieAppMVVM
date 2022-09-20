# MovieApp-MVVM-Interview

A simple project using The Movie DB based on Kotlin MVVM architecture

# Screenshots #
<img src="https://github.com/rcpyesilkaya/MovieApp-MVVM/blob/master/app/src/main/res/drawable-v24/ss1.jpeg" width="200" height="400" padding="5"/> <img src="https://github.com/rcpyesilkaya/MovieApp-MVVM/blob/master/app/src/main/res/drawable-v24/ss2.jpeg" width="200" height="400" padding="5"/> 


# API

* https://www.themoviedb.org/documentation/api


# Libraries and tools

* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify domain layer data to views.
* [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - dispose observing data when lifecycle state changes.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.
* [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
* [OkHttp](https://github.com/square/okhttp) - implementing interceptor, logging and mocking web server
* [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - implementing adapters and viewHolders
* [RxJava2](https://developer.android.com/reference/kotlin/androidx/ui/rxjava2/package-summary) - For a seamless user experience
* [Glide](https://github.com/bumptech/glide) - loading images
* [DataBinding](https://developer.android.com/topic/libraries/data-binding)
  *paging-to achieve stability
# Architecture

* [MVVM Architecture](https://developer.android.com/jetpack/guide) (Model -View - ViewModel)
* MVVM architecture separates the business from the UI,which makes it easier for debugging.

#assumptions made
 users will not need to see the cast or trailers in the app
 no any other additional functionality was needed.e.g searching movies,categorizing movies e.t.c

#challenges 
rapid depracation of libraries
time limitation

#all Features were completed
Fetch movies from the movie db api
Cache all the data once fetched to a local storage with maximum size of 20MB

#glide-for image cache strategy








