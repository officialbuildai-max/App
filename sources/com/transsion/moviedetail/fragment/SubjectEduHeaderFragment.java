package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectEduInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010 R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010 R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010 R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/transsion/moviedetail/fragment/SubjectEduHeaderFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lcn/q;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "i0", "(Landroid/view/View;)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", "j0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Landroid/view/LayoutInflater;", "inflater", "e0", "(Landroid/view/LayoutInflater;)Lcn/q;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "initData", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "a", "Lkotlin/Lazy;", "d0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "TAG", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "d", "ops", "e", "mSubjectId", "f", "pageName", "", be.g.f16474b, "I", "curSeason", "h", "moduleName", "", "i", "Z", "isInterceptDetail", "Lcom/transsion/moviedetail/view/HeaderExtensionFragment;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/moviedetail/view/HeaderExtensionFragment;", "headerExtensionFragment", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SubjectEduHeaderFragment extends BaseFragment<cn.q> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mSubjectId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInterceptDetail;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HeaderExtensionFragment headerExtensionFragment;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "SubjectEduHeaderFragment";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String pageName = "subjectdetail";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* loaded from: classes5.dex */
    static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f47139a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f47139a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f47139a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f47139a.invoke(obj);
        }
    }

    private final MovieDetailViewModel d0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(SubjectEduHeaderFragment subjectEduHeaderFragment, Pair pair) {
        Subject subject = (Subject) pair.getSecond();
        lg.a.f68962a.c(subjectEduHeaderFragment.TAG, "get movie detail data==" + pair, true);
        if (subject != null && subjectEduHeaderFragment.mMovieDetailBean == null) {
            subjectEduHeaderFragment.j0(subject);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(SubjectEduHeaderFragment subjectEduHeaderFragment, Integer num) {
        Intrinsics.e(num);
        subjectEduHeaderFragment.curSeason = num.intValue();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(SubjectEduHeaderFragment subjectEduHeaderFragment, View view) {
        Intrinsics.e(view);
        subjectEduHeaderFragment.i0(view);
    }

    private final void i0(View view) {
        if (this.isInterceptDetail || com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        a.C0856a.g(lg.a.f68962a, "Open the right to view more detail", false, 2, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            SubjectEduInfoMoreDetailDialog subjectEduInfoMoreDetailDialog = new SubjectEduInfoMoreDetailDialog();
            subjectEduInfoMoreDetailDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("data_key_resource_detectors", this.mMovieDetailBean)));
            subjectEduInfoMoreDetailDialog.n0(parentFragment, R$id.fl_bottom_dialog_container);
        }
    }

    private final void j0(Subject movieDetailBean) {
        Subject subject;
        AppCompatTextView appCompatTextView;
        FrameLayout frameLayout;
        cn.q mViewBinding;
        CustomTextViewGroup customTextViewGroup;
        cn.q mViewBinding2;
        CustomTextViewGroup customTextViewGroup2;
        cn.q mViewBinding3;
        CustomTextViewGroup customTextViewGroup3;
        cn.q mViewBinding4;
        CustomTextViewGroup customTextViewGroup4;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        HashMap g11;
        HashMap g12;
        this.mMovieDetailBean = movieDetailBean;
        String ops = movieDetailBean != null ? movieDetailBean.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.n(this.ops);
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g12 = logViewConfig3.g()) != null) {
            String subjectId = movieDetailBean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            g12.put("subject_id", subjectId);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g11 = logViewConfig4.g()) != null) {
            g11.put("has_resource", String.valueOf(movieDetailBean.getHasResource()));
        }
        cn.q mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatTextView4 = mViewBinding5.f17541j) != null) {
            appCompatTextView4.setText(movieDetailBean.getTitle());
        }
        String description = movieDetailBean.getDescription();
        if (description == null || description.length() <= 0) {
            cn.q mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (appCompatTextView = mViewBinding6.f17537f) != null) {
                jg.c.g(appCompatTextView);
            }
        } else {
            cn.q mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (appCompatTextView3 = mViewBinding7.f17537f) != null) {
                appCompatTextView3.setText(movieDetailBean.getDescription());
            }
            cn.q mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (appCompatTextView2 = mViewBinding8.f17537f) != null) {
                jg.c.k(appCompatTextView2);
            }
        }
        int a11 = com.transsion.moviedetailapi.g.a(movieDetailBean.getSubjectType());
        cn.q mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (appCompatImageView = mViewBinding9.f17534c) != null) {
            appCompatImageView.setImageResource(a11);
        }
        String category = movieDetailBean.getCategory();
        if (category != null && (mViewBinding4 = getMViewBinding()) != null && (customTextViewGroup4 = mViewBinding4.f17536e) != null) {
            customTextViewGroup4.setText(category);
        }
        String genre = movieDetailBean.getGenre();
        if (genre != null && (mViewBinding3 = getMViewBinding()) != null && (customTextViewGroup3 = mViewBinding3.f17539h) != null) {
            customTextViewGroup3.setText(genre);
        }
        String a12 = defpackage.a.a(this.mMovieDetailBean);
        if (a12 != null && (mViewBinding2 = getMViewBinding()) != null && (customTextViewGroup2 = mViewBinding2.f17538g) != null) {
            customTextViewGroup2.setText(a12);
        }
        Context context = getContext();
        if (context != null) {
            int i11 = R$string.movie_detail_students;
            Long viewers = movieDetailBean.getViewers();
            String string = context.getString(i11, Long.valueOf(viewers != null ? viewers.longValue() : 0L));
            if (string != null && (mViewBinding = getMViewBinding()) != null && (customTextViewGroup = mViewBinding.f17542k) != null) {
                customTextViewGroup.setText(string);
            }
        }
        if (this.isInterceptDetail) {
            cn.q mViewBinding10 = getMViewBinding();
            if (mViewBinding10 == null || (frameLayout = mViewBinding10.f17533b) == null) {
                return;
            }
            jg.c.g(frameLayout);
            return;
        }
        if (this.headerExtensionFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            bundle.putString("module_name", this.moduleName);
            bundle.putInt("season", this.curSeason);
            bundle.putString("ops", this.ops);
            bundle.putString(WebConstants.PAGE_FROM, this.pageName);
            headerExtensionFragment.setArguments(bundle);
            p11.s(R$id.extension_container, headerExtensionFragment);
            this.headerExtensionFragment = headerExtensionFragment;
            p11.j();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public cn.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        cn.q c11 = cn.q.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        String str;
        View view2;
        cn.q mViewBinding;
        AppCompatTextView appCompatTextView;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.mMovieDetailBean = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.ops = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.isInterceptDetail = arguments3 != null ? arguments3.getBoolean("is_Intercept_detail") : false;
        Bundle arguments4 = getArguments();
        this.mSubjectId = arguments4 != null ? arguments4.getString("id") : null;
        Bundle arguments5 = getArguments();
        this.moduleName = arguments5 != null ? arguments5.getString("module_name") : null;
        Bundle arguments6 = getArguments();
        this.curSeason = arguments6 != null ? arguments6.getInt("season") : 1;
        Bundle arguments7 = getArguments();
        this.ops = arguments7 != null ? arguments7.getString("ops") : null;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (str = arguments8.getString(WebConstants.PAGE_FROM)) == null) {
            str = "subjectdetail";
        }
        this.pageName = str;
        Subject subject = this.mMovieDetailBean;
        if (subject != null) {
            Intrinsics.e(subject);
            j0(subject);
        }
        if (this.isInterceptDetail && (mViewBinding = getMViewBinding()) != null && (appCompatTextView = mViewBinding.f17541j) != null) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        MovieDetailViewModel d02 = d0();
        d02.F().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.fragment.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f02;
                f02 = SubjectEduHeaderFragment.f0(SubjectEduHeaderFragment.this, (Pair) obj);
                return f02;
            }
        }));
        d02.K().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.fragment.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g02;
                g02 = SubjectEduHeaderFragment.g0(SubjectEduHeaderFragment.this, (Integer) obj);
                return g02;
            }
        }));
        cn.q mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (view2 = mViewBinding2.f17543l) == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubjectEduHeaderFragment.h0(SubjectEduHeaderFragment.this, view3);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
