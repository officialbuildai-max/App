package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5055a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5056b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.d.<init>():void");
    }

    public d(boolean z10, boolean z11) {
        this.f5055a = z10;
        this.f5056b = z11;
    }

    public /* synthetic */ d(boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? false : z11);
    }

    public final boolean a() {
        return this.f5056b;
    }

    public final boolean b() {
        return this.f5055a;
    }

    public final void c(boolean z10) {
        this.f5056b = z10;
    }

    public final void d(boolean z10) {
        this.f5055a = z10;
    }
}
