package com.transsion.edcation.history;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.edcation.R$string;
import com.transsion.home.p004enum.BottomTabType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import p6.f;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lcom/transsion/edcation/history/EducationHistoryFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lvk/b;", "<init>", "()V", "Landroid/view/View;", "j0", "()Landroid/view/View;", "", "isRefresh", "", "Lcom/transsion/baselib/db/video/VideoDetailPlayBean;", "i0", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/LayoutInflater;", "inflater", "m0", "(Landroid/view/LayoutInflater;)Lvk/b;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onResume", "Lcom/transsion/edcation/history/EducationHistoryAdapter;", "a", "Lcom/transsion/edcation/history/EducationHistoryAdapter;", "mAdapter", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "l0", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "mVideoDetailPlayDao", "", "c", "I", "mOffset", "d", "mLimit", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class EducationHistoryFragment extends BaseFragment<vk.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private EducationHistoryAdapter mAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mOffset;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mVideoDetailPlayDao = LazyKt.b(new Function0() { // from class: com.transsion.edcation.history.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao o02;
            o02 = EducationHistoryFragment.o0();
            return o02;
        }
    });

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLimit = 10;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i0(boolean r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsion.edcation.history.EducationHistoryFragment$fetchHistory$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.edcation.history.EducationHistoryFragment$fetchHistory$1 r0 = (com.transsion.edcation.history.EducationHistoryFragment$fetchHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.edcation.history.EducationHistoryFragment$fetchHistory$1 r0 = new com.transsion.edcation.history.EducationHistoryFragment$fetchHistory$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.b(r8)
            goto L50
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.b(r8)
            if (r7 == 0) goto L39
            r6.mOffset = r3
        L39:
            com.transsion.baselib.db.video.VideoDetailPlayDao r7 = r6.l0()
            int r8 = r6.mOffset
            int r2 = r6.mLimit
            com.transsion.moviedetailapi.SubjectType r5 = com.transsion.moviedetailapi.SubjectType.EDUCATION
            int r5 = r5.getValue()
            r0.label = r4
            java.lang.Object r8 = r7.i(r8, r2, r5, r0)
            if (r8 != r1) goto L50
            return r1
        L50:
            java.util.List r8 = (java.util.List) r8
            int r7 = r6.mOffset
            if (r8 == 0) goto L5a
            int r3 = r8.size()
        L5a:
            int r7 = r7 + r3
            r6.mOffset = r7
            if (r8 != 0) goto L64
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L64:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.edcation.history.EducationHistoryFragment.i0(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View j0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        String string = getString(R$string.course_list_empy);
        Intrinsics.g(string, "getString(...)");
        stateView.showData(4, 1, false, "", string);
        String string2 = getString(R$string.course_explore_now);
        Intrinsics.g(string2, "getString(...)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0() { // from class: com.transsion.edcation.history.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k02;
                k02 = EducationHistoryFragment.k0(EducationHistoryFragment.this);
                return k02;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(EducationHistoryFragment educationHistoryFragment) {
        Navigator.x(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_HOME).K("topTab", "Education"), educationHistoryFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final VideoDetailPlayDao l0() {
        return (VideoDetailPlayDao) this.mVideoDetailPlayDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(EducationHistoryFragment educationHistoryFragment) {
        k.d(v.a(educationHistoryFragment), null, null, new EducationHistoryFragment$initView$1$1$1(educationHistoryFragment, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao o0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        vk.b mViewBinding = getMViewBinding();
        RecyclerView recyclerView = mViewBinding != null ? mViewBinding.f77464b : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        EducationHistoryAdapter educationHistoryAdapter = new EducationHistoryAdapter(new ArrayList());
        this.mAdapter = educationHistoryAdapter;
        if (recyclerView != null) {
            recyclerView.setAdapter(educationHistoryAdapter);
        }
        EducationHistoryAdapter educationHistoryAdapter2 = this.mAdapter;
        if (educationHistoryAdapter2 != null) {
            educationHistoryAdapter2.h0().z(true);
            educationHistoryAdapter2.h0().z(true);
            educationHistoryAdapter2.h0().y(true);
            educationHistoryAdapter2.h0().D(new f() { // from class: com.transsion.edcation.history.e
                @Override // p6.f
                public final void a() {
                    EducationHistoryFragment.n0(EducationHistoryFragment.this);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        k.d(v.a(this), null, null, new EducationHistoryFragment$lazyLoadData$1(this, null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public vk.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vk.b c11 = vk.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k.d(v.a(this), null, null, new EducationHistoryFragment$onResume$1(this, null), 3, null);
    }
}
