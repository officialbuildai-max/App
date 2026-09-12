package okio.internal;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.C1017SegmentedByteString;
import okio.Segment;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\bø\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", EventConstants.KEY_ACTION, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k = 2, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
@SourceDebugExtension
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes7.dex */
public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i11, int i12, int i13) {
        Intrinsics.h(iArr, "<this>");
        int i14 = i13 - 1;
        while (i12 <= i14) {
            int i15 = (i12 + i14) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i11) {
                i12 = i15 + 1;
            } else {
                if (i16 <= i11) {
                    return i15;
                }
                i14 = i15 - 1;
            }
        }
        return (-i12) - 1;
    }

    public static final void commonCopyInto(C1017SegmentedByteString c1017SegmentedByteString, int i11, byte[] target, int i12, int i13) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        Intrinsics.h(target, "target");
        long j11 = i13;
        okio.SegmentedByteString.checkOffsetAndCount(c1017SegmentedByteString.size(), i11, j11);
        okio.SegmentedByteString.checkOffsetAndCount(target.length, i12, j11);
        int i14 = i13 + i11;
        int segment = segment(c1017SegmentedByteString, i11);
        while (i11 < i14) {
            int i15 = segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1];
            int i16 = c1017SegmentedByteString.getDirectory()[segment] - i15;
            int i17 = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment];
            int min = Math.min(i14, i16 + i15) - i11;
            int i18 = i17 + (i11 - i15);
            ArraysKt.j(c1017SegmentedByteString.getSegments()[segment], target, i12, i18, i18 + min);
            i12 += min;
            i11 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(C1017SegmentedByteString c1017SegmentedByteString, Object obj) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        if (obj == c1017SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c1017SegmentedByteString.size() && c1017SegmentedByteString.rangeEquals(0, byteString, 0, c1017SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(C1017SegmentedByteString c1017SegmentedByteString) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        return c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(C1017SegmentedByteString c1017SegmentedByteString) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        int hashCode = c1017SegmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = c1017SegmentedByteString.getSegments().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = c1017SegmentedByteString.getDirectory()[length + i11];
            int i15 = c1017SegmentedByteString.getDirectory()[i11];
            byte[] bArr = c1017SegmentedByteString.getSegments()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        c1017SegmentedByteString.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(C1017SegmentedByteString c1017SegmentedByteString, int i11) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length - 1], i11, 1L);
        int segment = segment(c1017SegmentedByteString, i11);
        return c1017SegmentedByteString.getSegments()[segment][(i11 - (segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1])) + c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment]];
    }

    public static final boolean commonRangeEquals(C1017SegmentedByteString c1017SegmentedByteString, int i11, ByteString other, int i12, int i13) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        Intrinsics.h(other, "other");
        if (i11 < 0 || i11 > c1017SegmentedByteString.size() - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int segment = segment(c1017SegmentedByteString, i11);
        while (i11 < i14) {
            int i15 = segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1];
            int i16 = c1017SegmentedByteString.getDirectory()[segment] - i15;
            int i17 = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment];
            int min = Math.min(i14, i16 + i15) - i11;
            if (!other.rangeEquals(i12, c1017SegmentedByteString.getSegments()[segment], i17 + (i11 - i15), min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    public static final boolean commonRangeEquals(C1017SegmentedByteString c1017SegmentedByteString, int i11, byte[] other, int i12, int i13) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        Intrinsics.h(other, "other");
        if (i11 < 0 || i11 > c1017SegmentedByteString.size() - i13 || i12 < 0 || i12 > other.length - i13) {
            return false;
        }
        int i14 = i13 + i11;
        int segment = segment(c1017SegmentedByteString, i11);
        while (i11 < i14) {
            int i15 = segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1];
            int i16 = c1017SegmentedByteString.getDirectory()[segment] - i15;
            int i17 = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment];
            int min = Math.min(i14, i16 + i15) - i11;
            if (!okio.SegmentedByteString.arrayRangeEquals(c1017SegmentedByteString.getSegments()[segment], i17 + (i11 - i15), other, i12, min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(C1017SegmentedByteString c1017SegmentedByteString, int i11, int i12) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c1017SegmentedByteString, i12);
        if (i11 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
        if (resolveDefaultParameter > c1017SegmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + c1017SegmentedByteString.size() + ')').toString());
        }
        int i13 = resolveDefaultParameter - i11;
        if (i13 < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i11).toString());
        }
        if (i11 == 0 && resolveDefaultParameter == c1017SegmentedByteString.size()) {
            return c1017SegmentedByteString;
        }
        if (i11 == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int segment = segment(c1017SegmentedByteString, i11);
        int segment2 = segment(c1017SegmentedByteString, resolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) ArraysKt.t(c1017SegmentedByteString.getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i14 = segment;
            int i15 = 0;
            while (true) {
                iArr[i15] = Math.min(c1017SegmentedByteString.getDirectory()[i14] - i11, i13);
                int i16 = i15 + 1;
                iArr[i15 + bArr.length] = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + i14];
                if (i14 == segment2) {
                    break;
                }
                i14++;
                i15 = i16;
            }
        }
        int i17 = segment != 0 ? c1017SegmentedByteString.getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i11 - i17);
        return new C1017SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(C1017SegmentedByteString c1017SegmentedByteString) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        byte[] bArr = new byte[c1017SegmentedByteString.size()];
        int length = c1017SegmentedByteString.getSegments().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = c1017SegmentedByteString.getDirectory()[length + i11];
            int i15 = c1017SegmentedByteString.getDirectory()[i11];
            int i16 = i15 - i12;
            ArraysKt.j(c1017SegmentedByteString.getSegments()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    public static final void commonWrite(C1017SegmentedByteString c1017SegmentedByteString, Buffer buffer, int i11, int i12) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        Intrinsics.h(buffer, "buffer");
        int i13 = i11 + i12;
        int segment = segment(c1017SegmentedByteString, i11);
        while (i11 < i13) {
            int i14 = segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1];
            int i15 = c1017SegmentedByteString.getDirectory()[segment] - i14;
            int i16 = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i11;
            int i17 = i16 + (i11 - i14);
            Segment segment2 = new Segment(c1017SegmentedByteString.getSegments()[segment], i17, i17 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.e(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.e(segment4);
                segment4.push(segment2);
            }
            i11 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i12);
    }

    private static final void forEachSegment(C1017SegmentedByteString c1017SegmentedByteString, int i11, int i12, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(c1017SegmentedByteString, i11);
        while (i11 < i12) {
            int i13 = segment == 0 ? 0 : c1017SegmentedByteString.getDirectory()[segment - 1];
            int i14 = c1017SegmentedByteString.getDirectory()[segment] - i13;
            int i15 = c1017SegmentedByteString.getDirectory()[c1017SegmentedByteString.getSegments().length + segment];
            int min = Math.min(i12, i14 + i13) - i11;
            function3.invoke(c1017SegmentedByteString.getSegments()[segment], Integer.valueOf(i15 + (i11 - i13)), Integer.valueOf(min));
            i11 += min;
            segment++;
        }
    }

    public static final void forEachSegment(C1017SegmentedByteString c1017SegmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        Intrinsics.h(action, "action");
        int length = c1017SegmentedByteString.getSegments().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = c1017SegmentedByteString.getDirectory()[length + i11];
            int i14 = c1017SegmentedByteString.getDirectory()[i11];
            action.invoke(c1017SegmentedByteString.getSegments()[i11], Integer.valueOf(i13), Integer.valueOf(i14 - i12));
            i11++;
            i12 = i14;
        }
    }

    public static final int segment(C1017SegmentedByteString c1017SegmentedByteString, int i11) {
        Intrinsics.h(c1017SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c1017SegmentedByteString.getDirectory(), i11 + 1, 0, c1017SegmentedByteString.getSegments().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }
}
