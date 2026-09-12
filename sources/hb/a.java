package hb;

import android.text.TextUtils;
import com.google.firebase.abt.AbtException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kb.a;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f64535g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: h, reason: collision with root package name */
    static final DateFormat f64536h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: a, reason: collision with root package name */
    private final String f64537a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64538b;

    /* renamed from: c, reason: collision with root package name */
    private final String f64539c;

    /* renamed from: d, reason: collision with root package name */
    private final Date f64540d;

    /* renamed from: e, reason: collision with root package name */
    private final long f64541e;

    /* renamed from: f, reason: collision with root package name */
    private final long f64542f;

    public a(String str, String str2, String str3, Date date, long j11, long j12) {
        this.f64537a = str;
        this.f64538b = str2;
        this.f64539c = str3;
        this.f64540d = date;
        this.f64541e = j11;
        this.f64542f = j12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(a.c cVar) {
        String str = cVar.f66864d;
        if (str == null) {
            str = "";
        }
        return new a(cVar.f66862b, String.valueOf(cVar.f66863c), str, new Date(cVar.f66873m), cVar.f66865e, cVar.f66870j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Map map) {
        g(map);
        try {
            return new a((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey("triggerEvent") ? (String) map.get("triggerEvent") : "", f64536h.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
        } catch (NumberFormatException e11) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e11);
        } catch (ParseException e12) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e12);
        }
    }

    private static void g(Map map) {
        ArrayList arrayList = new ArrayList();
        for (String str : f64535g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f64537a;
    }

    long d() {
        return this.f64540d.getTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f64538b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a.c f(String str) {
        a.c cVar = new a.c();
        cVar.f66861a = str;
        cVar.f66873m = d();
        cVar.f66862b = this.f64537a;
        cVar.f66863c = this.f64538b;
        cVar.f66864d = TextUtils.isEmpty(this.f64539c) ? null : this.f64539c;
        cVar.f66865e = this.f64541e;
        cVar.f66870j = this.f64542f;
        return cVar;
    }
}
