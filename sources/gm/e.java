package gm;

import android.net.Uri;
import com.cloud.tmc.kernel.utils.UrlUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f64003a = new e();

    private e() {
    }

    public final boolean a(String url) {
        Object m1185constructorimpl;
        Intrinsics.h(url, "url");
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri parse = Uri.parse(url);
            String query = parse.getQuery();
            if (query == null) {
                String fragment = parse.getFragment();
                query = null;
                if (fragment != null) {
                    query = StringsKt.b1(fragment, UrlUtils.QUESTION_MARK, null, 2, null);
                }
            }
            String queryParameter = Uri.parse(UrlUtils.QUESTION_MARK + query).getQueryParameter("h5_bar");
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(queryParameter != null ? Boolean.parseBoolean(queryParameter) : false));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            System.out.println((Object) ("Error parsing URL: " + m1188exceptionOrNullimpl.getMessage()));
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }
}
