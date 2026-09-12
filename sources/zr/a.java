package zr;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.core.utils.ToastUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79573a = new a();

    private a() {
    }

    public final Uri a(Uri uri) {
        Object m1185constructorimpl;
        String queryParameter;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            queryParameter = uri.getQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE);
            str = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (queryParameter.length() > 0) {
            return uri.buildUpon().path(queryParameter).build();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("subject", "/movie/detail");
        hashMap.put("post", "/post/detail");
        String uri2 = uri.toString();
        Intrinsics.g(uri2, "toString(...)");
        if (!TextUtils.isEmpty(uri2)) {
            List S0 = StringsKt.S0(uri2, new String[]{"-"}, false, 0, 6, null);
            if (S0.size() >= 2) {
                String str2 = (String) hashMap.get(S0.get(0));
                String str3 = (String) S0.get(1);
                return new Uri.Builder().encodedPath(str2).encodedQuery("id=" + str3).build();
            }
        }
        String path = uri.getPath();
        if (path != null) {
            str = path;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == '/') {
                i11++;
            }
        }
        if (i11 < 2) {
            return null;
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            ToastUtil.f("请升级最新版本");
        }
        return uri;
    }
}
