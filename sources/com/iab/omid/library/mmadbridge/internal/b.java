package com.iab.omid.library.mmadbridge.internal;

import android.view.View;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: d, reason: collision with root package name */
    private static b f33744d = new b();

    private b() {
    }

    public static b k() {
        return f33744d;
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d
    public void f(boolean z10) {
        Iterator it = c.e().c().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.mmadbridge.adsession.h) it.next()).t().n(z10);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d
    public boolean h() {
        Iterator it = c.e().a().iterator();
        while (it.hasNext()) {
            View n11 = ((com.iab.omid.library.mmadbridge.adsession.h) it.next()).n();
            if (n11 != null && n11.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
