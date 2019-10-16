package com.jcmo.main

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import com.google.firebase.storage.UploadTask
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage

import kotlinx.android.synthetic.main.activity_edit_perfil.*
import java.io.ByteArrayOutputStream
import com.google.firebase.database.FirebaseDatabase
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class EditPerfilActivity : AppCompatActivity() {

    //private val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var storage: FirebaseStorage

    private lateinit var database2: DatabaseReference// ...


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_perfil)
        var url :String = "asdasdasdasd"

        /*btguardar.setOnClickListener {
            saveUser(url)
        }*/


        btguardar.setOnClickListener {
            saveImage(ivperfil)
        }

        ivperfil.setOnClickListener {
            dispatchTakePictureIntent()
        }

    }



    private fun dispatchTakePictureIntent() {

        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivperfil.setImageBitmap(imageBitmap)


            //root.iPicture.setImageBitmap(imageBitmap)
            //saveImage(root.iPicture)
        }
    }


    private fun saveImage(iPicture : ImageView? ) {
        storage = FirebaseStorage.getInstance()
        val photoRef = storage.reference.child("user").child("78931")

        ivperfil.isDrawingCacheEnabled = true
        ivperfil.buildDrawingCache()


       iPicture?.isDrawingCacheEnabled = true
        iPicture?.buildDrawingCache()
        val bitmap = (ivperfil!!.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val data = baos.toByteArray()

        //val uploadTask :UploadTask = photoRef.putBytes(data)
        //val asd = photoRef.putBytes(data)
        var uploadTask = photoRef.putBytes(data)

        //Log.i("OK","asdasd")

        //photoRef.putFile()

        val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            return@Continuation photoRef.downloadUrl
        }).addOnCompleteListener { task ->
            if(task.isSuccessful){
                var downloadUri = task.result
                saveUser(downloadUri.toString())
                //saveUser()
                //Toast.makeText(this,downloadUri.toString(),Toast.LENGTH_SHORT).show()
           }else{

                //Toast.makeText(this,"fallo",Toast.LENGTH_SHORT).show()
            }
        }



    }
    //urlFoto2:String

    private fun saveUser(urlFoto:String) {
        //Toast.makeText(this,urlFoto2,Toast.LENGTH_SHORT).show()

        //if (urlFoto2.isEmpty()){
            //urlFoto = "https://firebasestorage.googleapis.com/v0/b/main-aead3.appspot.com/o/users%2Fperfil.png?alt=media&token=8d06e516-3dea-4211-979a-e8ba2e3420ad"
        //}else{
           // urlFoto = urlFoto2
        //}
        database2 = FirebaseDatabase.getInstance().reference

        val nombre = "Camilo"
        val id = "555"
        val correo = "juanmart32@gmail.com"

        val user = User(
            nombre,
            correo,
            id,
            urlFoto
        )

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("user")
       // database2.child("user").child(id).setValue(user)
        myRef.child(id).setValue(user)
        setResult(Activity.RESULT_OK, intent)//llama actividad
        finish()//destruyr actividad

    }




}
