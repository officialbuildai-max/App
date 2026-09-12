package com.mbridge.msdk.video.dynview.energize;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.listener.e;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f39063b;

    /* renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.inter.a f39064a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f39063b != null) {
            return f39063b;
        }
        synchronized (a.class) {
            try {
                if (f39063b == null) {
                    f39063b = new a();
                }
                aVar = f39063b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private void a(c cVar, View view, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().a(cVar, view, eVar);
    }

    private void a(c cVar, View view, Map map, e eVar) {
        com.mbridge.msdk.video.dynview.wrapper.a aVar = new com.mbridge.msdk.video.dynview.wrapper.a();
        aVar.a(cVar, view, map, eVar);
        this.f39064a = aVar.f39214l;
    }

    private void b(c cVar, View view, Map map, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().b(cVar, view, map, eVar);
    }

    private void c(c cVar, View view, Map map, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().c(cVar, view, map, eVar);
    }

    public void a(View view, c cVar, Map map, e eVar) {
        int g11 = cVar.g();
        if (g11 == 1) {
            a(cVar, view, map, eVar);
            return;
        }
        if (g11 == 2) {
            b(cVar, view, map, eVar);
            return;
        }
        if (g11 == 4) {
            a(cVar, view, eVar);
        } else if (g11 != 5) {
            eVar.a(view, new ArrayList());
        } else {
            c(cVar, view, map, eVar);
        }
    }

    public void b() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f39064a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f39064a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void d() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f39064a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
