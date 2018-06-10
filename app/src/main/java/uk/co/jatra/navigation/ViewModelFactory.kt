package uk.co.jatra.navigation

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ViewModelFactory(context: Application) : ViewModelProvider.AndroidViewModelFactory(context) {
    private val viewModel = AppViewModel()

    companion object {
        private var instance: ViewModelFactory? = null
        fun instance(application: Application) :ViewModelFactory? {
            if (instance == null) {
                instance = ViewModelFactory(application)
            }
            return instance
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  viewModel as T
    }
}