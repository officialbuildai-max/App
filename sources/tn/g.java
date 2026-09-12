package tn;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.api.IStreamDetailService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f76445a;

    /* renamed from: b, reason: collision with root package name */
    private final int f76446b;

    /* renamed from: c, reason: collision with root package name */
    private final Subject f76447c;

    /* renamed from: d, reason: collision with root package name */
    private final String f76448d;

    /* renamed from: e, reason: collision with root package name */
    private final String f76449e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f76450f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f76451g;

    public g(Fragment fragment, int i11, Subject subject, String pageName, String str, boolean z10, boolean z11) {
        Fragment b11;
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(pageName, "pageName");
        this.f76445a = fragment;
        this.f76446b = i11;
        this.f76447c = subject;
        this.f76448d = pageName;
        this.f76449e = str;
        this.f76450f = z10;
        this.f76451g = z11;
        if (!fragment.isAdded() || fragment.isDetached() || fragment.isRemoving()) {
            return;
        }
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        w p11 = childFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        IStreamDetailService iStreamDetailService = (IStreamDetailService) TheRouter.d(IStreamDetailService.class, new Object[0]);
        if (iStreamDetailService != null && (b11 = iStreamDetailService.b(subject, pageName, str, z10, z11)) != null) {
            p11.s(i11, b11);
        }
        p11.j();
    }

    public /* synthetic */ g(Fragment fragment, int i11, Subject subject, String str, String str2, boolean z10, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, i11, subject, str, str2, (i12 & 32) != 0 ? false : z10, (i12 & 64) != 0 ? false : z11);
    }
}
