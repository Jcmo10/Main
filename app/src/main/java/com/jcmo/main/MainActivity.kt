package com.jcmo.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_main.*


private var emailM: String? = null
private var passM: String? = null
var trabajador : MutableList<Trabajador> = ArrayList()
var animal : MutableList<Animal> = ArrayList()
var bool: Boolean = false
var boolean2: Boolean = false


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,comunicador {


    //Bottom
    private lateinit var textMessage: TextView

    //Bottom
    //Bottom

    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListenerB = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()


        animal.add(Animal("vaca","123",R.drawable.perfil,"100Kg","5","Macho","AAA","BBB"))
        when (item.itemId) {
            R.id.navigation_home -> {
                boolean2 = false
                val datosRecibidos = intent.extras
                //bool = datosRecibidos?.getBoolean("vis")!!
                emailM = datosRecibidos?.getString("correo").toString()
                //tinfo.text = "$emailM\nas\ndf"
                val homeFragment = HomeFragment()
                val bundle = Bundle()
                bundle.putString("Emaila", emailM)
                //transaction.replace(R.id.contenedor, homeFragment).addToBackStack(null).commit()
                transaction.replace(R.id.contenedor, homeFragment).commit()
                //transaction.addToBackStack(null)
                //textMessage.setText(emailM)
                //textMessage.setText(R.string.title_home)
                //message2.text = textMessage.toString()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val animalesFragment = AnimalesFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("animal", ArrayList<Animal>(animal))
                bundle.putBoolean("visi",bool)
                //transaction.replace(R.id.contenedor, animalesFragment).addToBackStack("tag").commit()
                //transaction.replace(R.id.contenedor, animalesFragment).commit()
                transaction.replace(R.id.contenedor, animalesFragment).commit()
                //textMessage.setText(emailM)
                //textMessage.setText(R.string.title_dashboard)
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val produccionFragment = ProduccionFragment()
                transaction.replace(R.id.contenedor, produccionFragment).commit()
                //textMessage.setText(emailM)
                //textMessage.setText(R.string.title_notifications)
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_eventos -> {
                val eventosFragment = EventosFragment()
                transaction.replace(R.id.contenedor, eventosFragment).commit()
                //textMessage.setText(emailM)
                //textMessage.text = "asdasd"
                //message2.text = textMessage.toString()
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }
    //Bottom

    //private var trabajador : MutableList<Trabajador> = ArrayList()
    var trabajadores : MutableList<Trabajador> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        trabajador.add(Trabajador("Jose Ramirez","Administrador",R.drawable.perfil))


        //var boolean = intent

       //val datosRecibidos = intent.extras
        //bool = datosRecibidos?.getBoolean("vis")!!
        //emailM = datosRecibidos?.getString("correo").toString()
        //passM =  datosRecibidos?.getString("pass").toString()
        //textViewcorreo.text = emailM
        //message2.text = emailM
        //tvContraseñaM.text = passM

        //Inicio BottomNavigation


        val navViewB: BottomNavigationView = findViewById(R.id.nav_viewB)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val homeFragment = HomeFragment()
        //textMessage = findViewById(R.id.message2)
        transaction.replace(R.id.contenedor, homeFragment).commit()
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
        navView.itemIconTintList=null
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


    ////Navigation Drawer
   override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
       val datosRecibidos = intent.extras
       emailM = datosRecibidos?.getString("correo").toString()
       passM =  datosRecibidos?.getString("pass").toString()
        trabajador.add(Trabajador("Jose Ramirez","Administrador",R.drawable.perfil))
        if(imageViewperfil != null) {
            imageViewperfil.setImageResource(R.drawable.perfil)
        }


        if(emailM != null) {
            textViewcorreo.text = emailM
        }
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

      // message2.text = emailM

        when (item.itemId) {
            R.id.nav_home -> {
                val navViewB: BottomNavigationView = findViewById(R.id.nav_viewB)
                navViewB.selectedItemId = R.id.navigation_home
                val homeFragment = HomeFragment()
                transaction.replace(R.id.contenedor, homeFragment).commit()
                //finish()
                //message2.text = "Home"
            }
            R.id.nav_gallery -> {
                val navViewB: BottomNavigationView = findViewById(R.id.nav_viewB)
                navViewB.selectedItemId = R.id.navigation_eventos
                val eventosFragment = EventosFragment()
                transaction.replace(R.id.contenedor, eventosFragment).commit()
                //finish()
               // message2.text = "Eventos"
            }
            R.id.nav_slideshow -> {

               // val bundle = Bundle()
                //bundle.putParcelableArrayList("peluchess", ArrayList<Trabajador>(trabajador))
                intent.putParcelableArrayListExtra("rrr", ArrayList<Trabajador>(trabajador))
                intent.putExtra("trabajador", ArrayList<Trabajador>(trabajador))
                intent = Intent(this,TrabajadoresActivity::class.java)
                startActivity(intent)
                //finish()

                //message2.text = "Trabajdores"
            }
            R.id.nav_tools -> {
                intent = Intent(this,PerfilActivity::class.java)
                startActivity(intent)
                //finish()
                //message2.text = "Perfil"
            }
            R.id.nav_share -> {
                intent = Intent(this,ContactarActivity::class.java)
                startActivity(intent)
                //finish()
                //message2.text = "Contactenos"
            }
            R.id.nav_send -> {
                intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("correo",emailM)
                intent.putExtra("pass",passM)
                startActivity(intent)
                //finish()
               // message2.text = "Enviar"
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    ////Navigation Drawer


    override fun cambiarfragevent(boolean: Boolean) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        boolean2 = boolean

        if(boolean2){
            val navViewB: BottomNavigationView = findViewById(R.id.nav_viewB)
            navViewB.selectedItemId = R.id.navigation_eventos
            val eventosFragment = EventosFragment()
            transaction.replace(R.id.contenedor, eventosFragment).commit()
        }
    }

}
