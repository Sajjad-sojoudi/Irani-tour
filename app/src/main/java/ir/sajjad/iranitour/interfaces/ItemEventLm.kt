package ir.sajjad.iranitour.interfaces

import ir.sajjad.iranitour.data.ItemPostLandMark

interface ItemEventLm {
    fun onItemLmClicked(itemPostLandMark: ItemPostLandMark)
    fun onImageLmLongClicked(itemPostLandMark: ItemPostLandMark)

}