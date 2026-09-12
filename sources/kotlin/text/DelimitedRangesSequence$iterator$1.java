package kotlin.text;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u0006#"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "", "a", "()V", "c", "()Lkotlin/ranges/IntRange;", "", "hasNext", "()Z", "", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", "d", "Lkotlin/ranges/IntRange;", "getNextItem", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextItem", "e", "getCounter", "setCounter", "counter", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int nextState = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentStartIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int nextSearchIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IntRange nextItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int counter;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ DelimitedRangesSequence f67625f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i11;
        CharSequence charSequence;
        this.f67625f = delimitedRangesSequence;
        i11 = delimitedRangesSequence.f67617b;
        charSequence = delimitedRangesSequence.f67616a;
        int m11 = RangesKt.m(i11, 0, charSequence.length());
        this.currentStartIndex = m11;
        this.nextSearchIndex = m11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r0 < r4) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a() {
        /*
            r6 = this;
            int r0 = r6.nextSearchIndex
            r1 = 0
            if (r0 >= 0) goto Lc
            r6.nextState = r1
            r0 = 0
            r6.nextItem = r0
            goto L9e
        Lc:
            kotlin.text.DelimitedRangesSequence r0 = r6.f67625f
            int r0 = kotlin.text.DelimitedRangesSequence.e(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L23
            int r0 = r6.counter
            int r0 = r0 + r3
            r6.counter = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.f67625f
            int r4 = kotlin.text.DelimitedRangesSequence.e(r4)
            if (r0 >= r4) goto L31
        L23:
            int r0 = r6.nextSearchIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f67625f
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L47
        L31:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f67625f
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
            int r4 = kotlin.text.StringsKt.i0(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L9c
        L47:
            kotlin.text.DelimitedRangesSequence r0 = r6.f67625f
            kotlin.jvm.functions.Function2 r0 = kotlin.text.DelimitedRangesSequence.c(r0)
            kotlin.text.DelimitedRangesSequence r4 = r6.f67625f
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
            int r5 = r6.nextSearchIndex
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L77
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f67625f
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.d(r4)
            int r4 = kotlin.text.StringsKt.i0(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L9c
        L77:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.currentStartIndex
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.t(r4, r2)
            r6.nextItem = r4
            int r2 = r2 + r0
            r6.currentStartIndex = r2
            if (r0 != 0) goto L99
            r1 = r3
        L99:
            int r2 = r2 + r1
            r6.nextSearchIndex = r2
        L9c:
            r6.nextState = r3
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
    }

    @Override // java.util.Iterator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public IntRange next() {
        if (this.nextState == -1) {
            a();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.nextItem;
        Intrinsics.f(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            a();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
