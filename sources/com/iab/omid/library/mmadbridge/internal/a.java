package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;
import com.iab.omid.library.mmadbridge.internal.d;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a implements d.a {

    /* renamed from: f, reason: collision with root package name */
    private static a f33738f = new a(new d());

    /* renamed from: a, reason: collision with root package name */
    protected oe.f f33739a = new oe.f();

    /* renamed from: b, reason: collision with root package name */
    private Date f33740b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33741c;

    /* renamed from: d, reason: collision with root package name */
    private d f33742d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33743e;

    private a(d dVar) {
        this.f33742d = dVar;
    }

    public static a a() {
        return f33738f;
    }

    private void d() {
        if (!this.f33741c || this.f33740b == null) {
            return;
        }
        Iterator it = c.e().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.mmadbridge.adsession.h) it.next()).t().l(c());
        }
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d.a
    public void a(boolean z10) {
        if (!this.f33743e && z10) {
            e();
        }
        this.f33743e = z10;
    }

    public void b(Context context) {
        if (this.f33741c) {
            return;
        }
        this.f33742d.a(context);
        this.f33742d.b(this);
        this.f33742d.i();
        this.f33743e = this.f33742d.g();
        this.f33741c = true;
    }

    public Date c() {
        Date date = this.f33740b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a11 = this.f33739a.a();
        Date date = this.f33740b;
        if (date == null || a11.after(date)) {
            this.f33740b = a11;
            d();
        }
    }
}
