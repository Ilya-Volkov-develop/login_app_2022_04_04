package ru.iliavolkov.loginapp.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.iliavolkov.loginapp.databinding.FragmentLoginBinding
import ru.iliavolkov.loginapp.presenter.LoginContract
import ru.iliavolkov.loginapp.presenter.LoginPresenter

class LoginFragment : Fragment(),LoginContract.RepositoryView {


    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    lateinit var presenter: LoginContract.RepositoryPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        binding.btnLogin.setOnClickListener {
            presenter.onLogin(binding.userLogin.text.toString(),binding.userPassword.text.toString())
        }
        binding.btnRegister.setOnClickListener {
            Toast.makeText(requireContext(),"Заглушка",Toast.LENGTH_SHORT).show()
        }
        binding.forgotPassword.setOnClickListener {
            Toast.makeText(requireContext(),"Заглушка",Toast.LENGTH_SHORT).show()
        }
    }

    override fun setSuccess() {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.GREEN)
        Toast.makeText(requireContext(),"Success",Toast.LENGTH_SHORT).show()
    }

    override fun setError(error: String) {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.RED)
        Toast.makeText(requireContext(),error,Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        binding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.loadingLayout.visibility = View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance(presenter: LoginContract.RepositoryPresenter) = LoginFragment().apply {
            this.presenter = presenter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}