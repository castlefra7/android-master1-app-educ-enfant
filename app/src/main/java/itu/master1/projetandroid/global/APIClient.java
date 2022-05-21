package itu.master1.projetandroid.global;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + MyApplication.TOKEN)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)

                .build();

        return retrofit;
    }
}
