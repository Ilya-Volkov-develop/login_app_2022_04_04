package ru.iliavolkov.loginapp.ui.login

class LoginContract {

    interface RepositoryPresenter {
        fun onAttach(view: RepositoryView)
        fun onLogin(login: String, password: String)
    }

    interface RepositoryView {
        fun setSuccess()
        fun setError(error: String)
        fun showProgress()
        fun hideProgress()
    }

}