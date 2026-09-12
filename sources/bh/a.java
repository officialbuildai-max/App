package bh;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0156a f16551a = new C0156a(null);

    /* renamed from: b, reason: collision with root package name */
    private static MMKV f16552b = mh.a.f69688a.a();

    /* renamed from: bh.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0156a {
        private C0156a() {
        }

        public /* synthetic */ C0156a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String string;
            MMKV c11 = c();
            return (c11 == null || (string = c11.getString("install_ch", "")) == null) ? "" : string;
        }

        public final String b() {
            String string;
            MMKV c11 = c();
            return (c11 == null || (string = c11.getString("install_id", "")) == null) ? "" : string;
        }

        public final MMKV c() {
            return a.f16552b;
        }

        public final String d() {
            String string;
            MMKV c11 = c();
            return (c11 == null || (string = c11.getString("install_share_uid", "")) == null) ? "" : string;
        }

        public final void e(String v11) {
            Intrinsics.h(v11, "v");
            MMKV c11 = c();
            if (c11 != null) {
                c11.putString("install_ch", v11);
            }
        }

        public final void f(String v11) {
            Intrinsics.h(v11, "v");
            MMKV c11 = c();
            if (c11 != null) {
                c11.putString("install_id", v11);
            }
        }

        public final void g(String uid) {
            Intrinsics.h(uid, "uid");
            MMKV c11 = c();
            if (c11 != null) {
                c11.putString("install_share_uid", uid);
            }
        }

        public final void h(String userId) {
            Intrinsics.h(userId, "userId");
            MMKV c11 = c();
            if (c11 != null) {
                c11.putString("myuserid", userId);
            }
        }
    }
}
