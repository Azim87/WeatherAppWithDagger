package kg.azimus.weatherappwithdagger.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
     AppModule::class,
     MainViewModelModule::class
])
interface AppComponent