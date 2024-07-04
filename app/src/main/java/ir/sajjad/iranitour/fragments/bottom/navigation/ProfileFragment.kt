package ir.sajjad.iranitour.fragments.bottom.navigation

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AlertDialogLayout
import androidx.core.view.isEmpty
import androidx.room.Room
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.activity.MainActivity
import ir.sajjad.iranitour.databinding.DialogEditProfileBinding
import ir.sajjad.iranitour.databinding.FragmentProfileBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPreferencesFileName = "data"
        val sharedPreferences =
            requireActivity().getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name", "")
        val username = sharedPreferences.getString("username", "")
        val gmail = sharedPreferences.getString("gmail", "")
        val password = sharedPreferences.getString("password", "")

        binding.txtTitleName.text = name
        binding.txtFullName.text = name
        binding.txtUserName.text = username
        binding.txtGmail.text = gmail
        binding.txtPassword.text = password

        binding.btnEditData.setOnClickListener {
            showEditDialog()
        }

    }

    fun showEditDialog(){
        val dialogEditProf =DialogEditProfileBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(context)
            .setView(dialogEditProf.root)
            .setCancelable(true)
            .create()

        dialogEditProf.edtFullNameEdit.editText!!.setText(binding.txtFullName.text)
        dialogEditProf.edtUserEdit.editText!!.setText(binding.txtUserName.text)
        dialogEditProf.edtGmailEdit.editText!!.setText(binding.txtGmail.text)
        dialogEditProf.edtPasswordEdit.editText!!.setText(binding.txtPassword.text)

        dialogEditProf.btnEditDialog.setOnClickListener {

            if (
                dialogEditProf.edtFullNameEdit.isEmpty()||
                dialogEditProf.edtUserEdit.isEmpty()||
                dialogEditProf.edtGmailEdit.isEmpty()||
                dialogEditProf.edtPasswordEdit.isEmpty()){

                Toast.makeText(context, resources.getString(R.string.fill_value), Toast.LENGTH_SHORT).show()

            }
            else {
                val sharedPreferencesFileName = "data"
                val sharedPreferences = requireActivity().getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
                sharedPreferences.edit().putString("name",dialogEditProf.edtFullNameEdit.editText!!.text.toString()).apply()
                sharedPreferences.edit().putString("username",dialogEditProf.edtUserEdit.editText!!.text.toString()).apply()
                sharedPreferences.edit().putString("gmail",dialogEditProf.edtGmailEdit.editText!!.text.toString()).apply()
                sharedPreferences.edit().putString("password",dialogEditProf.edtPasswordEdit.editText!!.text.toString()).apply()

                binding.txtTitleName.text = dialogEditProf.edtFullNameEdit.editText!!.text.toString()
                binding.txtFullName.text = dialogEditProf.edtFullNameEdit.editText!!.text.toString()
                binding.txtUserName.text = dialogEditProf.edtUserEdit.editText!!.text.toString()
                binding.txtGmail.text = dialogEditProf.edtGmailEdit.editText!!.text.toString()
                binding.txtPassword.text = dialogEditProf.edtPasswordEdit.editText!!.text.toString()

                dialog.dismiss()
                Toast.makeText(context, resources.getString(R.string.edit_data), Toast.LENGTH_SHORT).show()
            }

        }

        dialogEditProf.btnCancelDialog.setOnClickListener {
            dialog.dismiss()
        }
            dialog.show()

    }


}