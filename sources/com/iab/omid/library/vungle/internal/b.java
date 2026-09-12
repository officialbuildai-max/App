package com.iab.omid.library.vungle.internal;

import android.view.View;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: d, reason: collision with root package name */
    private static b f33859d = new b();

    private b() {
    }

    public static b k() {
        return f33859d;
    }

    @Override // com.iab.omid.library.vungle.internal.d
    public void f(boolean z10) {
        Iterator it = c.e().c().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.vungle.adsession.h) it.next()).k().k(z10);
        }
    }

    @Override // com.iab.omid.library.vungle.internal.d
    public boolean h() {
        Iterator it = c.e().a().iterator();
        while (it.hasNext()) {
            View l11 = ((com.iab.omid.library.vungle.adsession.h) it.next()).l();
            if (l11 != null && l11.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
