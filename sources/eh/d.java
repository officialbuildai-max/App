package eh;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private String f61996a = "";

    /* renamed from: b, reason: collision with root package name */
    private dh.b f61997b;

    /* renamed from: c, reason: collision with root package name */
    private long f61998c;

    /* renamed from: d, reason: collision with root package name */
    private Executor f61999d;

    /* renamed from: e, reason: collision with root package name */
    private dh.a f62000e;

    public final dh.a a() {
        return this.f62000e;
    }

    public final long b() {
        return this.f61998c;
    }

    public final Executor c() {
        return this.f61999d;
    }

    public final dh.b d() {
        return this.f61997b;
    }

    public final String e() {
        return this.f61996a;
    }

    public final void f(Executor executor) {
        this.f61999d = executor;
    }

    public final void g(dh.b bVar) {
        this.f61997b = bVar;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f61996a = str;
    }
}
