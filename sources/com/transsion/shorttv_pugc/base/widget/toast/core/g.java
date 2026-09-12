package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.transsion.shorttv_pugc.base.widget.toast.core.a;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class g extends Handler implements lt.b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f54018e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Application f54019a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.shorttv_pugc.base.widget.toast.core.a f54020b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f54021c;

    /* renamed from: d, reason: collision with root package name */
    private lt.c f54022d;

    /* loaded from: classes6.dex */
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

    @Override // lt.b
    public void a(CharSequence charSequence) {
        removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = charSequence;
        sendMessageDelayed(obtain, 200L);
    }

    @Override // lt.b
    public void b(lt.c cVar) {
        this.f54022d = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r4.getApplicationInfo().targetSdkVersion < 30) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public lt.a c(android.app.Application r4) {
        /*
            r3 = this;
            com.transsion.shorttv_pugc.base.widget.toast.core.a r0 = r3.f54020b
            kotlin.jvm.internal.Intrinsics.e(r0)
            android.app.Activity r0 = r0.a()
            if (r0 == 0) goto L11
            com.transsion.shorttv_pugc.base.widget.toast.core.b r1 = new com.transsion.shorttv_pugc.base.widget.toast.core.b
            r1.<init>(r0)
            goto L22
        L11:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 25
            if (r0 != r1) goto L1d
            com.transsion.shorttv_pugc.base.widget.toast.core.d r1 = new com.transsion.shorttv_pugc.base.widget.toast.core.d
            r1.<init>(r4)
            goto L22
        L1d:
            com.transsion.shorttv_pugc.base.widget.toast.core.e r1 = new com.transsion.shorttv_pugc.base.widget.toast.core.e
            r1.<init>(r4)
        L22:
            boolean r0 = r1 instanceof com.transsion.shorttv_pugc.base.widget.toast.core.b
            if (r0 != 0) goto L37
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r0 < r2) goto L37
            kotlin.jvm.internal.Intrinsics.e(r4)
            android.content.pm.ApplicationInfo r0 = r4.getApplicationInfo()
            int r0 = r0.targetSdkVersion
            if (r0 >= r2) goto L76
        L37:
            lt.c r0 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r0)
            android.view.View r4 = r0.createView(r4)
            r1.setView(r4)
            lt.c r4 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r4)
            int r4 = r4.getGravity()
            lt.c r0 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r0)
            int r0 = r0.getXOffset()
            lt.c r2 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r2 = r2.getYOffset()
            r1.setGravity(r4, r0, r2)
            lt.c r4 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r4)
            float r4 = r4.getHorizontalMargin()
            lt.c r0 = r3.f54022d
            kotlin.jvm.internal.Intrinsics.e(r0)
            float r0 = r0.getVerticalMargin()
            r1.setMargin(r4, r0)
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.base.widget.toast.core.g.c(android.app.Application):lt.a");
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        lt.a aVar;
        Intrinsics.h(msg, "msg");
        WeakReference weakReference = this.f54021c;
        if (weakReference != null) {
            Intrinsics.e(weakReference);
            aVar = (lt.a) weakReference.get();
        } else {
            aVar = null;
        }
        int i11 = msg.what;
        if (i11 != 1) {
            if (i11 == 2 && aVar != null) {
                aVar.cancel();
                return;
            }
            return;
        }
        Object obj = msg.obj;
        if (obj instanceof CharSequence) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            CharSequence charSequence = (CharSequence) obj;
            if (aVar != null) {
                aVar.cancel();
            }
            lt.a c11 = c(this.f54019a);
            this.f54021c = new WeakReference(c11);
            Intrinsics.e(c11);
            c11.setDuration(d(charSequence));
            c11.setText(charSequence);
            c11.show();
            b(new mt.a());
        }
    }

    @Override // lt.b
    public void registerStrategy(Application application) {
        this.f54019a = application;
        a.C0664a c0664a = com.transsion.shorttv_pugc.base.widget.toast.core.a.f54004b;
        Intrinsics.e(application);
        this.f54020b = c0664a.a(application);
    }
}
