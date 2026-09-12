package com.transsion.fission;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.tn.lib.net.bean.BaseDto;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import xk.a;

/* loaded from: classes5.dex */
public final class f extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f44196a = LazyKt.b(new Function0() { // from class: com.transsion.fission.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xk.a f11;
            f11 = f.f();
            return f11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f44197b = new b0();

    /* loaded from: classes5.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            b0 b0Var = f.this.f44197b;
            if (str2 == null) {
                str2 = "";
            }
            if (str == null) {
                str = "";
            }
            b0Var.q(new BaseDto(str2, str, null, ""));
        }

        @Override // sg.a
        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
            super.d(baseDto);
            f.this.f44197b.q(baseDto);
        }
    }

    private final xk.a d() {
        return (xk.a) this.f44196a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xk.a f() {
        return (xk.a) zg.c.f79537e.a().h(xk.a.class);
    }

    public final LiveData e() {
        return this.f44197b;
    }

    public final void g(String code) {
        io.reactivex.rxjava3.core.j a11;
        io.reactivex.rxjava3.core.j f11;
        Intrinsics.h(code, "code");
        String str = "{\"inviteCode\": \"" + code + "\"}";
        xk.a d11 = d();
        if (d11 == null || (a11 = a.C0989a.a(d11, null, RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json")), 1, null)) == null || (f11 = a11.f(sg.d.f75472a.c())) == null) {
            return;
        }
        f11.subscribe(new a());
    }
}
