package yq;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.transsion.search.bean.GoogleSuggestResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f79170a = new b();

    private b() {
    }

    private final JsonArray a(JsonArray jsonArray, int i11) {
        Object m1185constructorimpl;
        JsonElement c11 = c(jsonArray, i11);
        if (c11 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(c11.getAsJsonArray());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (JsonArray) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    private final List b(JsonArray jsonArray) {
        Object m1185constructorimpl;
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement : jsonArray) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(jsonElement.getAsString());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            String str = (String) m1185constructorimpl;
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final JsonElement c(JsonArray jsonArray, int i11) {
        if (i11 < 0 || i11 >= jsonArray.size()) {
            return null;
        }
        return jsonArray.get(i11);
    }

    private final GoogleSuggestResponse d() {
        return new GoogleSuggestResponse("", CollectionsKt.l());
    }

    private final String f(JsonArray jsonArray, int i11) {
        Object obj;
        JsonElement c11 = c(jsonArray, i11);
        if (c11 == null) {
            return "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m1185constructorimpl(c11.getAsString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (String) (Result.m1191isFailureimpl(obj) ? "" : obj);
    }

    private final String g(String str) {
        String obj = StringsKt.s1(str).toString();
        int i11 = 0;
        if (!StringsKt.W(obj, ")]}'", false, 2, null)) {
            return obj;
        }
        int length = obj.length();
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char charAt = obj.charAt(i11);
            if (charAt == '\n' || charAt == '\r') {
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            a.C0856a.z(lg.a.f68962a, "GoogleSuggestParser", "parse failed: xssi prefix found without line break", false, 4, null);
            return "";
        }
        while (i11 < obj.length() && (obj.charAt(i11) == '\n' || obj.charAt(i11) == '\r')) {
            i11++;
        }
        String substring = obj.substring(i11);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public final GoogleSuggestResponse e(String raw) {
        Object m1185constructorimpl;
        Intrinsics.h(raw, "raw");
        String g11 = g(raw);
        if (StringsKt.q0(g11)) {
            a.C0856a.z(lg.a.f68962a, "GoogleSuggestParser", "parse failed: empty payload after stripping prefix", false, 4, null);
            return d();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(JsonParser.parseString(g11).getAsJsonArray());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.y(lg.a.f68962a, "GoogleSuggestParser", "parse failed: invalid json array", m1188exceptionOrNullimpl, false, 8, null);
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        JsonArray jsonArray = (JsonArray) m1185constructorimpl;
        if (jsonArray == null) {
            return d();
        }
        if (jsonArray.size() <= 1) {
            a.C0856a.z(lg.a.f68962a, "GoogleSuggestParser", "parse failed: unexpected array size=" + jsonArray.size(), false, 4, null);
            return d();
        }
        String f11 = f(jsonArray, 0);
        JsonArray a11 = a(jsonArray, 1);
        List b11 = a11 != null ? b(a11) : null;
        if (b11 == null) {
            b11 = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : b11) {
            if (!StringsKt.q0((String) obj)) {
                arrayList.add(obj);
            }
        }
        return new GoogleSuggestResponse(f11, arrayList);
    }
}
