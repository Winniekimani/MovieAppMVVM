package com.winnie.moviemvvm

import com.winnie.moviemvvm.data.api.TheMovieDBInterface
import com.winnie.moviemvvm.data.vo.Movie
import com.winnie.moviemvvm.data.vo.MovieResponse
import com.winnie.moviemvvm.ui.popular_movie.MainActivityViewModel
import com.winnie.moviemvvm.ui.popular_movie.MoviePagedListRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class MainRepositoryTest {

    lateinit var mainRepository: MoviePagedListRepository
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    @Mock
    lateinit var apiService: TheMovieDBInterface

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainRepository = MoviePagedListRepository(apiService)
    }



}
