package itu.master1.projetandroid.authentication.model;

import com.google.gson.annotations.SerializedName;
/**
 * which allows users to be controlled
 *
 */
public final class Utilisateur extends BaseModel{
    @SerializedName("login")
    private String nom;
    @SerializedName("motDePasse")
    private String motDePasse;

    private boolean aOuvertCeJour;
    /**
     * Constructor set name and passowrd deflaut
     *
     */
    public Utilisateur() {
        setNom("rasoa");
        setMotDePasse("123456");
    }

    /**
     * Constructor set name and passowrd with
     * @param _name username
     * @param _password password
     */
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
    /**
     * check the user, if there is in the database
     * @return boolean
     */
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

    /**
     * get the name of user
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * set the name of user
     * @param nom username
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * get the password of user
     * @return String
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * set the password of user
     * @param motDePasse password of user
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
