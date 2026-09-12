package kotlin.internal;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import v6.f;
import wz.b;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a'\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0004\u001a'\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\u0004\u001a'\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0003\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlin/UInt;", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "(III)I", "Lkotlin/ULong;", "(JJJ)J", "start", TtmlNode.END, "", "step", "d", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class UProgressionUtilKt {
    private static final int a(int i11, int i12, int i13) {
        int compare;
        int a11 = b.a(i11, i13);
        int a12 = b.a(i12, i13);
        compare = Integer.compare(a11 ^ Integer.MIN_VALUE, a12 ^ Integer.MIN_VALUE);
        int b11 = UInt.b(a11 - a12);
        return compare >= 0 ? b11 : UInt.b(b11 + i13);
    }

    private static final long b(long j11, long j12, long j13) {
        int compare;
        long a11 = f.a(j11, j13);
        long a12 = f.a(j12, j13);
        compare = Long.compare(a11 ^ Long.MIN_VALUE, a12 ^ Long.MIN_VALUE);
        long b11 = ULong.b(a11 - a12);
        return compare >= 0 ? b11 : ULong.b(b11 + j13);
    }

    public static final long c(long j11, long j12, long j13) {
        int compare;
        int compare2;
        if (j13 > 0) {
            compare2 = Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j12 : ULong.b(j12 - b(j12, j11, ULong.b(j13)));
        }
        if (j13 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        compare = Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
        return compare <= 0 ? j12 : ULong.b(j12 + b(j11, j12, ULong.b(-j13)));
    }

    public static final int d(int i11, int i12, int i13) {
        int compare;
        int compare2;
        if (i13 > 0) {
            compare2 = Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
            return compare2 >= 0 ? i12 : UInt.b(i12 - a(i12, i11, UInt.b(i13)));
        }
        if (i13 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        compare = Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
        return compare <= 0 ? i12 : UInt.b(i12 + a(i11, i12, UInt.b(-i13)));
    }
}
