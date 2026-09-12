package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f32230a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32231b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32232c;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f32234e;

    /* renamed from: d, reason: collision with root package name */
    final ArrayDeque f32233d = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private boolean f32235f = false;

    private x0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f32230a = sharedPreferences;
        this.f32231b = str;
        this.f32232c = str2;
        this.f32234e = executor;
    }

    private boolean c(boolean z10) {
        if (z10 && !this.f32235f) {
            j();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        x0 x0Var = new x0(sharedPreferences, str, str2, executor);
        x0Var.e();
        return x0Var;
    }

    private void e() {
        synchronized (this.f32233d) {
            try {
                this.f32233d.clear();
                String string = this.f32230a.getString(this.f32231b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f32232c)) {
                    String[] split = string.split(this.f32232c, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f32233d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this.f32233d) {
            this.f32230a.edit().putString(this.f32231b, h()).commit();
        }
    }

    private void j() {
        this.f32234e.execute(new Runnable() { // from class: com.google.firebase.messaging.w0
            @Override // java.lang.Runnable
            public final void run() {
                x0.this.i();
            }
        });
    }

    public boolean b(String str) {
        boolean c11;
        if (TextUtils.isEmpty(str) || str.contains(this.f32232c)) {
            return false;
        }
        synchronized (this.f32233d) {
            c11 = c(this.f32233d.add(str));
        }
        return c11;
    }

    public String f() {
        String str;
        synchronized (this.f32233d) {
            str = (String) this.f32233d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean c11;
        synchronized (this.f32233d) {
            c11 = c(this.f32233d.remove(obj));
        }
        return c11;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f32233d.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(this.f32232c);
        }
        return sb2.toString();
    }
}
