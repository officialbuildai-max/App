package sg;

import android.util.Log;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.exception.ApiException;
import com.tn.lib.net.exception.ServerException;
import io.reactivex.rxjava3.core.o;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes3.dex */
public abstract class a implements o {

    /* renamed from: b, reason: collision with root package name */
    public static final C0943a f75469b = new C0943a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f75470c = "0";

    /* renamed from: a, reason: collision with root package name */
    private final String f75471a = "TNBaseObserver";

    /* renamed from: sg.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0943a {
        private C0943a() {
        }

        public /* synthetic */ C0943a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract void a(String str, String str2);

    @Override // io.reactivex.rxjava3.core.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onNext(BaseDto t11) {
        Intrinsics.h(t11, "t");
        if (Intrinsics.c(t11.getCode(), f75470c)) {
            a.C0856a.f(lg.a.f68962a, this.f75471a, "onNext: data=" + t11.getData(), false, 4, null);
            c(t11.getData());
            d(t11);
            return;
        }
        a.C0856a.f(lg.a.f68962a, this.f75471a, "onNext: Server errorInfo=" + t11.getData(), false, 4, null);
        try {
            a(wg.a.f77794a.a(new ServerException(t11.getCode(), t11.getMsg())).getErrCode(), t11.getMsg());
            Unit unit = Unit.f67184a;
        } catch (Exception e11) {
            Log.e(this.f75471a, "onNext Exception " + e11.getMessage());
        }
    }

    public void c(Object obj) {
    }

    public void d(BaseDto baseDto) {
        Intrinsics.h(baseDto, "baseDto");
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        a.C0856a.f(lg.a.f68962a, this.f75471a, "onComplete", false, 4, null);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable e11) {
        Intrinsics.h(e11, "e");
        try {
            ApiException a11 = wg.a.f77794a.a(e11);
            a.C0856a.f(lg.a.f68962a, this.f75471a, "onError: errorInfo=" + e11, false, 4, null);
            a(a11.getErrCode(), a11.getErrMsg());
        } catch (Exception e12) {
            Log.e(this.f75471a, "onError Exception " + e12.getMessage());
            a("", e12.getMessage());
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
        Intrinsics.h(d11, "d");
        a.C0856a.f(lg.a.f68962a, this.f75471a, "Disposable=" + d11.isDisposed(), false, 4, null);
    }
}
