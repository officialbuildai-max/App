package kotlin.sequences;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "", "startIndex", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "n", "a", "(I)Lkotlin/sequences/Sequence;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "I", "c", "f", "()I", "count", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Sequence sequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int startIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int endIndex;

    public SubSequence(Sequence sequence, int i11, int i12) {
        Intrinsics.h(sequence, "sequence");
        this.sequence = sequence;
        this.startIndex = i11;
        this.endIndex = i12;
        if (i11 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i11).toString());
        }
        if (i12 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i12).toString());
        }
        if (i12 >= i11) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i12 + " < " + i11).toString());
    }

    private final int f() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence a(int n11) {
        return n11 >= f() ? SequencesKt__SequencesKt.g() : new SubSequence(this.sequence, this.startIndex + n11, this.endIndex);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence b(int n11) {
        if (n11 >= f()) {
            return this;
        }
        Sequence sequence = this.sequence;
        int i11 = this.startIndex;
        return new SubSequence(sequence, i11, n11 + i11);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new SubSequence$iterator$1(this);
    }
}
