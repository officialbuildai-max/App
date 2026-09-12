package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class s implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12070a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12071b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12072c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f12073a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12074b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12075c;

        /* renamed from: d, reason: collision with root package name */
        public final String f12076d;

        /* renamed from: e, reason: collision with root package name */
        public final String f12077e;

        /* renamed from: f, reason: collision with root package name */
        public final String f12078f;

        public a(int i11, int i12, String str, String str2, String str3, String str4) {
            this.f12073a = i11;
            this.f12074b = i12;
            this.f12075c = str;
            this.f12076d = str2;
            this.f12077e = str3;
            this.f12078f = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12073a == aVar.f12073a && this.f12074b == aVar.f12074b && TextUtils.equals(this.f12075c, aVar.f12075c) && TextUtils.equals(this.f12076d, aVar.f12076d) && TextUtils.equals(this.f12077e, aVar.f12077e) && TextUtils.equals(this.f12078f, aVar.f12078f);
        }

        public int hashCode() {
            int i11 = ((this.f12073a * 31) + this.f12074b) * 31;
            String str = this.f12075c;
            int hashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f12076d;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f12077e;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f12078f;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public s(String str, String str2, List list) {
        this.f12070a = str;
        this.f12071b = str2;
        this.f12072c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return TextUtils.equals(this.f12070a, sVar.f12070a) && TextUtils.equals(this.f12071b, sVar.f12071b) && this.f12072c.equals(sVar.f12072c);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ androidx.media3.common.r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        String str = this.f12070a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12071b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f12072c.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HlsTrackMetadataEntry");
        if (this.f12070a != null) {
            str = " [" + this.f12070a + ", " + this.f12071b + "]";
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }
}
