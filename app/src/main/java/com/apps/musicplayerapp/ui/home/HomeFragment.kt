package com.apps.musicplayerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
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
import kotlinx.android.synthetic.main.fragment_home.*


@AndroidEntryPoint
class HomeFragment  : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: RecentMusicListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    private fun setupObserver() {
        homeViewModel.getMusiclIst().observe(viewLifecycleOwner, Observer {
            when(it.status)
            {
                Status.SUCCESS->
                {
                    recycle_home_list.visibility=View.VISIBLE
                    it.data?.let { it1 -> showSongsList(it1) }
                }
                Status.LOADING -> {
                    recycle_home_list.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                  //  progressBar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupUI() {
        recycle_home_list.layoutManager = LinearLayoutManager(activity)
        adapter = RecentMusicListAdapter(arrayListOf())
        val mDivider = ContextCompat.getDrawable(requireActivity(), R.drawable.divider)
    val dividerItemDecoration= DividerItemDecoration(
        recycle_home_list.context,
        (recycle_home_list.layoutManager as LinearLayoutManager).orientation
    )
        dividerItemDecoration.setDrawable(mDivider!!)
        recycle_home_list.addItemDecoration(dividerItemDecoration)
        recycle_home_list.adapter = adapter
    }


    private fun showSongsList(musicList: List<RecentMusic>) {
        adapter.notifyDataSetChanged()
        adapter.addData(musicList)
    }
}

