package com.apm.insight.b;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f19451a;

    /* renamed from: c, reason: collision with root package name */
    private static g f19452c;

    /* renamed from: b, reason: collision with root package name */
    private final b f19453b;

    private f(@NonNull Context context) {
        this.f19453b = new b(context);
        g gVar = new g();
        f19452c = gVar;
        gVar.a();
    }

    public static f a(Context context) {
        if (f19451a == null) {
            synchronized (f.class) {
                try {
                    if (f19451a == null) {
                        f19451a = new f(context);
                    }
                } finally {
                }
            }
        }
        return f19451a;
    }

    public static g b() {
        return f19452c;
    }

    public final b a() {
        return this.f19453b;
    }

    public final void c() {
        this.f19453b.a();
    }

    public final void d() {
        this.f19453b.b();
    }
}
