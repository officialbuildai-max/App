package zv;

import com.transsion.upgradesdk.net.j;
import com.transsion.upgradesdk.net.k;
import com.transsion.upgradesdk.net.l;
import com.transsion.upgradesdk.net.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.k0;

/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f79606a = LazyKt.b(k.f56724a);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f79607b = LazyKt.b(j.f56723a);

    /* renamed from: c, reason: collision with root package name */
    public static final OkHttpClient f79608c = new OkHttpClient.Builder().addInterceptor(new a()).build();

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f79609d = LazyKt.b(m.f56726a);

    /* renamed from: e, reason: collision with root package name */
    public static final Lazy f79610e = LazyKt.b(l.f56725a);

    public static k0 a() {
        Object value = f79610e.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (k0) value;
    }

    public static k0 b() {
        Object value = f79609d.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (k0) value;
    }
}
