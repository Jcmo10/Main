package com.jcmo.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.content_main.*

//Bottom
private lateinit var textMessage: TextView
//Bottom

private var emailM: String? = null
private var passM: String? = null



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    //Bottom
    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListenerB = BottomNavigationView.OnNavigationItemSelectedListener { item ->




        when (item.itemId) {
            R.id.navigation_home -> {
                //textMessage.setText(emailM)
                textMessage.setText(R.string.title_home)
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //textMessage.setText(emailM)
                textMessage.setText(R.string.title_dashboard)
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //textMessage.setText(emailM)
                textMessage.setText(R.string.title_notifications)
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }
    //Bottom


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var datosRecibidos = intent.extras
        emailM = datosRecibidos?.getString("correo").toString()
        passM =  datosRecibidos?.getString("pass").toString()

        message2.text = emailM
        //tvContraseñaM.text = passM

        //Inicio BottomNavigation
        val navViewB: BottomNavigationView = findViewById(R.id.nav_viewB)
        textMessage = findViewById(R.id.message2)
        navViewB.setOnNavigationItemSelectedListener(onNavigationItemSelectedListenerB)
        //Fin BottomNavigation



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId){
            R.id.action_settings -> {
                intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("correo",emailM)
                intent.putExtra("pass",passM)
                startActivity(intent)
                finish()
            }

        }
        return super.onOptionsItemSelected(item)

        /*return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }*/
    }

   override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
       var datosRecibidos = intent.extras
       emailM = datosRecibidos?.getString("correo").toString()
       passM =  datosRecibidos?.getString("pass").toString()

      // message2.text = emailM

        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                message2.text = emailM
                //message2.text = "dashboard"
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
