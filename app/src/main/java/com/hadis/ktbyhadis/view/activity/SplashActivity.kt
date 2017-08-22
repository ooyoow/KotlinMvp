package com.hadis.ktbyhadis.view.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import com.hadis.ktbyhadis.R
import com.twobbble.tools.newIntent
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        //设置全屏
        initView()
        setAnimation()
    }

    private fun initView() {
        val fontType: Typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        tv_name_english.typeface = fontType
        tv_english_intro.typeface = fontType
    }

    private fun setAnimation() {
        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 1500
        val scaleAnimation = ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 1500
        val animationSet: AnimationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 1500
        iv_icon_splash.startAnimation(animationSet)
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                newIntent<Main2Activity>("Tag", "hehe")
                finish()
            }
        })


    }

}