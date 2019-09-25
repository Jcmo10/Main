package com.jcmo.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Trabajador (var nombre:String?,var ocupacion:String?,var foto:Int?): Parcelable

