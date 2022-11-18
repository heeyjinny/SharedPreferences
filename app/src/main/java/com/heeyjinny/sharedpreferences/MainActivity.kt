package com.heeyjinny.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences를 사용하여 내부 저장소에 간단한 데이터 저장하고 불러오기

        //***값 저장 4단계***
        //1. SharedPreferences 생성
        //SharedPreferences생성을 위해 getSharedPreferences()메서드 생성하여
        //변수 sharedA에 생성할 파일명 저장
        //파라미터 : 파일명, 모드(메인 액티비티 이외 다른 컴포넌트들은 Context.MODE_PRIVATE)
        val sharedA = getSharedPreferences("이름", MODE_PRIVATE)

        //2. Editor 꺼내기
        //파일에 들어갈 데이터 저장을 위해 Editor 인터페이스의 메서드 edit() 사용
        //SharedPreferences 를 생성해 가지고 있는
        //변수 sharedA 를 통해 edit()메서드 호출하여 변수 editor에 저장
        val editor = sharedA.edit()

        //3. putInt(), putString() 등 메서드로 값 저장
        //데이터 저장 시 입력될 값의 타입에 맞는 Editor의 메서드를 사용해 저장
        editor.putString("키", "값")

        //4. 실제 파일에 반영을 위해 apply() 메서드 호출 필수
        editor.apply()

        //**값 읽어오기 2단계**
        //1. SharedPreferences 생성
        //변수 sharedB를 생성해 getSharedPreferences()메서드를 저장하여 생성
        val sharedB = getSharedPreferences("이름", MODE_PRIVATE)

        //2. getInt(), getString() 등 메서드로 값 읽어오기
        //get메서드는 put과 다르게 입력값의 파라미터는 기본값을 지정할 수 있음
        //기본값(defaultValue)를 지정하면 해당 키의 데이터가 없을 때 지정한 기본값 반환
        sharedB.getString("키","기본값")


    }//onreate
}//MainActivity