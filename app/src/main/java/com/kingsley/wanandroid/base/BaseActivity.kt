package com.kingsley.wanandroid.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.gyf.barlibrary.ImmersionBar

/**
 * Created by Stephen on 2018/3/15.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var immersionBar: ImmersionBar

    private val imm: InputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initImmersionBar()
    }

    protected abstract fun setLayoutId(): Int

    open protected fun initImmersionBar() {
        // 在BaseActivity里初始化
        immersionBar = ImmersionBar.with(this)
        immersionBar.init()
    }

    /**
     *  cancel request
     */
    protected abstract fun cancelRequest()

    override fun onDestroy() {
        super.onDestroy()
        immersionBar.destroy()
        cancelRequest()
    }

    override fun finish() {
        // if not finish
        if (isFinishing) {
            super.finish()
            hideSoftKeyBoard()
        }
    }

    private fun hideSoftKeyBoard() {
        currentFocus?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 2)
        }
    }
}