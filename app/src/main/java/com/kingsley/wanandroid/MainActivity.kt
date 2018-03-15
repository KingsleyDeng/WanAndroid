package com.kingsley.wanandroid

import android.os.Bundle
import com.kingsley.wanandroid.base.BaseActivity

/**
 *  主界面
 */
class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun cancelRequest() {
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar.titleBar(R.id.toolbar).init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
