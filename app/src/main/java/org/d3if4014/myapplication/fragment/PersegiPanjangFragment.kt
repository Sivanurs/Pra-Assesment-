package org.d3if4014.myapplication.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if4014.myapplication.MainActivity

import org.d3if4014.myapplication.R
import org.d3if4014.myapplication.databinding.FragmentPersegiPanjangBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    private lateinit var binding : FragmentPersegiPanjangBinding
    private var luas = 0.0
    private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        title()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegi_panjang,container,false)
        binding.btnHitungPp.setOnClickListener { checkInput()}
        binding.btnSharePp.setOnClickListener { sendemail() }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun title(){
        val getActivity = activity!! as MainActivity
        getActivity.supportActionBar?.title = "Persegi Panjang"
    }

    private fun checkInput(){
        when {
            binding.inpPanjang.text.isEmpty() -> {
                Toast.makeText(activity,"Panjang Harus diisi", Toast.LENGTH_SHORT).show()
            }
            binding.inpLebar.text.isEmpty() -> {
                Toast.makeText(activity,"Lebar harus diisi", Toast.LENGTH_SHORT).show()
            }
            else -> hitunghasil()
        }
    }
    private fun visibleResult(){
        binding.luasPp.visibility = View.VISIBLE
        binding.kelilingPp.visibility = View.VISIBLE
        binding.tvluas.visibility = View.VISIBLE
        binding.tvkeliling.visibility = View.VISIBLE
        binding.btnSharePp.visibility = View.VISIBLE
        binding.btnHitungPp.visibility = View.VISIBLE
    }
    private fun hitunghasil(){
        var panjang = binding.inpPanjang.text.toString().toDouble()
        var lebar = binding.inpLebar.text.toString().toDouble()
        luas = panjang * lebar
        keliling = 2 * (panjang + lebar)
        visibleResult()

        binding.tvluas.text = "$luas"
        binding.tvkeliling.text = "$keliling"
    }

    private fun sendemail(){
        val intent = Intent(Intent.ACTION_SENDTO)
        val subject = "Hasil Perhitungan Persegi Panjang"
        val message = """
            "Panjang = ${binding.inpPanjang.text}
            "Lebar   = ${binding.inpLebar.text}
            "Luas   = ${binding.tvluas.text}
            "Lebar   = ${binding.tvkeliling.text}
        """.trimIndent()
        intent.data = Uri.parse("MailTo :")
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.putExtra(Intent.EXTRA_SUBJECT,message)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("luas", luas)
        outState.putDouble("keliling", keliling)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            luas = savedInstanceState.getDouble("luas")
            keliling = savedInstanceState.getDouble("keliling")

            visibleResult()
            binding.tvluas.text = "$luas"
            binding.tvkeliling.text = "$keliling"
        }
        super.onViewStateRestored(savedInstanceState)
    }
}
