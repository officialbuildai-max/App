package wg;

import android.net.ParseException;
import android.text.TextUtils;
import android.util.MalformedJsonException;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonParseException;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.exception.ApiException;
import com.tn.lib.net.exception.ServerException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import org.json.JSONException;
import retrofit2.HttpException;
import retrofit2.j0;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0985a f77794a = new C0985a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f77795b = 1000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f77796c = 110004;

    /* renamed from: d, reason: collision with root package name */
    private static final int f77797d = 9003;

    /* renamed from: e, reason: collision with root package name */
    private static final int f77798e = 1102;

    /* renamed from: f, reason: collision with root package name */
    private static final int f77799f = 11000;

    /* renamed from: g, reason: collision with root package name */
    private static final int f77800g = 11001;

    /* renamed from: h, reason: collision with root package name */
    private static final int f77801h = 1032;

    /* renamed from: i, reason: collision with root package name */
    private static final int f77802i = TAdErrorCode.CODE_CURRENT_OBJECT_IS_DESTROYED;

    /* renamed from: wg.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0985a {
        private C0985a() {
        }

        public /* synthetic */ C0985a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ApiException a(Throwable th2) {
            ApiException apiException;
            ResponseBody d11;
            if (th2 instanceof HttpException) {
                HttpException httpException = (HttpException) th2;
                j0<?> response = httpException.response();
                BaseDto baseDto = (BaseDto) o.d((response == null || (d11 = response.d()) == null) ? null : d11.string(), BaseDto.class);
                if (baseDto == null) {
                    return new ApiException(th2, String.valueOf(httpException.code()), httpException.message());
                }
                if (TextUtils.isEmpty(baseDto.getMsg())) {
                    baseDto.setMsg("Oops，something went wrong");
                }
                return new ApiException(th2, String.valueOf(httpException.code()), baseDto.getMsg());
            }
            if (th2 instanceof ServerException) {
                ServerException serverException = (ServerException) th2;
                return new ApiException(th2, serverException.getErrCode(), serverException.getErrMsg());
            }
            if ((th2 instanceof JsonParseException) || (th2 instanceof JSONException) || (th2 instanceof ParseException) || (th2 instanceof MalformedJsonException)) {
                apiException = new ApiException(th2, String.valueOf(a.f77799f), "Oops，something went wrong");
            } else if (th2 instanceof ConnectException) {
                apiException = new ApiException(th2, String.valueOf(a.f77797d), "Oops，something went wrong");
            } else if (th2 instanceof SocketTimeoutException) {
                apiException = new ApiException(th2, String.valueOf(a.f77802i), "Oops，something went wrong");
            } else if (th2 instanceof UnknownHostException) {
                apiException = new ApiException(th2, String.valueOf(a.f77797d), "Oops，something went wrong");
            } else {
                if (th2 == null) {
                    throw new RuntimeException("未知异常");
                }
                apiException = new ApiException(th2, String.valueOf(a.f77795b), "Oops，something went wrong");
            }
            return apiException;
        }
    }
}
