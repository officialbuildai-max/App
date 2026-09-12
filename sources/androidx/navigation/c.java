package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f13942a;

    /* renamed from: b, reason: collision with root package name */
    private l f13943b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f13944c;

    public c(int i11, l lVar, Bundle bundle) {
        this.f13942a = i11;
        this.f13943b = lVar;
        this.f13944c = bundle;
    }

    public /* synthetic */ c(int i11, l lVar, Bundle bundle, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : lVar, (i12 & 4) != 0 ? null : bundle);
    }

    public final Bundle a() {
        return this.f13944c;
    }

    public final int b() {
        return this.f13942a;
    }

    public final l c() {
        return this.f13943b;
    }

    public final void d(Bundle bundle) {
        this.f13944c = bundle;
    }

    public final void e(l lVar) {
        this.f13943b = lVar;
    }
}
