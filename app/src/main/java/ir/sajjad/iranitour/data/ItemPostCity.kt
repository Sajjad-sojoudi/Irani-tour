package ir.sajjad.iranitour.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPostCity(
    val idCity: Int? = null,
    val txtCity: String,
    val imgCity: String,
    val txtCityDetails: String,
    val isSave: Boolean,

) : Parcelable
