package com.apps.musicplayerapp.ui.recent

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.api.ApiHelper
import com.apps.musicplayerapp.utils.TestCoroutineRule
import com.apps.newsapp.data.MusicRepository
import com.apps.newsapp.utils.Resource
import com.mindorks.example.coroutines.data.local.DatabaseHelper
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RecentViewModelTest : TestCase() {


    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var musicRepository: MusicRepository

    @Mock
    private  lateinit var context: Context

    @Mock
    private lateinit var databaseHelper: DatabaseHelper

    @Mock
    private lateinit var apiMusicObserver: Observer<Resource<List<RecentMusic>>>

    public override fun setUp() {
        super.setUp()
    }


    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(emptyList<RecentMusic>())
                .`when`(musicRepository)
                .getMusic(true)
            val viewModel = RecentViewModel(musicRepository,context, databaseHelper)
            viewModel.getMusiclIst().observeForever(apiMusicObserver)
            Mockito.verify(musicRepository).getMusic(true)
            Mockito.verify(apiMusicObserver).onChanged(Resource.success(emptyList()))
            viewModel.getMusiclIst().removeObserver(apiMusicObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            Mockito.doThrow(RuntimeException(errorMessage))
                .`when`(musicRepository)
                .getMusic(true)
            val viewModel = RecentViewModel(musicRepository,context, databaseHelper)
            viewModel.getMusiclIst().observeForever(apiMusicObserver)
            Mockito.verify(musicRepository).getMusic(true)
            Mockito.verify(apiMusicObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getMusiclIst().removeObserver(apiMusicObserver)
        }
    }

    @Test
    fun fetch_from_room_when_network_not_available()
    {
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(emptyList<RecentMusic>())
                .`when`(musicRepository)
                .getMusic(false)
            val viewModel = RecentViewModel(musicRepository,context, databaseHelper)
            viewModel.getMusiclIst().observeForever(apiMusicObserver)
            Mockito.verify(musicRepository).getMusic(true)
            Mockito.verify(apiMusicObserver).onChanged(Resource.success(emptyList()))
            viewModel.getMusiclIst().removeObserver(apiMusicObserver)
        }
    }


    public override fun tearDown() {}
}