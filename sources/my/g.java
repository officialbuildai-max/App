package my;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f70169a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70170b;

    /* renamed from: c, reason: collision with root package name */
    private final long f70171c;

    public g(String videoId, String collectionId, long j11) {
        Intrinsics.h(videoId, "videoId");
        Intrinsics.h(collectionId, "collectionId");
        this.f70169a = videoId;
        this.f70170b = collectionId;
        this.f70171c = j11;
    }

    public final String a() {
        return this.f70170b;
    }

    public final long b() {
        return this.f70171c;
    }

    public final String c() {
        return this.f70169a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.c(this.f70169a, gVar.f70169a) && Intrinsics.c(this.f70170b, gVar.f70170b) && this.f70171c == gVar.f70171c;
    }

    public int hashCode() {
        return (((this.f70169a.hashCode() * 31) + this.f70170b.hashCode()) * 31) + s.a(this.f70171c);
    }

    public String toString() {
        return "UGCPlayRecordEvent(videoId=" + this.f70169a + ", collectionId=" + this.f70170b + ", progress=" + this.f70171c + ")";
    }
}
