package dz;

import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: dz.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0761a {
        public static void a(a aVar, UserInfo user) {
            Intrinsics.h(user, "user");
        }

        public static void b(a aVar) {
        }

        public static void c(a aVar, UserInfo user) {
            Intrinsics.h(user, "user");
        }
    }

    void onLogin(UserInfo userInfo);

    void onLogout();

    void onUpdateUserInfo(UserInfo userInfo);
}
