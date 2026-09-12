package kw;

import com.transsion.usercenter.edit.api.RequstUserEntity;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import sg.d;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f68520a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f68521b = LazyKt.b(new Function0() { // from class: kw.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a c11;
            c11 = c.c();
            return c11;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: kw.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0845a extends sg.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.transsion.usercenter.edit.a f68522d;

            C0845a(com.transsion.usercenter.edit.a aVar) {
                this.f68522d = aVar;
            }

            @Override // sg.a
            public void a(String str, String str2) {
                c.f68520a.g(str, str2);
                com.transsion.usercenter.edit.a aVar = this.f68522d;
                if (aVar != null) {
                    aVar.a(str, str2);
                }
            }

            @Override // sg.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(String str) {
                this.f68522d.b(str, false, "");
            }
        }

        /* loaded from: classes7.dex */
        public static final class b extends sg.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.transsion.usercenter.edit.a f68523d;

            b(com.transsion.usercenter.edit.a aVar) {
                this.f68523d = aVar;
            }

            @Override // sg.a
            public void a(String str, String str2) {
                c.f68520a.g(str, str2);
                com.transsion.usercenter.edit.a aVar = this.f68523d;
                if (aVar != null) {
                    aVar.a(str, str2);
                }
            }

            @Override // sg.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(UserInfo userInfo) {
                this.f68523d.b(userInfo, false, "");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final RequestBody c(String str) {
            return RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json"));
        }

        private final kw.a d() {
            return (kw.a) c.f68521b.getValue();
        }

        private final String f(Object obj) {
            return String.valueOf(ow.a.f72312a.a(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(String str, String str2) {
            a.C0856a.f(lg.a.f68962a, "ApiServer", "onFailure code=" + str + " message=" + str2, false, 4, null);
        }

        public final void b(RequstUserEntity entity, com.transsion.usercenter.edit.a callback) {
            Intrinsics.h(entity, "entity");
            Intrinsics.h(callback, "callback");
            d().b(vg.a.f77447a.a(), c(f(entity))).f(d.f75472a.c()).subscribe(new C0845a(callback));
        }

        public final void e(com.transsion.usercenter.edit.a callback) {
            Intrinsics.h(callback, "callback");
            d().a(vg.a.f77447a.a()).f(d.f75472a.c()).subscribe(new b(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kw.a c() {
        return (kw.a) zg.c.f79537e.a().h(kw.a.class);
    }
}
