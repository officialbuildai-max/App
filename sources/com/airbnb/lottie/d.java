package com.airbnb.lottie;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17792a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f17793b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f17794c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f17795d = true;

    /* renamed from: e, reason: collision with root package name */
    private static AsyncUpdates f17796e = AsyncUpdates.AUTOMATIC;

    /* renamed from: f, reason: collision with root package name */
    private static t4.e f17797f;

    /* renamed from: g, reason: collision with root package name */
    private static t4.d f17798g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile t4.g f17799h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile t4.f f17800i;

    /* renamed from: j, reason: collision with root package name */
    private static ThreadLocal f17801j;

    public static void b(String str) {
        if (f17793b) {
            f().a(str);
        }
    }

    public static float c(String str) {
        if (f17793b) {
            return f().b(str);
        }
        return 0.0f;
    }

    public static AsyncUpdates d() {
        return f17796e;
    }

    public static boolean e() {
        return f17795d;
    }

    private static v4.h f() {
        v4.h hVar = (v4.h) f17801j.get();
        if (hVar != null) {
            return hVar;
        }
        v4.h hVar2 = new v4.h();
        f17801j.set(hVar2);
        return hVar2;
    }

    public static boolean g() {
        return f17793b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ File h(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static t4.f i(Context context) {
        if (!f17794c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        t4.f fVar = f17800i;
        if (fVar == null) {
            synchronized (t4.f.class) {
                try {
                    fVar = f17800i;
                    if (fVar == null) {
                        t4.d dVar = f17798g;
                        if (dVar == null) {
                            dVar = new t4.d() { // from class: com.airbnb.lottie.c
                                @Override // t4.d
                                public final File a() {
                                    File h11;
                                    h11 = d.h(applicationContext);
                                    return h11;
                                }
                            };
                        }
                        fVar = new t4.f(dVar);
                        f17800i = fVar;
                    }
                } finally {
                }
            }
        }
        return fVar;
    }

    public static t4.g j(Context context) {
        t4.g gVar = f17799h;
        if (gVar == null) {
            synchronized (t4.g.class) {
                try {
                    gVar = f17799h;
                    if (gVar == null) {
                        t4.f i11 = i(context);
                        t4.e eVar = f17797f;
                        if (eVar == null) {
                            eVar = new t4.b();
                        }
                        gVar = new t4.g(i11, eVar);
                        f17799h = gVar;
                    }
                } finally {
                }
            }
        }
        return gVar;
    }
}
