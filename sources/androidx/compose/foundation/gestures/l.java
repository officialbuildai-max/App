package androidx.compose.foundation.gestures;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class l extends f.c implements m1 {

    /* renamed from: p, reason: collision with root package name */
    public static final a f2799p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f2800q = 8;

    /* renamed from: n, reason: collision with root package name */
    private final Object f2801n = f2799p;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2802o;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(boolean z10) {
        this.f2802o = z10;
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return this.f2801n;
    }

    public final boolean D1() {
        return this.f2802o;
    }

    public final void E1(boolean z10) {
        this.f2802o = z10;
    }
}
