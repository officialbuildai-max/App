package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Region {

    /* renamed from: a, reason: collision with root package name */
    private final String f18644a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18645b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f18646c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f18647d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map f18648e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Region(String str, String str2) {
        this.f18644a = str;
        if (str2 == null || str2.isEmpty()) {
            this.f18645b = "amazonaws.com";
        } else {
            this.f18645b = str2;
        }
    }

    public static Region e(Regions regions) {
        return RegionUtils.a(regions.getName());
    }

    public static Region f(String str) {
        return RegionUtils.a(str);
    }

    public String a() {
        return this.f18645b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map b() {
        return this.f18647d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map c() {
        return this.f18648e;
    }

    public String d() {
        return this.f18644a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return d().equals(((Region) obj).d());
        }
        return false;
    }

    public String g(String str) {
        return (String) this.f18646c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map h() {
        return this.f18646c;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public boolean i(String str) {
        return this.f18646c.containsKey(str);
    }

    public String toString() {
        return d();
    }
}
