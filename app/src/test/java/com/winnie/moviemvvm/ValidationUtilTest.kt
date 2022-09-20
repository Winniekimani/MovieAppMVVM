package com.winnie.moviemvvm

import com.winnie.moviemvvm.data.vo.Movie
import junit.framework.Assert.assertEquals
import org.junit.Test

class ValidationUtilTest {

    @Test
    fun validateMovieTest() {
        val movie = Movie(1,"testUrl","22-5-2022", "The reckon")
        assertEquals(true, ValidationUtil.validateMovie(movie))
    }

    @Test
    fun validateMovieEmptyTest() {
        val movie = Movie(1,"","main", "")
        assertEquals(false, ValidationUtil.validateMovie(movie))
    }


}