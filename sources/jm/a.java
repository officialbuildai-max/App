package jm;

import com.transsion.lib_web.download_render.data.PageData;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f66347a;

    /* renamed from: b, reason: collision with root package name */
    private final PageData f66348b;

    public a(long j11, PageData remotePageData) {
        Intrinsics.h(remotePageData, "remotePageData");
        this.f66347a = j11;
        this.f66348b = remotePageData;
    }

    public final PageData a() {
        return this.f66348b;
    }

    public final long b() {
        return this.f66347a;
    }

    public final void c() {
        Iterator it = CollectionsKt.o(new e(this.f66347a, this.f66348b), new c(this.f66347a, this.f66348b)).iterator();
        while (it.hasNext()) {
            ((d) it.next()).start();
        }
    }
}
