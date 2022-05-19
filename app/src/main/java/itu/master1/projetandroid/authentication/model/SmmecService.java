package itu.master1.projetandroid.authentication.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SmmecService {
    @POST("api/user/login")
    Call<ResponseBody> seConnecter(@Body Utilisateur utilisareur);

}
