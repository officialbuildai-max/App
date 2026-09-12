package t9;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class x implements com.google.android.exoplayer2.k {

    /* renamed from: d, reason: collision with root package name */
    public static final x f76286d = new x(new TrackGroup[0]);

    /* renamed from: e, reason: collision with root package name */
    public static final k.a f76287e = new k.a() { // from class: t9.w
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            x e11;
            e11 = x.e(bundle);
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f76288a;

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableList f76289b;

    /* renamed from: c, reason: collision with root package name */
    private int f76290c;

    public x(TrackGroup... trackGroupArr) {
        this.f76289b = ImmutableList.copyOf(trackGroupArr);
        this.f76288a = trackGroupArr.length;
        f();
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return parcelableArrayList == null ? new x(new TrackGroup[0]) : new x((TrackGroup[]) com.google.android.exoplayer2.util.d.b(TrackGroup.f25726f, parcelableArrayList).toArray(new TrackGroup[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        int i11 = 0;
        while (i11 < this.f76289b.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f76289b.size(); i13++) {
                if (((TrackGroup) this.f76289b.get(i11)).equals(this.f76289b.get(i13))) {
                    com.google.android.exoplayer2.util.s.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrackGroup b(int i11) {
        return (TrackGroup) this.f76289b.get(i11);
    }

    public int c(TrackGroup trackGroup) {
        int indexOf = this.f76289b.indexOf(trackGroup);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.f76288a == xVar.f76288a && this.f76289b.equals(xVar.f76289b);
    }

    public int hashCode() {
        if (this.f76290c == 0) {
            this.f76290c = this.f76289b.hashCode();
        }
        return this.f76290c;
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(this.f76289b));
        return bundle;
    }
}
