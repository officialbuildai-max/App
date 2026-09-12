package az;

import be.g;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.net.bean.BaseDto;
import com.transsnet.login.bean.LoginThirdUserInfo;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u000b\u0010\tJ/\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\f\u0010\tJ/\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\rH'¢\u0006\u0004\b\u0011\u0010\u0010J/\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\rH'¢\u0006\u0004\b\u0012\u0010\u0010J/\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\rH'¢\u0006\u0004\b\u0016\u0010\u0010J/\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00070\u00062\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Laz/a;", "", "", "host", "Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;", TtmlNode.TAG_BODY, "Lio/reactivex/rxjava3/core/j;", "Lcom/tn/lib/net/bean/BaseDto;", "d", "(Ljava/lang/String;Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;)Lio/reactivex/rxjava3/core/j;", "Lcom/transsnet/loginapi/bean/UserInfo;", "i", g.f16474b, "Lokhttp3/RequestBody;", "Lcom/transsnet/login/phone/bean/LoginCheckPhoneExistResult;", CampaignEx.JSON_KEY_AD_K, "(Ljava/lang/String;Lokhttp3/RequestBody;)Lio/reactivex/rxjava3/core/j;", j.f35620b, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "userId", "e", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/j;", "h", "a", "(Lokhttp3/RequestBody;Ljava/lang/String;)Lio/reactivex/rxjava3/core/j;", "f", "(Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;Ljava/lang/String;)Lio/reactivex/rxjava3/core/j;", "Lcom/transsnet/login/bean/LoginThirdUserInfo;", "c", "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: az.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0148a {
        public static /* synthetic */ io.reactivex.rxjava3.core.j a(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkEmail");
            }
            if ((i11 & 2) != 0) {
                str = vg.a.f77447a.a();
            }
            return aVar.a(requestBody, str);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j b(a aVar, LoginSmsCodeRequest loginSmsCodeRequest, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkEmailCode");
            }
            if ((i11 & 2) != 0) {
                str = vg.a.f77447a.a();
            }
            return aVar.f(loginSmsCodeRequest, str);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j c(a aVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = vg.a.f77447a.a();
            }
            return aVar.e(str, str2);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j d(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: thirdLogin");
            }
            if ((i11 & 2) != 0) {
                str = vg.a.f77447a.a();
            }
            return aVar.c(requestBody, str);
        }
    }

    @POST("/wefeed-mobile-bff/user-api/check-mail-account")
    io.reactivex.rxjava3.core.j<BaseDto<LoginCheckPhoneExistResult>> a(@Body RequestBody body, @Query("host") String host);

    @POST("/wefeed-mobile-bff/user-api/register")
    io.reactivex.rxjava3.core.j<BaseDto<UserInfo>> b(@Query("host") String host, @Body RequestBody body);

    @POST("/wefeed-mobile-bff/user-api/third-login")
    io.reactivex.rxjava3.core.j<BaseDto<LoginThirdUserInfo>> c(@Body RequestBody body, @Query("host") String host);

    @POST("/wefeed-mobile-bff/user-api/get-sms-code")
    io.reactivex.rxjava3.core.j<BaseDto<String>> d(@Query("host") String host, @Body LoginSmsCodeRequest body);

    @GET("/wefeed-mobile-bff/user-api/info")
    io.reactivex.rxjava3.core.j<BaseDto<UserInfo>> e(@Query("userId") String userId, @Query("host") String host);

    @POST("/wefeed-mobile-bff/user-api/check-sms-code")
    io.reactivex.rxjava3.core.j<BaseDto<String>> f(@Body LoginSmsCodeRequest body, @Query("host") String host);

    @POST("/wefeed-mobile-bff/user-api/check-sms-code")
    io.reactivex.rxjava3.core.j<BaseDto<String>> g(@Query("host") String host, @Body LoginSmsCodeRequest body);

    @POST("/wefeed-mobile-bff/user-api/logout")
    io.reactivex.rxjava3.core.j<BaseDto<UserInfo>> h(@Query("host") String host, @Body RequestBody body);

    @POST("/wefeed-mobile-bff/user-api/login")
    io.reactivex.rxjava3.core.j<BaseDto<UserInfo>> i(@Query("host") String host, @Body LoginSmsCodeRequest body);

    @POST("/wefeed-mobile-bff/user-api/reset-password")
    io.reactivex.rxjava3.core.j<BaseDto<UserInfo>> j(@Query("host") String host, @Body RequestBody body);

    @POST("/wefeed-mobile-bff/user-api/check-phone-account")
    io.reactivex.rxjava3.core.j<BaseDto<LoginCheckPhoneExistResult>> k(@Query("host") String host, @Body RequestBody body);
}
