package ir.sajjad.iranitour.interfaces

import ir.sajjad.iranitour.data.ItemPostCity

interface ItemCityEvent {
    fun onItemClicked(itemPostCity: ItemPostCity)
    fun onImageLongCLiked(itemPostCity: ItemPostCity)
}