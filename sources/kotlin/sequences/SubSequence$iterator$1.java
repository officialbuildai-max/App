package kotlin.sequences;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "", "a", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "getPosition", "()I", "setPosition", "(I)V", RequestParameters.POSITION, "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Iterator iterator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SubSequence f67573c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubSequence$iterator$1(SubSequence subSequence) {
        Sequence sequence;
        this.f67573c = subSequence;
        sequence = subSequence.sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a() {
        /*
            r2 = this;
        L0:
            int r0 = r2.position
            kotlin.sequences.SubSequence r1 = r2.f67573c
            int r1 = kotlin.sequences.SubSequence.e(r1)
            if (r0 >= r1) goto L1e
            java.util.Iterator r0 = r2.iterator
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L1e
            java.util.Iterator r0 = r2.iterator
            r0.next()
            int r0 = r2.position
            int r0 = r0 + 1
            r2.position = r0
            goto L0
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SubSequence$iterator$1.a():void");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i11;
        a();
        int i12 = this.position;
        i11 = this.f67573c.endIndex;
        return i12 < i11 && this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        int i11;
        a();
        int i12 = this.position;
        i11 = this.f67573c.endIndex;
        if (i12 >= i11) {
            throw new NoSuchElementException();
        }
        this.position++;
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
