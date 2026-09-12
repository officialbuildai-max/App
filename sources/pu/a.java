package pu;

import com.transsion.tinker.lib.custom.check.CheckUpdateResponse;
import retrofit2.d;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes7.dex */
public interface a {
    @GET("/{appPath}/app/check-update")
    d<CheckUpdateResponse> a(@Path("appPath") String str, @Query("basePkgMd5") String str2, @Query("channel") String str3);
}
