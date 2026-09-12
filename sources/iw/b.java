package iw;

import com.blankj.utilcode.util.o;
import com.tencent.mmkv.MMKV;
import com.transsion.usercenter.devicemanagement.model.UpgradeRightsDto;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f65783a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f65784b = LazyKt.b(new Function0() { // from class: iw.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV e11;
            e11 = b.e();
            return e11;
        }
    });

    private b() {
    }

    private final String b(String str) {
        if (str == null || StringsKt.q0(str)) {
            return null;
        }
        return "upgrade_rights_" + str + "_" + Locale.getDefault().toLanguageTag();
    }

    private final MMKV d() {
        return (MMKV) f65784b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        MMKV I = MMKV.I("device_management_upgrade_rights");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final UpgradeRightsDto c(String str) {
        String string;
        Object m1185constructorimpl;
        String b11 = b(str);
        if (b11 == null || (string = d().getString(b11, null)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl((UpgradeRightsDto) o.d(string, UpgradeRightsDto.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (UpgradeRightsDto) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    public final void f(String str, UpgradeRightsDto rights) {
        Intrinsics.h(rights, "rights");
        String b11 = b(str);
        if (b11 == null) {
            return;
        }
        d().putString(b11, o.j(rights));
    }
}
