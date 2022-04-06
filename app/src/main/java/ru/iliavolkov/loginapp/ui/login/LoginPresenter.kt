package ru.iliavolkov.loginapp.ui.login

import ru.iliavolkov.loginapp.model.LoginUsecase

class LoginPresenter(
    private val loginUsecase: LoginUsecase
) : LoginContract.RepositoryPresenter {
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
        loginUsecase.login(login, password) { result ->
            view.hideProgress()
            isSuccess = if (result) {
                view.setSuccess()
                true
            } else {
                view.setError("Логин и пароль не совпадают")
                false
            }
        }
    }
}