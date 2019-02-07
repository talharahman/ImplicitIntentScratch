package org.pursuit.implicitintentsfromscratch.network;

import org.pursuit.implicitintentsfromscratch.model.ZodiacList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {

    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacList> getZodiac();
}
