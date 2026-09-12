package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J!\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/transsion/subtitle/fragment/NoSubtitleTipFragment;", "Lcom/transsion/subtitle/fragment/SubtitleBaseFragment;", "Lfu/d;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "h0", "(Landroid/view/LayoutInflater;)Lfu/d;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "initView", "onDestroy", "", be.g.f16474b, "Z", "isSelect", "", "h", "Ljava/lang/String;", "searchName", "i", "isVideoStartCheck", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "VideoSubtitle_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class NoSubtitleTipFragment extends SubtitleBaseFragment<fu.d> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String searchName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoStartCheck = true;

    /* renamed from: com.transsion.subtitle.fragment.NoSubtitleTipFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NoSubtitleTipFragment a(boolean z10, String name, String str) {
            Intrinsics.h(name, "name");
            NoSubtitleTipFragment noSubtitleTipFragment = new NoSubtitleTipFragment();
            noSubtitleTipFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("EXTRA_NAME", name), TuplesKt.a("KEY_VIDEO_START_CHECK", Boolean.valueOf(z10)), TuplesKt.a("KEY_PAGE_NAME", str)));
            return noSubtitleTipFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TextView.OnEditorActionListener {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            androidx.view.b0 h11;
            androidx.view.b0 n11;
            EditTextWithClear editTextWithClear;
            Editable text;
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            String str = null;
            CharSequence text2 = textView != null ? textView.getText() : null;
            if (text2 == null || text2.length() == 0) {
                uh.b.f76876a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
                return true;
            }
            if (textView != null) {
                KeyboardUtils.e(textView);
            }
            SubtitleDownloadViewModel viewModel = NoSubtitleTipFragment.this.getViewModel();
            if (viewModel != null && (n11 = viewModel.n()) != null) {
                fu.d dVar = (fu.d) NoSubtitleTipFragment.this.getMViewBinding();
                if (dVar != null && (editTextWithClear = dVar.f62608b) != null && (text = editTextWithClear.getText()) != null) {
                    str = text.toString();
                }
                n11.q(str);
            }
            SubtitleDownloadViewModel viewModel2 = NoSubtitleTipFragment.this.getViewModel();
            if (viewModel2 != null && (h11 = viewModel2.h()) != null) {
                h11.q("DOWNLOAD_SUBTITLE");
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void i0(NoSubtitleTipFragment noSubtitleTipFragment, View view) {
        ImageView imageView;
        fu.d dVar = (fu.d) noSubtitleTipFragment.getMViewBinding();
        if (dVar != null && (imageView = dVar.f62610d) != null) {
            imageView.setSelected(!noSubtitleTipFragment.isSelect);
        }
        noSubtitleTipFragment.isSelect = !noSubtitleTipFragment.isSelect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j0(NoSubtitleTipFragment noSubtitleTipFragment, View view) {
        androidx.view.b0 h11;
        androidx.view.b0 n11;
        EditTextWithClear editTextWithClear;
        Editable text;
        EditTextWithClear editTextWithClear2;
        fu.d dVar = (fu.d) noSubtitleTipFragment.getMViewBinding();
        String str = null;
        Editable text2 = (dVar == null || (editTextWithClear2 = dVar.f62608b) == null) ? null : editTextWithClear2.getText();
        if (text2 == null || text2.length() == 0) {
            uh.b.f76876a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
            return;
        }
        if (view != null) {
            KeyboardUtils.e(view);
        }
        SubtitleDownloadViewModel viewModel = noSubtitleTipFragment.getViewModel();
        if (viewModel != null && (n11 = viewModel.n()) != null) {
            fu.d dVar2 = (fu.d) noSubtitleTipFragment.getMViewBinding();
            if (dVar2 != null && (editTextWithClear = dVar2.f62608b) != null && (text = editTextWithClear.getText()) != null) {
                str = text.toString();
            }
            n11.q(str);
        }
        SubtitleDownloadViewModel viewModel2 = noSubtitleTipFragment.getViewModel();
        if (viewModel2 == null || (h11 = viewModel2.h()) == null) {
            return;
        }
        h11.q("DOWNLOAD_SUBTITLE");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public fu.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fu.d c11 = fu.d.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        EditTextWithClear editTextWithClear;
        TextView textView;
        LinearLayoutCompat linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat2;
        EditTextWithClear editTextWithClear2;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.searchName = arguments.getString("EXTRA_NAME", "");
            this.isVideoStartCheck = arguments.getBoolean("KEY_VIDEO_START_CHECK", true);
        }
        fu.d dVar = (fu.d) getMViewBinding();
        if (dVar != null && (editTextWithClear2 = dVar.f62608b) != null) {
            editTextWithClear2.setText(this.searchName);
        }
        fu.d dVar2 = (fu.d) getMViewBinding();
        if (dVar2 != null && (linearLayoutCompat2 = dVar2.f62611e) != null) {
            linearLayoutCompat2.setVisibility(this.isVideoStartCheck ? 0 : 8);
        }
        fu.d dVar3 = (fu.d) getMViewBinding();
        if (dVar3 != null && (linearLayoutCompat = dVar3.f62611e) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipFragment.i0(NoSubtitleTipFragment.this, view2);
                }
            });
        }
        fu.d dVar4 = (fu.d) getMViewBinding();
        if (dVar4 != null && (textView = dVar4.f62612f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipFragment.j0(NoSubtitleTipFragment.this, view2);
                }
            });
        }
        fu.d dVar5 = (fu.d) getMViewBinding();
        if (dVar5 == null || (editTextWithClear = dVar5.f62608b) == null) {
            return;
        }
        editTextWithClear.setOnEditorActionListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isSelect && this.isVideoStartCheck) {
            com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("no_subtitle_tip_again", false);
        }
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        e0("dialog_no_subtitle");
    }
}
