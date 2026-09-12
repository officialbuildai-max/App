package com.iab.omid.library.vungle.internal;

import android.content.Context;
import com.iab.omid.library.vungle.internal.d;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a implements d.a {

    /* renamed from: f, reason: collision with root package name */
    private static a f33853f = new a(new d());

    /* renamed from: a, reason: collision with root package name */
    protected ue.f f33854a = new ue.f();

    /* renamed from: b, reason: collision with root package name */
    private Date f33855b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33856c;

    /* renamed from: d, reason: collision with root package name */
    private d f33857d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33858e;

    private a(d dVar) {
        this.f33857d = dVar;
    }

    public static a a() {
        return f33853f;
    }

    private void d() {
        if (!this.f33856c || this.f33855b == null) {
            return;
        }
        Iterator it = c.e().a().iterator();
        while (it.hasNext()) {
            ((com.iab.omid.library.vungle.adsession.h) it.next()).k().i(c());
        }
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z10) {
        if (!this.f33858e && z10) {
            e();
        }
        this.f33858e = z10;
    }

    public void b(Context context) {
        if (this.f33856c) {
            return;
        }
        this.f33857d.a(context);
        this.f33857d.b(this);
        this.f33857d.i();
        this.f33858e = this.f33857d.g();
        this.f33856c = true;
    }

    public Date c() {
        Date date = this.f33855b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a11 = this.f33854a.a();
        Date date = this.f33855b;
        if (date == null || a11.after(date)) {
            this.f33855b = a11;
            d();
        }
    }
}
