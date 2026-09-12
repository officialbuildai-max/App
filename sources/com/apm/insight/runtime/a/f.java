package com.apm.insight.runtime.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.runtime.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile f f19858a;

    /* renamed from: b, reason: collision with root package name */
    private Context f19859b;

    /* renamed from: c, reason: collision with root package name */
    private Map<CrashType, c> f19860c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private b f19861d;

    /* renamed from: e, reason: collision with root package name */
    private d f19862e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.insight.runtime.a.f$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19863a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f19863a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19863a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19863a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19863a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19863a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19863a[CrashType.CUSTOM_JAVA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19863a[CrashType.BLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19863a[CrashType.ENSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private f(@NonNull Context context) {
        this.f19859b = context;
        try {
            this.f19861d = b.d();
            this.f19862e = new d(this.f19859b);
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
        }
    }

    @Nullable
    private c a(CrashType crashType) {
        c cVar = this.f19860c.get(crashType);
        if (cVar != null) {
            return cVar;
        }
        switch (AnonymousClass1.f19863a[crashType.ordinal()]) {
            case 1:
                cVar = new j(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 2:
                cVar = new k(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 3:
                cVar = new l(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 4:
                cVar = new a(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 5:
                cVar = new h(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 6:
                cVar = new g(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 7:
                cVar = new e(this.f19859b, this.f19861d, this.f19862e);
                break;
            case 8:
                cVar = new i(this.f19859b, this.f19861d, this.f19862e);
                break;
        }
        if (cVar != null) {
            this.f19860c.put(crashType, cVar);
        }
        return cVar;
    }

    public static f a() {
        if (f19858a == null) {
            Context g11 = com.apm.insight.e.g();
            if (g11 == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            f19858a = new f(g11);
        }
        return f19858a;
    }

    public final com.apm.insight.entity.a a(CrashType crashType, com.apm.insight.entity.a aVar) {
        c a11;
        return (crashType == null || (a11 = a(crashType)) == null) ? aVar : a11.a(aVar, null, false);
    }

    public final com.apm.insight.entity.a a(CrashType crashType, @Nullable c.a aVar) {
        c a11;
        if (crashType == null || (a11 = a(crashType)) == null) {
            return null;
        }
        return a11.a(null, aVar, true);
    }

    public final com.apm.insight.entity.a a(List<com.apm.insight.entity.a> list, JSONArray jSONArray) {
        if (list.isEmpty()) {
            return null;
        }
        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<com.apm.insight.entity.a> it = list.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next().c());
        }
        aVar.a("data", (Object) jSONArray2);
        aVar.a("all_data", (Object) jSONArray);
        Header a11 = Header.a(this.f19859b);
        Header.a(a11);
        a11.c();
        a11.d();
        a11.e();
        Header.b(a11);
        aVar.a(a11);
        return aVar;
    }
}
