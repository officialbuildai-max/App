package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\b¨\u0006\n"}, d2 = {"", "collection", "", "", "a", "(Ljava/util/Collection;)[Ljava/lang/Object;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "[Ljava/lang/Object;", "EMPTY", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class CollectionToArray {

    /* renamed from: a, reason: collision with root package name */
    private static final Object[] f67401a = new Object[0];

    public static final Object[] a(Collection collection) {
        Intrinsics.h(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    objArr[i11] = it.next();
                    if (i12 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i13 = ((i12 * 3) + 1) >>> 1;
                        if (i13 <= i12) {
                            i13 = 2147483645;
                            if (i12 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i13);
                        Intrinsics.g(objArr, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i12);
                        Intrinsics.g(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i11 = i12;
                }
            }
        }
        return f67401a;
    }

    public static final Object[] b(Collection collection, Object[] objArr) {
        Object[] objArr2;
        Intrinsics.h(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i11 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            Intrinsics.f(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i12 = i11 + 1;
            objArr2[i11] = it.next();
            if (i12 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i13 = ((i12 * 3) + 1) >>> 1;
                if (i13 <= i12) {
                    i13 = 2147483645;
                    if (i12 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i13);
                Intrinsics.g(objArr2, "copyOf(...)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i12] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i12);
                Intrinsics.g(copyOf, "copyOf(...)");
                return copyOf;
            }
            i11 = i12;
        }
    }
}
