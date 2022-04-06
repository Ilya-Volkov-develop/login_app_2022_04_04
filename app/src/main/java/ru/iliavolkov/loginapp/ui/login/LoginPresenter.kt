package ru.iliavolkov.loginapp.ui.login

import android.os.Handler
import android.os.Looper

class LoginPresenter : LoginContract.RepositoryPresenter {
    private var isSuccess: Boolean = false
    lateinit var view: LoginContract.RepositoryView

    override fun onAttach(view: LoginContract.RepositoryView) {
        this.view = view
        if (isSuccess) {
            view.setSuccess()
        } else {
            view.setError("Логин и пароль не совпадают")
        }
    }

    override fun onLogin(login: String, password: String) {
        view.showProgress()
        Thread {
            Thread.sleep(1000)
            //И малейшего представлнения не имею как можно обойтись без Handler(Looper.getMainLooper())
            Handler(Looper.getMainLooper()).post {
                view.hideProgress()
                isSuccess = if (true) {
                    view.setSuccess()
                    true
                } else {
                    view.setError("Логин и пароль не совпадают")
                    false
                }
            }
        }.start()
    }
}