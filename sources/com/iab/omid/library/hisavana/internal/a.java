package com.iab.omid.library.hisavana.internal;

import android.content.Context;
import com.iab.omid.library.hisavana.internal.d;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a implements d.a {

    /* renamed from: f, reason: collision with root package name */
    private static a f33619f = new a(new d());

    /* renamed from: a, reason: collision with root package name */
    protected ie.f f33620a = new ie.f();

    /* renamed from: b, reason: collision with root package name */
    private Date f33621b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33622c;

    /* renamed from: d, reason: collision with root package name */
    private d f33623d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33624e;

    private a(d dVar) {
        this.f33623d = dVar;
    }

    public static a a() {
        return f33619f;
    }

    private void d() {
        if (!this.f33622c || this.f33621b == null) {
            return;
        }
        Iterator it = c.e().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.hisavana.adsession.h) it.next()).l().i(c());
        }
    }

    @Override // com.iab.omid.library.hisavana.internal.d.a
    public void a(boolean z10) {
        if (!this.f33624e && z10) {
            e();
        }
        this.f33624e = z10;
    }

    public void b(Context context) {
        if (this.f33622c) {
            return;
        }
        this.f33623d.a(context);
        this.f33623d.b(this);
        this.f33623d.i();
        this.f33624e = this.f33623d.g();
        this.f33622c = true;
    }

    public Date c() {
        Date date = this.f33621b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a11 = this.f33620a.a();
        Date date = this.f33621b;
        if (date == null || a11.after(date)) {
            this.f33621b = a11;
            d();
        }
    }
}
