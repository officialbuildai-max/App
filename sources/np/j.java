package np;

import android.app.Dialog;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tencent.mmkv.MMKV;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.view.LinkEditText;
import ip.b;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class j implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f70626a;

    /* renamed from: b, reason: collision with root package name */
    private LinkEditText f70627b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f70628c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f70629d;

    /* renamed from: e, reason: collision with root package name */
    private View f70630e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f70631f;

    /* renamed from: g, reason: collision with root package name */
    private View f70632g;

    /* renamed from: h, reason: collision with root package name */
    private View f70633h;

    /* renamed from: i, reason: collision with root package name */
    private np.b f70634i;

    /* renamed from: j, reason: collision with root package name */
    private Dialog f70635j;

    /* renamed from: k, reason: collision with root package name */
    private MMKV f70636k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f70637l;

    /* renamed from: m, reason: collision with root package name */
    private b.InterfaceC0821b f70638m;

    /* renamed from: n, reason: collision with root package name */
    private View f70639n;

    /* renamed from: o, reason: collision with root package name */
    private final InputFilter.LengthFilter f70640o;

    /* loaded from: classes6.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                RelativeLayout relativeLayout = j.this.f70631f;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = j.this.f70631f;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends InputFilter.LengthFilter {
        b() {
            super(1000);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            int length;
            if (charSequence != null) {
                try {
                    length = charSequence.length();
                } catch (Exception unused) {
                }
            } else {
                length = 0;
            }
            if (length + (spanned != null ? spanned.length() : 0) > getMax()) {
                uh.b.f76876a.d(R$string.comment_max_tips);
            }
            return charSequence;
        }
    }

    public j() {
        this(null, null, null, null, false, 31, null);
    }

    public j(View view, Dialog dialog, b.InterfaceC0821b interfaceC0821b, View view2, boolean z10) {
        LinkEditText linkEditText;
        View view3;
        this.f70626a = z10;
        this.f70638m = interfaceC0821b;
        this.f70639n = view2;
        this.f70637l = true;
        if (view != null) {
            this.f70627b = (LinkEditText) view.findViewById(R$id.comment_input_edit_text);
            this.f70630e = view.findViewById(R$id.tv_add);
            this.f70629d = (TextView) view.findViewById(R$id.tv_cancel);
            this.f70632g = view.findViewById(R$id.comment_input_disable_click);
            this.f70628c = (TextView) view.findViewById(R$id.tv_hint);
            this.f70631f = (RelativeLayout) view.findViewById(R$id.rl_clear);
        }
        this.f70635j = dialog;
        if (dialog != null) {
            this.f70627b = (LinkEditText) dialog.findViewById(R$id.comment_input_edit_text);
            this.f70630e = dialog.findViewById(R$id.tv_add);
            this.f70628c = (TextView) dialog.findViewById(R$id.tv_hint);
            this.f70629d = (TextView) dialog.findViewById(R$id.tv_cancel);
            this.f70631f = (RelativeLayout) dialog.findViewById(R$id.rl_clear);
            this.f70633h = dialog.findViewById(R$id.comment_input_layout);
        }
        LinkEditText linkEditText2 = this.f70627b;
        if (linkEditText2 != null) {
            linkEditText2.setEnabled(z10);
            linkEditText2.setSingleLine(!z10);
            linkEditText2.setClickable(!z10);
            if (linkEditText2.isEnabled()) {
                linkEditText2.setMaxLines(4);
            }
        }
        if (z10 && (view3 = this.f70630e) != null) {
            view3.setVisibility(0);
        }
        LinkEditText linkEditText3 = this.f70627b;
        if (linkEditText3 != null) {
            KeyboardUtils.i(linkEditText3);
        }
        try {
            MMKV I = MMKV.I("kv_link_record");
            this.f70636k = I;
            String string = I != null ? I.getString("link", "") : null;
            if (!TextUtils.isEmpty(string) && (linkEditText = this.f70627b) != null) {
                linkEditText.setText(string);
            }
        } catch (Exception unused) {
        }
        this.f70640o = new b();
    }

    public /* synthetic */ j(View view, Dialog dialog, b.InterfaceC0821b interfaceC0821b, View view2, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : view, (i11 & 2) != 0 ? null : dialog, (i11 & 4) != 0 ? null : interfaceC0821b, (i11 & 8) == 0 ? view2 : null, (i11 & 16) != 0 ? false : z10);
    }

    private final np.a h() {
        np.b bVar = this.f70634i;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final j jVar, View view, boolean z10) {
        LinkEditText linkEditText;
        view.dispatchWindowFocusChanged(z10);
        if (z10) {
            LinkEditText linkEditText2 = jVar.f70627b;
            if (!TextUtils.isEmpty(linkEditText2 != null ? linkEditText2.getText() : null) || (linkEditText = jVar.f70627b) == null) {
                return;
            }
            linkEditText.post(new Runnable() { // from class: np.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.m(j.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(j jVar) {
        LinkEditText linkEditText = jVar.f70627b;
        if (linkEditText != null) {
            linkEditText.setText("");
        }
        LinkEditText linkEditText2 = jVar.f70627b;
        if (linkEditText2 != null) {
            linkEditText2.setSelection(0);
        }
        LinkEditText linkEditText3 = jVar.f70627b;
        if (linkEditText3 != null) {
            linkEditText3.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(j jVar) {
        b.InterfaceC0821b interfaceC0821b = jVar.f70638m;
        if (interfaceC0821b != null) {
            interfaceC0821b.completeLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(j jVar, View view) {
        LinkEditText linkEditText = jVar.f70627b;
        jVar.s(String.valueOf(linkEditText != null ? linkEditText.getText() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j jVar, View view) {
        LinkEditText linkEditText = jVar.f70627b;
        String valueOf = String.valueOf(linkEditText != null ? linkEditText.getText() : null);
        MMKV mmkv = jVar.f70636k;
        if (mmkv != null) {
            mmkv.putString("link", valueOf);
        }
        jVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j jVar, View view) {
        LinkEditText linkEditText = jVar.f70627b;
        if (linkEditText != null) {
            linkEditText.setText("");
        }
        LinkEditText linkEditText2 = jVar.f70627b;
        if (linkEditText2 != null) {
            linkEditText2.requestFocus();
        }
        LinkEditText linkEditText3 = jVar.f70627b;
        if (linkEditText3 != null) {
            linkEditText3.setSelection(0);
        }
    }

    private final int r() {
        np.b bVar = this.f70634i;
        if (bVar != null) {
            return bVar.c();
        }
        return 10;
    }

    private final void s(String str) {
        if (TextUtils.isEmpty(StringsKt.n1(str).toString()) || str.length() < 5) {
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.post_link_hint);
            return;
        }
        String substring = str.substring(0, 5);
        Intrinsics.g(substring, "substring(...)");
        if (!StringsKt.c0(substring, "http", false, 2, null) && !StringsKt.c0(substring, "https", false, 2, null) && !StringsKt.c0(substring, "www.", false, 2, null)) {
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.post_link_hint);
            return;
        }
        if (!StringsKt.c0(str, "http:", false, 2, null) && !StringsKt.c0(str, "https:", false, 2, null)) {
            str = "https://" + str;
        }
        MMKV mmkv = this.f70636k;
        if (mmkv != null) {
            mmkv.putString("link", "");
        }
        com.transsion.publish.c.f50499a.a().g(str);
        i();
    }

    private final void t(int i11) {
        v(i11);
        u(i11);
    }

    private final void u(int i11) {
        if (i11 > r()) {
            uh.b.f76876a.d(R$string.comment_max_tips);
        }
    }

    private final void v(int i11) {
        View view = this.f70630e;
        if (view != null) {
            boolean z10 = false;
            if (1 <= i11 && i11 <= r()) {
                z10 = true;
            }
            if (view.isSelected() != z10) {
                view.setSelected(z10);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        np.a h11 = h();
        if (h11 != null) {
            h11.afterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        np.a h11 = h();
        if (h11 != null) {
            h11.beforeTextChanged(charSequence, i11, i12, i13);
        }
    }

    public final void i() {
        this.f70639n = null;
        LinkEditText linkEditText = this.f70627b;
        if (linkEditText != null) {
            KeyboardUtils.e(linkEditText);
        }
        Dialog dialog = this.f70635j;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final View j() {
        return this.f70627b;
    }

    public final void k(np.b bVar) {
        LinkEditText linkEditText;
        Editable b11;
        this.f70634i = bVar;
        LinkEditText linkEditText2 = this.f70627b;
        if (linkEditText2 != null) {
            linkEditText2.addTextChangedListener(this);
            np.b bVar2 = this.f70634i;
            if (bVar2 != null && bVar2.d() != null) {
                linkEditText2.setText("");
                linkEditText2.setSelection(0);
                t(0);
            }
            np.b bVar3 = this.f70634i;
            if (bVar3 != null && (b11 = bVar3.b()) != null) {
                linkEditText2.setText(b11);
                linkEditText2.setSelection(b11.length());
                t(b11.length());
            }
            linkEditText2.setMaxEms(r() * 2);
            if (this.f70626a) {
                linkEditText2.requestFocus();
                linkEditText2.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    linkEditText2.setTextCursorDrawable(androidx.core.content.b.getDrawable(linkEditText2.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = linkEditText2.getFilters();
            Intrinsics.g(filters, "getFilters(...)");
            List O0 = ArraysKt.O0(filters);
            O0.add(0, this.f70640o);
            linkEditText2.setFilters((InputFilter[]) O0.toArray(new InputFilter[0]));
        }
        View view = this.f70630e;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: np.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.o(j.this, view2);
                }
            });
        }
        TextView textView = this.f70629d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: np.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.p(j.this, view2);
                }
            });
        }
        RelativeLayout relativeLayout = this.f70631f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: np.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.q(j.this, view2);
                }
            });
        }
        LinkEditText linkEditText3 = this.f70627b;
        Editable text = linkEditText3 != null ? linkEditText3.getText() : null;
        if (!TextUtils.isEmpty(text) && (linkEditText = this.f70627b) != null) {
            linkEditText.setText(text);
        }
        LinkEditText linkEditText4 = this.f70627b;
        if (linkEditText4 != null) {
            linkEditText4.addTextChangedListener(new a());
        }
        LinkEditText linkEditText5 = this.f70627b;
        if (linkEditText5 != null) {
            linkEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: np.g
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z10) {
                    j.l(j.this, view2, z10);
                }
            });
        }
        LinkEditText linkEditText6 = this.f70627b;
        if (linkEditText6 != null) {
            linkEditText6.requestFocus();
        }
        LinkEditText linkEditText7 = this.f70627b;
        if (linkEditText7 != null) {
            linkEditText7.setSelection(text != null ? text.length() : 0);
        }
        LinkEditText linkEditText8 = this.f70627b;
        if (linkEditText8 != null) {
            linkEditText8.postDelayed(new Runnable() { // from class: np.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.n(j.this);
                }
            }, 1000L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        t(charSequence != null ? charSequence.length() : 0);
        if (this.f70626a) {
            np.a h11 = h();
            if (h11 != null) {
                h11.onTextChanged(charSequence, i11, i12, i13);
                return;
            }
            return;
        }
        View view = this.f70630e;
        if (view != null) {
            view.setVisibility((charSequence != null ? charSequence.length() : 0) <= 0 ? 8 : 0);
        }
    }
}
