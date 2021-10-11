package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //var
    private lateinit var inputNIS: EditText
    private lateinit var inputNama: EditText
    private lateinit var jklakilaki: RadioButton
    private lateinit var jkPerempuan: RadioButton
    private lateinit var btnTambah: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById (R.id.txtInputNis)
        inputNama = findViewById (R.id.txtInputNama)
        jklakilaki = findViewById (R.id.rbLakiLaki)
        jkPerempuan = findViewById (R.id.rbPerempuan)
        btnTambah = findViewById (R.id.btnTambah)
        recyclerView = findViewById (R.id.listData)
        //membuat variabel kosong tipe orang mutablelist untuk simpan data array
        // data array disimpan di atas class Siswadata
        val data= mutableListOf<SiswaData>()
        viewManager=LinearLayoutManager(this)
        recyclerAdapter = SiswaAdapter(data)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager = viewManager

        // setOnclicklistener untuk tombol Tambah Data
        btnTambah.setOnClickListener {
            // 1. membuat ariabel penyimpan data
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jk=""
            if (jklakilaki.isChecked){
                jk="Laki-Laki"
            }else{
                jk="Perempuan"
            }
            // siswa data ke array mutablelist
            val dataSiswa=SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }
}