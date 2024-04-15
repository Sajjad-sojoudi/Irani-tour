package ir.sajjad.iranitour.fragments.navigation.drawer

import android.app.AlertDialog
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sajjad.iranitour.databinding.FragmentSettingBinding
import java.util.Locale


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.changeLang.setOnClickListener{
            showChangeLang()
        }
    }

    private fun showChangeLang() {
        val listItems = arrayOf("فارسی", "English")

        val mBuilder = AlertDialog.Builder(context)
        mBuilder.setTitle("chooseLang")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
            if (which == 0) {
                // تنظیم زبان به فارسی
                setLocale("fa")
            } else if (which == 1) {
                // تنظیم زبان به انگلیسی
                setLocale("en")
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context?.resources?.updateConfiguration(config, context?.resources?.displayMetrics)

        // در اینجا می‌توانید مقدار زبان را در مدل داده ذخیره کنید

        // اعمال تغییرات مربوط به زبان در تمام قسمت‌های برنامه
        // مثلا: تغییر متن‌ها، تصاویر، طرح بندی‌ها و ...
        // باید به صورت دستی تغییرات لازم را اعمال کنید
    }



}