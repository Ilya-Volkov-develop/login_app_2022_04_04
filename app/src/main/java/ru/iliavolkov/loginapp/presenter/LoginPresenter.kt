package ru.iliavolkov.loginapp.presenter

import android.os.Handler
import android.os.Looper
import ru.iliavolkov.loginapp.model.LoginRequest

class LoginPresenter:LoginContract.RepositoryPresenter {

    lateinit var view: LoginContract.RepositoryView
    override fun onAttach(view: LoginContract.RepositoryView) {
        this.view = view
    }

    override fun onLogin(login: String, password: String) {
        view.showProgress()
        Thread{
            Thread.sleep(1000)
            //И малейшего представлнения не имею как можно обойтись без Handler(Looper.getMainLooper())
            Handler(Looper.getMainLooper()).post{
                view.hideProgress()
                if (LoginRequest().request(login,password)) view.setSuccess()
                else view.setError("Логин и пароль не совпадают")
            }
        }.start()
    }
}