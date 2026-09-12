package com.mbridge.msdk.foundation.cache;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.i0;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f35025a;

    /* renamed from: b, reason: collision with root package name */
    private double f35026b;

    /* renamed from: c, reason: collision with root package name */
    private String f35027c;

    /* renamed from: d, reason: collision with root package name */
    private String f35028d;

    /* renamed from: e, reason: collision with root package name */
    private int f35029e;

    /* renamed from: f, reason: collision with root package name */
    private long f35030f;

    /* renamed from: g, reason: collision with root package name */
    private int f35031g;

    /* renamed from: h, reason: collision with root package name */
    private long f35032h;

    /* renamed from: i, reason: collision with root package name */
    private String f35033i;

    /* renamed from: j, reason: collision with root package name */
    private long f35034j;

    public CopyOnWriteArrayList<CampaignEx> a() {
        return this.f35025a;
    }

    public void a(int i11) {
        this.f35029e = i11;
    }

    public void a(long j11) {
        this.f35034j = j11;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a11 = i0.a(str);
        if (TextUtils.isEmpty(a11)) {
            return;
        }
        try {
            double parseDouble = Double.parseDouble(a11);
            if (parseDouble <= 0.0d) {
                return;
            }
            this.f35026b = parseDouble;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f35025a = copyOnWriteArrayList;
    }

    public double b() {
        return this.f35026b;
    }

    public void b(int i11) {
        this.f35031g = i11;
    }

    public void b(long j11) {
        this.f35030f = j11;
    }

    public void b(String str) {
        this.f35027c = str;
    }

    public long c() {
        return this.f35034j;
    }

    public void c(long j11) {
        this.f35032h = j11;
    }

    public void c(String str) {
        this.f35028d = str;
    }

    public String d() {
        return this.f35027c;
    }

    public void d(String str) {
        this.f35033i = str;
    }

    public String e() {
        return this.f35028d;
    }

    public int f() {
        return this.f35029e;
    }

    public int g() {
        return this.f35031g;
    }

    public long h() {
        return this.f35032h;
    }
}
