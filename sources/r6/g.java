package r6;

import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final BaseQuickAdapter f74286a;

    /* renamed from: b, reason: collision with root package name */
    private p6.g f74287b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f74288c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f74289d;

    /* renamed from: e, reason: collision with root package name */
    private int f74290e;

    public g(BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(baseQuickAdapter, "baseQuickAdapter");
        this.f74286a = baseQuickAdapter;
        this.f74290e = 1;
    }

    public final void a(int i11) {
        p6.g gVar;
        if (!this.f74288c || this.f74289d || i11 > this.f74290e || (gVar = this.f74287b) == null) {
            return;
        }
        gVar.a();
    }

    public void b(p6.g gVar) {
        this.f74287b = gVar;
    }

    public final void c(int i11) {
        this.f74290e = i11;
    }

    public final void d(boolean z10) {
        this.f74288c = z10;
    }

    public final void e(boolean z10) {
        this.f74289d = z10;
    }
}
