package com.bayarsahintekin.stars.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bayarsahintekin.stars.R
import com.bayarsahintekin.stars.data.model.Star
import com.bayarsahintekin.stars.databinding.ViewStarBinding
import com.bayarsahintekin.stars.util.*
import kotlin.random.Random

class StarView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = ViewStarBinding.inflate(LayoutInflater.from(context), this, true)
    private var skyList: ArrayList<Star> = arrayListOf()
    private val TAG = "StarView"
    private lateinit var callbacks: IStarView

    init {
        binding.wvStar.loadUrl(Constants.STAR_URL)
        binding.wvStar.settings.loadWithOverviewMode = true
        binding.wvStar.settings.useWideViewPort = true

        binding.btnBigStar.setOnClickListener {
            if (skyList.size < 10){
                bigButtonSelected()
            }else {
                showToast(context,resources.getString(R.string.sky_is_full),Toast.LENGTH_SHORT)
                logArray(resources.getString(R.string.sky_is_full))
            }
            if (::callbacks.isInitialized)
                callbacks.bigStarButtonSelected()
        }

        binding.btnSmallStar.setOnClickListener {
            if (skyList.size < 10){
                smallButtonSelected()
            }else {
                logArray(resources.getString(R.string.sky_is_full))
                showToast(context,resources.getString(R.string.sky_is_full),Toast.LENGTH_SHORT)
            }

            if (::callbacks.isInitialized)
                callbacks.smallStarButtonSelected()
        }
    }

    fun addStarInterface(callbacks: IStarView){
        this.callbacks = callbacks
    }

    private fun smallButtonSelected(){
        skyList.add(Star(
            size = Size.SMALL.size,
            color = BigColors.values()[Random.nextInt(BigColors.values().size)].color,
            brightness = Brightness.values()[Random.nextInt(Brightness.values().size)].brightness
        ))
        logArray()
    }


    private fun bigButtonSelected(){
        skyList.add(Star(
            size = Size.BIG.size,
            color = SmallColors.values()[Random.nextInt(SmallColors.values().size)].color,
            brightness = Brightness.values()[Random.nextInt(Brightness.values().size)].brightness
        ))
        logArray()
    }

    private fun logArray(error: String? = null){
        var listStr = ""
        val lineSeparator = System.lineSeparator()
        for (i in skyList){
            listStr = "$listStr $lineSeparator $i"
        }
        if (error != null) {
            logInfo(TAG,listStr)
            logInfo(TAG,error)
        }else {
            val brightCount = skyList.count{ it.brightness == Brightness.BRIGHT.brightness }
            logInfo(TAG,listStr)
            logInfo(TAG,"Bright count: $brightCount")
        }
    }

}