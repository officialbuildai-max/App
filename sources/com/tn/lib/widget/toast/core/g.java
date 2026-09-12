package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tn.lib.widget.toast.core.a;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class g extends Handler implements vh.b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f41528e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Application f41529a;

    /* renamed from: b, reason: collision with root package name */
    private com.tn.lib.widget.toast.core.a f41530b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f41531c;

    /* renamed from: d, reason: collision with root package name */
    private vh.c f41532d;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g() {
        super(Looper.getMainLooper());
    }

    private final int d(CharSequence charSequence) {
        return charSequence.length() > 20 ? 1 : 0;
    }

    @Override // vh.b
    public void a(CharSequence charSequence) {
        removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = charSequence;
        sendMessageDelayed(obtain, 200L);
    }

    @Override // vh.b
    public void b(vh.c cVar) {
        this.f41532d = cVar;
    }

    public vh.a c(Application application) {
        com.tn.lib.widget.toast.core.a aVar = this.f41530b;
        Intrinsics.e(aVar);
        Activity a11 = aVar.a();
        vh.a bVar = a11 != null ? new b(a11) : Build.VERSION.SDK_INT == 25 ? new d(application) : new e(application);
        vh.c cVar = this.f41532d;
        Intrinsics.e(cVar);
        bVar.b(cVar.createView(application));
        vh.c cVar2 = this.f41532d;
        Intrinsics.e(cVar2);
        int gravity = cVar2.getGravity();
        vh.c cVar3 = this.f41532d;
        Intrinsics.e(cVar3);
        int xOffset = cVar3.getXOffset();
        vh.c cVar4 = this.f41532d;
        Intrinsics.e(cVar4);
        bVar.setGravity(gravity, xOffset, cVar4.getYOffset());
        vh.c cVar5 = this.f41532d;
        Intrinsics.e(cVar5);
        float horizontalMargin = cVar5.getHorizontalMargin();
        vh.c cVar6 = this.f41532d;
        Intrinsics.e(cVar6);
        bVar.setMargin(horizontalMargin, cVar6.getVerticalMargin());
        return bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Object obj;
        Intrinsics.h(msg, "msg");
        WeakReference weakReference = this.f41531c;
        if (weakReference != null) {
            Intrinsics.e(weakReference);
            obj = weakReference.get();
        } else {
            obj = null;
        }
        int i11 = msg.what;
        if (i11 != 1) {
            if (i11 == 2 && obj != null) {
                ((vh.a) obj).cancel();
                return;
            }
            return;
        }
        Object obj2 = msg.obj;
        if (obj2 instanceof CharSequence) {
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequence charSequence = (CharSequence) obj2;
            vh.a aVar = (vh.a) obj;
            if (aVar != null) {
                aVar.cancel();
            }
            vh.a c11 = c(this.f41529a);
            this.f41531c = new WeakReference(c11);
            Intrinsics.e(c11);
            c11.setDuration(d(charSequence));
            c11.setText(charSequence);
            try {
                Result.Companion companion = Result.INSTANCE;
                c11.show();
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            b(new wh.a());
        }
    }

    @Override // vh.b
    public void registerStrategy(Application application) {
        this.f41529a = application;
        a.C0590a c0590a = com.tn.lib.widget.toast.core.a.f41513b;
        Intrinsics.e(application);
        this.f41530b = c0590a.a(application);
    }
}
