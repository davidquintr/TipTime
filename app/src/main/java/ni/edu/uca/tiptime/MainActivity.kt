package ni.edu.uca.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.tiptime.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            calcularPropina()
        }

    }

    fun calcularPropina(){
        var monto : Double = binding.etCoste.text.toString().toDouble()
        var calculo = monto

        if(monto == null){
            binding.tvResult.text = "Ingrese un monto válido"
        }

        with(binding){
            if(rbAsom.isChecked){
                calculo += monto * 0.20
            } else if(rbGood.isChecked){
                calculo += monto * 0.18
            } else if(rbOk.isChecked) {
                calculo += monto * 0.15
            } else {
                Toast.makeText(this@MainActivity,"Seleccione una propina válida",Toast.LENGTH_LONG).show()
                return
            }

            if(swRound.isChecked){
                calculo = round(calculo)
            }

            tvResult.text = getString(R.string.tip_amount,calculo.toString())
        }
    }

}