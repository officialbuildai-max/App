package kotlin.internal;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.time.Clock;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "", "cause", "exception", "", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Lkotlin/random/Random;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lkotlin/random/Random;", "Lkotlin/time/Clock;", "c", "()Lkotlin/time/Clock;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public class PlatformImplementations {

    /* loaded from: classes7.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f67315a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f67316b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f67317c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics.e(methods);
            int length = methods.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                method = null;
                if (i12 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i12];
                if (Intrinsics.c(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.g(parameterTypes, "getParameterTypes(...)");
                    if (Intrinsics.c(ArraysKt.A0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i12++;
            }
            f67316b = method2;
            int length2 = methods.length;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                Method method3 = methods[i11];
                if (Intrinsics.c(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i11++;
            }
            f67317c = method;
        }

        private a() {
        }
    }

    public void a(Throwable cause, Throwable exception) {
        Intrinsics.h(cause, "cause");
        Intrinsics.h(exception, "exception");
        Method method = a.f67316b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new FallbackThreadLocalRandom();
    }

    public Clock c() {
        throw new UnsupportedOperationException("getSystemClock should not be called on the base PlatformImplementations.");
    }
}
