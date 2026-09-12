package ti;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f76383a = new i();

    private i() {
    }

    public static /* synthetic */ void b(i iVar, FragmentManager fragmentManager, int i11, Fragment fragment, boolean z10, String str, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i12 & 16) != 0) {
            str = fragment.getClass().getSimpleName();
        }
        iVar.a(fragmentManager, i11, fragment, z11, str);
    }

    private final void c(FragmentManager fragmentManager, w wVar) {
        if (fragmentManager.T0() || fragmentManager.L0()) {
            return;
        }
        try {
            wVar.j();
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        }
    }

    public final void a(FragmentManager fragmentManager, int i11, Fragment fragment, boolean z10, String str) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        Intrinsics.h(fragment, "fragment");
        if (fragmentManager.T0() || fragmentManager.L0()) {
            return;
        }
        Fragment k02 = str != null ? fragmentManager.k0(str) : null;
        if (k02 == null || !k02.isAdded()) {
            w p11 = fragmentManager.p();
            Intrinsics.g(p11, "beginTransaction(...)");
            p11.t(i11, fragment, str);
            if (z10) {
                p11.g(str);
            }
            c(fragmentManager, p11);
        }
    }
}
