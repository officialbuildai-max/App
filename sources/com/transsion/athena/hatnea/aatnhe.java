package com.transsion.athena.hatnea;

import java.util.List;

/* loaded from: classes5.dex */
public class aatnhe {

    /* renamed from: a, reason: collision with root package name */
    public int f42807a;

    /* renamed from: b, reason: collision with root package name */
    public String f42808b;

    /* renamed from: c, reason: collision with root package name */
    public List<athena> f42809c;

    /* renamed from: d, reason: collision with root package name */
    public String f42810d;

    /* loaded from: classes5.dex */
    public static class athena {

        /* renamed from: a, reason: collision with root package name */
        public int f42811a;

        /* renamed from: b, reason: collision with root package name */
        public int f42812b;

        /* renamed from: c, reason: collision with root package name */
        public long f42813c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public athena(int i11, int i12, long j11) {
            this.f42811a = i11;
            this.f42812b = i12;
            this.f42813c = j11;
        }

        public String a() {
            return this.f42812b + "-" + this.f42813c;
        }

        public String toString() {
            return "{appId=" + this.f42811a + ", type=" + this.f42812b + ", version=" + this.f42813c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aatnhe() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aatnhe(String str) {
        this.f42810d = str;
    }
}
