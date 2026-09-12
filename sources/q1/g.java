package q1;

import androidx.view.m;
import androidx.view.t0;
import androidx.view.v0;
import androidx.view.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f73174a = new g();

    /* loaded from: classes2.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f73175a = new a();

        private a() {
        }
    }

    private g() {
    }

    public final p1.a a(y0 owner) {
        Intrinsics.h(owner, "owner");
        return owner instanceof m ? ((m) owner).getDefaultViewModelCreationExtras() : a.C0908a.f72393b;
    }

    public final v0.c b(y0 owner) {
        Intrinsics.h(owner, "owner");
        return owner instanceof m ? ((m) owner).getDefaultViewModelProviderFactory() : c.f73168a;
    }

    public final String c(KClass modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        String a11 = h.a(modelClass);
        if (a11 == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + a11;
    }

    public final t0 d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
