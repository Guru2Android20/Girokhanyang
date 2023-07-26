package com.example.guruapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.guruapp.databinding.ActivityNaviBinding

private const val TAG_MAIN = "main_fragment"
private const val TAG_CALENDAR = "calendar_fragment"
private const val TAG_WRITING = "writing_fragment"
private const val TAG_CHART = "chart_fragment"
private const val TAG_MYPAGE = "myPage_fragment"


class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 결합 클래스 인스턴스 생성
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_MAIN, MainFragment())

        // 네비게이션 버튼에 프래그먼트 연결
        binding.navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mainFragment -> setFragment(TAG_MAIN, MainFragment())
                R.id.calendarFragment -> setFragment(TAG_CALENDAR, CalendarFragment())
                R.id.writingFragment -> setFragment(TAG_WRITING, WritingFragment())
                R.id.chartFragment -> setFragment(TAG_CHART, ChartFragment())
                R.id.myPageFragment -> setFragment(TAG_MYPAGE, MyPageFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        // FragmentManager 클래스 사용
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        // 프래그먼트 추가
        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val main = manager.findFragmentByTag(TAG_MAIN)
        val calendar = manager.findFragmentByTag(TAG_CALENDAR)
        val writing = manager.findFragmentByTag(TAG_WRITING)
        val chart = manager.findFragmentByTag(TAG_CHART)
        val myPage = manager.findFragmentByTag(TAG_MYPAGE)

        if (main != null) {
            fragTransaction.hide(main)
        }
        if (calendar != null) {
            fragTransaction.hide(calendar)
        }
        if (writing != null) {
            fragTransaction.hide(writing)
        }
        if (chart != null) {
            fragTransaction.hide(chart)
        }
        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        // 태그에 맞는 프래그먼트 보여주기
        when (tag) {
            TAG_MAIN -> if (main != null) fragTransaction.show(main)
            TAG_CALENDAR -> if (calendar != null) fragTransaction.show(calendar)
            TAG_WRITING -> if (writing != null) fragTransaction.show(writing)
            TAG_CHART -> if (chart != null) fragTransaction.show(chart)
            TAG_MYPAGE -> if (myPage != null) fragTransaction.show(myPage)
        }

        fragTransaction.commitAllowingStateLoss()
    }
}