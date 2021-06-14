package jp.numero.dynamiccolorpreview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import jp.numero.dynamiccolorpreview.databinding.ViewColorInfoBinding
import java.util.*

class ColorInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewColorInfoBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
        context.withStyledAttributes(attrs, R.styleable.ColorInfoView) {
            setTitle(getString(R.styleable.ColorInfoView_title))
            setItemColor(getColor(R.styleable.ColorInfoView_infoColor, Color.WHITE))
        }
    }

    fun setTitle(title: String?) {
        binding.titleTextView.text = title
    }

    fun setItemColor(color: Int) {
        binding.colorTextView.backgroundTintList = ColorStateList.valueOf(color)
        binding.colorTextView.text = Integer.toHexString(color).uppercase(Locale.getDefault())
        binding.colorTextView.setTextColor(color.adjustTextColor())
    }

    /**
     * @return Color.BLACK or Color.WHITE
     */
    private fun Int.adjustTextColor(): Int {
        val red = Color.red(this)
        val green = Color.green(this)
        val blue = Color.blue(this)
        return if (red * 0.299 + green * 0.587 + blue * 0.114 > 186) {
            Color.BLACK
        } else {
            Color.WHITE
        }
    }
}