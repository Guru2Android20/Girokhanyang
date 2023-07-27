package com.example.guruapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyPageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(com.example.guruapp.R.layout.fragment_my_page, container, false)
        val changeNameBtn: Button = v.findViewById(com.example.guruapp.R.id.changeNameBtn)
        val changePwBtn: Button = v.findViewById(com.example.guruapp.R.id.changePwBtn)

        // 이름 변경 액티비티로 이동
        changeNameBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ChangeNameActivity::class.java)
            startActivity(intent)
        })

        // 비밀번호 변경 액티비티로 이동
        changePwBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ChangePwActivity::class.java)
            startActivity(intent)
        })

        // Inflate the layout for this fragment
        return v
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "userDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE userTBL ( uID CHAR(20) PRIMARY KEY, uPW CHAR(15), uName CHAR(20) );")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS userDB")
            onCreate(db)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyPageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}