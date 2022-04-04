package ru.iliavolkov.loginapp.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ru.iliavolkov.loginapp.R
import ru.iliavolkov.loginapp.databinding.FragmentLoginBinding
import ru.iliavolkov.loginapp.presenter.LoginContract
import ru.iliavolkov.loginapp.presenter.LoginPresenter

class MainActivity : AppCompatActivity(),LoginContract.RepositoryView {
    lateinit var presenter: LoginContract.RepositoryPresenter
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = restorePresenter()
        presenter.onAttach(this)
        binding.btnLogin.setOnClickListener {
            presenter.onLogin(binding.userLogin.text.toString(),binding.userPassword.text.toString())
        }
        binding.btnRegister.setOnClickListener {
            Toast.makeText(this,"Заглушка", Toast.LENGTH_SHORT).show()
        }
        binding.forgotPassword.setOnClickListener {
            Toast.makeText(this,"Заглушка", Toast.LENGTH_SHORT).show()
        }

    }
    override fun setSuccess() {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.GREEN)
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
    }

    override fun setError(error: String) {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.RED)
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        binding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.loadingLayout.visibility = View.GONE
    }
    private fun restorePresenter(): LoginContract.RepositoryPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }
}