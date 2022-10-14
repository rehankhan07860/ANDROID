package com.example.loginpageapi;

import java.net.URI;

public class RetrofitClient {

    private static Retrofit retrofit;
    private  static String Base_URL = "https://reqres.in/";
    public  static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            URI GsonConverterFact;
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
}
