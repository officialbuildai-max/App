package yf;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f79125a;

    /* renamed from: b, reason: collision with root package name */
    private final String f79126b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f79127c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f79128d;

    /* renamed from: e, reason: collision with root package name */
    private final HashSet f79129e;

    public d(boolean z10, String taskName, String dependsOn, Runnable runnable) {
        Intrinsics.h(taskName, "taskName");
        Intrinsics.h(dependsOn, "dependsOn");
        this.f79125a = z10;
        this.f79126b = taskName;
        this.f79127c = runnable;
        this.f79129e = new HashSet();
        for (String str : StringsKt.S0(dependsOn, new String[]{","}, false, 0, 6, null)) {
            if (!StringsKt.q0(str)) {
                this.f79129e.add(StringsKt.n1(str).toString());
            }
        }
        if (this.f79129e.contains(this.f79126b)) {
            throw new IllegalArgumentException("TheRouter::Task::The task cannot depend on himself : " + this.f79126b);
        }
        if (!this.f79129e.isEmpty() || Intrinsics.c(this.f79126b, "TheRouter_Initialization") || Intrinsics.c(this.f79126b, "TheRouter_Before_Initialization")) {
            return;
        }
        this.f79129e.add("TheRouter_Initialization");
    }

    public final boolean a() {
        return this.f79125a;
    }

    public final HashSet b() {
        return this.f79129e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c() {
        return this.f79128d;
    }

    public final String d() {
        return this.f79126b;
    }

    public final boolean e() {
        return this.f79128d == 2;
    }

    public final boolean f() {
        return this.f79128d == 0;
    }

    public abstract void g();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(int i11) {
        this.f79128d = i11;
    }
}
