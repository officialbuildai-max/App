package com.iab.omid.library.vungle.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: d, reason: collision with root package name */
    private static j f33880d = new j();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f33881a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f33882b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33883c = false;

    /* loaded from: classes4.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j jVar;
            boolean z10;
            boolean z11;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                jVar = j.this;
                z10 = jVar.f33883c;
                z11 = true;
            } else {
                if (!intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    return;
                }
                jVar = j.this;
                z10 = jVar.f33883c;
                z11 = false;
            }
            jVar.c(z11, z10);
            j.this.f33882b = z11;
        }
    }

    public static j f() {
        return f33880d;
    }

    public void a() {
        Context context = (Context) this.f33881a.get();
        if (context == null) {
            return;
        }
        boolean isDeviceLocked = ((KeyguardManager) context.getSystemService("keyguard")).isDeviceLocked();
        c(this.f33882b, isDeviceLocked);
        this.f33883c = isDeviceLocked;
    }

    public void b(Context context) {
        if (context == null) {
            return;
        }
        this.f33881a = new WeakReference(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new a(), intentFilter);
    }

    public void c(boolean z10, boolean z11) {
        if ((z11 || z10) == (this.f33883c || this.f33882b)) {
            return;
        }
        Iterator it = c.e().c().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.vungle.adsession.h) it.next()).k().n(z11 || z10);
        }
    }
}
