package itu.master1.projetandroid.authentification.model;

import com.google.gson.annotations.SerializedName;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Utilisateur extends BaseModel{
    @SerializedName("login")
    private String nom;
    @SerializedName("motDePasse")
    private String motDePasse;

    private boolean aOuvertCeJour;

    public Utilisateur() {
        setNom("rasoa");
        setMotDePasse("123456");
    }

    public Utilisateur(String _name, String _password) {
        this.setNom(_name);
        this.setMotDePasse(_password);
    }

    public boolean isaOuvertCeJour() {
        return aOuvertCeJour;
    }

    public void setaOuvertCeJour(boolean aOuvertCeJour) {
        this.aOuvertCeJour = aOuvertCeJour;
    }

    public boolean seConnecter() {
        boolean result = false;
        /*OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.2.251/")
                .client(client)
                .build();
        SmmecService service = retrofit.create(SmmecService.class);
        Call<ResponseBody> infoUtilisateur = service.seConnecter(this);

        infoUtilisateur.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody result = response.body();
                System.out.println(result.getStatus());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });*/
        if(getNom().equals("rasoa") && getMotDePasse().equals(("123456"))) {
            result = true;
        }
        return result;
    }

    public void seDeconnecter() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
