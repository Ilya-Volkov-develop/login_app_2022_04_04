package ru.iliavolkov.loginapp.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.iliavolkov.loginapp.databinding.ActivityLoginBinding
import ru.iliavolkov.loginapp.presenter.LoginContract
import ru.iliavolkov.loginapp.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.RepositoryView {
    private lateinit var presenter: LoginContract.RepositoryPresenter
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = restorePresenter()
        presenter.onAttach(this)
        binding.btnLogin.setOnClickListener {
            presenter.onLogin(
                binding.userLogin.text.toString(),
                binding.userPassword.text.toString()
            )
        }
        binding.btnRegister.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_SHORT).show()
        }
        binding.forgotPassword.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_SHORT).show()
        }

    }

    override fun setSuccess() {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.GREEN)
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun setError(error: String) {
        hideProgress()
        binding.userLoginText.setBackgroundColor(Color.RED)
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        binding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.loadingLayout.visibility = View.GONE
    }

    @Suppress("DEPRECATION")
    private fun restorePresenter(): LoginContract.RepositoryPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }
}