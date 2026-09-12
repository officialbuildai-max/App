package com.mbridge.msdk.video.dynview.energize;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f39065a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (f39065a != null) {
            return f39065a;
        }
        synchronized (b.class) {
            try {
                if (f39065a == null) {
                    f39065a = new b();
                }
                bVar = f39065a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    private void a(View view, c cVar) {
        new com.mbridge.msdk.video.dynview.wrapper.b().a(view, cVar);
    }

    private void a(View view, Map<String, Object> map) {
        new com.mbridge.msdk.video.dynview.wrapper.b().a(view, map);
    }

    private void b(View view, c cVar) {
        new com.mbridge.msdk.video.dynview.wrapper.b().b(view, cVar);
    }

    private void b(View view, c cVar, Map<String, Object> map) {
        new com.mbridge.msdk.video.dynview.wrapper.b().b(view, cVar, map);
    }

    private void c(View view, c cVar, Map<String, Object> map) {
        new com.mbridge.msdk.video.dynview.wrapper.b().a(view, cVar, map);
    }

    public void a(View view, c cVar, Map<String, Object> map) {
        if (cVar == null) {
            return;
        }
        int g11 = cVar.g();
        if (g11 == 1) {
            a(view, map);
            return;
        }
        if (g11 == 2) {
            c(view, cVar, map);
            return;
        }
        if (g11 == 3) {
            b(view, cVar);
        } else if (g11 == 4) {
            b(view, cVar, map);
        } else {
            if (g11 != 5) {
                return;
            }
            a(view, cVar);
        }
    }
}
