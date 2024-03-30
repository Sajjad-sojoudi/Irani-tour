package ir.sajjad.iranitour.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "table_iranlogy")
data class ItemPost(

     val id :Int? = null,
     val imgUrl :String,
     val txtName : String,
     val txtDetails : String
)
