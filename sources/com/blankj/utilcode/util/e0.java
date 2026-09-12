package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.s;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class e0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean A(Intent intent) {
        return p.c(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B() {
        return g0.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C() {
        return v.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D(String str) {
        return b0.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean E(View view, long j11) {
        return j.b(view, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View F(int i11) {
        return g0.b(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void G() {
        H(AdaptScreenUtils.f());
    }

    private static void H(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.d().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void I(Utils.a aVar) {
        UtilsActivityLifecycleImpl.f20156g.u(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void J(Runnable runnable) {
        ThreadUtils.k(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K(Runnable runnable, long j11) {
        ThreadUtils.l(runnable, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void L(Application application) {
        UtilsActivityLifecycleImpl.f20156g.y(application);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap M(View view) {
        return ImageUtils.h(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Utils.a aVar) {
        UtilsActivityLifecycleImpl.f20156g.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(byte[] bArr) {
        return i.c(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(File file) {
        return n.c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(float f11) {
        return a0.a(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(CharSequence charSequence, CharSequence charSequence2) {
        return b0.a(charSequence, charSequence2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Activity activity) {
        KeyboardUtils.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str, Object... objArr) {
        return b0.c(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List h() {
        return UtilsActivityLifecycleImpl.f20156g.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i() {
        return y.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Application j() {
        return UtilsActivityLifecycleImpl.f20156g.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        return t.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File l(String str) {
        return n.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long m(String str) {
        return n.j(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long n(String str) {
        return n.k(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent o(String str, boolean z10) {
        return p.b(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p() {
        return d.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Notification q(s.a aVar, Utils.b bVar) {
        return s.a(aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x r() {
        return x.a("Utils");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s() {
        return d.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(int i11) {
        return b0.d(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity u() {
        return UtilsActivityLifecycleImpl.f20156g.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(Application application) {
        UtilsActivityLifecycleImpl.f20156g.p(application);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w(Activity activity) {
        return a.c(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return UtilsActivityLifecycleImpl.f20156g.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y(File file) {
        return n.m(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z() {
        return PermissionUtils.t();
    }
}
