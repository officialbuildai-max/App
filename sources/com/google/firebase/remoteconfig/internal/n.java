package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import java.util.Date;
import yc.j;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: e, reason: collision with root package name */
    static final Date f32591e = new Date(-1);

    /* renamed from: f, reason: collision with root package name */
    static final Date f32592f = new Date(-1);

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f32593a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f32594b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final Object f32595c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f32596d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f32597a;

        /* renamed from: b, reason: collision with root package name */
        private Date f32598b;

        a(int i11, Date date) {
            this.f32597a = i11;
            this.f32598b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f32598b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f32597a;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f32599a;

        /* renamed from: b, reason: collision with root package name */
        private Date f32600b;

        public b(int i11, Date date) {
            this.f32599a = i11;
            this.f32600b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f32600b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f32599a;
        }
    }

    public n(SharedPreferences sharedPreferences) {
        this.f32593a = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        a aVar;
        synchronized (this.f32595c) {
            aVar = new a(this.f32593a.getInt("num_failed_fetches", 0), new Date(this.f32593a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return aVar;
    }

    public long b() {
        return this.f32593a.getLong("fetch_timeout_in_seconds", 60L);
    }

    public yc.i c() {
        s a11;
        synchronized (this.f32594b) {
            long j11 = this.f32593a.getLong("last_fetch_time_in_millis", -1L);
            int i11 = this.f32593a.getInt("last_fetch_status", 0);
            a11 = s.b().c(i11).d(j11).b(new j.b().d(this.f32593a.getLong("fetch_timeout_in_seconds", 60L)).e(this.f32593a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.f32495j)).c()).a();
        }
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f32593a.getString("last_fetch_etag", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date e() {
        return new Date(this.f32593a.getLong("last_fetch_time_in_millis", -1L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f() {
        return this.f32593a.getLong("last_template_version", 0L);
    }

    public long g() {
        return this.f32593a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.f32495j);
    }

    public b h() {
        b bVar;
        synchronized (this.f32596d) {
            bVar = new b(this.f32593a.getInt("num_failed_realtime_streams", 0), new Date(this.f32593a.getLong("realtime_backoff_end_time_in_millis", -1L)));
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        k(0, f32592f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        o(0, f32592f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i11, Date date) {
        synchronized (this.f32595c) {
            this.f32593a.edit().putInt("num_failed_fetches", i11).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void l(yc.j jVar) {
        synchronized (this.f32594b) {
            this.f32593a.edit().putLong("fetch_timeout_in_seconds", jVar.a()).putLong("minimum_fetch_interval_in_seconds", jVar.b()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str) {
        synchronized (this.f32594b) {
            this.f32593a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(long j11) {
        synchronized (this.f32594b) {
            this.f32593a.edit().putLong("last_template_version", j11).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i11, Date date) {
        synchronized (this.f32596d) {
            this.f32593a.edit().putInt("num_failed_realtime_streams", i11).putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f32594b) {
            this.f32593a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Date date) {
        synchronized (this.f32594b) {
            this.f32593a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        synchronized (this.f32594b) {
            this.f32593a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
