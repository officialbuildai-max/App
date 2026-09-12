package com.cloud.hisavana.sdk;

import android.util.ArrayMap;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class r4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f23006a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap f23007b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static r4 f23008a = new r4();
    }

    private r4() {
        this.f23006a = 100;
        this.f23007b = new ArrayMap();
    }

    public static r4 b() {
        return b.f23008a;
    }

    public i1 a(String str) {
        WeakReference weakReference = (WeakReference) this.f23007b.get(str);
        if (weakReference == null) {
            return null;
        }
        return (i1) weakReference.get();
    }

    public void c(String str, i1 i1Var) {
        try {
            if (this.f23007b.size() >= 100) {
                this.f23007b.removeAt(0);
                e4.b().d("AdSplashManager", "spalsh attachTranSplash map clear");
            }
            this.f23007b.put(str, new WeakReference(i1Var));
            e4.b().d("AdSplashManager", "spalsh attachTranSplash map size = " + this.f23007b.size());
        } catch (Exception e11) {
            e4.b().w("AdSplashManager", e11.getMessage());
        }
    }

    public void d(String str) {
        this.f23007b.remove(str);
        e4.b().d("AdSplashManager", "spalsh unAttach map size = " + this.f23007b.size());
    }
}
