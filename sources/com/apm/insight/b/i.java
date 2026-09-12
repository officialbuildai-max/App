package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static int f19508a = 5;

    /* renamed from: b, reason: collision with root package name */
    private static b f19509b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19510c;

    /* renamed from: d, reason: collision with root package name */
    private static Printer f19511d;

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    static class b implements Printer {

        /* renamed from: a, reason: collision with root package name */
        List<Printer> f19512a = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private List<Printer> f19515d = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        List<Printer> f19513b = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private boolean f19516e = false;

        /* renamed from: c, reason: collision with root package name */
        boolean f19514c = false;

        b() {
        }

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.b();
            if (str.charAt(0) == '>' && this.f19514c) {
                for (Printer printer : this.f19513b) {
                    if (!this.f19512a.contains(printer)) {
                        this.f19512a.add(printer);
                    }
                }
                this.f19513b.clear();
                this.f19514c = false;
            }
            if (this.f19512a.size() > i.f19508a) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.f19512a) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
            i.b();
        }
    }

    public static void a() {
        if (f19510c) {
            return;
        }
        f19510c = true;
        f19509b = new b();
        Printer d11 = d();
        f19511d = d11;
        if (d11 != null) {
            f19509b.f19512a.add(d11);
        }
        if (com.apm.insight.e.s()) {
            Looper.getMainLooper().setMessageLogging(f19509b);
        }
    }

    public static void a(Printer printer) {
        if (printer == null || f19509b.f19513b.contains(printer)) {
            return;
        }
        f19509b.f19513b.add(printer);
        f19509b.f19514c = true;
    }

    static /* synthetic */ a b() {
        return null;
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }
}
