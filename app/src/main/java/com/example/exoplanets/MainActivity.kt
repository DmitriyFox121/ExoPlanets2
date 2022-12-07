package com.example.exoplanets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.MediaController
import android.widget.Toast
import kotlin.properties.Delegates
import android.widget.VideoView
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity(),  ListFragment.OnFragmentSendDataListener {

    var backPressedTime:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.exoplanets_menu_item -> {
                buttonAboutActivity()
            }
            R.id.about_menu_item ->{
                buttonProgramActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun buttonAboutActivity() {
        val intent: Intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun buttonProgramActivity() {
        val intent: Intent = Intent(this@MainActivity, ProgramActivity::class.java)
        startActivity(intent)
    }



    override fun onBackPressed() {
        if (backPressedTime+3000>System.currentTimeMillis()){
        super.onBackPressed()
            finish()}
        else{
            Toast.makeText(this,"Нажмите 2 раза для выхода", Toast.LENGTH_LONG).show()}
        backPressedTime=System.currentTimeMillis()
        }




    override fun onSendData(selectedItem: String?)  {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.detailFragment) as DetailFragment?
        if (fragment != null && fragment.isVisible){
            fragment.setSelectedItem(selectedItem)
        }
        else{
            val intent = Intent(applicationContext,
                DetailActivity::class.java)
            intent.putExtra(DetailActivity.SELECTED_ITEM, selectedItem)
            startActivity(intent)
        }
        fragment?.setSelectedItem(selectedItem)
    }


}

