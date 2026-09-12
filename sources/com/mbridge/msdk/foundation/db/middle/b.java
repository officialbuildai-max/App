package com.mbridge.msdk.foundation.db.middle;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.k;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.buffer.a f35162a;

    /* renamed from: b, reason: collision with root package name */
    private k f35163b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f35164a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.same.buffer.a f35165b;

        a(boolean z10, com.mbridge.msdk.foundation.same.buffer.a aVar) {
            this.f35164a = z10;
            this.f35165b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f35164a || b.this.f35163b == null) {
                return;
            }
            for (String str : this.f35165b.a()) {
                b.this.f35163b.a(str, b.this.f35162a.a(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mbridge.msdk.foundation.db.middle.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0485b {

        /* renamed from: a, reason: collision with root package name */
        private static b f35167a = new b(null);
    }

    private b() {
        this.f35162a = new com.mbridge.msdk.foundation.same.buffer.a(1000);
        try {
            k a11 = k.a(g.a(c.m().d()));
            this.f35163b = a11;
            a(a11.a(), false);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return C0485b.f35167a;
    }

    public JSONObject a(String str) {
        k kVar;
        JSONObject a11 = this.f35162a.a(str);
        if (a11 != null || (kVar = this.f35163b) == null) {
            return a11;
        }
        JSONObject b11 = kVar.b(str);
        if (b11 != null) {
            this.f35162a.a(str, b11);
        }
        return b11;
    }

    public void a(JSONObject jSONObject, boolean z10) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            com.mbridge.msdk.foundation.same.buffer.a aVar = new com.mbridge.msdk.foundation.same.buffer.a(100);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.f35162a.a(next, optJSONObject);
                aVar.a(next, optJSONObject);
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(z10, aVar));
        }
    }

    public JSONArray b() {
        return new JSONArray((Collection) this.f35162a.a());
    }
}
