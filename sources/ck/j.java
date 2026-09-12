package ck;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import hj.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public abstract class j extends Dialog implements hj.a {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f17326a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, int i11) {
        super(context, i11);
        Intrinsics.h(context, "context");
        this.f17326a = LazyKt.b(new Function0() { // from class: ck.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                hj.b c11;
                c11 = j.c(j.this);
                return c11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hj.b c(j jVar) {
        return jVar.d();
    }

    public abstract boolean b();

    public hj.b d() {
        return a.C0806a.a(this);
    }

    public final void e() {
    }

    public void f() {
    }

    public final void g(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            show();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // hj.a
    public hj.b getLogViewConfig() {
        return (hj.b) this.f17326a.getValue();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            if (isShowing()) {
                return;
            }
            a.C0856a c0856a = lg.a.f68962a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("show dialog hasShownAnyDialogInSession ");
            sb2.append(this);
            sb2.append(" :");
            u uVar = u.f17345a;
            sb2.append(uVar.b());
            a.C0856a.g(c0856a, sb2.toString(), false, 2, null);
            if (!uVar.b() || b()) {
                f();
                super.show();
                uVar.c(true);
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }
}
