package ru.iliavolkov.loginapp.ui.login

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.iliavolkov.loginapp.app
import ru.iliavolkov.loginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.RepositoryView {

    private lateinit var presenter: LoginContract.RepositoryPresenter
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = restorePresenter()
        presenter.onAttach(this)
        initButton()
    }

    private fun initButton() {
        with(binding) {
            btnLogin.setOnClickListener {
                presenter.onLogin(
                    userLogin.text.toString(),
                    userPassword.text.toString()
                )
            }
            btnRegister.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Заглушка", Toast.LENGTH_SHORT).show()
            }
            forgotPassword.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Заглушка", Toast.LENGTH_SHORT).show()
            }
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
        return presenter ?: LoginPresenter(app.loginUsecase)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }
}