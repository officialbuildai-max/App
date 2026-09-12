package com.transsion.member;

import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class ObserveLoginAction implements dz.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f46454c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f46455d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final ObserveLoginAction f46456e = new ObserveLoginAction();

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f46457a = LazyKt.b(new Function0() { // from class: com.transsion.member.w0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi k11;
            k11 = ObserveLoginAction.k();
            return k11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f46458b = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ObserveLoginAction a() {
            return ObserveLoginAction.f46456e;
        }
    }

    private ObserveLoginAction() {
    }

    private final native void f();

    private final native String g();

    private final native ILoginApi h();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native ILoginApi k();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit l(ObserveLoginAction observeLoginAction);

    private final native void m();

    public final native void e(zm.e eVar);

    public final native void i();

    public final native void j();

    public final native void n(zm.e eVar);

    @Override // dz.a
    public native void onLogin(UserInfo userInfo);

    @Override // dz.a
    public native void onLogout();

    @Override // dz.a
    public native void onUpdateUserInfo(UserInfo userInfo);
}
