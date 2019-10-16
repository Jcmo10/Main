package com.jcmo.main


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.android.synthetic.main.fragment_create.view.*
import java.io.ByteArrayOutputStream

/**
 * A simple [Fragment] subclass.
 */
class CreateFragment : Fragment() {

    private lateinit var root: View
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var storage: FirebaseStorage

    private var id: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_create, container, false)


        root.btguardar.setOnClickListener {
            /* val name = eName.text.toString()
             id = eId.text.toString()
             val email = eMail.text.toString()*/

            saveImage(ivperfil)


            /*val user = User(
                name,
                id,
                email,
                //"https://firebasestorage.googleapis.com/v0/b/fir-application-68583.appspot.com/o/usuarios%2Fbatman.jpg?alt=media&token=4ccfe216-5568-4097-827b-d046b22763c4"
                "https://firebasestorage.googleapis.com/v0/b/fir-application-4b819.appspot.com/o/usuario%2Fsimplecow.png?alt=media&token=dcb26c2f-f9e5-4955-a4d3-c3870a958bb6"
            )*/

            /*myRef.child(id).setValue(user)
                .addOnSuccessListener {

                }
                .addOnFailureListener {

                }*/
        }

        root.ivperfil.setOnClickListener {
            takePhoto()
        }

        return root
    }

    private fun takePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    // activity?.packageManager?.let {
    //                takePictureIntent.resolveActivity(it)?.also {
    //                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
    //                }
    //            }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            root.ivperfil.setImageBitmap(imageBitmap)
            //saveImage(root.iPicture)
        }
    }

    private fun saveImage(iPicture: ImageView?) {
        storage = FirebaseStorage.getInstance()
        val photoRef = storage.reference.child("usuarios").child("123")

        iPicture?.isDrawingCacheEnabled = true
        iPicture?.buildDrawingCache()
        val bitmap = (iPicture?.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = photoRef.putBytes(data)

        val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            return@Continuation photoRef.downloadUrl
        }).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                savedUser(downloadUri.toString())
                Log.i("OK",downloadUri.toString())
            } else {
                Log.i("nOK","fallo")
                // Handle failures
                // ...
            }
        }

        /* uploadTask.addOnFailureListener {

             // Handle unsuccessful uploads
         }.addOnSuccessListener {
             Log.d("subida", it.metadata.toString())
             // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
             // ...
         }*/

    }


    private fun savedUser(urlFoto:String){
        val name = "asdfg"
        val id = "ggg"
        val email = "mnkjh"

        val user = User(
            name,
            id,
            email,
            urlFoto
        )

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("usuarios")
        myRef.child(id).setValue(user)

    }


}