package kg.azimus.weatherappwithdagger.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kg.azimus.weatherappwithdagger.ui.main.MainViewModel


@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun userViewModel(userViewModel: MainViewModel?): ViewModel?

}