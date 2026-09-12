package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class g extends CrashlyticsReport.d.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f31572a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f31573b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.d.b.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31574a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f31575b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b a() {
            byte[] bArr;
            String str = this.f31574a;
            if (str != null && (bArr = this.f31575b) != null) {
                return new g(str, bArr);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31574a == null) {
                sb2.append(" filename");
            }
            if (this.f31575b == null) {
                sb2.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f31575b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f31574a = str;
            return this;
        }
    }

    private g(String str, byte[] bArr) {
        this.f31572a = str;
        this.f31573b = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b
    public byte[] b() {
        return this.f31573b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b
    public String c() {
        return this.f31572a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.b)) {
            return false;
        }
        CrashlyticsReport.d.b bVar = (CrashlyticsReport.d.b) obj;
        if (this.f31572a.equals(bVar.c())) {
            if (Arrays.equals(this.f31573b, bVar instanceof g ? ((g) bVar).f31573b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f31572a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f31573b);
    }

    public String toString() {
        return "File{filename=" + this.f31572a + ", contents=" + Arrays.toString(this.f31573b) + "}";
    }
}
