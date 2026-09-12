package com.transsion.athena.data;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class anehat {

    /* renamed from: a, reason: collision with root package name */
    public long f42741a;

    /* renamed from: b, reason: collision with root package name */
    public String f42742b;

    /* renamed from: c, reason: collision with root package name */
    public List<athena> f42743c;

    /* renamed from: d, reason: collision with root package name */
    public long f42744d;

    /* renamed from: e, reason: collision with root package name */
    public long f42745e;

    /* renamed from: f, reason: collision with root package name */
    public int f42746f;

    /* renamed from: g, reason: collision with root package name */
    public int f42747g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f42748h;

    /* loaded from: classes5.dex */
    public static class athena {

        /* renamed from: a, reason: collision with root package name */
        public String f42749a;

        /* renamed from: b, reason: collision with root package name */
        public long f42750b;

        /* renamed from: c, reason: collision with root package name */
        public String f42751c;

        /* renamed from: d, reason: collision with root package name */
        public int f42752d;

        public athena(String str, long j11, int i11, String str2) {
            this.f42749a = str;
            this.f42750b = j11;
            this.f42752d = i11;
            this.f42751c = str2;
        }

        public String toString() {
            return "TidEvent{event='" + this.f42749a + "', ts=" + this.f42750b + '}';
        }
    }

    public anehat(long j11, String str, List<athena> list, long j12, long j13, int i11, int i12, boolean z10) {
        this.f42741a = j11;
        this.f42743c = list;
        this.f42742b = str;
        this.f42744d = j12;
        this.f42745e = j13;
        this.f42746f = i11;
        this.f42747g = i12;
        this.f42748h = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof anehat) && this.f42741a == ((anehat) obj).f42741a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f42741a), this.f42743c, Long.valueOf(this.f42744d), Long.valueOf(this.f42745e), Integer.valueOf(this.f42746f), Integer.valueOf(this.f42747g), Boolean.valueOf(this.f42748h));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<athena> it = this.f42743c.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
        }
        return "TidEventSet{tid=" + this.f42741a + ", event='" + this.f42742b + "', eventList=" + ((Object) sb2) + ", eventCount=" + this.f42746f + '}';
    }
}
