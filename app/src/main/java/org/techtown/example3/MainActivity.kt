package org.techtown.example3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener{
            val oper = getOperator("add")
            if (oper !=null){
                val output1 = calc(getFirst(), getSecond(), oper)
                textView.setText("더하기 결과: ${output1}")
            }
        }

        subtractButton.setOnClickListener{
            val oper = getOperator("subtract")
            if (oper !=null){
                val output1 = calc(getFirst(), getSecond(), oper)
                textView.setText("빼기 결과: ${output1}")
            }
        }

        multiplyButton.setOnClickListener{
            val oper = getOperator("multiply")
            if (oper !=null){
                val output1 = calc(getFirst(), getSecond(), oper)
                textView.setText("곱하기 결과: ${output1}")
            }
        }

        divideButton.setOnClickListener{
            val oper = getOperator("divide")
            if (oper !=null){
                val output1 = calc(getFirst(), getSecond(), oper)
                textView.setText("나누기 결과: ${output1}")
            }
        }

    }

    fun getOperator(name:String):((Int, Int)->Int)?{
        var oper:((Int, Int)->Int)? = null
        if(name == "add"){
            oper = {a, b->a+b}
        }else if(name == "subtract"){
            oper = {a, b->a-b}
        }else if(name == "multiply"){
            oper = {a, b->a*b}
        }else if(name == "divide"){
            oper = {a, b->a/b}
        }
        return oper
    }

    fun calc(first:Int, second: Int, oper:(Int, Int)->Int):Int {
        return oper(first, second)
    }

    fun getFirst():Int{
        val firstStr = firstInput.text.toString().trim()
        val first = firstStr.toInt()

        return first
    }

    fun getSecond():Int{
        val secondStr = secondInput.text.toString().trim()
        val second = secondStr.toInt()

        return second
    }
}