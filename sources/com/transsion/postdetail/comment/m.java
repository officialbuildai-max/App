package com.transsion.postdetail.comment;

import android.app.Application;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class m implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final SocialStatus f48802a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f48803b;

    /* renamed from: c, reason: collision with root package name */
    private AppCompatEditText f48804c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f48805d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f48806e;

    /* renamed from: f, reason: collision with root package name */
    private View f48807f;

    /* renamed from: g, reason: collision with root package name */
    private View f48808g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f48809h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayoutCompat f48810i;

    /* renamed from: j, reason: collision with root package name */
    private AppCompatTextView f48811j;

    /* renamed from: k, reason: collision with root package name */
    private AppCompatTextView f48812k;

    /* renamed from: l, reason: collision with root package name */
    private AppCompatTextView f48813l;

    /* renamed from: m, reason: collision with root package name */
    private AppCompatImageView f48814m;

    /* renamed from: n, reason: collision with root package name */
    private ShapeableImageView f48815n;

    /* renamed from: o, reason: collision with root package name */
    private ShapeableImageView f48816o;

    /* renamed from: p, reason: collision with root package name */
    private AppCompatImageView f48817p;

    /* renamed from: q, reason: collision with root package name */
    private ro.a f48818q;

    /* renamed from: r, reason: collision with root package name */
    private List f48819r;

    /* renamed from: s, reason: collision with root package name */
    private final InputFilter.LengthFilter f48820s;

    /* loaded from: classes6.dex */
    public static final class a extends InputFilter.LengthFilter {
        a() {
            super(300);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            if (charSequence != null) {
                try {
                    charSequence.length();
                } catch (Exception unused) {
                }
            }
            if (spanned != null) {
                spanned.length();
            }
            return charSequence;
        }
    }

    public m() {
        this(null, null, null, false, 15, null);
    }

    public m(View view, Dialog dialog, SocialStatus socialStatus, boolean z10) {
        View view2;
        Intrinsics.h(socialStatus, "socialStatus");
        this.f48802a = socialStatus;
        this.f48803b = z10;
        this.f48819r = new ArrayList();
        if (view != null) {
            this.f48804c = (AppCompatEditText) view.findViewById(R$id.comment_input_edit_text);
            this.f48805d = (TextView) view.findViewById(R$id.comment_input_edit_limit);
            this.f48807f = view.findViewById(R$id.comment_input_edit_post);
            this.f48808g = view.findViewById(R$id.comment_input_disable_click);
            this.f48806e = (TextView) view.findViewById(R$id.tv_hint);
            this.f48809h = (ProgressBar) view.findViewById(R$id.progress_bar);
            this.f48810i = (LinearLayoutCompat) view.findViewById(R$id.ll_tint);
            this.f48811j = (AppCompatTextView) view.findViewById(R$id.tv_like);
            this.f48812k = (AppCompatTextView) view.findViewById(R$id.tv_comment);
            this.f48813l = (AppCompatTextView) view.findViewById(R$id.tv_share);
            this.f48814m = (AppCompatImageView) view.findViewById(R$id.iv_download);
            this.f48815n = (ShapeableImageView) view.findViewById(R$id.iv_choose_image);
            this.f48816o = (ShapeableImageView) view.findViewById(R$id.iv_selected_image);
            this.f48817p = (AppCompatImageView) view.findViewById(R$id.icon_delete_image);
            p(z10);
        }
        if (dialog != null) {
            this.f48804c = (AppCompatEditText) dialog.findViewById(R$id.comment_input_edit_text);
            this.f48805d = (TextView) dialog.findViewById(R$id.comment_input_edit_limit);
            this.f48807f = dialog.findViewById(R$id.comment_input_edit_post);
            this.f48806e = (TextView) dialog.findViewById(R$id.tv_hint);
            this.f48809h = (ProgressBar) dialog.findViewById(R$id.progress_bar);
            this.f48810i = (LinearLayoutCompat) dialog.findViewById(R$id.ll_tint);
            this.f48811j = (AppCompatTextView) dialog.findViewById(R$id.tv_like);
            this.f48812k = (AppCompatTextView) dialog.findViewById(R$id.tv_comment);
            this.f48813l = (AppCompatTextView) dialog.findViewById(R$id.tv_share);
            this.f48814m = (AppCompatImageView) dialog.findViewById(R$id.iv_download);
            this.f48815n = (ShapeableImageView) dialog.findViewById(R$id.iv_choose_image);
            this.f48816o = (ShapeableImageView) dialog.findViewById(R$id.iv_selected_image);
            this.f48817p = (AppCompatImageView) dialog.findViewById(R$id.icon_delete_image);
            p(z10);
        }
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            appCompatEditText.setEnabled(z10);
            appCompatEditText.setSingleLine(!z10);
            appCompatEditText.setClickable(!z10);
            if (appCompatEditText.isEnabled()) {
                appCompatEditText.setMaxLines(4);
            }
        }
        if (z10) {
            TextView textView = this.f48805d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = this.f48805d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (z10 && (view2 = this.f48807f) != null) {
            view2.setVisibility(0);
        }
        this.f48820s = new a();
    }

    public /* synthetic */ m(View view, Dialog dialog, SocialStatus socialStatus, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : view, (i11 & 2) != 0 ? null : dialog, (i11 & 4) != 0 ? new SocialStatus(true, true, true, true) : socialStatus, (i11 & 8) != 0 ? false : z10);
    }

    private final void A(int i11) {
        D(i11);
        C(i11);
    }

    private final void C(int i11) {
        TextView textView = this.f48805d;
        if (textView != null) {
            if (!this.f48803b || i11 < 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(new SpannableStringBuilder(i11 + "/" + q()));
            }
        }
        if (i11 > q()) {
            uh.b.f76876a.d(R$string.comment_max_tips);
        }
    }

    private final void D(int i11) {
        View view = this.f48807f;
        if (view != null) {
            boolean z10 = true;
            if ((1 > i11 || i11 > q()) && this.f48819r.isEmpty()) {
                z10 = false;
            }
            if (view.isEnabled() != z10) {
                view.setEnabled(z10);
            }
        }
    }

    private final i0 e() {
        ro.a aVar = this.f48818q;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private final void f() {
        Editable text;
        CharSequence n12;
        ShapeableImageView shapeableImageView = this.f48816o;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
        this.f48819r.clear();
        AppCompatEditText appCompatEditText = this.f48804c;
        D((appCompatEditText == null || (text = appCompatEditText.getText()) == null || (n12 = StringsKt.n1(text)) == null) ? 0 : n12.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(m mVar, View view) {
        AppCompatEditText appCompatEditText = mVar.f48804c;
        mVar.r(appCompatEditText != null ? appCompatEditText.getText() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(m mVar, View view) {
        mVar.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(m mVar, View view) {
        mVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(m mVar, View view) {
        com.transsion.publish.n.f50509b.a().f(mVar.f48819r);
        GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        companion.a(a11, mVar.f48819r, 0, 4, 1);
    }

    private final void p(boolean z10) {
        if (z10) {
            LinearLayoutCompat linearLayoutCompat = this.f48810i;
            if (linearLayoutCompat != null) {
                jg.c.g(linearLayoutCompat);
            }
            AppCompatTextView appCompatTextView = this.f48811j;
            if (appCompatTextView != null) {
                jg.c.g(appCompatTextView);
            }
            AppCompatTextView appCompatTextView2 = this.f48813l;
            if (appCompatTextView2 != null) {
                jg.c.g(appCompatTextView2);
            }
            AppCompatImageView appCompatImageView = this.f48814m;
            if (appCompatImageView != null) {
                jg.c.g(appCompatImageView);
            }
            AppCompatEditText appCompatEditText = this.f48804c;
            if (appCompatEditText != null) {
                jg.c.k(appCompatEditText);
                return;
            }
            return;
        }
        LinearLayoutCompat linearLayoutCompat2 = this.f48810i;
        if (linearLayoutCompat2 != null) {
            jg.c.j(linearLayoutCompat2, this.f48802a.getShowTint());
        }
        AppCompatTextView appCompatTextView3 = this.f48811j;
        if (appCompatTextView3 != null) {
            jg.c.j(appCompatTextView3, this.f48802a.getShowLike());
        }
        AppCompatTextView appCompatTextView4 = this.f48813l;
        if (appCompatTextView4 != null) {
            jg.c.j(appCompatTextView4, this.f48802a.getShowShare());
        }
        AppCompatImageView appCompatImageView2 = this.f48814m;
        if (appCompatImageView2 != null) {
            jg.c.j(appCompatImageView2, this.f48802a.getShowDownload());
        }
        AppCompatEditText appCompatEditText2 = this.f48804c;
        if (appCompatEditText2 != null) {
            jg.c.g(appCompatEditText2);
        }
    }

    private final int q() {
        ro.a aVar = this.f48818q;
        if (aVar != null) {
            return aVar.c();
        }
        return 10;
    }

    private final void r(Editable editable) {
        i0 e11 = e();
        if (e11 != null) {
            ro.a aVar = this.f48818q;
            e11.S(editable, aVar != null ? aVar.d() : null);
        }
    }

    private final void s() {
        i0 e11 = e();
        if (e11 != null) {
            e11.E();
        }
    }

    public final void B() {
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            appCompatEditText.setMaxEms(q() * 2);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        i0 e11 = e();
        if (e11 != null) {
            e11.afterTextChanged(editable);
        }
        TextView textView = this.f48806e;
        if (textView != null) {
            textView.setVisibility((editable == null || editable.length() == 0) ? 0 : 8);
        }
        if ((editable != null ? editable.length() : 0) >= 295) {
            TextView textView2 = this.f48805d;
            if (textView2 != null) {
                textView2.setTextColor(com.blankj.utilcode.util.h.a(R$color.error_50));
                return;
            }
            return;
        }
        TextView textView3 = this.f48805d;
        if (textView3 != null) {
            textView3.setTextColor(com.blankj.utilcode.util.h.a(R$color.text_02));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        i0 e11 = e();
        if (e11 != null) {
            e11.beforeTextChanged(charSequence, i11, i12, i13);
        }
    }

    public final void g() {
        ProgressBar progressBar = this.f48809h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        View view = this.f48807f;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final Editable h() {
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            return appCompatEditText.getText();
        }
        return null;
    }

    public final CommentBean i() {
        ro.a aVar = this.f48818q;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public final List j() {
        return this.f48819r;
    }

    public final void k(ro.a aVar) {
        Editable b11;
        CommentBean d11;
        this.f48818q = aVar;
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(this);
            ro.a aVar2 = this.f48818q;
            if ((aVar2 != null ? aVar2.d() : null) == null) {
                appCompatEditText.setText("");
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText2 = this.f48804c;
                if (appCompatEditText2 != null) {
                    appCompatEditText2.setHint(appCompatEditText.getContext().getString(R$string.comment_hint_add));
                }
            }
            ro.a aVar3 = this.f48818q;
            if (aVar3 != null && (d11 = aVar3.d()) != null) {
                appCompatEditText.setText("");
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText3 = this.f48804c;
                if (appCompatEditText3 != null) {
                    appCompatEditText3.setHint(appCompatEditText.getContext().getString(R$string.comment_reply_to, d11.getNickName()));
                }
            }
            ro.a aVar4 = this.f48818q;
            if (aVar4 != null && (b11 = aVar4.b()) != null) {
                appCompatEditText.setText(b11);
                appCompatEditText.setSelection(b11.length());
                A(b11.length());
            }
            appCompatEditText.setMaxEms(q() * 2);
            if (this.f48803b) {
                appCompatEditText.requestFocus();
                appCompatEditText.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    appCompatEditText.setTextCursorDrawable(androidx.core.content.b.getDrawable(appCompatEditText.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = appCompatEditText.getFilters();
            Intrinsics.g(filters, "getFilters(...)");
            List O0 = ArraysKt.O0(filters);
            O0.add(0, this.f48820s);
            appCompatEditText.setFilters((InputFilter[]) O0.toArray(new InputFilter[0]));
        }
        View view = this.f48807f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.l(m.this, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView = this.f48815n;
        if (shapeableImageView != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.m(m.this, view2);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.f48817p;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.n(m.this, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView2 = this.f48816o;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.o(m.this, view2);
                }
            });
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        A(charSequence != null ? charSequence.length() : 0);
        if (this.f48803b) {
            i0 e11 = e();
            if (e11 != null) {
                e11.onTextChanged(charSequence, i11, i12, i13);
            }
        } else {
            View view = this.f48807f;
            if (view != null) {
                view.setVisibility((charSequence != null ? charSequence.length() : 0) <= 0 ? 8 : 0);
            }
        }
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            Linkify.addLinks(appCompatEditText, 1);
        }
    }

    public final void t() {
        x("");
        ro.a aVar = this.f48818q;
        if (aVar != null) {
            aVar.e();
        }
        p(false);
    }

    public final void u() {
        this.f48819r.clear();
        ShapeableImageView shapeableImageView = this.f48816o;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
    }

    public final void v(CommentBean commentBean) {
        ro.a aVar = this.f48818q;
        if (aVar != null) {
            aVar.i(commentBean);
        }
    }

    public final void w(PhotoEntity photoEntity) {
        Editable text;
        CharSequence n12;
        Intrinsics.h(photoEntity, "photoEntity");
        ShapeableImageView shapeableImageView = this.f48816o;
        if (shapeableImageView != null) {
            int i11 = 0;
            shapeableImageView.setVisibility(0);
            this.f48819r.add(photoEntity);
            RequestManager with = Glide.with(shapeableImageView);
            String localPath = photoEntity.getLocalPath();
            if (localPath == null) {
                localPath = "";
            }
            RequestBuilder<Drawable> load2 = with.load2(new File(localPath));
            ShapeableImageView shapeableImageView2 = this.f48816o;
            Intrinsics.e(shapeableImageView2);
            load2.into(shapeableImageView2);
            AppCompatEditText appCompatEditText = this.f48804c;
            if (appCompatEditText != null && (text = appCompatEditText.getText()) != null && (n12 = StringsKt.n1(text)) != null) {
                i11 = n12.length();
            }
            D(i11);
        }
    }

    public final void x(CharSequence charSequence) {
        AppCompatEditText appCompatEditText;
        if (this.f48803b || (appCompatEditText = this.f48804c) == null) {
            return;
        }
        appCompatEditText.setText(charSequence);
    }

    public final void y() {
        ProgressBar progressBar = this.f48809h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        View view = this.f48807f;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public final void z() {
        AppCompatEditText appCompatEditText = this.f48804c;
        if (appCompatEditText != null) {
            appCompatEditText.removeTextChangedListener(this);
        }
        View view = this.f48807f;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }
}
