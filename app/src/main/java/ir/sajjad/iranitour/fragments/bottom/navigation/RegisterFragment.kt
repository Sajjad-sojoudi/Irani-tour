package ir.sajjad.iranitour.fragments.bottom.navigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import ir.sajjad.iranitour.R
import ir.sajjad.iranitour.activity.isRegistered
import ir.sajjad.iranitour.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        binding.edtPassword.editText!!.addTextChangedListener {
            if (it!!.length < 8) {
                binding.edtPassword.error = resources.getString(R.string.error_8_password)
            } else {
                binding.edtPassword.error = null
            }
        }

        binding.edtRePassword.editText!!.addTextChangedListener {
            if (it!!.length < 8) {
                binding.edtRePassword.error = resources.getString(R.string.error_8_password)
            } else {
                binding.edtRePassword.error = null
            }
        }


        val sharedPreferencesFileName = "data"
        val sharedPreferences = requireActivity().getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)

        binding.btnSignUp.setOnClickListener {
            if (binding.edtFullName.editText!!.text.isEmpty() ||
                binding.edtUserName.editText!!.text.isEmpty() ||
                binding.edtGmail.editText!!.text.isEmpty() ||
                binding.edtPassword.editText!!.text.isEmpty() ||
                binding.edtRePassword.editText!!.text.isEmpty()&&
                binding.edtPassword.editText != binding.edtRePassword.editText

            ){
                binding.edtRePassword.error = resources.getString(R.string.password_not_match)
                binding.edtPassword.error = resources.getString(R.string.enter_password)
                Toast.makeText(context, resources.getString(R.string.fill_value), Toast.LENGTH_SHORT).show()

            }else {

                val name = binding.edtFullName.editText!!.text.toString()
                sharedPreferences.edit().putString("name", name).apply()

                val username = binding.edtUserName.editText!!.text.toString()
                sharedPreferences.edit().putString("username", username).apply()

                val gmail = binding.edtGmail.editText!!.text.toString()
                sharedPreferences.edit().putString("gmail", gmail).apply()

                val password = binding.edtPassword.editText!!.text.toString()
                sharedPreferences.edit().putString("password", password).apply()

                findNavController().navigate(R.id.profileFragment)

                isRegistered = true
            }
        }



    }


}