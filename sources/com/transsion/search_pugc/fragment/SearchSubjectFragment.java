package com.transsion.search_pugc.fragment;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.u;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.view.c0;
import androidx.view.v;
import androidx.view.v0;
import br.b;
import com.blankj.utilcode.util.KeyboardUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.search.R$id;
import com.transsion.search.SearchManager;
import com.transsion.search_pugc.bean.SearchSuggestItem;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import com.transsion.search_pugc.fragment.result.SearchResultFragment;
import com.transsion.search_pugc.fragment.result.SearchResultViewModel;
import com.transsion.search_pugc.fragment.suggest.SearchSuggestFragment;
import com.transsion.search_pugc.speech.SpeechRecognizerView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import nh.m;
import nh.n;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0005¢\u0006\u0004\b.\u0010\u0004J3\u00102\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u00010\u001c2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000500¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b4\u0010-J\u0017\u00105\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b5\u0010\u001fJ\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00109R\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010<R\u0018\u0010I\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010CR\u0016\u0010Y\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010CR\u001b\u0010_\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010c¨\u0006f"}, d2 = {"Lcom/transsion/search_pugc/fragment/SearchSubjectFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lrq/i;", "<init>", "()V", "", "F0", "w0", "", "withoutKeyboard", "O0", "(Z)V", "D0", "Landroidx/fragment/app/Fragment;", "fragment", "N0", "(Landroidx/fragment/app/Fragment;)V", "showKeyboard", "J0", "Landroidx/lifecycle/u;", "owner", "Lkotlin/Function0;", "onBackPressed", "Landroidx/activity/u;", "x0", "(Landroidx/lifecycle/u;Lkotlin/jvm/functions/Function0;)Landroidx/activity/u;", "I0", "()Z", "", "keyWord", "W0", "(Ljava/lang/String;)V", "y0", "keyword", "X0", "z0", "Landroid/view/LayoutInflater;", "inflater", "B0", "(Landroid/view/LayoutInflater;)Lrq/i;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "V0", "searchFrom", "Lkotlin/Function1;", "callback", "A0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "initData", "L0", "lazyLoadData", "", "a", "I", "page", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "mKeyword", "c", "hintSearchWord", "d", "hintSearchIndex", "e", "Z", "backExitSearch", "f", "fromUGCVideoId", be.g.f16474b, "Landroidx/fragment/app/Fragment;", "currentPage", "Lcom/transsion/search_pugc/fragment/hot/SearchHotFragment;", "h", "Lcom/transsion/search_pugc/fragment/hot/SearchHotFragment;", "hotFragment", "Lcom/transsion/search_pugc/fragment/suggest/SearchSuggestFragment;", "i", "Lcom/transsion/search_pugc/fragment/suggest/SearchSuggestFragment;", "suggestFragment", "Lcom/transsion/search_pugc/fragment/result/SearchResultFragment;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/search_pugc/fragment/result/SearchResultFragment;", "searchResultFragment", CampaignEx.JSON_KEY_AD_K, "ignoreEditChanged", "l", "isSuggestClick", "Lcom/transsion/search_pugc/g;", "m", "Lkotlin/Lazy;", "getSearchReporter", "()Lcom/transsion/search_pugc/g;", "searchReporter", "Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "n", "C0", "()Lcom/transsion/search_pugc/fragment/result/SearchResultViewModel;", "viewModel", "o", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchSubjectFragment extends BaseFragment<rq.i> {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String hintSearchWord;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int hintSearchIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean backExitSearch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String fromUGCVideoId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Fragment currentPage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SearchHotFragment hotFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SearchSuggestFragment suggestFragment;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SearchResultFragment searchResultFragment;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreEditChanged;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isSuggestClick;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int page = 1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mKeyword = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy searchReporter = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.search_pugc.g M0;
            M0 = SearchSubjectFragment.M0(SearchSubjectFragment.this);
            return M0;
        }
    });

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SearchResultViewModel Y0;
            Y0 = SearchSubjectFragment.Y0(SearchSubjectFragment.this);
            return Y0;
        }
    });

    /* renamed from: com.transsion.search_pugc.fragment.SearchSubjectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchSubjectFragment a(String str, String str2, boolean z10, String str3) {
            SearchSubjectFragment searchSubjectFragment = new SearchSubjectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("hot_search_word", str);
            bundle.putString("keyword", str2);
            bundle.putString("form_ugc_video_id", str3);
            bundle.putBoolean("back_exit", z10);
            searchSubjectFragment.setArguments(bundle);
            return searchSubjectFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f52383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchSubjectFragment f52384b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function0 function0, SearchSubjectFragment searchSubjectFragment) {
            super(true);
            this.f52383a = function0;
            this.f52384b = searchSubjectFragment;
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            if (((Boolean) this.f52383a.invoke()).booleanValue()) {
                return;
            }
            setEnabled(false);
            this.f52384b.requireActivity().getOnBackPressedDispatcher().l();
            setEnabled(true);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements SearchSuggestFragment.b {
        c() {
        }

        @Override // com.transsion.search_pugc.fragment.suggest.SearchSuggestFragment.b
        public void a(SearchSuggestItem searchSuggestItem, int i11, String keyWord, String mOps) {
            String str;
            EditText editText;
            Intrinsics.h(keyWord, "keyWord");
            Intrinsics.h(mOps, "mOps");
            rq.i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                KeyboardUtils.e(editText);
            }
            SearchSubjectFragment.this.mKeyword = keyWord;
            SearchSubjectFragment.this.isSuggestClick = true;
            SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
            if (searchSuggestItem == null || (str = searchSuggestItem.getWord()) == null) {
                str = "";
            }
            searchSubjectFragment.W0(str);
            SearchSubjectFragment.this.L0("suggest");
            SearchSubjectFragment.this.getSearchReporter().E("suggest", SearchSubjectFragment.this.mKeyword);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements n {
        d() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (SearchSubjectFragment.this.currentPage instanceof SearchHotFragment) {
                Fragment fragment = SearchSubjectFragment.this.currentPage;
                Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.search_pugc.fragment.hot.SearchHotFragment");
                ((SearchHotFragment) fragment).onConnected();
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes6.dex */
    static final class e implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52387a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52387a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52387a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52387a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchSubjectFragment.this.C0().i().n(Boolean.FALSE);
            if (SearchSubjectFragment.this.ignoreEditChanged) {
                SearchSubjectFragment.this.ignoreEditChanged = false;
                return;
            }
            SearchSubjectFragment.this.mKeyword = String.valueOf(editable);
            SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
            searchSubjectFragment.X0(searchSubjectFragment.mKeyword);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextView textView;
            rq.i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding == null || (textView = mViewBinding.f74786j) == null) {
                return;
            }
            jg.c.k(textView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements TextView.OnEditorActionListener {
        g() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchSubjectFragment.this.mKeyword = String.valueOf(textView != null ? textView.getText() : null);
            SearchSubjectFragment.this.L0("input");
            SearchSubjectFragment.this.getSearchReporter().E("input", SearchSubjectFragment.this.mKeyword);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResultViewModel C0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    private final void D0() {
        EditText editText;
        if (this.backExitSearch) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Fragment fragment = this.currentPage;
        if (fragment instanceof SearchHotFragment) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        if (this.isSuggestClick && !(fragment instanceof SearchSuggestFragment)) {
            if (fragment instanceof SearchResultFragment) {
                N0(this.suggestFragment);
            }
        } else {
            this.isSuggestClick = false;
            rq.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
                return;
            }
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(SearchSubjectFragment searchSubjectFragment, Boolean bool) {
        if (bool.booleanValue()) {
            searchSubjectFragment.N0(searchSubjectFragment.hotFragment);
        }
        return Unit.f67184a;
    }

    private final void F0() {
        rq.i mViewBinding;
        EditText editText;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("hot_search_word") : null;
        this.hintSearchWord = string;
        if (string == null || string.length() <= 0 || (mViewBinding = getMViewBinding()) == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        editText.setHint(this.hintSearchWord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(final SearchSubjectFragment searchSubjectFragment, String str) {
        EditText editText;
        if (TextUtils.isEmpty(str)) {
            rq.i mViewBinding = searchSubjectFragment.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                editText.postDelayed(new Runnable() { // from class: com.transsion.search_pugc.fragment.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchSubjectFragment.H0(SearchSubjectFragment.this);
                    }
                }, 500L);
            }
            com.transsion.search_pugc.speech.f.f52579a.b(SearchSubjectFragment.class.getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 拉起键盘");
        } else {
            searchSubjectFragment.W0(str == null ? "" : str);
            searchSubjectFragment.L0("voice");
            searchSubjectFragment.getSearchReporter().E("voice", searchSubjectFragment.mKeyword);
            com.transsion.search_pugc.speech.f.f52579a.b(SearchSubjectFragment.class.getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 隐藏键盘");
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SearchSubjectFragment searchSubjectFragment) {
        EditText editText;
        EditText editText2;
        rq.i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f74778b) != null) {
            editText2.requestFocus();
        }
        rq.i mViewBinding2 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding2 == null || (editText = mViewBinding2.f74778b) == null) {
            return;
        }
        KeyboardUtils.i(editText);
    }

    private final boolean I0() {
        D0();
        return true;
    }

    private final void J0(boolean showKeyboard) {
        final EditText editText;
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        if (!editText.hasFocus()) {
            editText.requestFocus();
        }
        if (showKeyboard) {
            editText.post(new Runnable() { // from class: com.transsion.search_pugc.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    SearchSubjectFragment.K0(SearchSubjectFragment.this, editText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(SearchSubjectFragment searchSubjectFragment, EditText editText) {
        if (searchSubjectFragment.isAdded() && editText.hasFocus()) {
            KeyboardUtils.i(editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.search_pugc.g M0(SearchSubjectFragment searchSubjectFragment) {
        return com.transsion.search_pugc.g.f52532h.a(searchSubjectFragment.getContext());
    }

    private final void N0(Fragment fragment) {
        EditText editText;
        if (fragment == null || Intrinsics.c(this.currentPage, fragment) || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.currentPage = fragment;
        w p11 = getChildFragmentManager().p();
        SearchHotFragment searchHotFragment = this.hotFragment;
        if (searchHotFragment != null && !Intrinsics.c(this.currentPage, searchHotFragment)) {
            p11.p(searchHotFragment);
        }
        SearchSuggestFragment searchSuggestFragment = this.suggestFragment;
        if (searchSuggestFragment != null && !Intrinsics.c(this.currentPage, searchSuggestFragment)) {
            p11.p(searchSuggestFragment);
        }
        SearchResultFragment searchResultFragment = this.searchResultFragment;
        if (searchResultFragment != null && !Intrinsics.c(this.currentPage, searchResultFragment)) {
            p11.p(searchResultFragment);
        }
        p11.y(fragment);
        p11.j();
        if (!Intrinsics.c(fragment, this.searchResultFragment)) {
            Boolean bool = (Boolean) C0().i().f();
            if (bool == null || !bool.booleanValue()) {
                J0(false);
                return;
            }
            return;
        }
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        editText.clearFocus();
        KeyboardUtils.e(editText);
    }

    private final void O0(boolean withoutKeyboard) {
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        TextView textView;
        EditText editText4;
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText4 = mViewBinding.f74778b) != null) {
            editText4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.P0(SearchSubjectFragment.this, view);
                }
            });
        }
        rq.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (textView = mViewBinding2.f74786j) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.Q0(SearchSubjectFragment.this, view);
                }
            });
        }
        rq.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (editText3 = mViewBinding3.f74778b) != null) {
            editText3.addTextChangedListener(new f());
        }
        rq.i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (editText2 = mViewBinding4.f74778b) != null) {
            editText2.setOnEditorActionListener(new g());
        }
        rq.i mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (editText = mViewBinding5.f74778b) != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search_pugc.fragment.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    SearchSubjectFragment.R0(SearchSubjectFragment.this, view, z10);
                }
            });
        }
        rq.i mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (imageView = mViewBinding6.f74783g) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.S0(SearchSubjectFragment.this, view);
                }
            });
        }
        rq.i mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (appCompatImageView = mViewBinding7.f74780d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.T0(SearchSubjectFragment.this, view);
                }
            });
        }
        if (!withoutKeyboard) {
            J0(true);
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        x0(this, new Function0() { // from class: com.transsion.search_pugc.fragment.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean U0;
                U0 = SearchSubjectFragment.U0(SearchSubjectFragment.this);
                return Boolean.valueOf(U0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(SearchSubjectFragment searchSubjectFragment, View view) {
        TextView textView;
        rq.i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f74786j) == null) {
            return;
        }
        jg.c.k(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(SearchSubjectFragment searchSubjectFragment, View view) {
        searchSubjectFragment.L0("input");
        searchSubjectFragment.getSearchReporter().E("input", searchSubjectFragment.mKeyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(SearchSubjectFragment searchSubjectFragment, View view, boolean z10) {
        EditText editText;
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        TextView textView;
        String str;
        EditText editText2;
        EditText editText3;
        ViewGroup.LayoutParams layoutParams2;
        ImageView imageView2;
        TextView textView2;
        if (!z10) {
            rq.i mViewBinding = searchSubjectFragment.getMViewBinding();
            if (mViewBinding != null && (textView = mViewBinding.f74786j) != null) {
                jg.c.g(textView);
            }
            rq.i mViewBinding2 = searchSubjectFragment.getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f74783g) != null) {
                jg.c.k(imageView);
            }
            rq.i mViewBinding3 = searchSubjectFragment.getMViewBinding();
            if (mViewBinding3 == null || (editText = mViewBinding3.f74778b) == null || (layoutParams = editText.getLayoutParams()) == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
                return;
            }
            ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R$id.search_edit_clear);
            return;
        }
        rq.i mViewBinding4 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding4 != null && (textView2 = mViewBinding4.f74786j) != null) {
            jg.c.k(textView2);
        }
        rq.i mViewBinding5 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding5 != null && (imageView2 = mViewBinding5.f74783g) != null) {
            jg.c.g(imageView2);
        }
        rq.i mViewBinding6 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding6 != null && (editText3 = mViewBinding6.f74778b) != null && (layoutParams2 = editText3.getLayoutParams()) != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(16, R$id.tv_search);
        }
        if (searchSubjectFragment.currentPage instanceof SearchResultFragment) {
            rq.i mViewBinding7 = searchSubjectFragment.getMViewBinding();
            Editable text = (mViewBinding7 == null || (editText2 = mViewBinding7.f74778b) == null) ? null : editText2.getText();
            if ((text != null ? text.length() : 0) <= 0) {
                searchSubjectFragment.N0(searchSubjectFragment.hotFragment);
                return;
            }
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            searchSubjectFragment.X0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(SearchSubjectFragment searchSubjectFragment, View view) {
        ImageView imageView;
        EditText editText;
        rq.i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
            editText.setText("");
        }
        rq.i mViewBinding2 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding2 == null || (imageView = mViewBinding2.f74783g) == null) {
            return;
        }
        jg.c.g(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(SearchSubjectFragment searchSubjectFragment, View view) {
        searchSubjectFragment.D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U0(SearchSubjectFragment searchSubjectFragment) {
        return searchSubjectFragment.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(String keyWord) {
        Unit unit;
        EditText editText;
        EditText editText2;
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f74778b) != null) {
            editText2.setText(keyWord);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            rq.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (editText = mViewBinding2.f74778b) == null) {
                unit = null;
            } else {
                editText.setSelection(keyWord.length());
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(String keyword) {
        SearchSuggestFragment searchSuggestFragment;
        if (keyword.length() == 0) {
            N0(this.hotFragment);
        } else if (m.f70597a.e()) {
            if (!TextUtils.isEmpty(keyword) && (searchSuggestFragment = this.suggestFragment) != null) {
                searchSuggestFragment.o0(keyword);
            }
            N0(this.suggestFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel Y0(SearchSubjectFragment searchSubjectFragment) {
        FragmentActivity requireActivity = searchSubjectFragment.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        return (SearchResultViewModel) new v0(requireActivity).a(SearchResultViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.search_pugc.g getSearchReporter() {
        return (com.transsion.search_pugc.g) this.searchReporter.getValue();
    }

    private final void w0() {
        if (this.hotFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            SearchHotFragment a11 = SearchHotFragment.INSTANCE.a(this.hintSearchWord);
            p11.b(R$id.search_fragment_container, a11);
            this.hotFragment = a11;
            p11.j();
        }
    }

    private final u x0(androidx.view.u owner, Function0 onBackPressed) {
        b bVar = new b(onBackPressed, this);
        requireActivity().getOnBackPressedDispatcher().i(owner, bVar);
        return bVar;
    }

    private final void y0() {
        if (this.suggestFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            SearchSuggestFragment a11 = SearchSuggestFragment.INSTANCE.a();
            p11.b(R$id.search_fragment_container, a11);
            this.suggestFragment = a11;
            p11.j();
            SearchSuggestFragment searchSuggestFragment = this.suggestFragment;
            if (searchSuggestFragment != null) {
                searchSuggestFragment.q0(new c());
            }
        }
    }

    private final void z0() {
        if (this.searchResultFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            SearchResultFragment searchResultFragment = new SearchResultFragment();
            p11.b(R$id.search_fragment_container, searchResultFragment);
            this.searchResultFragment = searchResultFragment;
            p11.l();
        }
    }

    public final void A0(String keyWord, String searchFrom, Function1 callback) {
        EditText editText;
        Intrinsics.h(keyWord, "keyWord");
        Intrinsics.h(callback, "callback");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
        this.mKeyword = keyWord;
        this.ignoreEditChanged = true;
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
            editText.setText(this.mKeyword);
            try {
                Result.Companion companion = Result.INSTANCE;
                Editable text = editText.getText();
                editText.setSelection(text != null ? RangesKt.i(text.length(), this.mKeyword.length()) : 0);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        this.page = 1;
        L0(searchFrom);
        SearchManager.f51995f.a().g(this.mKeyword);
        callback.invoke(keyWord);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public rq.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rq.i c11 = rq.i.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final void L0(String searchFrom) {
        rq.i mViewBinding;
        EditText editText;
        if (!m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
        }
        if (this.mKeyword.length() == 0 && (mViewBinding = getMViewBinding()) != null && (editText = mViewBinding.f74778b) != null && Intrinsics.c(editText.getHint(), this.hintSearchWord)) {
            this.mKeyword = String.valueOf(this.hintSearchWord);
            this.ignoreEditChanged = true;
            editText.setText(String.valueOf(this.hintSearchWord));
            editText.setSelection(editText.getText().length());
            getSearchReporter().E("hint", this.mKeyword);
            searchFrom = "hint";
        }
        if (this.mKeyword.length() == 0) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f41533a;
            hVar.e(16);
            hVar.l(getString(com.transsion.search.R$string.tips_movie));
            return;
        }
        SearchHotFragment searchHotFragment = this.hotFragment;
        if (searchHotFragment != null) {
            searchHotFragment.addHistoryWord(this.mKeyword);
        }
        SearchResultFragment searchResultFragment = this.searchResultFragment;
        if (searchResultFragment != null) {
            searchResultFragment.u0(this.mKeyword, searchFrom, this.fromUGCVideoId);
        }
        N0(this.searchResultFragment);
    }

    public final void V0() {
        String str;
        EditText editText;
        b.a aVar = br.b.f16996a;
        List a11 = aVar.a();
        if (a11 == null || a11.isEmpty()) {
            return;
        }
        List a12 = aVar.a();
        int size = a12 != null ? a12.size() : 0;
        List a13 = aVar.a();
        if (a13 != null) {
            int i11 = this.hintSearchIndex;
            this.hintSearchIndex = i11 + 1;
            str = (String) CollectionsKt.l0(a13, i11 % size);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            this.hintSearchWord = str;
        }
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        editText.setHint(this.hintSearchWord);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        String str;
        ImageView imageView;
        EditText editText;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("keyword")) == null) {
            str = "";
        }
        Bundle arguments2 = getArguments();
        this.fromUGCVideoId = arguments2 != null ? arguments2.getString("form_ugc_video_id") : null;
        Bundle arguments3 = getArguments();
        this.backExitSearch = arguments3 != null ? arguments3.getBoolean("back_exit") : false;
        O0(str.length() > 0);
        if (str.length() > 0) {
            this.mKeyword = str;
            rq.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                editText.setText(this.mKeyword);
            }
            rq.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f74783g) != null) {
                jg.c.k(imageView);
            }
            L0("deeplink");
            getSearchReporter().E("deeplink", this.mKeyword);
        }
        C0().i().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.search_pugc.fragment.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = SearchSubjectFragment.E0(SearchSubjectFragment.this, (Boolean) obj);
                return E0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        SpeechRecognizerView speechRecognizerView;
        Intrinsics.h(view, "view");
        F0();
        setNetListener(new d());
        rq.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (speechRecognizerView = mViewBinding.f74782f) != null) {
            speechRecognizerView.setCallback(new Function1() { // from class: com.transsion.search_pugc.fragment.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit G0;
                    G0 = SearchSubjectFragment.G0(SearchSubjectFragment.this, (String) obj);
                    return G0;
                }
            });
        }
        kotlinx.coroutines.k.d(v.a(this), null, null, new SearchSubjectFragment$initView$3(null), 3, null);
        w0();
        y0();
        z0();
        N0(this.hotFragment);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
