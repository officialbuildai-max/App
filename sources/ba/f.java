package ba;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class f implements com.google.android.exoplayer2.k {

    /* renamed from: b, reason: collision with root package name */
    public static final f f16367b = new f(ImmutableList.of());

    /* renamed from: c, reason: collision with root package name */
    public static final k.a f16368c = new k.a() { // from class: ba.e
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            f c11;
            c11 = f.c(bundle);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f16369a;

    public f(List list) {
        this.f16369a = ImmutableList.copyOf((Collection) list);
    }

    private static ImmutableList b(List list) {
        ImmutableList.a builder = ImmutableList.builder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (((b) list.get(i11)).f16336d == null) {
                builder.a((b) list.get(i11));
            }
        }
        return builder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new f(parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(b.f16332s, parcelableArrayList));
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(b(this.f16369a)));
        return bundle;
    }
}
