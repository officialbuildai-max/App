package com.transsion.postdetail.shorttv_pugc.factory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h implements st.h {

    /* renamed from: a, reason: collision with root package name */
    private ShareDialogFragment f49357a;

    /* loaded from: classes6.dex */
    public static final class a implements com.transsion.share.share.a {
        a() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
        }

        @Override // com.transsion.share.share.a
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.h(url, "url");
            Intrinsics.h(fileName, "fileName");
            Intrinsics.h(fileSize, "fileSize");
            Intrinsics.h(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String id2) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0650a.c(this, str);
        }
    }

    private final ShareDialogFragment b(String str, String str2, String str3) {
        ShareDialogFragment a11;
        a11 = ShareDialogFragment.INSTANCE.a(PostType.UGC_SHORT_TV, str, "", ReportType.UFC_VIDEO.getValue(), (r29 & 16) != 0 ? "" : str2, (r29 & 32) != 0 ? "" : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, str3, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
        return a11;
    }

    @Override // st.h
    public void a(Fragment fragment, String str, String str2, String pageName) {
        ShareDialogFragment shareDialogFragment;
        Intrinsics.h(pageName, "pageName");
        if (this.f49357a == null) {
            if (str == null) {
                str = "";
            }
            ShareDialogFragment b11 = b(str, str2, pageName);
            this.f49357a = b11;
            if (b11 != null) {
                b11.G0(new a());
            }
        }
        if (fragment != null) {
            try {
                if (fragment.isAdded()) {
                    FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                    childFragmentManager.g0();
                    ShareDialogFragment shareDialogFragment2 = this.f49357a;
                    if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.f49357a) != null) {
                        shareDialogFragment.show(childFragmentManager, "share");
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
