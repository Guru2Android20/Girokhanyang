package com.example.guruapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.AxisValue
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.LineChartView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChartFragment : Fragment() {
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

        // Inflate the layout for this fragment
        return inflater.inflate(com.example.guruapp.R.layout.fragment_chart, container, false)
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lineChartView = view.findViewById<LineChartView>(R.id.chart)

        val values = ArrayList<PointValue>()
        values.add(PointValue(0f, 10f))
        values.add(PointValue(1f, 20f))
        values.add(PointValue(2f, 15f))
        values.add(PointValue(3f, 25f))
        // ... 이하 추가 데이터를 원하는 만큼 추가합니다.

        val line = Line(values).apply {
            color = ChartUtils.COLOR_BLUE // 그래프 색상 설정
            isCubic = true
        }

        val lines = ArrayList<Line>()
        lines.add(line)

        val data = LineChartData(lines)

        val axisX = Axis()
        val axisY = Axis()

        val axisValues = ArrayList<AxisValue>()
        axisValues.add(AxisValue(0f).setLabel("0일"))
        axisValues.add(AxisValue(1f).setLabel("1일"))
        axisValues.add(AxisValue(2f).setLabel("2일"))
        axisValues.add(AxisValue(3f).setLabel("3일"))
        // ... 이하 추가 레이블을 원하는 만큼 추가합니다.

        axisX.values = axisValues
        axisX.name = "X 축 레이블" // X 축 레이블 설정
        axisY.name = "Y 축 레이블" // Y 축 레이블 설정

        data.axisXBottom = axisX
        data.axisYLeft = axisY

        lineChartView.lineChartData = data
    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}