package itu.master1.projetandroid.authentication.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import itu.master1.projetandroid.authentication.model.Utilisateur;
import itu.master1.projetandroid.global.MyApplication;


public class ConnexionViewModel extends AndroidViewModel {
    private MutableLiveData<Utilisateur> utilisateur = new MutableLiveData<>();
    private MutableLiveData<Boolean> estAuthentifier = new MutableLiveData<>();

    public ConnexionViewModel(@NonNull Application application) {
        super(application);
        utilisateur.setValue(new Utilisateur());
    }

    public LiveData<Utilisateur> getUtilisateur() {
        return this.utilisateur;
    }
    public MutableLiveData<Boolean> getEstAuthentifier() {
        return this.estAuthentifier;
    }

    public void seConnecter() {
        Utilisateur _utilisateur = getUtilisateur().getValue();
        // WEB SERVICE CALL
        if(_utilisateur.seConnecter()) {
            MyApplication app = getApplication();
            app.setToken("Token: 122456");
            app.setaOuvertCeJour(true);

            this.estAuthentifier.setValue(true);
            // WEB SERVICE CALL
            Toast.makeText(getApplication(), "Vous êtes connecter avec succès." + _utilisateur.getNom() + " " + _utilisateur.getMotDePasse(), Toast.LENGTH_SHORT).show();
        }
    }
}
