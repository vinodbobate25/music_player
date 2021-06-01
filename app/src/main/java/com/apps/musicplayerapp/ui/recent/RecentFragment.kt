package com.apps.musicplayerapp.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.musicplayerapp.R
import com.apps.musicplayerapp.RecentMusic
import com.apps.newsapp.news.RecentMusicListAdapter
import com.apps.newsapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recent.*

@AndroidEntryPoint
class RecentFragment : Fragment() {

    private lateinit var recentViewModel: RecentViewModel
    private lateinit var adapter:RecentMusicListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recentViewModel =
                ViewModelProvider(this).get(RecentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recent, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    //setup observer
    private fun setupObserver()
    {
        recentViewModel.getMusiclIst().observe(viewLifecycleOwner, Observer {
            when(it.status)
            {
                Status.SUCCESS->
                {
                    recycle_recent_list.visibility=View.VISIBLE
                    it.data?.let { it1 -> showSongsList(it1) }
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                    //Handle Error
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private  fun setupUI()
    {
        recycle_recent_list.layoutManager= LinearLayoutManager(activity)
        adapter=RecentMusicListAdapter(arrayListOf())
        recycle_recent_list.addItemDecoration(DividerItemDecoration(recycle_recent_list.context,(recycle_recent_list.layoutManager as LinearLayoutManager).orientation))
        recycle_recent_list.adapter=adapter
    }


    //method to update the recyclerview adapter
    private  fun showSongsList( musicList:List<RecentMusic>)
    {
        adapter.notifyDataSetChanged()
        adapter.addData(musicList)
    }

}