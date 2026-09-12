package xw;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f78571b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f78572c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f78571b = LazyKt.b(new Function0() { // from class: xw.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 e11;
                e11 = c.e();
                return e11;
            }
        });
        this.f78572c = LazyKt.b(new Function0() { // from class: xw.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi h11;
                h11 = c.h();
                return h11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 e() {
        return new b0();
    }

    private final b0 g() {
        return (b0) this.f78571b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi h() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    public final LiveData f() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        super.onCleared();
    }
}
