package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public class z {

    /* renamed from: g, reason: collision with root package name */
    private static final Map f31340g;

    /* renamed from: h, reason: collision with root package name */
    static final String f31341h;

    /* renamed from: a, reason: collision with root package name */
    private final Context f31342a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f31343b;

    /* renamed from: c, reason: collision with root package name */
    private final a f31344c;

    /* renamed from: d, reason: collision with root package name */
    private final xb.d f31345d;

    /* renamed from: e, reason: collision with root package name */
    private final wb.b f31346e;

    /* renamed from: f, reason: collision with root package name */
    private final ob.j f31347f = ob.j.f71081a;

    static {
        HashMap hashMap = new HashMap();
        f31340g = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
        f31341h = String.format(Locale.US, "Crashlytics Android SDK/%s", "19.3.0");
    }

    public z(Context context, g0 g0Var, a aVar, xb.d dVar, wb.b bVar) {
        this.f31342a = context;
        this.f31343b = g0Var;
        this.f31344c = aVar;
        this.f31345d = dVar;
        this.f31346e = bVar;
    }

    private CrashlyticsReport.e.d.a.c A(CrashlyticsReport.a aVar) {
        return this.f31347f.a(aVar.e(), aVar.d(), aVar.c());
    }

    private CrashlyticsReport.a a(CrashlyticsReport.a aVar) {
        List list;
        if (!this.f31346e.b().f31792b.f31801c || this.f31344c.f31193c.size() <= 0) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f31344c.f31193c) {
                arrayList.add(CrashlyticsReport.a.AbstractC0421a.a().d(eVar.c()).b(eVar.a()).c(eVar.b()).a());
            }
            list = Collections.unmodifiableList(arrayList);
        }
        return CrashlyticsReport.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(list).a();
    }

    private CrashlyticsReport.b b() {
        return CrashlyticsReport.b().l("19.3.0").h(this.f31344c.f31191a).i(this.f31343b.a().c()).g(this.f31343b.a().e()).f(this.f31343b.a().d()).d(this.f31344c.f31196f).e(this.f31344c.f31197g).k(4);
    }

    private static long f(long j11) {
        if (j11 > 0) {
            return j11;
        }
        return 0L;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f31340g.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private CrashlyticsReport.e.d.a.b.AbstractC0425a h() {
        return CrashlyticsReport.e.d.a.b.AbstractC0425a.a().b(0L).d(0L).c(this.f31344c.f31195e).e(this.f31344c.f31192b).a();
    }

    private List i() {
        return Collections.singletonList(h());
    }

    private CrashlyticsReport.e.d.a j(int i11, CrashlyticsReport.a aVar) {
        return CrashlyticsReport.e.d.a.a().c(Boolean.valueOf(aVar.c() != 100)).d(A(aVar)).h(i11).f(o(aVar)).a();
    }

    private CrashlyticsReport.e.d.a k(int i11, xb.e eVar, Thread thread, int i12, int i13, boolean z10) {
        Boolean bool;
        CrashlyticsReport.e.d.a.c e11 = this.f31347f.e(this.f31342a);
        if (e11.b() > 0) {
            bool = Boolean.valueOf(e11.b() != 100);
        } else {
            bool = null;
        }
        return CrashlyticsReport.e.d.a.a().c(bool).d(e11).b(this.f31347f.d(this.f31342a)).h(i11).f(p(eVar, thread, i12, i13, z10)).a();
    }

    private CrashlyticsReport.e.d.c l(int i11) {
        d a11 = d.a(this.f31342a);
        Float b11 = a11.b();
        Double valueOf = b11 != null ? Double.valueOf(b11.doubleValue()) : null;
        int c11 = a11.c();
        boolean n11 = CommonUtils.n(this.f31342a);
        return CrashlyticsReport.e.d.c.a().b(valueOf).c(c11).f(n11).e(i11).g(f(CommonUtils.b(this.f31342a) - CommonUtils.a(this.f31342a))).d(CommonUtils.c(Environment.getDataDirectory().getPath())).a();
    }

    private CrashlyticsReport.e.d.a.b.c m(xb.e eVar, int i11, int i12) {
        return n(eVar, i11, i12, 0);
    }

    private CrashlyticsReport.e.d.a.b.c n(xb.e eVar, int i11, int i12, int i13) {
        String str = eVar.f78309b;
        String str2 = eVar.f78308a;
        StackTraceElement[] stackTraceElementArr = eVar.f78310c;
        int i14 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        xb.e eVar2 = eVar.f78311d;
        if (i13 >= i12) {
            xb.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f78311d;
                i14++;
            }
        }
        CrashlyticsReport.e.d.a.b.c.AbstractC0428a d11 = CrashlyticsReport.e.d.a.b.c.a().f(str).e(str2).c(r(stackTraceElementArr, i11)).d(i14);
        if (eVar2 != null && i14 == 0) {
            d11.b(n(eVar2, i11, i12, i13 + 1));
        }
        return d11.a();
    }

    private CrashlyticsReport.e.d.a.b o(CrashlyticsReport.a aVar) {
        return CrashlyticsReport.e.d.a.b.a().b(aVar).e(w()).c(i()).a();
    }

    private CrashlyticsReport.e.d.a.b p(xb.e eVar, Thread thread, int i11, int i12, boolean z10) {
        return CrashlyticsReport.e.d.a.b.a().f(z(eVar, thread, i11, z10)).d(m(eVar, i11, i12)).e(w()).c(i()).a();
    }

    private CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b q(StackTraceElement stackTraceElement, CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a abstractC0434a) {
        long j11 = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j11 = stackTraceElement.getLineNumber();
        }
        return abstractC0434a.e(max).f(str).b(fileName).d(j11).a();
    }

    private List r(StackTraceElement[] stackTraceElementArr, int i11) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(q(stackTraceElement, CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.a().c(i11)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CrashlyticsReport.e.a s() {
        return CrashlyticsReport.e.a.a().e(this.f31343b.f()).g(this.f31344c.f31196f).d(this.f31344c.f31197g).f(this.f31343b.a().c()).b(this.f31344c.f31198h.d()).c(this.f31344c.f31198h.e()).a();
    }

    private CrashlyticsReport.e t(String str, long j11) {
        return CrashlyticsReport.e.a().m(j11).j(str).h(f31341h).b(s()).l(v()).e(u()).i(3).a();
    }

    private CrashlyticsReport.e.c u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int g11 = g();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b11 = CommonUtils.b(this.f31342a);
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean w11 = CommonUtils.w();
        int l11 = CommonUtils.l();
        return CrashlyticsReport.e.c.a().b(g11).f(Build.MODEL).c(availableProcessors).h(b11).d(blockCount).i(w11).j(l11).e(Build.MANUFACTURER).g(Build.PRODUCT).a();
    }

    private CrashlyticsReport.e.AbstractC0438e v() {
        return CrashlyticsReport.e.AbstractC0438e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.x()).a();
    }

    private CrashlyticsReport.e.d.a.b.AbstractC0429d w() {
        return CrashlyticsReport.e.d.a.b.AbstractC0429d.a().d("0").c("0").b(0L).a();
    }

    private CrashlyticsReport.e.d.a.b.AbstractC0431e x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.e.d.a.b.AbstractC0431e y(Thread thread, StackTraceElement[] stackTraceElementArr, int i11) {
        return CrashlyticsReport.e.d.a.b.AbstractC0431e.a().d(thread.getName()).c(i11).b(r(stackTraceElementArr, i11)).a();
    }

    private List z(xb.e eVar, Thread thread, int i11, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, eVar.f78310c, i11));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(x(key, this.f31345d.a(entry.getValue())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public CrashlyticsReport.e.d c(CrashlyticsReport.a aVar) {
        int i11 = this.f31342a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.e.d.a().g("anr").f(aVar.i()).b(j(i11, a(aVar))).c(l(i11)).a();
    }

    public CrashlyticsReport.e.d d(Throwable th2, Thread thread, String str, long j11, int i11, int i12, boolean z10) {
        int i13 = this.f31342a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.e.d.a().g(str).f(j11).b(k(i13, xb.e.a(th2, this.f31345d), thread, i11, i12, z10)).c(l(i13)).a();
    }

    public CrashlyticsReport e(String str, long j11) {
        return b().m(t(str, j11)).a();
    }
}
