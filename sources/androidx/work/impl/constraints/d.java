package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.impl.constraints.b;
import androidx.work.impl.constraints.d;
import androidx.work.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends ConnectivityManager.NetworkCallback {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15695b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f15696a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Ref.BooleanRef booleanRef, ConnectivityManager connectivityManager, d dVar) {
            String str;
            if (booleanRef.element) {
                t e11 = t.e();
                str = WorkConstraintsTrackerKt.f15671a;
                e11.a(str, "NetworkRequestConstraintController unregister callback");
                connectivityManager.unregisterNetworkCallback(dVar);
            }
            return Unit.f67184a;
        }

        public final Function0 b(final ConnectivityManager connManager, NetworkRequest networkRequest, Function1 onConstraintState) {
            String str;
            String str2;
            Intrinsics.h(connManager, "connManager");
            Intrinsics.h(networkRequest, "networkRequest");
            Intrinsics.h(onConstraintState, "onConstraintState");
            final d dVar = new d(onConstraintState, null);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            try {
                t e11 = t.e();
                str2 = WorkConstraintsTrackerKt.f15671a;
                e11.a(str2, "NetworkRequestConstraintController register callback");
                connManager.registerNetworkCallback(networkRequest, dVar);
                booleanRef.element = true;
            } catch (RuntimeException e12) {
                String name = e12.getClass().getName();
                Intrinsics.g(name, "getName(...)");
                if (!StringsKt.G(name, "TooManyRequestsException", false, 2, null)) {
                    throw e12;
                }
                t e13 = t.e();
                str = WorkConstraintsTrackerKt.f15671a;
                e13.b(str, "NetworkRequestConstraintController couldn't register callback", e12);
                onConstraintState.invoke(new b.C0142b(7));
            }
            return new Function0() { // from class: androidx.work.impl.constraints.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit c11;
                    c11 = d.a.c(Ref.BooleanRef.this, connManager, dVar);
                    return c11;
                }
            };
        }
    }

    private d(Function1 function1) {
        this.f15696a = function1;
    }

    public /* synthetic */ d(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        t e11 = t.e();
        str = WorkConstraintsTrackerKt.f15671a;
        e11.a(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.f15696a.invoke(b.a.f15674a);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        Intrinsics.h(network, "network");
        t e11 = t.e();
        str = WorkConstraintsTrackerKt.f15671a;
        e11.a(str, "NetworkRequestConstraintController onLost callback");
        this.f15696a.invoke(new b.C0142b(7));
    }
}
