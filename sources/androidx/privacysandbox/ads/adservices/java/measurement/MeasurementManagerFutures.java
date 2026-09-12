package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.y0;
import w3.n;
import w3.o;
import w3.p;

/* loaded from: classes2.dex */
public abstract class MeasurementManagerFutures {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14102a = new a(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {

        /* renamed from: b, reason: collision with root package name */
        private final n f14103b;

        public Api33Ext5JavaImpl(n mMeasurementManager) {
            Intrinsics.h(mMeasurementManager, "mMeasurementManager");
            this.f14103b = mMeasurementManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public r b() {
            r0 b11;
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public r c(Uri trigger) {
            r0 b11;
            Intrinsics.h(trigger, "trigger");
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }

        public r e(w3.a deletionRequest) {
            r0 b11;
            Intrinsics.h(deletionRequest, "deletionRequest");
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }

        public r f(Uri attributionSource, InputEvent inputEvent) {
            r0 b11;
            Intrinsics.h(attributionSource, "attributionSource");
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }

        public r g(o request) {
            r0 b11;
            Intrinsics.h(request, "request");
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, request, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }

        public r h(p request) {
            r0 b11;
            Intrinsics.h(request, "request");
            b11 = k.b(o0.a(y0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, request, null), 3, null);
            return CoroutineAdapterKt.c(b11, null, 1, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MeasurementManagerFutures a(Context context) {
            Intrinsics.h(context, "context");
            n a11 = n.f77684a.a(context);
            if (a11 != null) {
                return new Api33Ext5JavaImpl(a11);
            }
            return null;
        }
    }

    public static final MeasurementManagerFutures a(Context context) {
        return f14102a.a(context);
    }

    public abstract r b();

    public abstract r c(Uri uri);
}
