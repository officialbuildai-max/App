package qo;

import androidx.collection.s;
import androidx.compose.foundation.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements n6.a {

    /* renamed from: a, reason: collision with root package name */
    private String f73782a;

    /* renamed from: b, reason: collision with root package name */
    private int f73783b;

    /* renamed from: c, reason: collision with root package name */
    private int f73784c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73785d;

    /* renamed from: e, reason: collision with root package name */
    private long f73786e;

    /* renamed from: f, reason: collision with root package name */
    private String f73787f;

    /* renamed from: g, reason: collision with root package name */
    private int f73788g;

    public a(String str, int i11, int i12, boolean z10, long j11, String str2, int i13) {
        this.f73782a = str;
        this.f73783b = i11;
        this.f73784c = i12;
        this.f73785d = z10;
        this.f73786e = j11;
        this.f73787f = str2;
        this.f73788g = i13;
    }

    public final String a() {
        return this.f73782a;
    }

    public final int b() {
        return this.f73784c;
    }

    public final int c() {
        return this.f73788g;
    }

    public final String d() {
        return this.f73787f;
    }

    public final int e() {
        return this.f73783b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f73782a, aVar.f73782a) && this.f73783b == aVar.f73783b && this.f73784c == aVar.f73784c && this.f73785d == aVar.f73785d && this.f73786e == aVar.f73786e && Intrinsics.c(this.f73787f, aVar.f73787f) && this.f73788g == aVar.f73788g;
    }

    public final boolean f() {
        return this.f73785d;
    }

    public final void g(boolean z10) {
        this.f73785d = z10;
    }

    @Override // n6.a
    public int getItemType() {
        return 2;
    }

    public int hashCode() {
        String str = this.f73782a;
        int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + this.f73783b) * 31) + this.f73784c) * 31) + e.a(this.f73785d)) * 31) + s.a(this.f73786e)) * 31;
        String str2 = this.f73787f;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f73788g;
    }

    public String toString() {
        return "CommentSubLoadMoreBean(commentId=" + this.f73782a + ", subCount=" + this.f73783b + ", currentCount=" + this.f73784c + ", isLoading=" + this.f73785d + ", createTime=" + this.f73786e + ", postId=" + this.f73787f + ", nextPage=" + this.f73788g + ")";
    }
}
