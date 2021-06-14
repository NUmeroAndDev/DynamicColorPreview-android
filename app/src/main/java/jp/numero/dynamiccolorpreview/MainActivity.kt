package jp.numero.dynamiccolorpreview

import android.os.Bundle
import androidx.activity.ComponentActivity
import jp.numero.dynamiccolorpreview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}