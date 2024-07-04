package ir.sajjad.iranitour.interfaces

import ir.sajjad.iranitour.data.ItemPost

interface ItemEvents {
    fun onImageClicked(itemPost: ItemPost)
    fun onItemClicked(itemPost: ItemPost)
    fun onImageLongClicked(itemPost: ItemPost)

}