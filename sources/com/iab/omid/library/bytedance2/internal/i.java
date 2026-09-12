package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.bytedance2.internal.d;
import com.iab.omid.library.bytedance2.walking.TreeWalker;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class i implements com.iab.omid.library.bytedance2.devicevolume.c, d.a {

    /* renamed from: f, reason: collision with root package name */
    private static i f33514f;

    /* renamed from: a, reason: collision with root package name */
    private float f33515a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.e f33516b;

    /* renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.b f33517c;

    /* renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.devicevolume.d f33518d;

    /* renamed from: e, reason: collision with root package name */
    private c f33519e;

    public i(com.iab.omid.library.bytedance2.devicevolume.e eVar, com.iab.omid.library.bytedance2.devicevolume.b bVar) {
        this.f33516b = eVar;
        this.f33517c = bVar;
    }

    private c a() {
        if (this.f33519e == null) {
            this.f33519e = c.c();
        }
        return this.f33519e;
    }

    public static i c() {
        if (f33514f == null) {
            f33514f = new i(new com.iab.omid.library.bytedance2.devicevolume.e(), new com.iab.omid.library.bytedance2.devicevolume.b());
        }
        return f33514f;
    }

    @Override // com.iab.omid.library.bytedance2.devicevolume.c
    public void a(float f11) {
        this.f33515a = f11;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f11);
        }
    }

    public void a(Context context) {
        this.f33518d = this.f33516b.a(new Handler(), context, this.f33517c.a(), this);
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.f33515a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f33518d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f33518d.d();
    }
}
