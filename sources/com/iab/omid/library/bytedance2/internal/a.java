package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.internal.d;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a implements d.a {

    /* renamed from: f, reason: collision with root package name */
    private static a f33489f = new a(new d());

    /* renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.bytedance2.utils.f f33490a = new com.iab.omid.library.bytedance2.utils.f();

    /* renamed from: b, reason: collision with root package name */
    private Date f33491b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33492c;

    /* renamed from: d, reason: collision with root package name */
    private d f33493d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33494e;

    private a(d dVar) {
        this.f33493d = dVar;
    }

    public static a a() {
        return f33489f;
    }

    private void c() {
        if (!this.f33492c || this.f33491b == null) {
            return;
        }
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public void a(@NonNull Context context) {
        if (this.f33492c) {
            return;
        }
        this.f33493d.a(context);
        this.f33493d.a(this);
        this.f33493d.e();
        this.f33494e = this.f33493d.c();
        this.f33492c = true;
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z10) {
        if (!this.f33494e && z10) {
            d();
        }
        this.f33494e = z10;
    }

    public Date b() {
        Date date = this.f33491b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date a11 = this.f33490a.a();
        Date date = this.f33491b;
        if (date == null || a11.after(date)) {
            this.f33491b = a11;
            c();
        }
    }
}
