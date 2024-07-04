package ir.sajjad.iranitour.fragments.details

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.databinding.FragmentDetailsOstanBinding


class DetailsOstanFragment() : BottomSheetDialogFragment() {
    lateinit var binding: FragmentDetailsOstanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val dialog = AlertDialog.Builder(context)
        binding = FragmentDetailsOstanBinding.inflate(layoutInflater,null,false)
        dialog.setView(binding.root)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shimmer = Shimmer.ColorHighlightBuilder()
            .setDuration(1500)
            .setDuration(1500)
            .setBaseAlpha(0.7f)
            .setHighlightAlpha(0.6f)
            .setBaseColor(ContextCompat.getColor(requireContext(), R.color.white)) // رنگ پایه (Base Color)
            .setHighlightColor(ContextCompat.getColor(requireContext(), R.color.shimmer_highlight)) // رنگ نور (Highlight Color)
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()

        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }

        val bundle = arguments
        if (bundle != null) {
            val txtImg = bundle.getString("sendImg")
            Glide
                .with(binding.root)
                .load(txtImg)
                .placeholder(shimmerDrawable)
                .into(binding.imgDetails)

            val txtName = bundle.getString("sendName")
            binding.txtNameDetails.text = txtName

            val txtDetails = bundle.getString("SendDetails")
            binding.txtDetails.text = txtDetails

        }

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        binding.txtDetails.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            dismiss()
        }



    }


}