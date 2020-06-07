package com.realm.example.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.realm.example.R
import com.realm.example.base.DataBindingActivity
import com.realm.example.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    private val mainVM by inject<MainVM>()

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.vm = mainVM
        initObserver()
        setClickListener()
    }

    private fun initObserver() {
        mainVM.getEmployeeData().observe(this, Observer {
            vb.tvResponse.text = it
        })
    }

    private fun setClickListener() {
        vb.btnSave.setOnClickListener {
            mainVM.addUpdateEmployee(
                vb.etId.text.toString(),
                vb.etName.text.toString(),
                vb.etLocation.text.toString()
            ).observe(this, Observer {
                vb.tvResponse.text = it
            })
        }
        vb.btnClear.setOnClickListener {
            mainVM.clearAll().observe(this, Observer {
                vb.tvResponse.text = it
            })
        }
    }
}