package com.transsion.search.fragment;

import ak.k;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
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
import be.g;
import com.blankj.utilcode.util.KeyboardUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.SearchManager;
import com.transsion.search.activity.SearchManagerActivity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.SearchSubjectFragment;
import com.transsion.search.fragment.hot.SearchHotFragment;
import com.transsion.search.fragment.result.SearchResultFragment;
import com.transsion.search.fragment.suggest.SearchSuggestFragment;
import com.transsion.search_pugc.speech.SpeechRecognizerView;
import com.transsnet.downloader.DownloadManagerApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import nh.m;
import nh.n;
import qq.c;
import rq.i;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0005¢\u0006\u0004\b.\u0010\u0004J3\u00102\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u00010\u001c2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000500¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b4\u0010-J\u0017\u00105\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b5\u0010\u001fJ\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0004R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010ER\u0016\u0010Y\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010E¨\u0006["}, d2 = {"Lcom/transsion/search/fragment/SearchSubjectFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lrq/i;", "<init>", "()V", "", "y0", "r0", "", "withoutKeyboard", "G0", "(Z)V", "x0", "Landroidx/fragment/app/Fragment;", "fragment", "F0", "(Landroidx/fragment/app/Fragment;)V", "showKeyboard", "C0", "Landroidx/lifecycle/u;", "owner", "Lkotlin/Function0;", "onBackPressed", "Landroidx/activity/u;", "s0", "(Landroidx/lifecycle/u;Lkotlin/jvm/functions/Function0;)Landroidx/activity/u;", "B0", "()Z", "", "keyWord", "O0", "(Ljava/lang/String;)V", "t0", "keyword", "P0", "u0", "Landroid/view/LayoutInflater;", "inflater", "w0", "(Landroid/view/LayoutInflater;)Lrq/i;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "N0", "searchFrom", "Lkotlin/Function1;", "callback", "v0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "initData", "E0", "lazyLoadData", "onDestroyView", "onDestroy", "", "a", "I", "page", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "mKeyword", "c", "hintSearchWord", "d", "hintSearchIndex", "e", "Z", "backExitSearch", "f", "Landroidx/fragment/app/Fragment;", "currentPage", "Lcom/transsion/search/fragment/hot/SearchHotFragment;", g.f16474b, "Lcom/transsion/search/fragment/hot/SearchHotFragment;", "hotFragment", "Lcom/transsion/search/fragment/suggest/SearchSuggestFragment;", "h", "Lcom/transsion/search/fragment/suggest/SearchSuggestFragment;", "suggestFragment", "Lcom/transsion/search/fragment/result/SearchResultFragment;", "i", "Lcom/transsion/search/fragment/result/SearchResultFragment;", "searchResultFragment", j.f35620b, "ignoreEditChanged", CampaignEx.JSON_KEY_AD_K, "isSuggestClick", "l", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchSubjectFragment extends BaseFragment<i> {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int page = 1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mKeyword = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String hintSearchWord;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int hintSearchIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean backExitSearch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Fragment currentPage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private SearchHotFragment hotFragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SearchSuggestFragment suggestFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SearchResultFragment searchResultFragment;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean ignoreEditChanged;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isSuggestClick;

    /* renamed from: com.transsion.search.fragment.SearchSubjectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchSubjectFragment a(String str, String str2, boolean z10) {
            SearchSubjectFragment searchSubjectFragment = new SearchSubjectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("hot_search_word", str);
            bundle.putString("keyword", str2);
            bundle.putBoolean("back_exit", z10);
            searchSubjectFragment.setArguments(bundle);
            return searchSubjectFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f52049a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchSubjectFragment f52050b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function0 function0, SearchSubjectFragment searchSubjectFragment) {
            super(true);
            this.f52049a = function0;
            this.f52050b = searchSubjectFragment;
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            if (((Boolean) this.f52049a.invoke()).booleanValue()) {
                return;
            }
            setEnabled(false);
            this.f52050b.requireActivity().getOnBackPressedDispatcher().l();
            setEnabled(true);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements SearchSuggestFragment.b {
        c() {
        }

        @Override // com.transsion.search.fragment.suggest.SearchSuggestFragment.b
        public void a(SuggestEntity suggestEntity, int i11, String keyWord, String mOps) {
            String str;
            Staff staff;
            String subjectId;
            Integer subjectType;
            String deeplink;
            EditText editText;
            Intrinsics.h(keyWord, "keyWord");
            Intrinsics.h(mOps, "mOps");
            i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                KeyboardUtils.e(editText);
            }
            Integer type = suggestEntity != null ? suggestEntity.getType() : null;
            if (type != null && type.intValue() == 2) {
                VerticalRank verticalRank = suggestEntity.getVerticalRank();
                if (verticalRank == null || (deeplink = verticalRank.getDeeplink()) == null) {
                    return;
                }
                Uri g11 = com.transsion.baselib.helper.b.f43318a.g(Uri.parse(deeplink + "&ops=" + mOps));
                if (g11 != null) {
                    k.o(g11);
                    return;
                }
                return;
            }
            str = "";
            if (type == null || type.intValue() != 1) {
                if (type == null || type.intValue() != 0) {
                    if (type == null || type.intValue() != 3 || (staff = suggestEntity.getStaff()) == null) {
                        return;
                    }
                    Navigator.x(TheRouter.c("/movie/staff").J("staff", staff), SearchSubjectFragment.this.requireContext(), null, 2, null);
                    return;
                }
                SearchSubjectFragment.this.mKeyword = keyWord;
                SearchSubjectFragment.this.isSuggestClick = true;
                SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
                String word = suggestEntity.getWord();
                searchSubjectFragment.O0(word != null ? word : "");
                SearchSubjectFragment.this.E0("suggest");
                return;
            }
            try {
                Subject subject = suggestEntity.getSubject();
                if (subject != null) {
                    Integer subjectType2 = subject.getSubjectType();
                    int value = SubjectType.SHORT_TV.getValue();
                    if (subjectType2 != null && subjectType2.intValue() == value) {
                        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                        Context context = SearchSubjectFragment.this.getContext();
                        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        FragmentActivity fragmentActivity = (FragmentActivity) context;
                        Subject subject2 = suggestEntity.getSubject();
                        a11.d0(fragmentActivity, "searchpage", (r22 & 4) != 0 ? "" : "", subject2 != null ? subject2.getOps() : null, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : false, (r22 & 64) != 0 ? null : suggestEntity.getSubject(), (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                        return;
                    }
                }
                Navigator c11 = TheRouter.c("/movie/detail");
                Subject subject3 = suggestEntity.getSubject();
                Navigator F = c11.F("subject_type", (subject3 == null || (subjectType = subject3.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
                Subject subject4 = suggestEntity.getSubject();
                if (subject4 != null && (subjectId = subject4.getSubjectId()) != null) {
                    str = subjectId;
                }
                Navigator.x(F.K("id", str).K("ops", mOps), SearchSubjectFragment.this.requireContext(), null, 2, null);
            } catch (Exception unused) {
            }
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
                Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.search.fragment.hot.SearchHotFragment");
                ((SearchHotFragment) fragment).onConnected();
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SearchSubjectFragment.this.ignoreEditChanged) {
                SearchSubjectFragment.this.ignoreEditChanged = false;
                return;
            }
            SearchSubjectFragment.this.mKeyword = String.valueOf(editable);
            SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
            searchSubjectFragment.P0(searchSubjectFragment.mKeyword);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextView textView;
            i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
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
    public static final class f implements TextView.OnEditorActionListener {
        f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchSubjectFragment.this.mKeyword = String.valueOf(textView != null ? textView.getText() : null);
            SearchSubjectFragment.this.E0("input");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(SearchSubjectFragment searchSubjectFragment) {
        EditText editText;
        EditText editText2;
        i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f74778b) != null) {
            editText2.requestFocus();
        }
        i mViewBinding2 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding2 == null || (editText = mViewBinding2.f74778b) == null) {
            return;
        }
        KeyboardUtils.i(editText);
    }

    private final boolean B0() {
        x0();
        return true;
    }

    private final void C0(boolean showKeyboard) {
        final EditText editText;
        i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        if (!editText.hasFocus()) {
            editText.requestFocus();
        }
        if (showKeyboard) {
            editText.post(new Runnable() { // from class: tq.b
                @Override // java.lang.Runnable
                public final void run() {
                    SearchSubjectFragment.D0(SearchSubjectFragment.this, editText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SearchSubjectFragment searchSubjectFragment, EditText editText) {
        if (searchSubjectFragment.isAdded() && editText.hasFocus()) {
            KeyboardUtils.i(editText);
        }
    }

    private final void F0(Fragment fragment) {
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
        p11.l();
        if (!Intrinsics.c(fragment, this.searchResultFragment)) {
            C0(false);
            return;
        }
        i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        editText.clearFocus();
        KeyboardUtils.e(editText);
    }

    private final void G0(boolean withoutKeyboard) {
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        TextView textView;
        EditText editText4;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText4 = mViewBinding.f74778b) != null) {
            editText4.setOnClickListener(new View.OnClickListener() { // from class: tq.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.H0(SearchSubjectFragment.this, view);
                }
            });
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (textView = mViewBinding2.f74786j) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tq.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.I0(SearchSubjectFragment.this, view);
                }
            });
        }
        i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (editText3 = mViewBinding3.f74778b) != null) {
            editText3.addTextChangedListener(new e());
        }
        i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (editText2 = mViewBinding4.f74778b) != null) {
            editText2.setOnEditorActionListener(new f());
        }
        i mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (editText = mViewBinding5.f74778b) != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tq.e
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    SearchSubjectFragment.J0(SearchSubjectFragment.this, view, z10);
                }
            });
        }
        i mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (imageView = mViewBinding6.f74783g) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tq.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.K0(SearchSubjectFragment.this, view);
                }
            });
        }
        i mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (appCompatImageView = mViewBinding7.f74780d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tq.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.L0(SearchSubjectFragment.this, view);
                }
            });
        }
        if (!withoutKeyboard) {
            C0(true);
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        s0(this, new Function0() { // from class: tq.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean M0;
                M0 = SearchSubjectFragment.M0(SearchSubjectFragment.this);
                return Boolean.valueOf(M0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SearchSubjectFragment searchSubjectFragment, View view) {
        TextView textView;
        i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f74786j) == null) {
            return;
        }
        jg.c.k(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(SearchSubjectFragment searchSubjectFragment, View view) {
        searchSubjectFragment.E0("input");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(SearchSubjectFragment searchSubjectFragment, View view, boolean z10) {
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
            i mViewBinding = searchSubjectFragment.getMViewBinding();
            if (mViewBinding != null && (textView = mViewBinding.f74786j) != null) {
                jg.c.g(textView);
            }
            i mViewBinding2 = searchSubjectFragment.getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f74783g) != null) {
                jg.c.k(imageView);
            }
            i mViewBinding3 = searchSubjectFragment.getMViewBinding();
            if (mViewBinding3 == null || (editText = mViewBinding3.f74778b) == null || (layoutParams = editText.getLayoutParams()) == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
                return;
            }
            ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R$id.search_edit_clear);
            return;
        }
        i mViewBinding4 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding4 != null && (textView2 = mViewBinding4.f74786j) != null) {
            jg.c.k(textView2);
        }
        i mViewBinding5 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding5 != null && (imageView2 = mViewBinding5.f74783g) != null) {
            jg.c.g(imageView2);
        }
        i mViewBinding6 = searchSubjectFragment.getMViewBinding();
        if (mViewBinding6 != null && (editText3 = mViewBinding6.f74778b) != null && (layoutParams2 = editText3.getLayoutParams()) != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(16, R$id.tv_search);
        }
        if (searchSubjectFragment.currentPage instanceof SearchResultFragment) {
            i mViewBinding7 = searchSubjectFragment.getMViewBinding();
            Editable text = (mViewBinding7 == null || (editText2 = mViewBinding7.f74778b) == null) ? null : editText2.getText();
            if ((text != null ? text.length() : 0) <= 0) {
                searchSubjectFragment.F0(searchSubjectFragment.hotFragment);
                return;
            }
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            searchSubjectFragment.P0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(SearchSubjectFragment searchSubjectFragment, View view) {
        EditText editText;
        i mViewBinding = searchSubjectFragment.getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(SearchSubjectFragment searchSubjectFragment, View view) {
        searchSubjectFragment.x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M0(SearchSubjectFragment searchSubjectFragment) {
        return searchSubjectFragment.B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(String keyWord) {
        Unit unit;
        EditText editText;
        EditText editText2;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f74778b) != null) {
            editText2.setText(keyWord);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            i mViewBinding2 = getMViewBinding();
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
    public final void P0(String keyword) {
        SearchSuggestFragment searchSuggestFragment;
        if (keyword.length() == 0) {
            F0(this.hotFragment);
            return;
        }
        if (!m.f70597a.e()) {
            SearchManagerActivity.INSTANCE.a("showLinkageSearchFragment --> currently no network does not use linkage");
            return;
        }
        if (!TextUtils.isEmpty(keyword) && (searchSuggestFragment = this.suggestFragment) != null) {
            searchSuggestFragment.n0(keyword);
        }
        F0(this.suggestFragment);
    }

    private final void r0() {
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

    private final u s0(androidx.view.u owner, Function0 onBackPressed) {
        b bVar = new b(onBackPressed, this);
        requireActivity().getOnBackPressedDispatcher().i(owner, bVar);
        return bVar;
    }

    private final void t0() {
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
                searchSuggestFragment.o0(new c());
            }
        }
    }

    private final void u0() {
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

    private final void x0() {
        EditText editText;
        Fragment fragment = this.currentPage;
        if (fragment instanceof SearchHotFragment) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.isSuggestClick && !(fragment instanceof SearchSuggestFragment)) {
            if (fragment instanceof SearchResultFragment) {
                F0(this.suggestFragment);
            }
        } else {
            this.isSuggestClick = false;
            i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (editText = mViewBinding.f74778b) == null) {
                return;
            }
            editText.setText("");
        }
    }

    private final void y0() {
        i mViewBinding;
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
    public static final Unit z0(final SearchSubjectFragment searchSubjectFragment, String str) {
        EditText editText;
        if (TextUtils.isEmpty(str)) {
            i mViewBinding = searchSubjectFragment.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                editText.postDelayed(new Runnable() { // from class: tq.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchSubjectFragment.A0(SearchSubjectFragment.this);
                    }
                }, 500L);
            }
            com.transsion.search.speech.f.f52268a.b(SearchSubjectFragment.class.getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 拉起键盘");
        } else {
            searchSubjectFragment.O0(str == null ? "" : str);
            searchSubjectFragment.E0("voice");
            com.transsion.search.speech.f.f52268a.b(SearchSubjectFragment.class.getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 隐藏键盘");
        }
        return Unit.f67184a;
    }

    public final void E0(String searchFrom) {
        i mViewBinding;
        EditText editText;
        if (!m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
        }
        if (this.mKeyword.length() == 0 && (mViewBinding = getMViewBinding()) != null && (editText = mViewBinding.f74778b) != null && Intrinsics.c(editText.getHint(), this.hintSearchWord)) {
            this.mKeyword = String.valueOf(this.hintSearchWord);
            this.ignoreEditChanged = true;
            editText.setText(String.valueOf(this.hintSearchWord));
            editText.setSelection(editText.getText().length());
            searchFrom = "hint";
        }
        if (this.mKeyword.length() == 0) {
            h hVar = h.f41533a;
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
            searchResultFragment.v0(this.mKeyword, searchFrom);
        }
        F0(this.searchResultFragment);
    }

    public final void N0() {
        String str;
        EditText editText;
        c.a aVar = qq.c.f73795a;
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
        i mViewBinding = getMViewBinding();
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
        this.backExitSearch = arguments2 != null ? arguments2.getBoolean("back_exit") : false;
        G0(str.length() > 0);
        if (str.length() > 0) {
            this.mKeyword = str;
            i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f74778b) != null) {
                editText.setText(this.mKeyword);
            }
            i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f74783g) != null) {
                jg.c.k(imageView);
            }
            E0("deeplink");
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        SpeechRecognizerView speechRecognizerView;
        Intrinsics.h(view, "view");
        BaseSearchMainFragment.INSTANCE.b();
        y0();
        setNetListener(new d());
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (speechRecognizerView = mViewBinding.f74782f) != null) {
            speechRecognizerView.setCallback(new Function1() { // from class: tq.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z02;
                    z02 = SearchSubjectFragment.z0(SearchSubjectFragment.this, (String) obj);
                    return z02;
                }
            });
        }
        r0();
        t0();
        u0();
        F0(this.hotFragment);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.currentPage = null;
        this.hotFragment = null;
        this.suggestFragment = null;
        this.searchResultFragment = null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.currentPage = null;
        this.hotFragment = null;
        this.suggestFragment = null;
        this.searchResultFragment = null;
        setNetListener(null);
        setMViewBinding(null);
    }

    public final void v0(String keyWord, String searchFrom, Function1 callback) {
        EditText editText;
        Intrinsics.h(keyWord, "keyWord");
        Intrinsics.h(callback, "callback");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
        this.mKeyword = keyWord;
        this.ignoreEditChanged = true;
        i mViewBinding = getMViewBinding();
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
        E0(searchFrom);
        SearchManager.f51995f.a().g(this.mKeyword);
        callback.invoke(keyWord);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        i c11 = i.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
