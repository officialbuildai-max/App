package com.mbridge.msdk.foundation.controller;

import android.annotation.SuppressLint;
import com.mbridge.msdk.foundation.controller.a;

/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: s, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c f35089s;

    private c() {
    }

    public static c m() {
        if (f35089s == null) {
            synchronized (c.class) {
                try {
                    if (f35089s == null) {
                        f35089s = new c();
                    }
                } finally {
                }
            }
        }
        return f35089s;
    }

    @Override // com.mbridge.msdk.foundation.controller.a
    protected void a(a.e eVar) {
    }
}
