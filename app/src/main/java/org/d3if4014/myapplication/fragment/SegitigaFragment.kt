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
import org.d3if4014.myapplication.databinding.FragmentSegitigaBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class SegitigaFragment : Fragment() {

    private lateinit var binding : FragmentSegitigaBinding
    private var luas = 0.0
    private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        title()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_segitiga,container,false)
        binding.btnHitungSegitiga.setOnClickListener { checkInput() }
        binding.btnShareSegitiga.setOnClickListener { sendemail() }
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun title(){
        val getActivity = activity!! as MainActivity
        getActivity.supportActionBar?.title = "Segitiga"
    }
    private fun checkInput(){
        when {
            binding.alasSegitiga.text.isEmpty() -> {
                Toast.makeText(activity,"Panjang Harus diisi", Toast.LENGTH_SHORT).show()
            }
            binding.tinggiSegitiga.text.isEmpty() -> {
                Toast.makeText(activity,"Lebar harus diisi", Toast.LENGTH_SHORT).show()
            }
            else -> hitunghasil()
        }
    }
    private fun visibleResult(){
        binding.alasSegitiga.visibility = View.VISIBLE
        binding.tinggiSegitiga.visibility = View.VISIBLE
        binding.tvLuasSegitiga.visibility = View.VISIBLE
        binding.tvKelilingSegitiga.visibility = View.VISIBLE
        binding.btnShareSegitiga.visibility = View.VISIBLE
        binding.btnHitungSegitiga.visibility = View.VISIBLE
    }
    private fun hitunghasil(){
        var alas = binding.alasSegitiga.text.toString().toDouble()
        var tinggi = binding.tinggiSegitiga.text.toString().toDouble()

        luas = alas * tinggi / 2
//        keliling =
    }
    private fun sendemail(){
        val intent = Intent(Intent.ACTION_SENDTO)
        val subject = "Hasil Perhitungan Persegi Panjang"
        val message = """
            "Alas = ${binding.alasSegitiga.text}
            "Tinggi   = ${binding.tinggiSegitiga.text}
            "Luas   = ${binding.tvLuasSegitiga.text}
            "Keliling   = ${binding.tvKelilingSegitiga.text}
        """.trimIndent()
        intent.data = Uri.parse("MailTo :")
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.putExtra(Intent.EXTRA_SUBJECT,message)
        startActivity(intent)
    }
}
