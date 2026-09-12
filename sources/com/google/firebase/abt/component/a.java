package com.google.firebase.abt.component;

import android.content.Context;
import ic.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f31099a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Context f31100b;

    /* renamed from: c, reason: collision with root package name */
    private final b f31101c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, b bVar) {
        this.f31100b = context;
        this.f31101c = bVar;
    }

    protected hb.b a(String str) {
        return new hb.b(this.f31100b, this.f31101c, str);
    }

    public synchronized hb.b b(String str) {
        try {
            if (!this.f31099a.containsKey(str)) {
                this.f31099a.put(str, a(str));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (hb.b) this.f31099a.get(str);
    }
}
