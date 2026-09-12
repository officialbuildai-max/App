package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static i f19887a;

    /* renamed from: b, reason: collision with root package name */
    private long f19888b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final List<Printer> f19889c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final List<Printer> f19890d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f19891e = false;

    static {
        new Printer() { // from class: com.apm.insight.runtime.i.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (str == null) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    i.a().a(str);
                } else if (str.charAt(0) == '<') {
                    i.a().b(str);
                }
                i.c();
            }
        };
    }

    private i() {
    }

    public static i a() {
        if (f19887a == null) {
            synchronized (i.class) {
                try {
                    if (f19887a == null) {
                        f19887a = new i();
                    }
                } finally {
                }
            }
        }
        return f19887a;
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Printer printer = list.get(i11);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th2) {
            com.apm.insight.a.a(th2);
        }
    }

    static /* synthetic */ Printer c() {
        return null;
    }

    final void a(String str) {
        this.f19888b = -1L;
        try {
            a(this.f19889c, str);
        } catch (Exception e11) {
            com.apm.insight.a.a((Throwable) e11);
        }
    }

    final void b(String str) {
        this.f19888b = SystemClock.uptimeMillis();
        try {
            a(this.f19890d, str);
        } catch (Exception e11) {
            com.apm.insight.a.b((Throwable) e11);
        }
    }

    public final boolean b() {
        return this.f19888b != -1 && SystemClock.uptimeMillis() - this.f19888b > 5000;
    }
}
