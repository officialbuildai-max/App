package com.apm.insight.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.e;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f19557a;

    /* renamed from: b, reason: collision with root package name */
    private com.apm.insight.e.a.b f19558b;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f19559c;

    private a() {
    }

    public static a a() {
        if (f19557a == null) {
            synchronized (a.class) {
                try {
                    if (f19557a == null) {
                        f19557a = new a();
                    }
                } finally {
                }
            }
        }
        return f19557a;
    }

    private void b() {
        if (this.f19558b == null) {
            a(e.g());
        }
    }

    public final synchronized void a(Context context) {
        try {
            this.f19559c = new b(context).getWritableDatabase();
        } finally {
            this.f19558b = new com.apm.insight.e.a.b();
        }
        this.f19558b = new com.apm.insight.e.a.b();
    }

    public final synchronized void a(com.apm.insight.d.a aVar) {
        b();
        com.apm.insight.e.a.b bVar = this.f19558b;
        if (bVar != null) {
            bVar.a(this.f19559c, aVar);
        }
    }

    public final synchronized boolean a(String str) {
        b();
        com.apm.insight.e.a.b bVar = this.f19558b;
        if (bVar == null) {
            return false;
        }
        return bVar.a(this.f19559c, str);
    }
}
