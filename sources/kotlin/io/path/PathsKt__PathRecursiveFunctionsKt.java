package kotlin.io.path;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
class PathsKt__PathRecursiveFunctionsKt extends p {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f67380a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f67381b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f67380a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f67381b = iArr2;
        }
    }

    public static final void a(Path path) {
        Intrinsics.h(path, "<this>");
        String b11 = t.b(path);
        int hashCode = b11.hashCode();
        if (hashCode != 46) {
            if (hashCode != 1518) {
                if (hashCode != 45679) {
                    if (hashCode != 45724) {
                        if (hashCode != 1472) {
                            if (hashCode != 1473 || !b11.equals("./")) {
                                return;
                            }
                        } else if (!b11.equals("..")) {
                            return;
                        }
                    } else if (!b11.equals("..\\")) {
                        return;
                    }
                } else if (!b11.equals("../")) {
                    return;
                }
            } else if (!b11.equals(".\\")) {
                return;
            }
        } else if (!b11.equals(".")) {
            return;
        }
        throw new IllegalFileNameException(path);
    }
}
