package ir.sajjad.iranitour.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ItemLandmarkDetails(
    val id :Int? = null,
    val imgUrlLmDetails :String,
    val txtNameLmDetails : String,
    val locLmDetails : String,
    val txtDetailsLmDetails : String,
    val isSaveLmDetails:Boolean
):Parcelable
