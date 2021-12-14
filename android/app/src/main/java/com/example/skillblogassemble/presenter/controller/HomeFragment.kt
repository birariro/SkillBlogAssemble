package com.example.skillblogassemble.presenter.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.skillblogassemble.R
import com.example.skillblogassemble.WebViewActivity
import com.example.skillblogassemble.presenter.HomeViewModel
import com.example.skillblogassemble.presenter.SliderTransformer
import com.example.skillblogassemble.presenter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel : HomeViewModel by viewModels()
    //val viewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val items = viewModel.getViewPagerDataList()
        var adapter = ViewPagerAdapter(items)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        viewPager.setPageTransformer(SliderTransformer(3))

        //viewpager2 양쪽 끝 이벤트 제거
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER;

        adapter.setOnItemClickListener(object : ViewPagerAdapter.OnItemClickListener{
            override fun onItemClick(v: View?, position: Int) {
                Log.d("click event", "${position}번 리스트 선택")
                val intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("url",items[position].link)
                startActivity(intent)
            }
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

