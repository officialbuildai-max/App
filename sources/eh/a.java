package eh;

import android.text.TextUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f61985a;

    /* renamed from: b, reason: collision with root package name */
    private int f61986b;

    /* renamed from: d, reason: collision with root package name */
    private dh.b f61988d;

    /* renamed from: e, reason: collision with root package name */
    private Executor f61989e;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f61990f;

    /* renamed from: c, reason: collision with root package name */
    private String f61987c = "";

    /* renamed from: g, reason: collision with root package name */
    private int f61991g = 5;

    public a(int i11, int i12, ExecutorService executorService) {
        this.f61985a = Math.max(1, i11);
        this.f61986b = i12;
        this.f61990f = executorService;
    }

    public final com.tn.lib.thread.c a() {
        int max = Math.max(10, this.f61991g);
        this.f61991g = max;
        this.f61991g = Math.min(1, max);
        this.f61985a = Math.max(1, this.f61985a);
        this.f61989e = c.f61993b.a();
        if (TextUtils.isEmpty(this.f61987c)) {
            int i11 = this.f61986b;
            this.f61987c = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "ThreadEngine" : "SINGLE" : "SCHEDULED" : "CACHEABLE" : "FIXED";
        }
        return new com.tn.lib.thread.c(this.f61986b, this.f61985a, this.f61991g, this.f61987c, this.f61988d, this.f61989e, this.f61990f);
    }

    public final a b(String name) {
        Intrinsics.h(name, "name");
        this.f61987c = name;
        return this;
    }

    public final a c(int i11) {
        this.f61991g = i11;
        return this;
    }
}
