package com.transsion.search.fragment.group;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.publish.api.GroupBean;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.PagerEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.dialog.CheckTipsDialog;
import com.transsion.search.fragment.group.SearchUploadGroupFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import nh.n;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0005J5\u0010\u001d\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\u0011\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010H\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/transsion/search/fragment/group/SearchUploadGroupFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lrq/d;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", "", "clear", "", "resetContent", "(Z)V", "postFinsh", "Lcom/transsion/publish/api/GroupBean;", "groupBean", "postGroup", "(Lcom/transsion/publish/api/GroupBean;)V", "searchJob", "initViewModel", "Landroid/view/View;", "emptyView", "()Landroid/view/View;", "clearTipsDialog", "showCheckDialog", "", "group_id", "subject_id", "opt", "", RequestParameters.POSITION, "reportClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lrq/d;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "lazyLoadData", "onDestroyView", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "isRefreshing", "Z", "Lcom/transsion/search/fragment/group/adapter/a;", "mSearchGroupAdapter", "Lcom/transsion/search/fragment/group/adapter/a;", "Lcom/transsion/search/fragment/group/adapter/b;", "mSearchKeywordAdapter", "Lcom/transsion/search/fragment/group/adapter/b;", "Lcom/transsion/search/adapter/b;", "mSearchWorkAdapter", "Lcom/transsion/search/adapter/b;", "", "mHistoryList", "Ljava/util/List;", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mSearchViewModel", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mType", "I", "page", "perPage", "mKeyword", "Ljava/lang/String;", "selectGroup", "Lcom/transsion/publish/api/GroupBean;", "Lcom/transsion/search/dialog/CheckTipsDialog;", "mCheckTipsDialog$delegate", "Lkotlin/Lazy;", "getMCheckTipsDialog", "()Lcom/transsion/search/dialog/CheckTipsDialog;", "mCheckTipsDialog", "Companion", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchUploadGroupFragment extends BaseFragment<rq.d> implements TRDialogListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isRefreshing;
    private com.transsion.search.fragment.group.adapter.a mSearchGroupAdapter;
    private com.transsion.search.fragment.group.adapter.b mSearchKeywordAdapter;
    private SearchViewModel mSearchViewModel;
    private com.transsion.search.adapter.b mSearchWorkAdapter;
    private int mType;
    private GroupBean selectGroup;
    private List<String> mHistoryList = new ArrayList();
    private int page = 1;
    private int perPage = 10;
    private String mKeyword = "";

    /* renamed from: mCheckTipsDialog$delegate, reason: from kotlin metadata */
    private final Lazy mCheckTipsDialog = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.group.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            CheckTipsDialog mCheckTipsDialog_delegate$lambda$0;
            mCheckTipsDialog_delegate$lambda$0 = SearchUploadGroupFragment.mCheckTipsDialog_delegate$lambda$0();
            return mCheckTipsDialog_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.search.fragment.group.SearchUploadGroupFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchUploadGroupFragment a(int i11) {
            SearchUploadGroupFragment searchUploadGroupFragment = new SearchUploadGroupFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
            searchUploadGroupFragment.setArguments(bundle);
            return searchUploadGroupFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements nh.n {
        b() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            r6.f h02;
            r6.f h03;
            List<Object> data;
            List<Object> data2;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            com.transsion.search.adapter.b bVar = SearchUploadGroupFragment.this.mSearchWorkAdapter;
            if (bVar == null || (data2 = bVar.getData()) == null || !data2.isEmpty()) {
                com.transsion.search.adapter.b bVar2 = SearchUploadGroupFragment.this.mSearchWorkAdapter;
                if (bVar2 != null && (h02 = bVar2.h0()) != null) {
                    h02.w();
                }
            } else {
                SearchUploadGroupFragment.this.searchJob();
            }
            com.transsion.search.fragment.group.adapter.a aVar = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar != null && (data = aVar.getData()) != null && data.isEmpty()) {
                SearchUploadGroupFragment.this.searchJob();
                return;
            }
            com.transsion.search.fragment.group.adapter.a aVar2 = SearchUploadGroupFragment.this.mSearchGroupAdapter;
            if (aVar2 == null || (h03 = aVar2.h0()) == null) {
                return;
            }
            h03.w();
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(textView != null ? textView.getText() : null);
            SearchUploadGroupFragment.this.searchJob();
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements sq.a {
        d() {
        }

        @Override // sq.a
        public void a() {
            String groupId;
            SearchViewModel searchViewModel;
            GroupBean groupBean = SearchUploadGroupFragment.this.selectGroup;
            if (groupBean == null || (groupId = groupBean.getGroupId()) == null || (searchViewModel = SearchUploadGroupFragment.this.mSearchViewModel) == null) {
                return;
            }
            searchViewModel.y(groupId);
        }

        @Override // sq.a
        public void b() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends RecyclerView.r {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            FragmentActivity activity;
            rq.d mViewBinding;
            EditText editText;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 1 || (activity = SearchUploadGroupFragment.this.getActivity()) == null) {
                return;
            }
            SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
            if (!KeyboardUtils.g(activity) || (mViewBinding = searchUploadGroupFragment.getMViewBinding()) == null || (editText = mViewBinding.f74746b) == null) {
                return;
            }
            KeyboardUtils.e(editText);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements com.transsion.search.a {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(List list, SearchUploadGroupFragment searchUploadGroupFragment) {
            RelativeLayout relativeLayout;
            List list2 = list;
            if (list2.isEmpty()) {
                rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
                if (mViewBinding == null || (relativeLayout = mViewBinding.f74751g) == null) {
                    return;
                }
                relativeLayout.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            CollectionsKt.Y(arrayList);
            searchUploadGroupFragment.mHistoryList = arrayList;
            com.transsion.search.fragment.group.adapter.b bVar = searchUploadGroupFragment.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.q1(arrayList);
            }
        }

        @Override // com.transsion.search.a
        public void a(final List list) {
            Intrinsics.h(list, "list");
            FragmentActivity activity = SearchUploadGroupFragment.this.getActivity();
            if (activity != null) {
                final SearchUploadGroupFragment searchUploadGroupFragment = SearchUploadGroupFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.transsion.search.fragment.group.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchUploadGroupFragment.f.c(list, searchUploadGroupFragment);
                    }
                });
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppCompatImageView appCompatImageView;
            AppCompatImageView appCompatImageView2;
            if ((editable != null ? editable.length() : 0) > 0) {
                rq.d mViewBinding = SearchUploadGroupFragment.this.getMViewBinding();
                if (mViewBinding != null && (appCompatImageView2 = mViewBinding.f74748d) != null) {
                    appCompatImageView2.setVisibility(0);
                }
            } else {
                rq.d mViewBinding2 = SearchUploadGroupFragment.this.getMViewBinding();
                if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f74748d) != null) {
                    appCompatImageView.setVisibility(8);
                }
                SearchUploadGroupFragment.this.resetContent(true);
            }
            SearchUploadGroupFragment.this.mKeyword = String.valueOf(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextView textView;
            rq.d mViewBinding = SearchUploadGroupFragment.this.getMViewBinding();
            if (mViewBinding == null || (textView = mViewBinding.f74754j) == null) {
                return;
            }
            jg.c.k(textView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class h implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52061a;

        h(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52061a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52061a;
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
            this.f52061a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.search_clear_title);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a k11 = aVar.k(string);
            String string2 = getString(R$string.search_clear_des);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a g11 = k11.g(string2);
            String string3 = getString(R$string.search_clear_cancel);
            Intrinsics.g(string3, "getString(...)");
            TRDialog.a e11 = g11.e(string3);
            String string4 = getString(R$string.search_clear_clear);
            Intrinsics.g(string4, "getString(...)");
            e11.j(string4).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.base_color_black)).f(this).a().d0(this, "clear_tips");
        } catch (Exception unused) {
        }
    }

    private final View emptyView() {
        EditText editText;
        Editable editable = null;
        View inflate = getLayoutInflater().inflate(R$layout.view_search_manager_empty, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R$id.tv_retry);
        if (nh.m.f70597a.e()) {
            rq.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74746b) != null) {
                editable = editText.getText();
            }
            String valueOf = String.valueOf(editable);
            textView.setText(getString(R$string.user_works_empty) + " \"" + valueOf + "\"");
            appCompatTextView.setVisibility(8);
            imageView.setImageResource(R$mipmap.ic_no_content);
        } else {
            textView.setText(com.transsion.baseui.R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchUploadGroupFragment.this.searchJob();
                }
            });
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    private final CheckTipsDialog getMCheckTipsDialog() {
        return (CheckTipsDialog) this.mCheckTipsDialog.getValue();
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        SearchViewModel searchViewModel = (SearchViewModel) new v0(requireActivity).a(SearchViewModel.class);
        searchViewModel.o().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$24;
                initViewModel$lambda$28$lambda$24 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$24(SearchUploadGroupFragment.this, (SearchGroupEntity) obj);
                return initViewModel$lambda$28$lambda$24;
            }
        }));
        searchViewModel.q().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$26;
                initViewModel$lambda$28$lambda$26 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$26(SearchUploadGroupFragment.this, (SearchWorkEntity) obj);
                return initViewModel$lambda$28$lambda$26;
            }
        }));
        searchViewModel.m().j(getViewLifecycleOwner(), new h(new Function1() { // from class: com.transsion.search.fragment.group.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$28$lambda$27;
                initViewModel$lambda$28$lambda$27 = SearchUploadGroupFragment.initViewModel$lambda$28$lambda$27(SearchUploadGroupFragment.this, (String) obj);
                return initViewModel$lambda$28$lambda$27;
            }
        }));
        this.mSearchViewModel = searchViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$24(SearchUploadGroupFragment searchUploadGroupFragment, SearchGroupEntity searchGroupEntity) {
        List<Object> data;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
        RecyclerView recyclerView2;
        ProgressBar progressBar;
        PagerEntity pager;
        PagerEntity pager2;
        String nextPage;
        Integer v11;
        PagerEntity pager3;
        RecyclerView.Adapter adapter = null;
        List<GroupBean> items = searchGroupEntity != null ? searchGroupEntity.getItems() : null;
        boolean hasMore = (searchGroupEntity == null || (pager3 = searchGroupEntity.getPager()) == null) ? false : pager3.getHasMore();
        searchUploadGroupFragment.page = (searchGroupEntity == null || (pager2 = searchGroupEntity.getPager()) == null || (nextPage = pager2.getNextPage()) == null || (v11 = StringsKt.v(nextPage)) == null) ? 1 : v11.intValue();
        searchUploadGroupFragment.perPage = (searchGroupEntity == null || (pager = searchGroupEntity.getPager()) == null) ? 10 : pager.getPerPage();
        rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f74750f) != null) {
            jg.c.g(progressBar);
        }
        com.transsion.search.fragment.group.adapter.a aVar = searchUploadGroupFragment.mSearchGroupAdapter;
        if (aVar != null) {
            aVar.h0().s();
            List<GroupBean> list = items;
            if (list == null || list.isEmpty()) {
                com.transsion.search.fragment.group.adapter.a aVar2 = searchUploadGroupFragment.mSearchGroupAdapter;
                if (aVar2 != null) {
                    aVar2.q1(new ArrayList());
                }
                aVar.Y0(searchUploadGroupFragment.emptyView());
                aVar.z1(true);
            }
            rq.d mViewBinding2 = searchUploadGroupFragment.getMViewBinding();
            if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f74752h) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter instanceof com.transsion.search.fragment.group.adapter.b) {
                rq.d mViewBinding3 = searchUploadGroupFragment.getMViewBinding();
                if (mViewBinding3 != null && (relativeLayout = mViewBinding3.f74751g) != null) {
                    relativeLayout.setVisibility(8);
                }
                rq.d mViewBinding4 = searchUploadGroupFragment.getMViewBinding();
                if (mViewBinding4 != null && (recyclerView = mViewBinding4.f74752h) != null) {
                    recyclerView.setAdapter(searchUploadGroupFragment.mSearchGroupAdapter);
                }
            }
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : items) {
                    GroupBean groupBean = (GroupBean) obj;
                    com.transsion.search.fragment.group.adapter.a aVar3 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar3 != null && (data = aVar3.getData()) != null && !data.contains(groupBean)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    aVar.h0().t(false);
                } else if (searchUploadGroupFragment.isRefreshing) {
                    searchUploadGroupFragment.isRefreshing = false;
                    com.transsion.search.fragment.group.adapter.a aVar4 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar4 != null) {
                        aVar4.n1(arrayList);
                    }
                } else {
                    com.transsion.search.fragment.group.adapter.a aVar5 = searchUploadGroupFragment.mSearchGroupAdapter;
                    if (aVar5 != null) {
                        aVar5.q(arrayList);
                    }
                }
            }
            if (!hasMore) {
                aVar.h0().t(false);
            }
            if (searchGroupEntity == null) {
                aVar.h0().v();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$26(SearchUploadGroupFragment searchUploadGroupFragment, SearchWorkEntity searchWorkEntity) {
        Pager pager;
        HashMap g11;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout;
        RecyclerView recyclerView2;
        List<Object> data;
        ProgressBar progressBar;
        Pager pager2;
        Pager pager3;
        Pager pager4;
        RecyclerView.Adapter adapter = null;
        List<SearchSubject> items = searchWorkEntity != null ? searchWorkEntity.getItems() : null;
        boolean hasMore = (searchWorkEntity == null || (pager4 = searchWorkEntity.getPager()) == null) ? false : pager4.getHasMore();
        searchUploadGroupFragment.page = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
        searchUploadGroupFragment.perPage = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
        rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f74750f) != null) {
            jg.c.g(progressBar);
        }
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar != null) {
            bVar.h0().s();
            com.transsion.search.adapter.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
            Boolean valueOf = (bVar2 == null || (data = bVar2.getData()) == null) ? null : Boolean.valueOf(data.isEmpty());
            List<SearchSubject> list = items;
            if ((list == null || list.isEmpty()) && Intrinsics.c(valueOf, Boolean.TRUE) && (searchUploadGroupFragment.page == 1 || (searchWorkEntity != null && (pager = searchWorkEntity.getPager()) != null && pager.getPage() == 1))) {
                com.transsion.search.adapter.b bVar3 = searchUploadGroupFragment.mSearchWorkAdapter;
                if (bVar3 != null) {
                    bVar3.q1(new ArrayList());
                }
                bVar.Y0(searchUploadGroupFragment.emptyView());
                bVar.z1(true);
            }
            rq.d mViewBinding2 = searchUploadGroupFragment.getMViewBinding();
            if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f74752h) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter instanceof com.transsion.search.fragment.group.adapter.b) {
                rq.d mViewBinding3 = searchUploadGroupFragment.getMViewBinding();
                if (mViewBinding3 != null && (relativeLayout = mViewBinding3.f74751g) != null) {
                    relativeLayout.setVisibility(8);
                }
                rq.d mViewBinding4 = searchUploadGroupFragment.getMViewBinding();
                if (mViewBinding4 != null && (recyclerView = mViewBinding4.f74752h) != null) {
                    recyclerView.setAdapter(searchUploadGroupFragment.mSearchWorkAdapter);
                }
            }
            if (list == null || list.isEmpty()) {
                bVar.h0().t(false);
            } else {
                if (searchUploadGroupFragment.isRefreshing) {
                    searchUploadGroupFragment.isRefreshing = false;
                    com.transsion.search.adapter.b bVar4 = searchUploadGroupFragment.mSearchWorkAdapter;
                    if (bVar4 != null) {
                        bVar4.n1(list);
                    }
                } else {
                    com.transsion.search.adapter.b bVar5 = searchUploadGroupFragment.mSearchWorkAdapter;
                    if (bVar5 != null) {
                        bVar5.q(list);
                    }
                }
                hj.b logViewConfig = searchUploadGroupFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
                hj.b logViewConfig2 = searchUploadGroupFragment.getLogViewConfig();
                if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
                    g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(searchUploadGroupFragment.mType));
                }
            }
            if (!hasMore) {
                bVar.h0().t(false);
            }
            if (searchWorkEntity == null) {
                bVar.h0().v();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$28$lambda$27(SearchUploadGroupFragment searchUploadGroupFragment, String str) {
        if (!TextUtils.isEmpty(str) && searchUploadGroupFragment.selectGroup != null) {
            searchUploadGroupFragment.postFinsh();
            searchUploadGroupFragment.postGroup(searchUploadGroupFragment.selectGroup);
            FragmentActivity activity = searchUploadGroupFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
            return Unit.f67184a;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CheckTipsDialog mCheckTipsDialog_delegate$lambda$0() {
        return CheckTipsDialog.INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$7(final SearchUploadGroupFragment searchUploadGroupFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            SearchViewModel searchViewModel = searchUploadGroupFragment.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.C(searchUploadGroupFragment.page, searchUploadGroupFragment.perPage, searchUploadGroupFragment.mKeyword);
                return;
            }
            return;
        }
        uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f74752h) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.a
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$10$lambda$7$lambda$6(SearchUploadGroupFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$7$lambda$6(SearchUploadGroupFragment searchUploadGroupFragment) {
        r6.f h02;
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar == null || (h02 = bVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(SearchUploadGroupFragment searchUploadGroupFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<Object> data;
        GroupBean groupBean;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        com.transsion.search.fragment.group.adapter.a aVar = searchUploadGroupFragment.mSearchGroupAdapter;
        if (aVar == null || (data = aVar.getData()) == null || (groupBean = (GroupBean) data.get(i11)) == null) {
            return;
        }
        searchUploadGroupFragment.selectGroup = groupBean;
        searchUploadGroupFragment.reportClick(groupBean.getGroupId(), "", groupBean.getOps(), i11);
        searchUploadGroupFragment.postFinsh();
        searchUploadGroupFragment.postGroup(searchUploadGroupFragment.selectGroup);
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        if (r2 != 3) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onViewCreated$lambda$14(com.transsion.search.fragment.group.SearchUploadGroupFragment r1, com.chad.library.adapter.base.BaseQuickAdapter r2, android.view.View r3, int r4) {
        /*
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.h(r2, r0)
            java.lang.String r2 = "view"
            kotlin.jvm.internal.Intrinsics.h(r3, r2)
            int r2 = r3.getId()
            int r3 = com.transsion.search.R$id.tv_keyword
            if (r2 != r3) goto L85
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L1b
            com.blankj.utilcode.util.KeyboardUtils.d(r2)
        L1b:
            com.transsion.search.fragment.group.adapter.b r2 = r1.mSearchKeywordAdapter
            if (r2 == 0) goto L26
            java.lang.Object r2 = r2.getItem(r4)
            java.lang.String r2 = (java.lang.String) r2
            goto L27
        L26:
            r2 = 0
        L27:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.mKeyword = r2
            g4.a r2 = r1.getMViewBinding()
            rq.d r2 = (rq.d) r2
            if (r2 == 0) goto L3e
            android.widget.EditText r2 = r2.f74746b
            if (r2 == 0) goto L3e
            java.lang.String r3 = r1.mKeyword
            r2.setText(r3)
        L3e:
            java.lang.String r2 = r1.mKeyword
            int r2 = r2.length()
            g4.a r3 = r1.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto L53
            android.widget.EditText r3 = r3.f74746b
            if (r3 == 0) goto L53
            r3.setSelection(r2)
        L53:
            g4.a r2 = r1.getMViewBinding()
            rq.d r2 = (rq.d) r2
            if (r2 == 0) goto L63
            android.widget.ProgressBar r2 = r2.f74750f
            if (r2 == 0) goto L63
            r3 = 0
            r2.setVisibility(r3)
        L63:
            int r2 = r1.mType
            r3 = 1
            if (r2 == r3) goto L75
            r4 = 2
            if (r2 == r4) goto L6f
            r4 = 3
            if (r2 == r4) goto L75
            goto L7a
        L6f:
            r1.page = r3
            r1.searchJob()
            goto L7a
        L75:
            r1.page = r3
            r1.searchJob()
        L7a:
            com.transsion.search.SearchManager$a r2 = com.transsion.search.SearchManager.f51995f
            com.transsion.search.SearchManager r2 = r2.a()
            java.lang.String r1 = r1.mKeyword
            r2.g(r1)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.group.SearchUploadGroupFragment.onViewCreated$lambda$14(com.transsion.search.fragment.group.SearchUploadGroupFragment, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$15(SearchUploadGroupFragment searchUploadGroupFragment, View view) {
        TextView textView;
        rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f74754j) == null) {
            return;
        }
        jg.c.k(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r3 != 3) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onViewCreated$lambda$16(com.transsion.search.fragment.group.SearchUploadGroupFragment r2, android.view.View r3, boolean r4) {
        /*
            r3.dispatchWindowFocusChanged(r4)
            if (r4 == 0) goto L67
            int r3 = r2.mType
            r4 = 0
            r0 = 1
            if (r3 == r0) goto L3d
            r1 = 2
            if (r3 == r1) goto L12
            r1 = 3
            if (r3 == r1) goto L3d
            goto L67
        L12:
            com.transsion.search.fragment.group.adapter.a r3 = r2.mSearchGroupAdapter
            if (r3 == 0) goto L67
            java.util.List r3 = r3.getData()
            if (r3 == 0) goto L67
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != r0) goto L67
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto L33
            android.widget.RelativeLayout r3 = r3.f74751g
            if (r3 == 0) goto L33
            r3.setVisibility(r4)
        L33:
            com.transsion.search.fragment.group.adapter.b r3 = r2.mSearchKeywordAdapter
            if (r3 == 0) goto L67
            java.util.List<java.lang.String> r4 = r2.mHistoryList
            r3.q1(r4)
            goto L67
        L3d:
            com.transsion.search.adapter.b r3 = r2.mSearchWorkAdapter
            if (r3 == 0) goto L67
            java.util.List r3 = r3.getData()
            if (r3 == 0) goto L67
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != r0) goto L67
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto L5e
            android.widget.RelativeLayout r3 = r3.f74751g
            if (r3 == 0) goto L5e
            r3.setVisibility(r4)
        L5e:
            com.transsion.search.fragment.group.adapter.b r3 = r2.mSearchKeywordAdapter
            if (r3 == 0) goto L67
            java.util.List<java.lang.String> r4 = r2.mHistoryList
            r3.q1(r4)
        L67:
            java.util.List<java.lang.String> r3 = r2.mHistoryList
            java.lang.String r3 = com.blankj.utilcode.util.o.j(r3)
            hj.b r2 = r2.getLogViewConfig()
            if (r2 == 0) goto L7e
            java.util.HashMap r2 = r2.g()
            if (r2 == 0) goto L7e
            java.lang.String r4 = "keyword"
            r2.put(r4, r3)
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.group.SearchUploadGroupFragment.onViewCreated$lambda$16(com.transsion.search.fragment.group.SearchUploadGroupFragment, android.view.View, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$19(SearchUploadGroupFragment searchUploadGroupFragment, View view) {
        searchUploadGroupFragment.postFinsh();
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2(final SearchUploadGroupFragment searchUploadGroupFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            SearchViewModel searchViewModel = searchUploadGroupFragment.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.D(searchUploadGroupFragment.page, searchUploadGroupFragment.perPage, searchUploadGroupFragment.mKeyword);
                return;
            }
            return;
        }
        uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        rq.d mViewBinding = searchUploadGroupFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f74752h) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.i
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadGroupFragment.onViewCreated$lambda$5$lambda$2$lambda$1(SearchUploadGroupFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2$lambda$1(SearchUploadGroupFragment searchUploadGroupFragment) {
        r6.f h02;
        com.transsion.search.adapter.b bVar = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar == null || (h02 = bVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4(SearchUploadGroupFragment searchUploadGroupFragment, com.transsion.search.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<Object> data;
        SearchSubject searchSubject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        com.transsion.search.adapter.b bVar2 = searchUploadGroupFragment.mSearchWorkAdapter;
        if (bVar2 == null || (data = bVar2.getData()) == null || (searchSubject = (SearchSubject) data.get(i11)) == null) {
            return;
        }
        searchUploadGroupFragment.reportClick("", searchSubject.getSubjectId(), searchSubject.getOps(), i11);
        if (searchUploadGroupFragment.mType == 3) {
            Integer subjectType = searchSubject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Navigator c11 = TheRouter.c("/movie/detail");
                Integer subjectType2 = searchSubject.getSubjectType();
                Navigator.x(c11.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", searchSubject.getSubjectId()).K("ops", searchSubject.getOps()), searchUploadGroupFragment.requireContext(), null, 2, null);
                return;
            } else {
                DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                Context context = bVar.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                a11.d0((FragmentActivity) context, "searchpage", (r22 & 4) != 0 ? "" : "", searchSubject.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : false, (r22 & 64) != 0 ? null : searchSubject, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        fp.a aVar = new fp.a();
        aVar.o(3);
        aVar.n(1);
        aVar.s(searchSubject);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = searchUploadGroupFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void postFinsh() {
        pq.a aVar = new pq.a();
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = pq.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    private final void postGroup(GroupBean groupBean) {
        fp.a aVar = new fp.a();
        aVar.o(6);
        aVar.n(1);
        aVar.m(groupBean);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    private final void reportClick(String group_id, String subject_id, String opt, int position) {
        HashMap hashMap = new HashMap();
        if (group_id == null) {
            group_id = "";
        }
        hashMap.put("group_id", group_id);
        if (subject_id == null) {
            subject_id = "";
        }
        hashMap.put("subject_id", subject_id);
        hashMap.put("sequence", String.valueOf(position));
        if (opt == null) {
            opt = "";
        }
        hashMap.put("ops", opt);
        com.transsion.baselib.helper.a.f43316a.f("searchresult", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r3 != 3) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resetContent(boolean r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L15
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            java.lang.String r0 = ""
            if (r3 == 0) goto L13
            android.widget.EditText r3 = r3.f74746b
            if (r3 == 0) goto L13
            r3.setText(r0)
        L13:
            r2.mKeyword = r0
        L15:
            int r3 = r2.mType
            r0 = 1
            if (r3 == r0) goto L36
            r0 = 2
            if (r3 == r0) goto L22
            r0 = 3
            if (r3 == r0) goto L36
            goto La2
        L22:
            com.transsion.search.fragment.group.adapter.a r3 = r2.mSearchGroupAdapter
            if (r3 == 0) goto L2e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.q1(r0)
        L2e:
            com.transsion.search.adapter.b r3 = r2.mSearchWorkAdapter
            if (r3 == 0) goto La2
            r3.H0()
            goto La2
        L36:
            com.transsion.search.adapter.b r3 = r2.mSearchWorkAdapter
            if (r3 == 0) goto L42
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.q1(r0)
        L42:
            com.transsion.search.adapter.b r3 = r2.mSearchWorkAdapter
            if (r3 == 0) goto L49
            r3.H0()
        L49:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.transsion.search.SearchManager$a r0 = com.transsion.search.SearchManager.f51995f
            com.transsion.search.SearchManager r0 = r0.a()
            java.util.List r0 = r0.l()
            java.util.Collection r0 = (java.util.Collection) r0
            r3.addAll(r0)
            kotlin.collections.CollectionsKt.Y(r3)
            r2.mHistoryList = r3
            com.transsion.search.fragment.group.adapter.b r0 = r2.mSearchKeywordAdapter
            if (r0 == 0) goto L69
            r0.q1(r3)
        L69:
            g4.a r0 = r2.getMViewBinding()
            rq.d r0 = (rq.d) r0
            if (r0 == 0) goto L7a
            androidx.recyclerview.widget.RecyclerView r0 = r0.f74752h
            if (r0 == 0) goto L7a
            com.transsion.search.fragment.group.adapter.b r1 = r2.mSearchKeywordAdapter
            r0.setAdapter(r1)
        L7a:
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L91
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto La2
            android.widget.RelativeLayout r3 = r3.f74751g
            if (r3 == 0) goto La2
            r0 = 0
            r3.setVisibility(r0)
            goto La2
        L91:
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto La2
            android.widget.RelativeLayout r3 = r3.f74751g
            if (r3 == 0) goto La2
            r0 = 8
            r3.setVisibility(r0)
        La2:
            g4.a r3 = r2.getMViewBinding()
            rq.d r3 = (rq.d) r3
            if (r3 == 0) goto Lb1
            android.widget.EditText r3 = r3.f74746b
            if (r3 == 0) goto Lb1
            com.blankj.utilcode.util.KeyboardUtils.i(r3)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.group.SearchUploadGroupFragment.resetContent(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r2 != 3) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void searchJob() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.group.SearchUploadGroupFragment.searchJob():void");
    }

    private final void showCheckDialog() {
        getMCheckTipsDialog().l0(this, "mCheckTipsDialog");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public rq.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rq.d c11 = rq.d.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        setNetListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b("searchpage", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProgressBar progressBar;
        rq.d mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f74750f) != null) {
            jg.c.g(progressBar);
        }
        super.onDestroyView();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        RelativeLayout relativeLayout;
        Intrinsics.h(dialog, "dialog");
        if (TextUtils.equals(dialog.getTag(), "clear_tips")) {
            SearchManager.f51995f.a().j();
            rq.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (relativeLayout = mViewBinding.f74751g) != null) {
                relativeLayout.setVisibility(8);
            }
            com.transsion.search.fragment.group.adapter.b bVar = this.mSearchKeywordAdapter;
            if (bVar != null) {
                bVar.q1(new ArrayList());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r5 != 3) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0217  */
    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.group.SearchUploadGroupFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
