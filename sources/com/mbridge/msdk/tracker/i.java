package com.mbridge.msdk.tracker;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class i implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    static String f38570i = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_error_message TEXT,report_count INTEGER)";

    /* renamed from: j, reason: collision with root package name */
    static String f38571j = "DROP TABLE IF EXISTS %s";

    /* renamed from: a, reason: collision with root package name */
    private final e f38572a;

    /* renamed from: b, reason: collision with root package name */
    private int f38573b;

    /* renamed from: c, reason: collision with root package name */
    private int f38574c;

    /* renamed from: d, reason: collision with root package name */
    private final String f38575d;

    /* renamed from: e, reason: collision with root package name */
    private long f38576e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38577f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38578g = false;

    /* renamed from: h, reason: collision with root package name */
    private String f38579h;

    public i(e eVar) {
        this.f38572a = eVar;
        this.f38575d = eVar.i();
    }

    public e a() {
        return this.f38572a;
    }

    public void a(int i11) {
        this.f38573b = i11;
    }

    public void a(long j11) {
        this.f38576e = j11;
    }

    public void a(String str) {
        this.f38579h = str;
    }

    public void a(boolean z10) {
        this.f38578g = z10;
    }

    public long b() {
        return this.f38576e;
    }

    public void b(int i11) {
        this.f38574c = i11;
    }

    public void b(boolean z10) {
        this.f38577f = z10;
    }

    public int c() {
        return this.f38573b;
    }

    public String d() {
        return this.f38579h;
    }

    public int e() {
        return this.f38574c;
    }

    public String f() {
        return this.f38575d;
    }

    public boolean g() {
        return this.f38578g;
    }

    public boolean h() {
        return this.f38577f;
    }
}
