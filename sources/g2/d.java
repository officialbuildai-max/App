package g2;

import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class d implements f0 {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f63324a;

    /* renamed from: b, reason: collision with root package name */
    private long f63325b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements f0 {

        /* renamed from: a, reason: collision with root package name */
        private final f0 f63326a;

        /* renamed from: b, reason: collision with root package name */
        private final ImmutableList f63327b;

        public a(f0 f0Var, List list) {
            this.f63326a = f0Var;
            this.f63327b = ImmutableList.copyOf((Collection) list);
        }

        @Override // androidx.media3.exoplayer.source.f0
        public boolean a(v2 v2Var) {
            return this.f63326a.a(v2Var);
        }

        public ImmutableList c() {
            return this.f63327b;
        }

        @Override // androidx.media3.exoplayer.source.f0
        public long getBufferedPositionUs() {
            return this.f63326a.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public long getNextLoadPositionUs() {
            return this.f63326a.getNextLoadPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public boolean isLoading() {
            return this.f63326a.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.f0
        public void reevaluateBuffer(long j11) {
            this.f63326a.reevaluateBuffer(j11);
        }
    }

    public d(List list, List list2) {
        ImmutableList.a builder = ImmutableList.builder();
        androidx.media3.common.util.a.a(list.size() == list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            builder.a(new a((f0) list.get(i11), (List) list2.get(i11)));
        }
        this.f63324a = builder.e();
        this.f63325b = C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        boolean z10;
        boolean z11 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z10 = false;
            for (int i11 = 0; i11 < this.f63324a.size(); i11++) {
                long nextLoadPositionUs2 = ((a) this.f63324a.get(i11)).getNextLoadPositionUs();
                boolean z12 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= v2Var.f13132a;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z12) {
                    z10 |= ((a) this.f63324a.get(i11)).a(v2Var);
                }
            }
            z11 |= z10;
        } while (z10);
        return z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        long j11 = Long.MAX_VALUE;
        long j12 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f63324a.size(); i11++) {
            a aVar = (a) this.f63324a.get(i11);
            long bufferedPositionUs = aVar.getBufferedPositionUs();
            if ((aVar.c().contains(1) || aVar.c().contains(2) || aVar.c().contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                j11 = Math.min(j11, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j12 = Math.min(j12, bufferedPositionUs);
            }
        }
        if (j11 != Long.MAX_VALUE) {
            this.f63325b = j11;
            return j11;
        }
        if (j12 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j13 = this.f63325b;
        return j13 != C.TIME_UNSET ? j13 : j12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f63324a.size(); i11++) {
            long nextLoadPositionUs = ((a) this.f63324a.get(i11)).getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j11 = Math.min(j11, nextLoadPositionUs);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        for (int i11 = 0; i11 < this.f63324a.size(); i11++) {
            if (((a) this.f63324a.get(i11)).isLoading()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        for (int i11 = 0; i11 < this.f63324a.size(); i11++) {
            ((a) this.f63324a.get(i11)).reevaluateBuffer(j11);
        }
    }
}
