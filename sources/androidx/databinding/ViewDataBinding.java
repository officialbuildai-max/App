package androidx.databinding;

import android.os.Build;
import android.view.View;
import androidx.databinding.c;
import androidx.databinding.library.R$id;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    static int f8615a = Build.VERSION.SDK_INT;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f8616b = true;

    /* renamed from: c, reason: collision with root package name */
    private static final androidx.databinding.d f8617c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final androidx.databinding.d f8618d = new b();

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.databinding.d f8619e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.databinding.d f8620f = new d();

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f8621g = new e();

    /* renamed from: h, reason: collision with root package name */
    private static final ReferenceQueue f8622h = new ReferenceQueue();

    /* renamed from: i, reason: collision with root package name */
    private static final View.OnAttachStateChangeListener f8623i = new f();

    /* renamed from: androidx.databinding.ViewDataBinding$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ ViewDataBinding this$0;

        AnonymousClass7(ViewDataBinding viewDataBinding) {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.c(null, false);
            }
            ViewDataBinding.h();
            if (ViewDataBinding.e(null).isAttachedToWindow()) {
                throw null;
            }
            ViewDataBinding.e(null).removeOnAttachStateChangeListener(ViewDataBinding.f8623i);
            ViewDataBinding.e(null).addOnAttachStateChangeListener(ViewDataBinding.f8623i);
        }
    }

    /* loaded from: classes.dex */
    class a implements androidx.databinding.d {
        a() {
        }
    }

    /* loaded from: classes.dex */
    class b implements androidx.databinding.d {
        b() {
        }
    }

    /* loaded from: classes.dex */
    class c implements androidx.databinding.d {
        c() {
        }
    }

    /* loaded from: classes.dex */
    class d implements androidx.databinding.d {
        d() {
        }
    }

    /* loaded from: classes.dex */
    class e extends c.a {
        e() {
        }

        @Override // androidx.databinding.c.a
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2, int i11, Object obj3) {
            android.support.v4.media.session.c.a(obj2);
            b((k) obj, null, i11, (Void) obj3);
        }

        public void b(k kVar, ViewDataBinding viewDataBinding, int i11, Void r42) {
            if (i11 == 1) {
                if (kVar.c(viewDataBinding)) {
                    return;
                }
                ViewDataBinding.a(viewDataBinding, true);
            } else if (i11 == 2) {
                kVar.b(viewDataBinding);
            } else {
                if (i11 != 3) {
                    return;
                }
                kVar.a(viewDataBinding);
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.g(view);
            ViewDataBinding.b(null).run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ boolean a(ViewDataBinding viewDataBinding, boolean z10) {
        throw null;
    }

    static /* synthetic */ Runnable b(ViewDataBinding viewDataBinding) {
        throw null;
    }

    static /* synthetic */ boolean c(ViewDataBinding viewDataBinding, boolean z10) {
        throw null;
    }

    static /* synthetic */ View e(ViewDataBinding viewDataBinding) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewDataBinding g(View view) {
        if (view != null) {
            android.support.v4.media.session.c.a(view.getTag(R$id.dataBinding));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        do {
        } while (f8622h.poll() != null);
    }
}
