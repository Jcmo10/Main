package com.jcmo.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
class Animal(var nombre:String?,var num:String?,var foto:Int?,var peso:String?,var edad:String?,var sexo:String?,var padre:String?,var madre:String?): Parcelable

