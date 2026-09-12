package rb;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final bc.a f74400a = new dc.d().j(a.f74354a).i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static i b(String str, String str2, String str3, String str4, long j11) {
        return new b(str, str2, i(str3), str4, j11);
    }

    private static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public CrashlyticsReport.e.d.AbstractC0437e h() {
        return CrashlyticsReport.e.d.AbstractC0437e.a().d(CrashlyticsReport.e.d.AbstractC0437e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
