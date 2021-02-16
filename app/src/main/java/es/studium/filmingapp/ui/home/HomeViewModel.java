package es.studium.filmingapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import es.studium.filmingapp.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("En esta app, vamos a hablar sobre la sinopsis, el reparto y los directores de las mejores películas y series del momento");
    }

    public LiveData<String> getText() {
        return mText;
    }
}