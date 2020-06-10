package kg.azimus.weatherappwithdagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(viewModels: Map<Class<out ViewModel?>, Provider<ViewModel>>) : ViewModelProvider.Factory {
    private var viewModels: Map<Class<out ViewModel>, Provider<ViewModel>>? = viewModels

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProvider: Provider<ViewModel> = viewModels?.get(modelClass)!!
            ?: throw IllegalArgumentException("model class $modelClass not found")

        return viewModelProvider.get() as T
    }
}