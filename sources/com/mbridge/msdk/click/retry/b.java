package com.mbridge.msdk.click.retry;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: k, reason: collision with root package name */
    public static int f34483k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static int f34484l = 1;

    /* renamed from: a, reason: collision with root package name */
    private final String f34485a;

    /* renamed from: b, reason: collision with root package name */
    private int f34486b;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<String> f34487c = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private final long f34488d = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name */
    private CampaignEx f34489e;

    /* renamed from: f, reason: collision with root package name */
    private String f34490f;

    /* renamed from: g, reason: collision with root package name */
    private int f34491g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f34492h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34493i;

    /* renamed from: j, reason: collision with root package name */
    private int f34494j;

    public b(String str, String str2) {
        this.f34485a = str;
        a(str2);
    }

    public CampaignEx a() {
        return this.f34489e;
    }

    public void a(int i11) {
        this.f34494j = i11;
    }

    public void a(CampaignEx campaignEx) {
        this.f34489e = campaignEx;
    }

    public void a(String str) {
        this.f34486b++;
        this.f34487c.add(str);
    }

    public void a(boolean z10) {
        this.f34492h = z10;
    }

    public HashSet<String> b() {
        return this.f34487c;
    }

    public void b(int i11) {
        this.f34491g = i11;
    }

    public void b(String str) {
        this.f34490f = str;
    }

    public void b(boolean z10) {
        this.f34493i = z10;
    }

    public long c() {
        return this.f34488d;
    }

    public int d() {
        return this.f34494j;
    }

    public int e() {
        return this.f34486b;
    }

    public String f() {
        return this.f34490f;
    }

    public String g() {
        return this.f34485a;
    }

    public int h() {
        return this.f34491g;
    }

    public boolean i() {
        return this.f34492h;
    }

    public boolean j() {
        return this.f34493i;
    }
}
